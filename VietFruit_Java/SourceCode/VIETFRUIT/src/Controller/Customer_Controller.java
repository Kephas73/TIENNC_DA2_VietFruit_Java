/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConnectDatabase;
import Model.Customer_Model;
import Model.Product_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kephas73
 */
public class Customer_Controller {
     ConnectDatabase  conn = new ConnectDatabase();
       public ResultSet List_Customer(){
        String sql = "SELECT MA_KHACH_HANG, HO_TEN, GIOI_TINH ,NGAY_SINH, SO_DIEN_THOAI, SCMND, DIEM_TICH_LUY, EMAIL, DIA_CHI FROM KHACH_HANG WHERE MA_KHACH_HANG !='KH000'";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
    public void Delete_Customer( Customer_Model Customer)
    {
         String sql = "DELETE FROM KHACH_HANG WHERE MA_KHACH_HANG='" + Customer.getMincode() + "'";
         conn.ExcuteQueryUpdateDB(sql);
    }
    public String Get_Mincode()
    {
         try {
                String sql="SELECT TOP 1 MA_KHACH_HANG FROM KHACH_HANG ORDER BY MA_KHACH_HANG DESC";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        if(rs!=null)
        {
                while (rs.next()) 
                    return rs.getString("MA_KHACH_HANG");
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
                    return "KH001";
                }
                else
                {
                    String s = Mincode.substring(2, Mincode.length());
                    int i=Integer.parseInt(s);
                    i++;
                    if (i < 10) return "KH00" + Integer.toString(i);
                    else
                        if (i < 100) return "KH0" + Integer.toString(i);
                        else return "KH" + Integer.toString(i);
                    
                }
    }
    public void Add_Customer(Customer_Model Customer)
    {
           // String Packaging = DateFormat.getDateInstance().format(Product.getPackaging());
            //String Expiration = DateFormat.getDateInstance().format(Product.getExpiration());
            String sql = "INSERT INTO KHACH_HANG VALUES('" + Customer.getMincode() + "',N'" + Customer.getName() + "',N'" + Customer.getSex() + "','" + Customer.getBirthday() + "','" + Customer.getPhone() + "','" + Customer.getIDCard() + "','" + Customer.getPoints() + "','" + Customer.getEmail() + "',N'" + Customer.getAddress() + "','" + Customer.getImage() + "')";
            conn.ExcuteQueryUpdateDB(sql);
    }
    public void Update_Customer(Customer_Model Customer)
    {
        // SimpleDateFormat fm= new SimpleDateFormat("{0:MM/dd/yyyy}");
        // String Packaging = fm.format(Product.getPackaging());
        // String Expiration =fm.format(Product.getExpiration());
          String sql = "UPDATE KHACH_HANG SET HO_TEN=N'" + Customer.getName() + "',GIOI_TINH=N'" + Customer.getSex() + "',NGAY_SINH='" + Customer.getBirthday() + "',SO_DIEN_THOAI='" + Customer.getPhone() + "',SCMND='" + Customer.getIDCard() + "',DIEM_TICH_LUY='" + Customer.getPoints() + "',EMAIL='" + Customer.getEmail() + "',DIA_CHI=N'" + Customer.getAddress() + "',ANH='" + Customer.getImage() + "'WHERE MA_KHACH_HANG='" + Customer.getMincode() + "'";
         conn.ExcuteQueryUpdateDB(sql);
    }
     public ResultSet Search_Name(String key){
       String sql = "SELECT MA_KHACH_HANG, HO_TEN, GIOI_TINH ,NGAY_SINH, SO_DIEN_THOAI, SCMND, DIEM_TICH_LUY, EMAIL, DIA_CHI FROM KHACH_HANG WHERE HO_TEN LIKE N'%" + key + "%' AND MA_KHACH_HANG != 'KH000'";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
     public ResultSet Search_Mincode(String key){
       String sql = "SELECT MA_KHACH_HANG, HO_TEN, GIOI_TINH ,NGAY_SINH, SO_DIEN_THOAI, SCMND, DIEM_TICH_LUY, EMAIL, DIA_CHI FROM KHACH_HANG WHERE MA_KHACH_HANG LIKE '%__" + key + "%' AND MA_KHACH_HANG != 'KH000'";// Bỏ hai kí tự đầu
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
     public void Update_Point(Customer_Model Customer)
     {
          String sql = "UPDATE KHACH_HANG SET DIEM_TICH_LUY='" + Customer.getPoints() + "' WHERE MA_KHACH_HANG='" + Customer.getMincode() + "'";
         conn.ExcuteQueryUpdateDB(sql);
     }
}
