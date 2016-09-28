import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 45858000w on 26/09/16.
 */
public class SAXManegador extends DefaultHandler{
/*
 <Nombre Classe = 'fuego' >Blaziken</Nombre>
	   <PV>130</PV>
	   <Ataque1>Danza del Fuego</Ataque1>
	   <Ataque2>Patada Llameante</Ataque2>
	   <Etapa>Fase 2</Etapa>
 */
    int contador_pokemon=0;
    Pokemon poke= new Pokemon();
    public List<Pokemon> Pokedex= new ArrayList<>();


    boolean is_nombre=false;
    boolean is_PV=false;
    boolean is_Ataque1=false;
    boolean is_Ataque2=false;
    boolean is_Etapa=false;
    boolean is_Classe=false;


    String nombre="";
    String pv="";
    String ataque1="";
    String ataque2="";
    String etapa="";
    String classes="";


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
        //System.out.println("----"+attributes.getValue("Classe"));
        if (qName.contains("Pokemon"))
        {
            contador_pokemon++;
        }
        else if (qName.contains("Nombre"))
        {
            is_nombre=true;
        }
        else if (qName.contains("PV"))
        {
            is_PV=true;
        }
        else if (qName.contains("Ataque1"))
        {
            is_Ataque1=true;
        }
        else if (qName.contains("Ataque2"))
        {
            is_Ataque2=true;
        }
        else if (qName.contains("Etapa"))
        {
            is_Etapa=true;
        }
        if (attributes.getLength()>0)
        {
            classes=attributes.getValue("Classe");
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String value= new String(ch,start,length).trim();
        if (value.length()==0) return;
        if (is_nombre)
        {
            nombre=value ;
            is_nombre=false;
        }
        else if (is_PV)
        {
            pv=value ;
            is_PV=false;
        }
        else if (is_Ataque1)
        {
            ataque1=value ;
            is_Ataque1=false;
        }
        else if (is_Ataque2)
        {
            ataque2=value ;
            is_Ataque2=false;
        }
        else if (is_Etapa)
        {
            etapa=value ;
            is_Etapa=false;
        }
        else if (is_Classe)
        {
            classes=value ;
            is_Classe=false;
        }


    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("Pokemon"))
        {
            Pokemon p=new Pokemon();
            p.setNombre(nombre);
            p.setPV(pv);
            p.setAtaque1(ataque1);
            p.setAtaque2(ataque2);
            p.setEtapa(etapa);
            p.setClasse(classes);

            Pokedex.add(p);
        }
    }
}
