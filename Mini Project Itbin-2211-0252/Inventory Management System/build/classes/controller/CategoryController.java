package controller;

import Model.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CategoryController {
    
    public static boolean addCategory(String name) {
        try {
            Connection con = DBconnection.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO category (name) VALUES (?)");
            ps.setString(1, name);
            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Category added successfully");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add category");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    public void updateCategory(String name) {
        if (validateFields()) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                Connection con = DBconnection.getCon();
                PreparedStatement ps = con.prepareStatement("update category set name=? where category_pk=?");
                ps.setString(1, name);
                //ps.setInt(2, categoryPk);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Category updated successfully");
                //manageCategoryView.setVisible(false);
                //new ManageCategory().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private boolean validateFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}