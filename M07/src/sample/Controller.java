package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;

public class Controller {
    public Button btMessage;
    public Label lblHW;
    public ProgressBar prgs;
    public ProgressIndicator prgs2;
    public Button bt;

    public void setVisibilidad(ActionEvent actionEvent)
    {
        if(lblHW.isVisible())
        {
            lblHW.setVisible(false);

        }
        else
        {
            lblHW.setVisible(true);
        }



    }

    public void set(MouseEvent mouseEvent) {


    }

    public void set2(ActionEvent actionEvent) {
        prgs2.setVisible(true);
        do {
            // prgs2.setProgress(0.5);
            if (prgs2.getProgress()==0) {
                for (double i = 0.00; i <= 1; i = i + 0.01) {
                    prgs2.setProgress(i);
                }
            }
            else if (prgs2.getProgress()==1){
                prgs2.setProgress(0);
            }



        }while(true);
    }
}
