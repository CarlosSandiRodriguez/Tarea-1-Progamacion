package Main;

import Classes.Gestion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is only used to create an instance and call the menu, so that the program starts.
 * @author Carls Sandí
 * @author Damian Monge
 * @author Andrey Campors
 * @author Marcos Montero
 */
public class StudientsGroups {

   
/**
 * You simply pass parameters to the menu method, create a Gestión class object, and call it.
 * @param args the temporary array to use
 * @throws IOException error loading data
 */
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Gestion ob = new Gestion();
        ob.menu();
       
    }
}
