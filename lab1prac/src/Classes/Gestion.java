
package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class aims to load the text file where the students' data comes. The user selects an option and according to the limit that is established, the groups are created in a matrix, and then displayed..  
 * @author Carls Sandí
 * @author Damian Monge
 * @author Andrey Campors
 * @author Marcos Montero
 */
public class Gestion {

    /**
     * It is the method in which groups are created and stored in an matriz, here the creation of the groups is executed, depending on the option chosen.
     * @param students Matriz where the groups will be saved
     * @param counter It is the measurement that the user enters and will be used to delimit the groups.
     * @param sortByPerson He is in charge of creating the groups either by number of people or number of groups.
     */
    public static void createGroups(String[][] students, int counter,
            boolean sortByPerson) {
        if (students == null || students.length == 0 || counter > 30) {
            System.out.println("Input parameters are invalid");
         
        }

        int numberOfGroups;

        if (sortByPerson) {
            numberOfGroups = (int) Math.ceil((double) students.length / counter);
        } else {
            numberOfGroups = counter;
            counter = (int) Math.ceil((double) students.length / numberOfGroups);
        }

        String[][] groups = new String[numberOfGroups][];
        order(students);

        int studentIndex = 0;
        for (int i = 0; i < numberOfGroups; i++) {
            int groupSize = Math.min(counter, students.length - studentIndex);
            groups[i] = new String[groupSize];
            StringBuilder groupBuilder = new StringBuilder();
            for (int j = 0; j < groupSize; j++) {
                groups[i][j] = students[studentIndex][2];
                groupBuilder.append(students[studentIndex][2]);
                if (j < groupSize - 1) {

                    groupBuilder.append(" / ");
                }
                studentIndex++;
            }
            System.out.println("Group number " + (i + 1) + ": "
                    + groupBuilder.toString());
        }

     
    }

    /**
     *It is responsible for executing the other methods, sending them the selected option and the array as parameters. Here the txt is loaded into an matriz.
     * @throws IOException This exception is used in case the user enters a value that is not an integer or some letter.
     */
    public void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[][] Students = readFile("reporte.txt");
        try{
        System.out.println("1. Create groups by number of people for each group");
        System.out.println("2. Create groups for each group");
        System.out.println("3. Exit");
        int option = scanner.nextInt();
        
        int partition = 0;
        switch (option) {
            case 1:
                System.out.print("Enter the number of people: ");
                partition = scanner.nextInt();

                createGroups(Students, partition, true);
                menu();
            case 2:
                System.out.print("Enter the number of groups: ");
                partition = scanner.nextInt();

                createGroups(Students, partition, false);
                menu();

            case 3:
                System.exit(0);
            default:
                System.out.println("Select one of the menu option");
                menu();
        }
        }catch(InputMismatchException e){
            System.out.println(" Please, enter only numbers ");
            menu();
        }
    }
 
    /**
     * He is in charge of distributing the students in the matriz
     * @param students It is the matriz, which is to be sorted.
     */
    public static void order(String[][] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (Integer.parseInt(students[j][3]) > Integer.parseInt(students[j + 1][3])) {
                    String[] temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    
    /**
     *The txt data is loaded into an array and these are passed to the matriz separating them by spaces.
     * @param fileName It is the txt file that is passed as a parameter.
     * @return returns an matriz with the student data loaded
     * @throws IOException It is used in case there is some data that cannot be read. 
     */
    public static String[][] readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        String[][] students = new String[0][4];
        int i = 0;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                students = Arrays.copyOf(students, students.length + 1);
                students[i++] = parts;
            }
        }
        reader.close();
        return students;
    }

}
