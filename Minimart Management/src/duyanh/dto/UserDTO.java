/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.dto;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author anhndSE130595
 */
public class UserDTO implements Serializable {

    String userID, passWord, fullName, gender, address, phone, role, note ;
    boolean available;

    public UserDTO(String userID, String passWord, String fullName, String gender, String address, String phone, String role, String note) {
        this.userID = userID;
        this.passWord = passWord;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.note = note;
    }

    public UserDTO(String userID, String fullName, String gender, String address, String phone, String role, String note) {
        this.userID = userID;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.note = note;
    }
    
    public String getUserID() {
        return userID;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getNote() {
        return note;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(userID);
        v.add(fullName);
        v.add(gender);
        v.add(phone);
        v.add(address);
        v.add(role);
        v.add(note);
        return v;
    }
}
