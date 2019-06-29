/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConnectDatabase;
import Model.Product_Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Kephas73
 */
public class Product_Controller {
    
    ConnectDatabase  conn = new ConnectDatabase();
  //  Connection conn=Product.getConnectDatabase();
    public ResultSet List_Product(){
        String sql = "SELECT MA_SAN_PHAM,TEN_SAN_PHAM,KHOI_LUONG_NHAP,GIA_NHAP_VAO,GIA_BAN_RA,NGAY_DONG_GOI,NGAY_HET_HAN,NHA_CUNG_CAP,NOI_XUAT_XU FROM KHO_SAN_PHAM WHERE MA_SAN_PHAM !='SP000'";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
    
    public String Get_Mincode()
    {
         try {
                String sql="SELECT TOP 1 MA_SAN_PHAM FROM KHO_SAN_PHAM ORDER BY MA_SAN_PHAM DESC";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        if(rs!=null)
        {
                while (rs.next()) 
                    return rs.getString("MA_SAN_PHAM");
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
                    return "SP001";
                }
                else
                {
                    String s = Mincode.substring(2, Mincode.length());
                    int i=Integer.parseInt(s);
                    i++;
                    if (i < 10) return "SP00" + Integer.toString(i);
                    else
                        if (i < 100) return "SP0" + Integer.toString(i);
                        else return "SP" + Integer.toString(i);
                    
                }
    }
    public void Delete_Product( Product_Model Product)
    {
         String sql = "DELETE FROM KHO_SAN_PHAM WHERE MA_SAN_PHAM='" + Product.getMincode() + "'";
         conn.ExcuteQueryUpdateDB(sql);
    }
    public void Add_Product(Product_Model Product)
    {
           // String Packaging = DateFormat.getDateInstance().format(Product.getPackaging());
            //String Expiration = DateFormat.getDateInstance().format(Product.getExpiration());
            String sql = "INSERT INTO KHO_SAN_PHAM VALUES('" + Product.getMincode() + "',N'"+Product.getName()+"','"+Product.getWeight()+"','"+Product.getPrice_in()+"','"+Product.getPrice_out()+"','"+ Product.getPackaging() +"','"+Product.getExpiration()+"',N'"+Product.getSupplier()+"',N'"+Product.getOrigin()+"','"+Product.getImage()+"')";
            conn.ExcuteQueryUpdateDB(sql);
    }
    public void Update_Product(Product_Model Product)
    {
        // SimpleDateFormat fm= new SimpleDateFormat("{0:MM/dd/yyyy}");
        // String Packaging = fm.format(Product.getPackaging());
        // String Expiration =fm.format(Product.getExpiration());
         String sql = "UPDATE KHO_SAN_PHAM SET TEN_SAN_PHAM=N'" + Product.getName() + "',KHOI_LUONG_NHAP='" + Product.getWeight() + "',GIA_NHAP_VAO='" + Product.getPrice_in() + "',GIA_BAN_RA='" + Product.getPrice_out() + "',NGAY_DONG_GOI='" + Product.getPackaging() + "',NGAY_HET_HAN='" + Product.getExpiration() + "',NHA_CUNG_CAP=N'" + Product.getSupplier() + "',NOI_XUAT_XU=N'" + Product.getOrigin() + "',ANH='" + Product.getImage() + "'WHERE MA_SAN_PHAM='" + Product.getMincode() + "'";
         conn.ExcuteQueryUpdateDB(sql);
    }
    public ResultSet Search_Name(String key){
       String sql = "SELECT MA_SAN_PHAM,TEN_SAN_PHAM,KHOI_LUONG_NHAP,GIA_NHAP_VAO,GIA_BAN_RA,NGAY_DONG_GOI,NGAY_HET_HAN,NHA_CUNG_CAP,NOI_XUAT_XU FROM KHO_SAN_PHAM WHERE TEN_SAN_PHAM LIKE N'%" + key + "%'  AND MA_SAN_PHAM !='SP000'";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
     public ResultSet Search_Mincode(String key){
       String sql = "SELECT MA_SAN_PHAM,TEN_SAN_PHAM,KHOI_LUONG_NHAP,GIA_NHAP_VAO,GIA_BAN_RA,NGAY_DONG_GOI,NGAY_HET_HAN,NHA_CUNG_CAP,NOI_XUAT_XU FROM KHO_SAN_PHAM WHERE MA_SAN_PHAM LIKE '%__" + key + "%' AND MA_SAN_PHAM !='SP000'";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
     
}
