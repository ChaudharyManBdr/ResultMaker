/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.logic.StudentBusiness;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import models.StudentModel;

/**
 *
 * @author manav
 */
public class StudentController {
    public void createStudent(List list){
        StudentModel studentModel = new StudentModel();
        StudentBusiness studentBusiness = new StudentBusiness();
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            studentModel.setName(itr.next().toString());            
            studentModel.setRollNo((Integer)itr.next());
            studentModel.setClassName((Integer)itr.next());
            studentModel.setSection(itr.next().toString());                    
        }
       if(studentBusiness.createStudent(studentModel)){
           JOptionPane.showMessageDialog(null, "Successfully Student Information Saved !!");
       } 
       else{
           JOptionPane.showMessageDialog(null, "Sorry Error Occured !!");
       }
    }
}
