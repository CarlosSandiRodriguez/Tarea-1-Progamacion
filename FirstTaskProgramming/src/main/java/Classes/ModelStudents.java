package Classes;

/**
 *This class is only used to know how to organize the data in the linked
 * @author sandi
 */
public class ModelStudents {

    public String acronymCourse;
    public String groupStudent;
    public String modality;
    public String studentCard;
    public String studentName;
    public String institutionalMail;
    public String tuition;
    
    /**
     * Constructor vacio
     */
    public ModelStudents(){
        
    }
/**
 * Parameters to use in the constructor
 * @param acronymCourse y
 * @param groupStudent y
 * @param modality y
 * @param studentCard y
 * @param studentName y
 * @param institutionalMail y
 * @param tuition  y
 */
    public ModelStudents(String acronymCourse, String groupStudent, String modality, String studentCard, String studentName, String institutionalMail, String tuition) {
        this.acronymCourse = acronymCourse;
        this.groupStudent = groupStudent;
        this.modality = modality;
        this.studentCard = studentCard;
        this.studentName = studentName;
        this.institutionalMail = institutionalMail;
        this.tuition = tuition;
    }
 
    
    
}
