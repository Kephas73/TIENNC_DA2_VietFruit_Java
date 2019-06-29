/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConnectDatabase;
import Model.Invoice_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kephas73
 */
public class Invoice_Controller {
    
    ConnectDatabase  conn = new ConnectDatabase();
     public String Get_Mincode()
    {
         try {
                String sql="SELECT TOP 1 MA_HOA_DON FROM HOA_DON ORDER BY MA_HOA_DON DESC";
                ResultSet rs=conn.ExcuteQueryGetTable(sql);
        if(rs!=null)
        {
                while (rs.next()) 
                    return rs.getString("MA_HOA_DON");
        }          
        }catch (SQLException ex) {
                Logger.getLogger(Product_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
            
    }
     
    public String Auto_Increment_Mincode()
    {
        String Mincode=Get_Mincode();
         if (Mincode == "")
                {
                    return "HD0001";
                }
                else
                {
                    String s = Mincode.substring(2, Mincode.length());
                    int i=Integer.parseInt(s);
                    i++;
                    if (i < 10) return "HD000" + Integer.toString(i);
                    else
                        if (i < 100) return "HD00" + Integer.toString(i);
                        else if(i<1000) return "HD0" + Integer.toString(i);
                        else return "HD" + Integer.toString(i);
                    
                }
    }
    
    public void Add_Invoice(Invoice_Model Invoice)
    {
           // String Packaging = DateFormat.getDateInstance().format(Product.getPackaging());
            //String Expiration = DateFormat.getDateInstance().format(Product.getExpiration());
             String sql = "INSERT INTO HOA_DON VALUES('" + Invoice.getMincodeI() + "','" +Invoice.getMincodeE() + "','" + Invoice.getMincodeC() + "','" + Invoice.getDay() + "','" + Invoice.getCash() + "')";
            conn.ExcuteQueryUpdateDB(sql);
    }
    public void Add_Invoice_Not_Customer(Invoice_Model Invoice)
    {
           // String Packaging = DateFormat.getDateInstance().format(Product.getPackaging());
            //String Expiration = DateFormat.getDateInstance().format(Product.getExpiration());
             String sql = "INSERT INTO HOA_DON VALUES('" + Invoice.getMincodeI() + "','" +Invoice.getMincodeE() + "',NULL,'" + Invoice.getDay() + "','" + Invoice.getCash() + "')";
            conn.ExcuteQueryUpdateDB(sql);
    }
}
