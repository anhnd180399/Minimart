/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.dao;

import duyanh.connection.MyConnection;
import duyanh.dto.UserDTO;
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
public class UserDAO implements Serializable {

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

    public UserDTO checkLogin(String userName, String passWord) throws Exception {
        UserDTO dto = null;
        try {
            String sql = "Select FullName, Gender, Address, Phone, Role, Note From Employees Where UserID = ? AND PassWord = ? AND Available = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, passWord);
            stm.setBoolean(3, true);
            rs = stm.executeQuery();
            if (rs.next()) {
                String empName, gender, address, phone, role, note;
                empName = rs.getString("FullName");
                gender = rs.getString("Gender");
                address = rs.getString("Address");
                phone = rs.getString("Phone");
                role = rs.getString("Role");
                note = rs.getString("Note");
                dto = new UserDTO(userName, passWord, empName, gender, address, phone, role, note);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<UserDTO> getAll() throws Exception {
        List<UserDTO> list = null;
        try {
            String sql = "Select UserID, FullName, Gender, Address, Phone, Role, Note From Employees Where Role != ? AND Available = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, "admin");
            stm.setBoolean(2, true);
            rs = stm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String userID, empName, gender, address, phone, role, note;
                userID = rs.getString("UserID");
                empName = rs.getString("FullName");
                gender = rs.getString("Gender");
                address = rs.getString("Address");
                phone = rs.getString("Phone");
                role = rs.getString("Role");
                note = rs.getString("Note");
                list.add(new UserDTO(userID, empName, gender, address, phone, role, note));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean checkUserID(String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Select FullName From Employees Where UserID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, userID);
            rs = stm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean addUser(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Employees(UserID,PassWord,FullName,Gender,Address,Phone,Role,Note,Available) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getUserID());
            stm.setString(2, "1");
            stm.setString(3, dto.getFullName());
            stm.setString(4, dto.getGender());
            stm.setString(5, dto.getAddress());
            stm.setString(6, dto.getPhone());
            stm.setString(7, dto.getRole());
            stm.setString(8, dto.getNote());
            stm.setBoolean(9, true);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateUser(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Employees Set FullName = ?, Gender = ?, Address = ?, Phone = ?, Role = ?, Note = ? Where UserID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getFullName());
            stm.setString(2, dto.getGender());
            stm.setString(3, dto.getAddress());
            stm.setString(4, dto.getPhone());
            stm.setString(5, dto.getRole());
            stm.setString(6, dto.getNote());
            stm.setString(7, dto.getUserID());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteUser(String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Employees Set Available = ? Where UserID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setBoolean(1, false);
            stm.setString(2, userID);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean resetPassWord(String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Employees Set PassWord = ? Where UserID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, "1");
            stm.setString(2, userID);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean changePassWord(String newPassword, String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Employees Set PassWord = ? Where UserID = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, newPassword);
            stm.setString(2, userID);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
