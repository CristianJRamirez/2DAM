package Practica2;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sun.plugin2.message.Message;

public class Controller {
    public Button btSuma;
    public Button btResta;
    public Button btMultiplicacion;
    public Button btDivision;
    public TextField txtResultado;
    public TextField txt1;
    public TextField txt2;
/*
    Multiplica por 9, divide entre 5, después suma 32
            °F a °C 	Resta 32, después multiplica por 5, después divide entre 9
*/

/*
        if (!lblC.getText().isEmpty() && lblC.getText()!=null)
        {
            System.out.println("2");
            // double numDouble=Double.parseDouble(numString);
            double x = (Double.parseDouble(lblC.getText())) * 9 / 5 + 32;
            lblF.setText(Double.toString(x));
            lblC.clear();
        }
        else if (!lblF.getText().isEmpty() && lblF.getText()!=null)
        {
            System.out.println("!");
            // double numDouble=Double.parseDouble(numString);
            double y= Double.parseDouble(lblF.getText())-32.0;
            double x = ((y *5 )/ 9);
            lblC.setText(Double.toString(x));
            lblF.clear();
        }

   else
        {
            System.out.println("Hay Datos en dos lados  o no hay en ninguno");
        }
        */
        public void setSuma(ActionEvent actionEvent) {
            try {
                if (getCamposLlenos()){
                    double valor1 = Double.parseDouble(txt1.getText());
                    double valor2 =  Double.parseDouble(txt2.getText());
                    double valorResultado=valor1+valor2;
                    txtResultado.setText(Double.toString(valorResultado));
                }
                else {
                    txtResultado.setText("No hay valores en los campos, introduce valores");
                    System.out.println("No hay valores en los campos, introduce valores");
                }
            }
            catch (Exception e) {
                System.out.println("Los datos no son numeros");
            }
        }

        public void setDivision(ActionEvent actionEvent) {
            try{
                if (getCamposLlenos()){
                    double valor1 = Double.parseDouble(txt1.getText());
                    double valor2 =  Double.parseDouble(txt2.getText());
                    double valorResultado=valor1/valor2;
                    txtResultado.setText(Double.toString(valorResultado));

                }
                else {
                    txtResultado.setText("No hay valores en los campos, introduce valores");
                    System.out.println("No hay valores en los campos, introduce valores");
                }
            }
            catch (Exception e) {
                System.out.println("Los datos no son numeros");
            }
        }

        public void setResta(ActionEvent actionEvent) {
            try{
                if (getCamposLlenos()){
                    double valor1 = Double.parseDouble(txt1.getText());
                    double valor2 =  Double.parseDouble(txt2.getText());
                    double valorResultado=valor1-valor2;
                    txtResultado.setText(Double.toString(valorResultado));
                }
                else {
                    txtResultado.setText("No hay valores en los campos, introduce valores");
                    System.out.println("No hay valores en los campos, introduce valores");
                }
            }
            catch (Exception e) {
                System.out.println("Los datos no son numeros");
            }

        }

        public void setMultiplicacion(ActionEvent actionEvent) {
            try{
                if (getCamposLlenos()){
                    double valor1 = Double.parseDouble(txt1.getText());
                    double valor2 =  Double.parseDouble(txt2.getText());
                    double valorResultado=valor1*valor2;
                    txtResultado.setText(Double.toString(valorResultado));
                }
                else {
                    txtResultado.setText("No hay valores en los campos, introduce valores");
                    System.out.println("No hay valores en los campos, introduce valores");
                }
            }
            catch (Exception e) {
                System.out.println("Los datos no son numeros");
            }
        }

        public boolean getCamposLlenos(){
            if (!txt1.getText().isEmpty() && !txt2.getText().isEmpty()) {
                return true;
            }
            return false;
        }

}
