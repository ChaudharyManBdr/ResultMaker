/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.logic.LoginBusiness;
import java.util.Iterator;
import java.util.List;
import views.MainPage;
import javax.swing.JOptionPane;
import models.LoginModel;

/**
 *
 * @author manav
 */
public class LoginController {

    public void actionLogin(String userName, String passWord) {

        LoginModel log = new LoginModel();
        LoginBusiness logBusiness = new LoginBusiness();
        log.setUsername(userName);
        log.setPassword(passWord);
        if (logBusiness.userLogin(log)) {
            MainPage mainPage = new MainPage();
            mainPage.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry Invalid Username and Password !!!");
        }

    }

    public void updatePassword(String oldPass, String newPass) {
        LoginModel log = new LoginModel();
        LoginBusiness logBusiness = new LoginBusiness();
        log.setPassword(newPass);
        if (logBusiness.updatePassword(log, oldPass)) {
            JOptionPane.showMessageDialog(null, "Successfully your password is Updated !!!");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry operation failed, try again !!!");
        }
    }

    public void updateUsernameAndPassword(List list) {
        LoginModel log = new LoginModel();
        String newUsername = null;
        String newPass = null;
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            log.setUsername(itr.next().toString());
            log.setPassword(itr.next().toString());
            newUsername = itr.next().toString();
            newPass = itr.next().toString();
        }
        
        LoginBusiness loginBusiness = new LoginBusiness();
        if(loginBusiness.updateUsernameAndPassword(log,newUsername,newPass)){
            JOptionPane.showMessageDialog(null, "Successfully Your Username And Password Updated !!!");
        }
        else{
        JOptionPane.showMessageDialog(null, "Sorry error occurred try again !!!");
    }

    }

}
