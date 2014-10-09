package org.hawklithm.sshCommander.utils;

import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import org.hawklithm.sshCommander.streamer.TextAreaOutputStreamer;
import org.hawklithm.sshCommander.streamer.TextFieldInputStreamer;

/**
 * Created by bluehawky on 14-10-7.
 */
public class ShellFactory {
    public static class Shell{
        private SplitPane pane;
        private TextArea ta;
        private TextField tf;

        public SplitPane getPane() {
            return pane;
        }

        public void setPane(SplitPane pane) {
            this.pane = pane;
        }

        public TextArea getTa() {
            return ta;
        }

        public void setTa(TextArea ta) {
            this.ta = ta;
        }

        public TextField getTf() {
            return tf;
        }

        public void setTf(TextField tf) {
            this.tf = tf;
        }
    }
    public static class StreamerShell extends Shell{
        private TextFieldInputStreamer inputStreamer;
        private TextAreaOutputStreamer outputStreamer;

        public StreamerShell(){ }
        public StreamerShell(SplitPane pane,TextFieldInputStreamer inputStreamer,TextAreaOutputStreamer outputStreamer){
            this.inputStreamer = inputStreamer;
            this.outputStreamer = outputStreamer;
            super.setPane(pane);
        }

        public TextFieldInputStreamer getInputStreamer() {
            return inputStreamer;
        }

        public void setInputStreamer(TextFieldInputStreamer inputStreamer) {
            this.inputStreamer = inputStreamer;
        }

        public TextAreaOutputStreamer getOutputStreamer() {
            return outputStreamer;
        }

        public void setOutputStreamer(TextAreaOutputStreamer outputStreamer) {
            this.outputStreamer = outputStreamer;
        }

        public SplitPane getPane() {
            return super.pane;
        }

        public void setPane(SplitPane pane) {
            super.pane = pane;
        }
    }

    public static Shell getShell(){
        Shell shell = new Shell();
        SplitPane  pane = new SplitPane();
        pane.setOrientation(Orientation.VERTICAL);
        pane.setPrefSize(600, 600);
        final StackPane sp1 = new StackPane();
        TextArea ta = new TextArea();
        sp1.getChildren().add(ta);
        final StackPane sp2 = new StackPane();
        TextField tf = new TextField();

        sp2.getChildren().add(tf);
        pane.getItems().addAll(sp1, sp2);
        pane.setDividerPositions(0.9f, 0.1f);

        shell.setPane(pane);
        shell.setTa(ta);
        shell.setTf(tf);

        return  shell;
    }

    public static StreamerShell addStreamer(Shell shell){
        StreamerShell streamerShell = new StreamerShell();
        streamerShell.setPane(shell.getPane());
        streamerShell.setInputStreamer(new TextFieldInputStreamer(shell.getTf()));
        streamerShell.setOutputStreamer(new TextAreaOutputStreamer(shell.getTa()));
        return streamerShell;
    }

}
