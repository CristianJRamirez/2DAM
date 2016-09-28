/**
 * Created by Cristian J on 26/09/2016.
 */
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException,  ParserConfigurationException, SAXException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Bienvenido al programa de CRISTIAN JAVIER");
        //System.out.println("dime el valor de x");
        //int x =sc.nextInt();



        SAXParserFactory factory= SAXParserFactory.newInstance();

        InputStream xmlInput = new FileInputStream("biblio(1).xml");

        SAXParser saxParser=factory.newSAXParser();

        SAXManegador handler= new SAXManegador();

        saxParser.parse(xmlInput,handler);

        System.out.println("Hi ha "+handler.contador_llibre + " llibres");


        tractarllista(handler);




        System.out.println("FIN del programa, si quiere repetirlo pulse Mayus+F10");

    }
    private static void tractarllista (SAXManegador sax)
    {
        for (Book b: sax.bookList)
        {
            System.out.println("El llibre " +b.getTitol()+" te com autor "+b.getAutor()+" i va ser publicat l'any "+b.getPublicacio() );
        }
    }
}