/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logic;

import javax.swing.JOptionPane;
import models.DB_Connection;
import models.LoginModel;

/**
 *
 * @author manav
 */
public class LoginBusiness {

    public boolean userLogin(LoginModel log) {
        DB_Connection dbcon = new DB_Connection();

        try {
            dbcon.pst = dbcon.con.prepareStatement("select * from tbl_login where username=? and password=?");

            dbcon.pst.setString(1, log.getUsername());
            dbcon.pst.setString(2, log.getPassword());

            dbcon.rs = dbcon.pst.executeQuery();
            if (dbcon.rs.next()) {
                return true;

            } else {
                return false;

            }

        } catch (Exception ex) {
            ex.getMessage();
            return false;

        }

    }

    public boolean updatePassword(LoginModel model, String oldPass) {

        DB_Connection dbcon = new DB_Connection();

        try {

            dbcon.pst = dbcon.con.prepareStatement("update tbl_login set password =? where  password=?");

            dbcon.pst.setString(1, model.getPassword());
            dbcon.pst.setString(2, oldPass);

            int check = dbcon.pst.executeUpdate();
            if (check == 1) {
                return true;

            } else {
                return false;

            }

        } catch (Exception ex) {
            ex.getMessage();
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;

        }

    }

    public boolean updateUsernameAndPassword(LoginModel model, String newUsername, String newPassword) {

        DB_Connection dbcon = new DB_Connection();

        int id = 0;

        try {
            dbcon.pst = dbcon.con.prepareStatement("select id from tbl_login where username=? and password=?");
            dbcon.pst.setString(1, model.getUsername());
            dbcon.pst.setString(2, model.getPassword());

            dbcon.rs = dbcon.pst.executeQuery();
            while (dbcon.rs.next()) {
                id = dbcon.rs.getInt(1);
            }
            dbcon.pst = dbcon.con.prepareStatement("update tbl_login set username =?  where id =?");
            dbcon.pst.setString(1, newUsername);
            dbcon.pst.setInt(2, id);
            int check = dbcon.pst.executeUpdate();
            
            dbcon.pst = dbcon.con.prepareStatement("update tbl_login set password=?  where id =?");
            dbcon.pst.setString(1, newPassword);
            dbcon.pst.setInt(2, id);
            check += dbcon.pst.executeUpdate();
            
            if (check == 2) {
                return true;

            } else {
                return false;

            }

        } catch (Exception ex) {
            ex.getMessage();
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;

        }
    }

}
