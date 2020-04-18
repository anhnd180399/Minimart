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
public class ProductDTO implements Serializable{
    String proID, proName, categoryID, packaging, description;
    int price;
    boolean available;

    public ProductDTO(String proID, String proName, String categoryID, String packaging, String description, int price) {
        this.proID = proID;
        this.proName = proName;
        this.categoryID = categoryID;
        this.packaging = packaging;
        this.description = description;
        this.price = price;
    }

    public ProductDTO() {
    }

    public String getProID() {
        return proID;
    }

    public String getProName() {
        return proName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getPackaging() {
        return packaging;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(proID);
        v.add(proName);
        v.add(categoryID);
        v.add(price);
        v.add(packaging);
        v.add(description);
        return v;
    }
}
