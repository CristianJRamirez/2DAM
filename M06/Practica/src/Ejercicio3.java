import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//-----------------------
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
/**
 * Created by 45858000w on 19/09/16.
 */
public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa de CRISTIAN JAVIER");

        System.out.println("Titulo");
        String titulo =sc.nextLine();
        System.out.println("Autor");
        String autor =sc.nextLine();
        System.out.println("Año");
        String año =sc.nextLine();

        File ruta = new File("/media/45858000w/SAMSUNG/CRISTIAN J/DAM 2º/M06/Practica/src/");
        File file = new File(ruta, "biblio.xml");

        String Texto=LeerArchivo(file.getAbsolutePath());

        //System.out.println(item.toString());
        FileWriter f = new FileWriter(file,false);
        BufferedWriter b = new BufferedWriter(f);



        b.write(Texto);

        String Frase="\t<libro> \n" +
                "\t\t<titulo>"+titulo+"</titulo>\n" +
                "\t\t<autor>"+autor+"</autor>\n" +
                "\t\t<fecha>"+año+"</fecha>\n" +
                "\t</libro>";
        //System.out.println(Frase);


        b.write(Frase+"\n");
        b.write("</biblioteca>");

        b.close();


        System.out.println("FIN del programa, si quiere repetirlo pulse Mayus+F10");
    }
    public static String LeerArchivo(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        String Texto=null;
        String aux="";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);

        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
            if (!cadena.contains("</biblioteca"))
            {
                    aux += cadena + "\n";

            }
            else
            {
                //System.out.println(aux);
                Texto+=aux;
                aux="";
            }
        }
        //System.out.println(Texto);
        b.close();
        return Texto;
    }
}
