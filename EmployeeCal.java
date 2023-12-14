package employee;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeCal {
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<Employee> bringEmployees() {
        
        ArrayList<Employee> output = new ArrayList<Employee>();
        
        try {
            statement =  con.createStatement();
            String query =  "Select * From employeee";
            
            ResultSet rs =  statement.executeQuery(query);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String dept  = rs.getString("departmant");
                String salary = rs.getString("salary");
                
                output.add(new Employee(id, name, surname, dept, salary));
                
                
            }
            return output;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
        
        
        
        
    }
    public void updateEmployees(int id,String new_name,String new_surname,String new_department,String new_salary) {
        String sorgu =  "Update calisanlar set ad = ? , soyad = ? , departman = ? , maas = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,new_name);
            preparedStatement.setString(2,new_surname);
            
            preparedStatement.setString(3,new_department);
            preparedStatement.setString(4,new_salary);
            
            preparedStatement.setInt(5, id);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void deleteEmployees(int id) {
        
        String query = "Delete from employee where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    public void calisanEkle(String name,String surname,String departmant,String salary) {
        
        String sorgu = "Insert Into calisanlar (name,surname,departmant,salary) VALUES(?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, departmant);
            preparedStatement.setString(4, salary);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    public boolean logIn(String user_name,String keyword) {
        
        String sorgu =  "Select * From adminler where username = ? and password = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1,user_name);
            preparedStatement.setString(2,keyword);
            
            ResultSet rs =  preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        
        
        
        
        
    }
    public EmployeeCal() {
        
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_name+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Can Not Found....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, Database.user_name, Database.keyword);
            System.out.println("Connection Successful...");
            
            
        } catch (SQLException ex) {
            System.out.println("Connection Failed...");
            //ex.printStackTrace();
        }
        
        
    }
    
}
