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
public class CategoryDTO implements Serializable{
    String categoryID, categoryName, description;

    public CategoryDTO(String categoryID, String categoryName, String description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
    }

    public CategoryDTO() {
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(categoryID);
        v.add(categoryName);
        v.add(description);
        return v;
    }    
}
