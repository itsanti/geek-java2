package hw4;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.nio.charset.Charset;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * chat client controller
 *
 * @author Aleksandr Kurov
 * @version dated Авг. 26, 2018
 */
public class ClientController {
    @FXML
    private void handleSendMsg(MouseEvent e) {
        genericHandler(e);
    }

    @FXML
    private void handleEnterPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            genericHandler(e);
        }
    }

    private void genericHandler(Event e) {
        Node source = (Node) e.getSource();
        TextField tf = (TextField) source.getScene().lookup("#msg");

        if(tf.getText().length() > 0) {
            TextArea ta = (TextArea) source.getScene().lookup("#chatArea");
            ta.appendText(getFormattedTime() + getEmogi(tf.getText()) + "\n");
            tf.clear();
        }

        tf.requestFocus();
    }

    private String getFormattedTime() {
        Format formatter = new SimpleDateFormat("HH:mm:ss");
        String time = formatter.format(new Date());
        return "[" + time + "] ";
    }

    private String getEmogi(String msg) {
        // https://www.compart.com/en/unicode/block/U+1F600
        // https://apps.timwhitlock.info/emoji/tables/unicode
        if (msg.indexOf("=)") > -1) {
            byte[] emojiBytes = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x83};
            String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
            msg = msg.replaceAll("=\\)", emojiAsString);
        }
        if (msg.indexOf("cat") > -1) {
            byte[] emojiBytes = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xB8};
            String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
            msg = msg.replaceAll("cat", emojiAsString);
        }
        return msg;
    }
}