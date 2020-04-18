/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.dao;

import duyanh.connection.MyConnection;
import duyanh.dto.BillDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhndSE130595
 */
public class BillDAO implements Serializable {

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

    public boolean exportBill(BillDTO dto, List<BillDTO> listBillDetail) throws Exception {
        boolean check = false;
        conn = MyConnection.getConnection();
        try {
            conn.setAutoCommit(false);
            String sql1 = "Insert into Bill(OrderID, CustomerPhone, UserID) values(?,?,?)";
            stm = conn.prepareStatement(sql1);
            stm.setString(1, dto.getOrderID());
            stm.setString(2, dto.getCusPhone());
            stm.setString(3, dto.getUserID());
            check = stm.executeUpdate() > 0;

            for (BillDTO billDTO : listBillDetail) {
                String sql = "Insert into BillDetail(OrderID, ProductID, ProductName, CategoryID, Price, Quantity, OrderDate) values (?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, billDTO.getOrderID());
                stm.setString(2, billDTO.getProID());
                stm.setString(3, billDTO.getProName());
                stm.setString(4, billDTO.getCategory());
                stm.setInt(5, billDTO.getPrice());
                stm.setInt(6, billDTO.getQuantity());
                stm.setDate(7, billDTO.getOrderDate());
                check = stm.executeUpdate() > 0;
            }
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            check = false;
        } finally {
            closeConnection();
        }
        return check;

    }
    public BillDTO searchByBillID(String billID)throws Exception{
        BillDTO dto = null;
        try {
            String sql = "Select CustomerPhone, UserID From Bill Where OrderID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, billID);
            rs = stm.executeQuery();
            if(rs.next()){
                dto = new BillDTO();
                String cusPhone, userID;
                cusPhone = rs.getString("CustomerPhone");
                userID = rs.getString("UserID");
                dto.setCusPhone(cusPhone);
                dto.setUserID(userID);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public List<BillDTO> searchDetail(String billID)throws Exception{
        List<BillDTO> list ;
        try{
            String sql = "Select ProductID, ProductName, CategoryID, Price, Quantity, OrderDate From BillDetail Where OrderID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, billID);
            rs = stm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()){
                String proID, proName, categoryID;
                int price, quantity;
                Date date;
                proID = rs.getString("ProductID");
                proName = rs.getString("ProductName");
                categoryID = rs.getString("CategoryID");
                price = rs.getInt("Price");
                quantity = rs.getInt("Quantity");
                date = rs.getDate("OrderDate");
                list.add(new BillDTO(billID, proID, proName, categoryID, price, quantity, date));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    public List<BillDTO> searchDetailByPhone(String phone)throws Exception{
        List<BillDTO> list ;
        try{
            String sql = "Select OrderID, ProductID, ProductName, CategoryID, Price, Quantity, OrderDate From BillDetail Where OrderID In "
                    + "(Select OrderID From Bill Where CustomerPhone = ?)";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, phone);
            rs = stm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()){
                String orderID, proID, proName, categoryID;
                int price, quantity;
                Date date;
                orderID = rs.getString("OrderID");
                proID = rs.getString("ProductID");
                proName = rs.getString("ProductName");
                categoryID = rs.getString("CategoryID");
                price = rs.getInt("Price");
                quantity = rs.getInt("Quantity");
                date = rs.getDate("OrderDate");
                list.add(new BillDTO(orderID, proID, proName, categoryID, price, quantity, date));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
