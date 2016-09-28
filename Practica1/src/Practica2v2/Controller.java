package Practica2v2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class Controller {
    public Button btSuma;
    public Button btRest;
    public Button btMulti;
    public Button btDiv;
    public TextField txtPantalla;
    public Button bt1;
    public Button bt2;
    public Button bt3;
    public Button bt4;
    public Button bt5;
    public Button bt6;
    public Button bt7;
    public Button bt8;
    public Button bt9;
    public Button bt0;
    public Button btPunto;
    public Button btIgual;
    Double n1=0.0;
    Double n2=0.0;
    Double n=0.0;
    int posini;
    int posfin;
    int pos;

    public void SetPantalla(ActionEvent actionEvent)
    {
        if (bt0.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+0);
        }
        if (bt1.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+1);
        }
        if (bt2.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+2);
        }
        if (bt3.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+3);
        }
        if (bt4.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+4);
        }
        if (bt5.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+5);
        }
        if (bt6.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+6);
        }
        if (bt7.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+7);
        }
        if (bt8.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+8);
        }
        if (bt9.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+9);
        }

        if (btPunto.isArmed())
        {
            txtPantalla.setText(txtPantalla.getText()+",");
        }
        if (btSuma.isArmed())
        {
            if (!Operacion())
            {
                txtPantalla.setText(txtPantalla.getText()+"+");
            }
            else
            {
                txtPantalla.setText(Double.toString(n));
                txtPantalla.setText(txtPantalla.getText()+"+");
            }
        }


        if (btRest.isArmed())
        {

            if (!Operacion())
            {
                txtPantalla.setText(txtPantalla.getText()+"-");
            }
            else
            {
                txtPantalla.setText(Double.toString(n));
                txtPantalla.setText(txtPantalla.getText()+"-");
            }
        }
        if (btDiv.isArmed())
        {

            if (!Operacion())
            {
                txtPantalla.setText(txtPantalla.getText()+"/");
            }
            else
            {
                txtPantalla.setText(Double.toString(n));
                txtPantalla.setText(txtPantalla.getText()+"/");
            }
        }
        if (btMulti.isArmed())
        {
            if (!Operacion())
            {
                txtPantalla.setText(txtPantalla.getText() + "*");
            }
            else
            {
                txtPantalla.setText(Double.toString(n));
                txtPantalla.setText(txtPantalla.getText()+"*");
            }

        }
        if (btIgual.isArmed())
        {
            if (Operacion())
            {
                txtPantalla.setText(Double.toString(n));
            }
        }



    }

    private boolean Operacion()
    {
        if (txtPantalla.getText().contains("+"))
        {
            pos=txtPantalla.getText().indexOf("+");
            n1=Double.parseDouble(txtPantalla.getText().substring(0,pos));
            n2=Double.parseDouble(txtPantalla.getText().substring(pos+1,txtPantalla.getText().length()));
            n=n1+n2;
            return true;
        }
        else if (txtPantalla.getText().contains("-"))
        {
            pos=txtPantalla.getText().indexOf("-");
            n1=Double.parseDouble(txtPantalla.getText().substring(0,pos));
            n2=Double.parseDouble(txtPantalla.getText().substring(pos+1,txtPantalla.getText().length()));
            n=n1-n2;
            return true;
        }
        else if (txtPantalla.getText().contains("*"))
        {
            pos=txtPantalla.getText().indexOf("*");
            n1=Double.parseDouble(txtPantalla.getText().substring(0,pos));
            n2=Double.parseDouble(txtPantalla.getText().substring(pos+1,txtPantalla.getText().length()));
            n=n1*n2;
            return true;
        }
        else if (txtPantalla.getText().contains("/"))
        {
            pos=txtPantalla.getText().indexOf("/");
            n1=Double.parseDouble(txtPantalla.getText().substring(0,pos));
            n2=Double.parseDouble(txtPantalla.getText().substring(pos+1,txtPantalla.getText().length()));
            n=n1/n2;
            return true;
        }

        return false;
    }



}
