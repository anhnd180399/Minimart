/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.dao;

import duyanh.connection.MyConnection;
import duyanh.dto.CategoryDTO;
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
public class CategoryDAO implements Serializable {

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

    public boolean checkSubCategory(String categoryID) throws Exception {
        boolean check = false;
        try {
            String sql = "Select ProductID From Product Where CategoryID = ? And Available = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, categoryID);
            stm.setBoolean(2, true);
            rs = stm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<CategoryDTO> getAllCategory() throws Exception {
        List<CategoryDTO> list;
        try {
            String sql = "Select CategoryID, CategoryName, Description From Category Where Available = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setBoolean(1, true);
            rs = stm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id, name, description;
                id = rs.getString("CategoryID");
                name = rs.getString("CategoryName");
                description = rs.getString("Description");
                list.add(new CategoryDTO(id, name, description));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    public boolean checkCategoryID(String categoryID)throws Exception{
        boolean check = false;
        try{
            String sql = "Select CategoryName From Category Where CategoryID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, categoryID);
            rs = stm.executeQuery();
            if(rs.next()) check = true;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean insertCategory(CategoryDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Category(CategoryID, CategoryName, Description, Available) values(?,?,?,?)";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getCategoryID());
            stm.setString(2, dto.getCategoryName());
            stm.setString(3, dto.getDescription());
            stm.setBoolean(4, true);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateCategory(CategoryDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Category Set CategoryName = ?, Description = ? Where CategoryID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getCategoryName());
            stm.setString(2, dto.getDescription());
            stm.setString(3, dto.getCategoryID());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteCategory(String categoryID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Category Set Available = ? Where CategoryID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setBoolean(1, false);
            stm.setString(2, categoryID);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
