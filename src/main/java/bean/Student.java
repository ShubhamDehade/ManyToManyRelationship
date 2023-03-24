package bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;
    private String sName;
    private int sMarks;
    @ManyToMany
    @JoinTable(
            name = "student_laptop",
            joinColumns = @JoinColumn(name = "student_ref"),
            inverseJoinColumns = @JoinColumn(name = "laptop_ref")
    )
    private List<Laptop> laptops;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsMarks() {
        return sMarks;
    }

    public void setsMarks(int sMarks) {
        this.sMarks = sMarks;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
    public void addLaptops(Laptop lp){
        if (laptops==null){
            laptops=new ArrayList<>();
        }
        laptops.add(lp);

    }
}
