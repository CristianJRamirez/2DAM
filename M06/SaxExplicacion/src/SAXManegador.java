import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 45858000w on 26/09/16.
 */
public class SAXManegador extends DefaultHandler{

    int contador_llibre=0;
    Book b= new Book();
    public List<Book> bookList= new ArrayList<>();


    boolean is_autor=false;
    boolean is_titulo=false;
    boolean is_fecha=false;

    String autorprov="";
    String tituloprov="";
    String fechaprov="";

    @Override
    public void startDocument() throws SAXException
    {
        System.out.println("He comenzado a leer");

    }

    @Override
    public void endDocument() throws SAXException
    {
        System.out.println("He acabado de leer");

    }

    /****
     *
     * @param uri
     * @param localName
     * @param qName -> etiquetas del xml
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (qName.equalsIgnoreCase("libro"))
        {
            contador_llibre++;
        }
        if (qName.equalsIgnoreCase("autor"))
        {
            is_autor=true;
        }
        if (qName.equalsIgnoreCase("titulo"))
        {
            is_titulo=true;
        }
        if (qName.equalsIgnoreCase("fecha"))
        {
            is_fecha=true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String value= new String(ch,start,length).trim();
        if (value.length()==0) return;
        if (is_autor)
        {
            autorprov=value ;
            is_autor=false;
        }
        else if (is_titulo)
        {
            tituloprov=value ;
            is_titulo=false;
        }
        else if (is_fecha)
        {
            fechaprov=value ;
            is_fecha=false;
        }


    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("lbro"))
        {
            Book zz= new Book();
            zz.setAutor(autorprov);
            zz.setTitol(tituloprov);
            zz.setPublicacio(fechaprov);
            bookList.add(zz);
        }
    }
}
