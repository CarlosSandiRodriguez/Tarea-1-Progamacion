package Classes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Esta clase es en la que se llevana acabo todos los metodos, se carga la lista, se edita y se muestra
 * todo ello mediate la libreria de collections y sus miltiples funciones
 * @author Carlos Sandí
 */
public class MethodAdministrator {
     boolean position = true;   
     
 /**
 *Metodo que permite ejecutar todos los demas metodos y es llamado en el main
 * @param estudiantes linked al que se le carga todo 
 */
    public void menuExecutable(LinkedList<ModelStudents> estudiantes) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("<<<MENU>>>\nEscoja una opción para continuar\n" +
                 "Seleccione 1 para mostrar la lista con los estudiantes\n" +
                 "Seleccione 2 para ordenar la lista de forma ascendente\n" +
                 "Seleccione 3 para buscar a un estudiante por su carné\n" +
                 "Seleccione 4 para escoger y editar un estudiante\n" +
                 "Seleccione 5 para eliminar un estudiante del registro\n" +
                 "Seleccione 6 para agregar un estudiante al final de la lista\n" +
                 "Seleccione 7 para agregar un estudiante a la lista\n" +
                 "Seleccione 8 para salir\n");

        int numeroCase = entrada.nextInt();
        
        switch (numeroCase) {
            case 1:
                showStudents(estudiantes);
                menuExecutable(estudiantes);
                break;
            case 2: 
                sortStudents(estudiantes);
                menuExecutable(estudiantes);
                break;
            case 3:
                searchStudentMeat(estudiantes);
                menuExecutable(estudiantes);
                break;
            case 4:
                   ModelStudents estudianteAEditar = searchStudentMeat(estudiantes);
                if (estudianteAEditar != null) {
                    editStudent(estudianteAEditar);
                }
                menuExecutable(estudiantes);
                break;
            case 5:
                 ModelStudents estudianteAEliminar = searchStudentMeat(estudiantes);
                  if (estudianteAEliminar != null) {
                      removeStudent(estudiantes, estudianteAEliminar);
                } 
                menuExecutable(estudiantes);
                break;
            case 6: 
                position = false;
                addNewStudents(estudiantes, position);
                menuExecutable(estudiantes);
                break;
            case 7:
                position = true;
                addNewStudents(estudiantes, position);
                menuExecutable(estudiantes);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("En estos momentos la opcion no se encuentra disponible");       
        }

    }

    /**
     * Metodo que permite mostrar unicamente el nombre y carné de los estudiantesz previamente cargados de el archivo txt
     * @param students Se le pasa por parametro el linked creado para que solo utilize ciertos datos en el
     */
    public static void showStudents(LinkedList<ModelStudents> students) {
        for (ModelStudents student : students) {
            System.out.println("Nombre del estudiante-> " + student.studentName
                    + "Numero de carné del estudiante-> " + student.studentCard);
        }
    }
    
 /**
 * Metodo que permite editar todos los datos de un estudiante si es encontrado su carné en el linked 
 * @param student Se utiliza para buscar y editar los datos de la persona solicitada 
 */
    public static void editStudent(ModelStudents student) {
        if (student == null) {
            System.out.println("El estudiante a editar no existe en el sistema");
            return;
        }

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese los datos nuevos para el estudiante");

        System.out.print("Sigla del curso ");
        /**
         *Temporary variable
         */
        student.acronymCourse = entrada.nextLine();

        System.out.print("Grupo del estudiante ");
        /**
         * Temporary variable
         */
        student.groupStudent = entrada.nextLine();

        System.out.print("Modalidad del estudiante ");
        /**
         * Temporary variable
         */
        student.modality = entrada.nextLine();
       
        System.out.print("carné del estudiante");
        /**
         * Temporary variable
         */
        student.studentCard = entrada.nextLine();

        System.out.print("Nombre completo del estudiante");
        /**
         * Temporary variable
         */
        student.studentName = entrada.nextLine();

        System.out.print("Correo institucional ");
        /**
         * Temporary variable
         */
        student.institutionalMail= entrada.nextLine();

        System.out.print("Matricula ");
        /**
         * Temporary variable
         */
        student.tuition = entrada.nextLine();

        System.out.println("La edición del estudiante ha sido un exito");
    }

/**
 * Metodo que ordena a los estudiantes por su primer apellido (En el archivo era muy complicado que fuera por el nombre) en oreden asendente
 * @param students Se utiliza el linked para comprarar sus datos tipo nombre y así ordenarlos
 */
    public static void sortStudents(LinkedList<ModelStudents> students) {
        Collections.sort(students, new Comparator<ModelStudents>() {
            public int compare(ModelStudents e1, ModelStudents e2) {
                return e1.studentName.compareTo(e2.studentName);
            }
        });
    }

