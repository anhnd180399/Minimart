/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.dao;

import duyanh.connection.MyConnection;
import duyanh.dto.CustomerDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author anhndSE130595
 */
public class CustomerDAO implements Serializable {

    Connection conn;
    PreparedStatement stm;
    ResultSet rs;

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CustomerDTO checkCusPhone(String phone) throws Exception {
        CustomerDTO dto = null;
        try {
            String sql = "Select CustomerName, Address From Customer Where Phone = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, phone);
            rs = stm.executeQuery();
            if (rs.next()) {
                dto = new CustomerDTO();
                dto.setCustomerName(rs.getString("CustomerName"));
                dto.setAddress(rs.getString("Address"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean  insertCustomer(CustomerDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Customer(Phone, CustomerName, Address) values(?,?,?)";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getPhone());
            stm.setString(2, dto.getCustomerName());
            stm.setString(3, dto.getAddress());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
