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
public class CustomerDTO implements Serializable{
    String phone, customerName, address;

    public CustomerDTO() {
    }

    public CustomerDTO(String phone, String customerName, String address) {
        this.phone = phone;
        this.customerName = customerName;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
