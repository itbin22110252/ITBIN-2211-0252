/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Model.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author shama
 */
public class LoginController {
    public static boolean loginUser(String email, String password) {
        try {
            Connection con = DBconnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from appuser where email='" + email + "' and password='" + password + "' and status='Active'");
            if (rs.next()) {
                // User found, login successful
                return true;
            } else {
                // User not found, login failed
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
