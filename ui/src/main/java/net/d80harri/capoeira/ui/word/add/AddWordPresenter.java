package net.d80harri.capoeira.ui.word.add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * Created by d80harri on 22.09.16.
 */
public class AddWordPresenter {

    @FXML
    public Button button;

    private int cnt = 0;

    public void onClick(ActionEvent actionEvent) {
        button.setText(""+cnt++);
    }
}
