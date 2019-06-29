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
public class Invoice_Model {

    String MincodeI, MincodeE,MincodeC,Day;
    Float Cash;
    public String getMincodeI() {
        return MincodeI;
    }

    public void setMincodeI(String MincodeI) {
        this.MincodeI = MincodeI;
    }

    public String getMincodeE() {
        return MincodeE;
    }

    public void setMincodeE(String MincodeE) {
        this.MincodeE = MincodeE;
    }

    public String getMincodeC() {
        return MincodeC;
    }

    public void setMincodeC(String MincodeC) {
        this.MincodeC = MincodeC;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public Float getCash() {
        return Cash;
    }

    public void setCash(Float Cash) {
        this.Cash = Cash;
    }
   
}
