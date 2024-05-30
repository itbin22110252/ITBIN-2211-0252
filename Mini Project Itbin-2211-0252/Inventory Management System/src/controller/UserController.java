/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UserController {
public void saveUser(String name, String mobileNumber, String email, String password, String address, String status) {
        if (validateFields(name, mobileNumber, email, password, address, status)) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                Connection con = DBconnection.getCon();
                PreparedStatement ps = con.prepareStatement("insert into appuser (userRole, name, mobileNumber, email, password, address, status) values ('Admin',?,?,?,?,?,?)");
                ps.setString(1, name);
                ps.setString(2, mobileNumber);
                ps.setString(3, email);
                ps.setString(4, password);
                ps.setString(5, address);
                ps.setString(6, status);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "User added successfully");
                // Assuming you have a reference to your current JFrame or JDialog
                // currentFrame.setVisible(false);
                new UserController().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private boolean validateFields(String name, String mobileNumber, String email, String password, String address, String status) {
        return name.isEmpty() || mobileNumber.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty() || status.isEmpty();
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public static boolean deleteUser(int appuserpk) {
        try {
            Connection con = DBconnection.getCon();
            PreparedStatement ps = con.prepareStatement("DELETE FROM appuser WHERE appuser_pk = ?");
            ps.setInt(1, appuserpk);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean updateUser(int appuserpk, String name, String mobileNumber, String email, String address, String status) {
        try {
            Connection con = DBconnection.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE appuser SET name=?, mobileNumber=?, email=?, address=?, status=? WHERE appuser_pk=?");
            ps.setString(1, name);
            ps.setString(2, mobileNumber);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, status);
            ps.setInt(6, appuserpk);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
