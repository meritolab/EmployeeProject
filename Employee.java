

public class Employee {
    
    private int id;
    private String name;
    private String surname;
    private String departmant;
    private String salary;

    public Employee(int id, String name, String surname, String departmant, String salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.departmant = departmant;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartmant() {
        return departmant;
    }

    public void setDepartmant(String departmant) {
        this.departmant = departmant;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    
}
