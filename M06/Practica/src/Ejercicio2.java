import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 45858000w on 19/09/16.
 */
public class Ejercicio2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa de CRISTIAN JAVIER");
        //   System.out.println("dime el valor de x");
        //   int x =sc.nextInt();


        File ruta = new File("/media/45858000w/SAMSUNG/CRISTIAN J/DAM 2º/M06/Practica/src/");
        File f = new File(ruta, "biblio.xml");


        if (!f.exists()) {  //se comprueba si el fichero existe o no
            System.out.println("Fichero " + f.getName() + " no existe");
            if (!ruta.exists()) {  //se comprueba si la ruta existe o no
                System.out.println("La ruta " + ruta.getName() + " no existe");
            } else {
                System.out.println("La ruta " + ruta.getName() + " existe");
            }
        } else { //el fichero existe. Mostramos el tamaño
            System.out.println("Fichero " + f.getName() + " existe");

            List <String> Texto=null;
            Texto=LeerArchivo(f.getAbsolutePath());
            EscribirArchivo(Texto,ruta.getAbsolutePath());
        }

        System.out.println("FIN del programa, si quiere repetirlo pulse Mayus+F10");
    }

    private static void EscribirArchivo(List <String> texto,String ruta) throws FileNotFoundException, IOException {
        File file = new File(ruta, "resum.txt");
        if (!file.exists())
        {
            file.createNewFile();
        }



        //if (texto.contains())
        for (String item: texto)
        {
            //System.out.println(item.toString());
            FileWriter f = new FileWriter(file,true);
            BufferedWriter b = new BufferedWriter(f);

            int inicioT = item.indexOf("<titulo>");
            int finT = item.indexOf("</titulo>", inicioT+8);
            String titulo = item.substring(inicioT + 8, finT);


            int inicioAU = item.indexOf("<autor>");
            int finAU = item.indexOf("</autor>", inicioAU+7);
            String autor = item.substring(inicioAU + 7, finAU);

            int inicioA = item.indexOf("<fecha>");
            int finA = item.indexOf("</fecha>", inicioA+7);
            String año = item.substring(inicioA + 7, finA);


            String Frase="El llibre amb títol  "+titulo+"  té com autor "+autor+" i va ser publicat l'any "+año+".";
            System.out.println(Frase);

            b.newLine();
            b.write(Frase+"\n");
            b.newLine();
            b.close();
        }


    }


    public static List <String> LeerArchivo(String archivo) throws FileNotFoundException, IOException {
            String cadena;
            List <String> Texto=new ArrayList<String>();
            String aux="";
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);

            while((cadena = b.readLine())!=null) {
                //System.out.println(cadena);
                if ((cadena.contains("<libro>"))||(cadena.contains("titulo"))||(cadena.contains("autor"))||(cadena.contains("fecha")))
                {
                    if (!cadena.contains("libro"))
                    {
                        //System.out.println(aux);
                        aux += cadena + "\n";

                    }
                }
                else if (cadena.contains("</libro>"))
                {
                    //System.out.println(aux);
                    Texto.add(aux);
                    aux="";
                }
            }
            //System.out.println(Texto);
            b.close();
            return Texto;
        }





}
