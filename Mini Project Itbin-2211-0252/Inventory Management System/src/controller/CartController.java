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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shama
 */
public class CartController {
public static boolean checkStock(int productPk, int noOfUnits) {
        try {
            Connection con = DBconnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT quantity FROM product WHERE product_pk=" + productPk);
            if (rs.next()) {
                if (rs.getInt("quantity") >= noOfUnits) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Product is out of stock. Only " + rs.getInt("quantity") + " left");
                    return false;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public static boolean addProductToCart(DefaultTableModel model, int productPk, String productName, String noOfUnits, String productPrice, String productDescription, int totalPrice) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productPk) {
                JOptionPane.showMessageDialog(null, "Product already exists in cart");
                return false;
            }
        }
        model.addRow(new Object[]{productPk, productName, noOfUnits, productPrice, productDescription, totalPrice});
        return true;
    }
}
