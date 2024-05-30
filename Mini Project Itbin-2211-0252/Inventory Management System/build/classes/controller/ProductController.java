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
public class ProductController {


    public static boolean addProduct(String name, String quantity, String price, String description, String categoryId) {
        try {
            Connection con = DBconnection.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO product (name, quantity, price, description, category_fk) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, quantity);
            ps.setString(3, price);
            ps.setString(4, description);
            ps.setString(5, categoryId);
            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Product added successfully");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add product");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    
}



