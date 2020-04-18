/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author anhndSE130595
 */
public class BillDTO implements Serializable{
    String orderID, cusPhone, userID;
    String proID, proName, category;
    int price, quantity;
    Date orderDate;

    public BillDTO() {
    }

    public BillDTO(String orderID, String cusPhone, String userID) {
        this.orderID = orderID;
        this.cusPhone = cusPhone;
        this.userID = userID;
    }

    public BillDTO(String orderID, String proID, String proName, String category, int price, int quantity, Date orderDate) {
        this.orderID = orderID;
        this.proID = proID;
        this.proName = proName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    

    public String getOrderID() {
        return orderID;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getUserID() {
        return userID;
    }

    public String getProID() {
        return proID;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getProName() {
        return proName;
    }

    public String getCategory() {
        return category;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(proID);
        v.add(proName);
        v.add(category);
        v.add(quantity);
        v.add(price);
        v.add(orderDate);
        return v;
    }
}
