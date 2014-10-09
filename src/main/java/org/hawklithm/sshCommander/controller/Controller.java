package org.hawklithm.sshCommander.controller;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.hawklithm.sshCommander.utils.ShellFactory;

import javax.swing.*;

public class Controller {
    @FXML private TextArea textArea;
    @FXML private GridPane gridPane;
    @FXML private Button button;
    int count=0;
    JSch jsch=new JSch();
    @FXML protected void handleAddButtonClickAction(MouseEvent event){
        System.out.println(event.toString());
        if (MouseEvent.MOUSE_CLICKED.equals(event.getEventType())){
            System.out.println("mouse click");
            ShellFactory.Shell shell = ShellFactory.getShell();
            ShellFactory.StreamerShell streamer = ShellFactory.addStreamer(shell);
            gridPane.add(shell.getPane(),++count,0);
        }
    }
    private Session connectToRS(String user,String host,Integer port) throws JSchException {
        if (port==null){
            port = 22;
        }
        if (user==null||host==null) {
            host = JOptionPane.showInputDialog("Enter username@hostname",
                    System.getProperty("user.name") +
                            "@localhost");
            user = host.substring(0, host.indexOf('@'));
            host = host.substring(host.indexOf('@') + 1);
        }
        Session session = jsch.getSession(user, host, port);
        return session;
    }
}
