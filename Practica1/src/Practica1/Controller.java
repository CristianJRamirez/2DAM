package Practica1;

import com.sun.rmi.rmid.ExecOptionPermission;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    public Button btConvers;

    public TextField txtC;
    public TextField txtF;


    /*
        Multiplica por 9, divide entre 5, después suma 32
                °F a °C 	Resta 32, después multiplica por 5, después divide entre 9
    */
    public void setConversion(ActionEvent actionEvent) {
        try {
            if (!txtC.getText().isEmpty() && txtC.getText() != null) {
                System.out.println("2");
                // double numDouble=Double.parseDouble(numString);
                double x = (Double.parseDouble(txtC.getText())) * 9 / 5 + 32;
                txtF.setText(Double.toString(x));
                txtC.clear();
            } else if (!txtF.getText().isEmpty() && txtF.getText() != null) {
                System.out.println("!");
                // double numDouble=Double.parseDouble(numString);
                double y = Double.parseDouble(txtF.getText()) - 32.0;
                double x = ((y * 5) / 9);
                txtC.setText(Double.toString(x));
                txtF.clear();
            } else {
                System.out.println("Hay Datos en dos lados  o no hay en ninguno");
            }
        }
        catch ( Exception e) {
            System.out.println("Los datos no son numeros");
        }
    }


}
