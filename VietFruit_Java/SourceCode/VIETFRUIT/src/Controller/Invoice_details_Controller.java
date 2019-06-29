/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConnectDatabase;
import Model.Invoice_details_Model;

/**
 *
 * @author Kephas73
 */
public class Invoice_details_Controller {
    
    ConnectDatabase  conn = new ConnectDatabase();
     public void Add_Invoice_details(Invoice_details_Model Invoice_details)
    {
           // String Packaging = DateFormat.getDateInstance().format(Product.getPackaging());
            //String Expiration = DateFormat.getDateInstance().format(Product.getExpiration());
             String sql = "INSERT INTO CHI_TIET_HOA_DON VALUES('" + Invoice_details.getMincdeI() + "','" + Invoice_details.getMincodeP() + "','" + Invoice_details.getWeight() + "','" + Invoice_details.getPrice() + "','" + Invoice_details.getCash() + "')";
            conn.ExcuteQueryUpdateDB(sql);
    }
    
}
