import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by 45858000w on 26/09/16.
 */
public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Bienvenido al programa de CRISTIAN JAVIER");
        //System.out.println("dime el valor de x");
        //int x =sc.nextInt();



        SAXParserFactory factory= SAXParserFactory.newInstance();

        InputStream xmlInput = new FileInputStream("ACCIDENTS_GU_BCN_2015.xml");

        SAXParser saxParser=factory.newSAXParser();

        SAXManegador handler= new SAXManegador();

        saxParser.parse(xmlInput,handler);



        System.out.println("Hi han "+handler.contador_Accidentes + " accidents");


        tractarllista(handler);




        System.out.println("FIN del programa, si quiere repetirlo pulse Mayus+F10");

    }
    private static void tractarllista (SAXManegador sax)
    {
        for (Accidente p: sax.NumeroAccidents)
        {
            System.out.println("Accidente Ocurrido en el districto de "+p.getNomdistricte()+", el "+p.getDiadesetmana());
        }
    }
}
