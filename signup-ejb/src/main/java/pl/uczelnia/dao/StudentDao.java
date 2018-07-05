package pl.uczelnia.dao;

import pl.uczelnia.jpa.Student;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class StudentDao extends AbstractDao {
    private Logger logger = Logger.getLogger("Signup");

    @Override
    protected Class getType() {
        return Student.class;
    }
}
