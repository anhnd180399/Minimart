/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.dao;

import duyanh.connection.MyConnection;
import duyanh.dto.CategoryDTO;
import duyanh.dto.ProductDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhndSE130595
 */
public class ProductDAO implements Serializable {

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

    public List<String> getCategoryID() throws Exception {
        List<String> result;
        try {
            String sql = "Select CategoryID From Category Where Available = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setBoolean(1, true);
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString("CategoryID"));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> getAll() throws Exception {
        List<ProductDTO> list;
        try {
            String sql = "Select ProductID, ProductName, CategoryID, UnitPrice, Packaging, Description From Product Where Available = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setBoolean(1, true);
            rs = stm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String proID, proName, categoryID, packaging, description;
                int price;
                proID = rs.getString("ProductID");
                proName = rs.getString("ProductName");
                categoryID = rs.getString("CategoryID");
                price = rs.getInt("UnitPrice");
                packaging = rs.getString("Packaging");
                description = rs.getString("Description");
                list.add(new ProductDTO(proID, proName, categoryID, packaging, description, price));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean checkProductID(String proID) throws Exception {
        boolean check = false;
        try {
            String sql = "Select ProductName From Product Where ProductID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, proID);
            rs = stm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    public ProductDTO getProductByID(String proID) throws Exception{
        ProductDTO dto = null ;
        try {
            String sql = "Select ProductName, CategoryID, UnitPrice From Product Where ProductID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, proID);
            rs = stm.executeQuery();
            if(rs.next()){
                dto = new ProductDTO();
                dto.setProName(rs.getString("ProductName"));
                dto.setCategoryID(rs.getString("CategoryID"));
                dto.setPrice(rs.getInt("UnitPrice"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public boolean insertProduct(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Product(ProductID, ProductName, CategoryID, UnitPrice, Packaging, Description, Available) values(?,?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getProID());
            stm.setString(2, dto.getProName());
            stm.setString(3, dto.getCategoryID());
            stm.setInt(4, dto.getPrice());
            stm.setString(5, dto.getPackaging());
            stm.setString(6, dto.getDescription());
            stm.setBoolean(7, true);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateProduct(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Product Set ProductName = ?, CategoryID = ?, UnitPrice = ?, Packaging = ?, Description = ? From Product Where ProductID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getProName());
            stm.setString(2, dto.getCategoryID());
            stm.setInt(3, dto.getPrice());
            stm.setString(4, dto.getPackaging());
            stm.setString(5, dto.getDescription());
            stm.setString(6, dto.getProID());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean deleteProduct(String productID)throws Exception{
        boolean check = false;
        try {
            String sql = "Update Product Set Available = ? Where ProductID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setBoolean(1,false);
            stm.setString(2,productID);
            check = stm.executeUpdate() > 0; 
        } finally {
            closeConnection();
        }
        return check;
    }
}
