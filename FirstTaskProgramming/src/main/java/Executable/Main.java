
package Executable;

import Classes.MethodAdministrator;
import Classes.ModelStudents;
import java.util.LinkedList;
import java.io.IOException;
import static Classes.MethodAdministrator.loadStudents;
/**
 *Class that instantiates and executes the menuExecutable method of MethodManager
 * @author sandi
 */
public class Main {

   /**
    * Run the method menuExecutable
    * @param args yes
    * @throws IOException yes
    */
    public static void main(String[] args) throws IOException {
        LinkedList<ModelStudents> students = loadStudents();
       MethodAdministrator ejec = new MethodAdministrator();
       
       ejec.menuExecutable(students);
       
    }
    
}
