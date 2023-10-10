package FORM;

//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;

import javax.swing.*;
import java.sql.*;

public class RegisterDAO {

 
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status
 
    public int registerStudent(Student student) throws MySQLQueryInterruptedException {
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into "
                    + "student "
                    + "(name,dob,gender,mailid,mobile_no,password,program,branch,semester) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setDate(2, (Date) student.getDob());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getMailId());
            ps.setString(5, student.getMobileNo());
            ps.setString(6, student.getEncPassword());
            ps.setString(7, student.getProgram());
            ps.setString(8, student.getBranch());
            ps.setInt(9, student.getSemester());
            st = ps.executeUpdate();
            System.out.println("Inserted  student " + st);
        } catch (MySQLQueryInterruptedException e) {
            /*This exception is throws when user is already
            registed with same id, mobileno or mail id*/
            e.printStackTrace();
            st = -1;
        } catch (SQLException e) {
            /*Any SqlException occures then this will execute*/
            e.printStackTrace();
            st = -2;
        }
        RegisterDAO dao = new RegisterDAO();
        int st = dao.registerStudent(student);

        System.out.println(st);
        if (st == 1) {
            JOptionPane.showMessageDialog(null, "Registered Successfully");

        }
        if (st == -1) {
            JOptionPane.showMessageDialog(null, "Already Registered");
        }
        if (st == -2) {
            JOptionPane.showMessageDialog(null, "OOps Unable to Register");
        }
        return st;
    }

}