/**
 * Metodo que permite crear nuevos estudiantes al linked creado ya sea de primero o ultimo
 * @param students Se utiliza para que al momento de cargar los datos vayan en orden
 * @param positionindicator Es un dato de tipo booleano que permite saber dónde se tiene que agregar la nueva persona en el linked
 */
    public static void addNewStudents(LinkedList<ModelStudents> students,
            boolean positionindicator) {
        boolean indicator = true;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Por favor, ingrese los datos del nuevo estudiante "
                + "que desea agregar");

        System.out.print("Ingrese las siglas del curso para el nuevo estudiante ");
        String siglaDelNuevoCurso = entrada.nextLine();

        System.out.print("Ingrese el grupo del nuevo estudiante");
        String numeroDelNuevoGrupo = entrada.nextLine();

        System.out.print("Ingrese la modalidad para el nuevo estudiante ");
        String modalidadNueva = entrada.nextLine();
        

        System.out.print("Ingrese el carné del nuevo estudiante");
        String carneNuevoEstudiante = entrada.nextLine();

        System.out.print("Ingrese el nombre del nuevo estudiante");
        String nombreNuevoEstudiante = entrada.nextLine();

        System.out.print("Ingrese la dirección de correo institucional para el"
                + " nuevo estudiante ");
        String correoDeNuevoEstudiante = entrada.nextLine();

        System.out.print("Ingrese cómo se matricula el nuevo estudiante");
        String matriculaNuevoEstudiante = entrada.nextLine();

        ModelStudents nuevoEstudiante = new ModelStudents(siglaDelNuevoCurso, numeroDelNuevoGrupo,
                modalidadNueva, carneNuevoEstudiante, nombreNuevoEstudiante,
                correoDeNuevoEstudiante, matriculaNuevoEstudiante);

        if (indicator) {
            students.addFirst(nuevoEstudiante);
        }else{
            students.addLast(nuevoEstudiante);
        }
            

        System.out.println("El nuevo estudiante se agrego de manera correcta");
    }
    
/**
 * Metodo que permite buscar a un estudiante existente mediante su carné y así notificar si existe o no
 * @param students Se utiliza para utilizar el linked y saber cuales estudiantes existen en el registro
 * @return cuando exite el carné buscado se utiliza, cuando no se encuentra el carné no se devuelve nada
 */
    public static ModelStudents searchStudentMeat(LinkedList<ModelStudents> students) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Busqueda por carné de estudiante");
        
        System.out.println("Ingrese el carné del estudainte a buscar");
        String meatToSearch = entrada.nextLine();

        for (ModelStudents student : students) {
            if (student.studentCard.equalsIgnoreCase(meatToSearch)) {
                System.out.println("El estudiante si existe en el registro \\n" +
                        " El estudiante es->"+ student.studentName);
                return student;
            }
        }

        System.out.println("El estudiante no existe en nuestro registro");
        return null;
    }

    /**
     * Metodo que se encarga de buscar si el estudiante seleccionada existe para lugo eliminar sus datos, se utiliza dos linked una que funcione como copia y otra que hace los cambios para luego pasarlos
     * @param students linked original al que se le carga la copia despues de eliminar
     * @param student copia a la que se le pueden hacer modificacione para lugo cargarla en la principal
     */
    public static void removeStudent(LinkedList<ModelStudents> students,
            ModelStudents student) {

        if (student == null) {
            System.out.println("El estudiante a eliminar no existe en el registro");
            return;
        }
        
        students.remove(student);
        System.out.println("Se ha completado la eliminación del estudiante");
    }

    /**
     * En este metodo se utiliza la función linked para cagarla con los datos de la lista, aquí se crea el Hashset para ver si existe algún nombre repetido
     * @return acá se retorna el linked hecho con los datos
     * @throws IOException Se utiliza en caso de un error al momento de cargar el archivo txt
     */
    public static LinkedList<ModelStudents> loadStudents() throws IOException {
        HashSet<String> namesStudents = new HashSet<>();
        LinkedList<ModelStudents> students = new LinkedList<>();

        File lectorDeArchivo = new File("Programación II.txt");
        BufferedReader lectorDeBuffer = new BufferedReader(new FileReader(lectorDeArchivo));

        String line;
        while ((line = lectorDeBuffer.readLine()) != null) {
            String[] capsulas = line.split("\t");
            ModelStudents student = new ModelStudents(capsulas[0],(capsulas[1]),(capsulas[2]), capsulas[3], capsulas[4],
                    capsulas[5], capsulas[6]);
            students.add(student);

            if (namesStudents.contains(student.studentName)) {
                System.out.println("El siguiente nombre de la lista esta repetido" + student.studentName);
            } else {
                namesStudents.add(student.studentName);
            }
        }

        return students;
    }
}
