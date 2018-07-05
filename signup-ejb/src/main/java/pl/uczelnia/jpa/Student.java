package pl.uczelnia.jpa;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String firstname;
    private String lastname;
    private String email;

    public Student() {
    }

    @Column(name = "id", nullable=false)
    public int getId() { return id;
    }

    public void setId(int id) { this.id = id;
    }

    @Column(name = "firstname", nullable = false)
    public String getFirstname() { return firstname;
    }

    public void setFirstname(String firstname) { this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = false)
    public String getLastname() { return lastname;
    }

    public void setLastname(String lastname) { this.lastname = lastname;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() { return email;
    }

    public void setEmail(String email) { this.email = email;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("firstName='").append(firstname).append('\'');
        sb.append(", id=").append(id);
        sb.append(", lastName='").append(lastname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
