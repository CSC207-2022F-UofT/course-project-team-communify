/*
 * Note to TAs: This code is from a dependency and is only
 * slightly modified to suit our needs better. Please ignore this file and assume that it is part
 * of a package we used - we did not write it, and we do not intend for it to be marked.
 */

package entities;

/*
 * 11/19/04		1.0 moved to LGPL.
 * 29/01/00		Initial version. mdm@techie.com
 *-----------------------------------------------------------------------
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU Library General Public License as published
 *   by the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this program; if not, write to the Free Software
 *   Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *----------------------------------------------------------------------
 */

import java.io.InputStream;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.decoder.SampleBuffer;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;

/**
 * The <code>Player</code> class implements a simple player for playback
 * of an MPEG audio stream.
 *
 * @author	Mat McGowan
 * @since	0.0.8
 */

// REVIEW: the audio device should not be opened until the
// first MPEG audio frame has been decoded.
public class JPlayer
{

    /**
     * The MPEG audio bitstream.
     */
    // javac blank final bug.
    /*final*/ private final Bitstream		bitstream;

    /**
     * The MPEG audio decoder.
     */
    /*final*/ private final Decoder		decoder;

    /**
     * The AudioDevice the audio samples are written to.
     */
    private AudioDevice audio;

    private int			lastPosition = 0;

    /**
     * Creates a new <code>Player</code> instance.
     * @param stream the input stream of the song
     * @throws JavaLayerException when song fails to player
     */
    public JPlayer(InputStream stream) throws JavaLayerException
    {
        this(stream, null);
    }

    /**
     * Creates a new <code>Player</code> instance.
     * @param stream the input stream of the song
     * @param device the output device
     * @throws JavaLayerException when song fails to player
     */
    public JPlayer(InputStream stream, AudioDevice device) throws JavaLayerException
    {
        bitstream = new Bitstream(stream);
        decoder = new Decoder();

        if (device!=null)
        {
            audio = device;
        }
        else
        {
            FactoryRegistry r = FactoryRegistry.systemRegistry();
            audio = r.createAudioDevice();
        }
        audio.open(decoder);
    }

    /**
     * @throws JavaLayerException if the song fails to play
     */
    public void play() throws JavaLayerException
    {
        play(Integer.MAX_VALUE);
    }

    /**
     * Plays a number of MPEG audio frames.
     *
     * @param frames The number of frames to play.
     * @throws JavaLayerException if the song fails to play
     */
    public void play(int frames) throws JavaLayerException
    {
        boolean ret = true;

        while (frames-- > 0 && ret)
        {
            ret = decodeFrame();
        }

        if (!ret)
        {
            // last frame, ensure all data flushed to the audio device.
            AudioDevice out = audio;
            if (out!=null)
            {
                out.flush();
                synchronized (this)
                {
                    close();
                }
            }
        }
    }

    /**
     * Closes this player. Any audio currently playing is stopped
     * immediately.
     */
    public synchronized void close()
    {
        AudioDevice out = audio;
        if (out!=null)
        {
            audio = null;
            // this may fail, so ensure object state is set up before
            // calling this method.
            out.close();
            lastPosition = out.getPosition();
            try
            {
                bitstream.close();
            }
            catch (BitstreamException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Retrieves the position in milliseconds of the current audio
     * sample being played. This method delegates to the <code>
     * AudioDevice</code> that is used by this player to sound
     * the decoded audio samples.
     * @return the frame position of the song
     */
    public int getPosition()
    {
        int position = lastPosition;

        AudioDevice out = audio;
        if (out!=null)
        {
            position = out.getPosition();
        }
        return position;
    }

    /**
     * Decodes a single frame.
     *
     * @return true if there are no more frames to decode, false otherwise.
     * @throws JavaLayerException if the frame cannot be decoded
     */
    protected boolean decodeFrame() throws JavaLayerException
    {
        try
        {
            AudioDevice out = audio;
            if (out==null)
                return false;

            Header h = bitstream.readFrame();

            if (h==null)
                return false;

            // sample buffer set when decoder constructed
            SampleBuffer output = (SampleBuffer)decoder.decodeFrame(h, bitstream);

            synchronized (this)
            {
                out = audio;
                if (out!=null)
                {
                    out.write(output.getBuffer(), 0, output.getBufferLength());
                }
            }

            bitstream.closeFrame();
        }
        catch (RuntimeException ex)
        {
            throw new JavaLayerException("Exception decoding audio frame", ex);
        }
        return true;
    }

    /**
     * Plays a range of MPEG audio frames
     *
     * @param start The first frame to play
     * @param end   The last frame to play
     * @throws JavaLayerException if the song cannot be played
     */
    public void play(final int start, final int end) throws JavaLayerException
    {
        boolean ret = true;
        int offset = start;
        while (offset-- > 0 && ret) ret = skipFrame();
        play(end - start);
    }

    /**
     * skips over a single frame
     * @return false	if there are no more frames to decode, true otherwise.
     * @throws JavaLayerException if a frame cannot be skipped
     */
    protected boolean skipFrame() throws JavaLayerException
    {
        Header h = bitstream.readFrame();
        if (h == null) return false;
        bitstream.closeFrame();
        return true;
    }
}
