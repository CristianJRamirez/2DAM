import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Created by 45858000w on 28/09/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la comanda a ejecutar y los argumentos si necesita");
        String comanda =sc.nextLine(); //"python Random.py";
        System.out.println();
        try
        {
            Process proceso= Runtime.getRuntime().exec(comanda);
            String x;
            BufferedReader bf = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            while ((x=bf.readLine())!=null) {
                System.out.println(x);
            }

            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
