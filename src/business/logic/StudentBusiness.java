/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logic;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.DB_Connection;
import models.StudentModel;

/**
 *
 * @author manav
 */
public class StudentBusiness {
    public boolean createStudent(StudentModel model){
        
        DB_Connection dbcon = new DB_Connection();
        
        try{
            dbcon.pst = dbcon.con.prepareStatement("insert into tbl_student (name, roll_no, class, section) values (?,?,?,?)");
            dbcon.pst.setString(1, model.getName());            
            dbcon.pst.setInt(2, model.getRollNo());
            dbcon.pst.setInt(3, model.getClassName());
            dbcon.pst.setString(4, model.getSection());
            
            int i = dbcon.pst.executeUpdate();
            if(i == 1){
                return true;
            }
            else{
                return false;
            }
            
        }catch(Exception ex){
            ex.getMessage();
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
        
     
    }
    
    public void updateStudent(int id){
        
    }
    
    public void deleteStudent(int id){
        
    }
    public List listStudent(){
        
        return new ArrayList();
    }
    
}
