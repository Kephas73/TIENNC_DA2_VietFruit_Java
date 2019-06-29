/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kephas73
 */
public class Invoice_details_Model {

    String MincdeI,MincodeP;
    float Weight,Price,Cash;
    public String getMincdeI() {
        return MincdeI;
    }

    public void setMincdeI(String MincdeI) {
        this.MincdeI = MincdeI;
    }

    public String getMincodeP() {
        return MincodeP;
    }

    public void setMincodeP(String MincodeP) {
        this.MincodeP = MincodeP;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public float getCash() {
        return Cash;
    }

    public void setCash(float Cash) {
        this.Cash = Cash;
    }
    
}
