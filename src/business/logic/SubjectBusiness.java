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
import models.SubjectModel;

/**
 *
 * @author manav
 */
public class SubjectBusiness {
        public boolean createSubject(SubjectModel model){
        
        DB_Connection dbcon = new DB_Connection();
        
        try{
            dbcon.pst = dbcon.con.prepareStatement("insert into tbl_subjects (class, subject) values (?,?)");
           
            dbcon.pst.setInt(1, model.getClassName());
            dbcon.pst.setString(2, model.getSubject());
            
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
        public boolean updateSubject(){
            return false;
        }
        public boolean deleteSubject(){
            return false;
        }
        public List listSubject(){
            List<SubjectModel> list = new ArrayList<SubjectModel>();
            
            
            
            return list;
        }
        public List searchSubject(){
            List list = new ArrayList();
            
            
            return list;
        }
}
