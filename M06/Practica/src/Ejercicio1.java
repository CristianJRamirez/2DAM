import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Created by 45858000w on 19/09/16.
 */
public class Ejercicio1 {

    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Bienvenido al programa de CRISTIAN JAVIER");
     //   System.out.println("dime el valor de x");
     //   int x =sc.nextInt();



        File ruta = new File("/media/45858000w/SAMSUNG/CRISTIAN J");
        File f = new File(ruta, "datos.txt");

        System.out.println("Ruta absoluta del fichero "+f.getAbsolutePath());
        System.out.println("Padre del fichero "+f.getParent());
        System.out.println("Ruta absoluta de la ruta "+ruta.getAbsolutePath());
        System.out.println("Padre de la ruta "+ruta.getParent());
        System.out.println("Ruta relativa de la ruta "+ruta.getPath());
        System.out.println("Ruta relativa del archivo "+ f.getPath());
        if (!f.exists())
        {  //se comprueba si el fichero existe o no
            System.out.println("Fichero " + f.getName() + " no existe");
            if (!ruta.exists())
            {  //se comprueba si la ruta existe o no
                System.out.println("El directorio " + ruta.getName() + " no existe");
                if (ruta.mkdir())
                { //se crea la ruta. Si se ha creado correctamente
                    System.out.println("Directorio creado");
                    if (f.createNewFile())
                    {  //se crea el fichero. Si se ha creado correctamente
                        System.out.println("Fichero " + f.getName() + " creado");
                    }
                    else
                    {
                        System.out.println("No se ha podido crear " + f.getName());
                    }
                }
                else
                {
                    System.out.println("No se ha podido crear " + ruta.getName());
                }
            } else
                {  //si la ruta existe creamos el fichero
                if (f.createNewFile())
                {
                    System.out.println("Fichero " + f.getName() + " creado");
                } else
                    {
                    System.out.println("No se ha podido crear " + f.getName());
                }
            }
        } else
            { //el fichero existe. Mostramos el tamaño
            System.out.println("Fichero " + f.getName() + " existe");

            if (f.isHidden())
            {
                System.out.println("Esta oculto ");
            }
            else
            {
                System.out.println("No Esta oculto ");
            }
                Date d = new Date(f.lastModified());
            System.out.println("La ultima modificacion fue el "+ d);
            System.out.println("");
        }

        if (ruta.exists())
        {
            System.out.printf("Los Archivos que hay en la ruta son -> ");
            String[] lista = ruta.list();
            for (int i = 0; i < lista.length; i++)
            {
                System.out.println(lista[i]);
            }
        }





        System.out.println("FIN del programa, si quiere repetirlo pulse Mayus+F10");

    }
}
