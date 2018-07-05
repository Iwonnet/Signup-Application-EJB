package pl.uczelnia;

import pl.uczelnia.dao.StudentDao;
import pl.uczelnia.jpa.Student;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.logging.Logger;

@ManagedBean(eager = true)
@ApplicationScoped
public class StudentDatabaseBean implements StudentService {

    @EJB(name = "studentDao")
    private StudentDao studentDao;

    private static final Logger LOGGER = Logger.getLogger("StudentDatabaseBean");

    @Override
    public void create(Student s) {
        LOGGER.info("createStudent invoked for: " + s);
        try {
            studentDao.create(s);
        } catch (Exception e) {
            LOGGER.warning("createStudent failed: " + e);
        }
    }
}
