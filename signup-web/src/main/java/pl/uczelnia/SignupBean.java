package pl.uczelnia;

import pl.uczelnia.jpa.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class SignupBean implements Serializable {
    private static final long serialVersionUID = 5103450608081796600L;
    private Logger logger = Logger.getLogger("SignupBean");

    private String email;
    private String firstName;
    private String lastName;

    @ManagedProperty(value="#{studentDatabaseBean}")
    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "SignupBean{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String signup() {
        logger.info("signup invoked, bean fields: " + this);

        Student s = new Student();
        s.setFirstname(this.firstName);
        s.setLastname(this.lastName);
        s.setEmail(this.email);
        studentService.create(s);

        return "signup-confirmation";
    }
}
