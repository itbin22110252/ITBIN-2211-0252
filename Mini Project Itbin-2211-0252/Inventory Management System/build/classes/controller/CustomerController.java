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

/**
 *
 * @author shama
 */
public class CustomerController {
  public static boolean addCategory(String name) {
        try {
            Connection con = DBconnection.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO customer (name) VALUES (?)");
            ps.setString(1, name);
            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Customer added successfully");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Customer");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }  
}
