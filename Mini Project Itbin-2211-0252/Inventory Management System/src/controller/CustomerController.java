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
  public static boolean addCustomer(String name, String mobileNumber, String email) throws Exception {
        Connection con = DBconnection.getCon();
        PreparedStatement ps = con.prepareStatement("INSERT INTO customer (name, mobileNumber, email) VALUES (?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, mobileNumber);
        ps.setString(3, email);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    }
  
  public static boolean updateCustomer(String name, String mobileNumber, String email, int customerId) {
    try {
        Connection con = DBconnection.getCon();
        PreparedStatement ps = con.prepareStatement("UPDATE customer SET name=?, mobileNumber=?, email=? WHERE customer_pk=?");
        ps.setString(1, name);
        ps.setString(2, mobileNumber);
        ps.setString(3, email);
        ps.setInt(4, customerId);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    
}
  
}
