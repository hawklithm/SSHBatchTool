package org.hawklithm.sshCommander.streamer;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by bluehawky on 14-10-7.
 */
public class TextAreaOutputStreamer extends OutputStream {
    private TextArea tf;
    private String str = null;
    private int pos = 0;
    private byte[] buf;

    public TextAreaOutputStreamer(TextArea jtf) {
        tf = jtf;
        buf = new byte[8123];
    }

    @Override
    public void write(int b) throws IOException {
        if (pos >= buf.length){
            flushBuffer();
        }
        buf[pos++] = (byte)b;
    }

    private void flushBuffer() throws IOException {
        if (pos > 0) {
            tf.appendText(new String(buf,0,pos));
            pos = 0;
        }
    }

    @Override
    public void flush() throws IOException {
        flushBuffer();
    }
}
