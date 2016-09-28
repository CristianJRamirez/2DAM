import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.print.Book;
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

        InputStream xmlInput = new FileInputStream("pokemons.xml");

        SAXParser saxParser=factory.newSAXParser();

        SAXManegador handler= new SAXManegador();

        saxParser.parse(xmlInput,handler);



        System.out.println("Hi han "+handler.contador_pokemon + " pokemon");


        tractarllista(handler);




        System.out.println("FIN del programa, si quiere repetirlo pulse Mayus+F10");

    }
    private static void tractarllista (SAXManegador sax)
    {
        for (Pokemon p: sax.Pokedex)
        {
            System.out.println("El pokemon " +p.getNombre()+" y es de la classe de "+p.getClasse()+", tiene tantos  "+p.getPV()+"ps, con los ataques "+p.getAtaque1()+" y "+p.getAtaque2()
            +", en la etapa "+p.getEtapa());
        }
    }
}
