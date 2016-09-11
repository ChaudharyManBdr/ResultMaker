/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import business.logic.SubjectBusiness;
import java.util.Iterator;
import models.SubjectModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manav
 */
public class SubjectController {
    
    public static void main(String[] args) {
        
        SubjectBusiness  sb = new SubjectBusiness();
        //System.out.println(sb.createSubject(model));
    }
    
    public void createSubject(List list){
        SubjectModel subjectModel = new SubjectModel();
        SubjectBusiness subjectBusiness = new SubjectBusiness();
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            subjectModel.setClassName((int)itr.next());
            subjectModel.setSubject(itr.next().toString());
        }
        if(subjectBusiness.createSubject(subjectModel)){
            JOptionPane.showMessageDialog(null, "Subject added successfully !!!");
        }
        else{
             JOptionPane.showMessageDialog(null, "Sorry error occurred !!!");
        }
        
    }
}
