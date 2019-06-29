/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Kephas73
 */
public class Product_Model {
    
     String Mincode, Name,Supplier,Origin, Image;

   
    Float Weight,Price_in,Price_out;
    String Packaging,Expiration;
   

    public String getMincode() {
        return Mincode;
    }

    public void setMincode(String Mincode) {
        this.Mincode = Mincode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public Float getWeight() {
        return Weight;
    }

    public void setWeight(Float Weight) {
        this.Weight = Weight;
    }

    public Float getPrice_in() {
        return Price_in;
    }

    public void setPrice_in(Float Price_in) {
        this.Price_in = Price_in;
    }

    public Float getPrice_out() {
        return Price_out;
    }

    public void setPrice_out(Float Price_out) {
        this.Price_out = Price_out;
    }

    public String getPackaging() {
        return Packaging;
    }

    public void setPackaging(String Packaging) {
        this.Packaging = Packaging;
    }

    public String getExpiration() {
        return Expiration;
    }

    public void setExpiration(String Expiration) {
        this.Expiration = Expiration;
    }
     public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
}
