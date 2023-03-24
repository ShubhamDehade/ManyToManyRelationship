package bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lId;
    private String lName;
    @ManyToMany
    @JoinTable(
            name="student_laptop",
            joinColumns=@JoinColumn(name = "laptop_ref"),
            inverseJoinColumns = @JoinColumn(name ="student_ref" )

    )
    private List<Student> students;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudents(Student s){
        if (students==null){
            students=new ArrayList<>();
        }
        students.add(s);
    }
}
