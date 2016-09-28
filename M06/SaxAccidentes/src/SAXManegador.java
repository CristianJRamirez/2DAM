import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 45858000w on 26/09/16.
 */
public class SAXManegador extends DefaultHandler{

    int[] ContadorDistricto= new int[75];
    int contador_Accidentes=0;
    int cont_districte=0;
    int cont_diaL=0;
    int cont_diaM=0;
    int cont_diaX=0;
    int cont_diaJ=0;
    int cont_diaV=0;
    int cont_diaS=0;
    int cont_diaD=0;


    public List<Accidente> NumeroAccidents= new ArrayList<>();


    boolean is_nomdistricte=false;
    boolean is_diadesetmana=false;



    String nomdistricte="";
    String diadesetmana="";



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
        if (qName.equalsIgnoreCase("Registre"))
        {
            contador_Accidentes++;
        }
        else if (qName.equalsIgnoreCase("Nomdistricte"))
        {
            is_nomdistricte=true;
        }
        else if (qName.equalsIgnoreCase("Diadesetmana"))
        {
            is_diadesetmana=true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String value= new String(ch,start,length).trim();
        if (value.length()==0) return;
        if (is_nomdistricte)
        {
           // ContadorDistricto[posicion=NKbarri]++;
            nomdistricte=value ;

            /*
            //System.out.println("Districto -> "+  value);
            if (value.equalsIgnoreCase("Sant Marti")){cont_diaL++;}
            else if (value.equalsIgnoreCase("Ciutat Vella")){cont_diaM++;}
            else if (value.equalsIgnoreCase("Eixample")){cont_diaX++;}
            else if (value.equalsIgnoreCase("Sants-Montjuïc")){cont_diaJ++;}
            else if (value.equalsIgnoreCase("Les Corts")){cont_diaV++;}
            else if (value.equalsIgnoreCase("Sarrià-Sant Gervasi")){cont_diaS++;}
            else if (value.equalsIgnoreCase("Gràcia")){cont_diaD++;}
            else if (value.equalsIgnoreCase("Horta-Guinardó")){cont_diaD++;}
            else if (value.equalsIgnoreCase("Nou Barris")){cont_diaD++;}
            else if (value.equalsIgnoreCase("Gràcia")){cont_diaD++;}
            else if (value.equalsIgnoreCase("Gràcia")){cont_diaD++;}
            else if (value.equalsIgnoreCase("Gràcia")){cont_diaD++;}
            else if (value.equalsIgnoreCase("Gràcia")){cont_diaD++;}
            else if (value.equalsIgnoreCase("Gràcia")){cont_diaD++;}
            else if (value.equalsIgnoreCase("Gràcia")){cont_diaD++;}

            else {}
*/
            is_nomdistricte=false;
        }
        else if (is_diadesetmana)
        {
            diadesetmana=value ;
            if (value.equalsIgnoreCase("Dl")){cont_diaL++;}
            else if (value.equalsIgnoreCase("Dm")){cont_diaM++;}
            else if (value.equalsIgnoreCase("Dc")){cont_diaX++;}
            else if (value.equalsIgnoreCase("Dj")){cont_diaJ++;}
            else if (value.equalsIgnoreCase("Dv")){cont_diaV++;}
            else if (value.equalsIgnoreCase("Ds")){cont_diaS++;}
            else if (value.equalsIgnoreCase("Dg")){cont_diaD++;}
            is_diadesetmana=false;
        }



    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("Registre"))
        {
            Accidente a=new Accidente();
            a.setNomdistricte(nomdistricte);
            a.setDiadesetmana(diadesetmana);

            NumeroAccidents.add(a);
        }
    }
}
