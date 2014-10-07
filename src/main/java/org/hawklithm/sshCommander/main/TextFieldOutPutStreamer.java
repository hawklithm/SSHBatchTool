package org.hawklithm.sshCommander.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by bluehawky on 14-10-7.
 */
public class TextFieldOutPutStreamer extends OutputStream {
    private TextArea tf;
    private String str = null;
    private int pos = 0;
    private byte[] buf;

    public TextFieldOutPutStreamer(TextArea jtf) {
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
            tf.append(new String(buf,0,pos));
            pos = 0;
        }
    }

    @Override
    public void flush() throws IOException {
        flushBuffer();
    }
}
