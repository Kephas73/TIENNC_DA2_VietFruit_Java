/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConnectDatabase;
import Model.Customer_Model;
import Model.Employee_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kephas73
 */
public class Employee_Controller {
     ConnectDatabase  conn = new ConnectDatabase();
       public ResultSet List_Employee(){
        String sql = "SELECT MA_NHAN_VIEN,TEN_NHAN_VIEN,GIOI_TINH,NGAY_SINH,TEN_BO_PHAN,SO_DIEN_THOAI,SCMND,EMAIL,DIA_CHI,LUONG_CO_BAN FROM NHAN_VIEN WHERE MA_NHAN_VIEN !='NV000'";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
    public void Delete_Employee( Employee_Model Employee)
    {
         String sql = "DELETE FROM NHAN_VIEN WHERE MA_NHAN_VIEN='" + Employee.getMincode() + "'";
         conn.ExcuteQueryUpdateDB(sql);
    }
    public String Get_Mincode()
    {
         try {
         String sql="SELECT TOP 1 MA_NHAN_VIEN FROM NHAN_VIEN ORDER BY MA_NHAN_VIEN DESC";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        if(rs!=null)
        {
                while (rs.next()) 
                    return rs.getString("MA_NHAN_VIEN");
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
                    return "NV001";
                }
                else
                {
                    String s = Mincode.substring(2, Mincode.length());
                    int i=Integer.parseInt(s);
                    i++;
                    if (i < 10) return "NV00" + Integer.toString(i);
                    else
                        if (i < 100) return "NV0" + Integer.toString(i);
                        else return "NV" + Integer.toString(i);
                    
                }
    }
     public void Add_Employee(Employee_Model Employee)
    {
           // String Packaging = DateFormat.getDateInstance().format(Product.getPackaging());
            //String Expiration = DateFormat.getDateInstance().format(Product.getExpiration());
            String sql = "INSERT INTO NHAN_VIEN VALUES('" + Employee.getMincode() + "',N'" + Employee.getName() + "',N'" + Employee.getSex() + "','" + Employee.getBirthday() + "',N'" + Employee.getPosition() + "','" + Employee.getPhone() + "','" + Employee.getIDCard() + "','" + Employee.getEmail() + "',N'" + Employee.getAddress() + "','" + Employee.getSalary() + "','"+ Employee.getImage() +"')";
            conn.ExcuteQueryUpdateDB(sql);
    }
    public void Update_Employee(Employee_Model Employee)
    {
        // SimpleDateFormat fm= new SimpleDateFormat("{0:MM/dd/yyyy}");
        // String Packaging = fm.format(Product.getPackaging());
        // String Expiration =fm.format(Product.getExpiration());
          String sql = "UPDATE NHAN_VIEN SET TEN_NHAN_VIEN=N'" + Employee.getName() + "',GIOI_TINH=N'" + Employee.getSex() + "',NGAY_SINH='" + Employee.getBirthday() + "',TEN_BO_PHAN=N'"+ Employee.getPosition() +"',SO_DIEN_THOAI='" + Employee.getPhone() + "',SCMND='" + Employee.getIDCard() + "',EMAIL='" + Employee.getEmail() + "',DIA_CHI=N'" + Employee.getAddress() + "',LUONG_CO_BAN='"+ Employee.getSalary() +"',ANH='" + Employee.getImage() + "'WHERE MA_NHAN_VIEN='" + Employee.getMincode() + "'";
         conn.ExcuteQueryUpdateDB(sql);
    }
    public ResultSet Search_Name(String key){
        String sql = "SELECT MA_NHAN_VIEN,TEN_NHAN_VIEN,GIOI_TINH,NGAY_SINH,TEN_BO_PHAN,SO_DIEN_THOAI,SCMND,EMAIL,DIA_CHI,LUONG_CO_BAN FROM NHAN_VIEN WHERE TEN_NHAN_VIEN LIKE N'%" + key + "%' AND MA_NHAN_VIEN !='NV000'";
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
     public ResultSet Search_Mincode(String key){
       String sql = "SELECT MA_NHAN_VIEN,TEN_NHAN_VIEN,GIOI_TINH,NGAY_SINH,TEN_BO_PHAN,SO_DIEN_THOAI,SCMND,EMAIL,DIA_CHI,LUONG_CO_BAN FROM NHAN_VIEN WHERE MA_NHAN_VIEN LIKE '%__" + key + "%' AND MA_NHAN_VIEN !='NV000'";// Bỏ hai kí tự đầu
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
     public ResultSet Search_Mincode_cashier(String key){
       String sql = " SELECT MA_NHAN_VIEN,TEN_NHAN_VIEN,GIOI_TINH,NGAY_SINH,TEN_BO_PHAN,SO_DIEN_THOAI,SCMND,EMAIL,DIA_CHI,LUONG_CO_BAN FROM NHAN_VIEN WHERE MA_NHAN_VIEN LIKE '%__" + key + "%' AND TEN_BO_PHAN=N'Thu ngân' AND MA_NHAN_VIEN !='NV000'";// Bỏ hai kí tự đầu
        ResultSet rs=conn.ExcuteQueryGetTable(sql);
        return rs;
        
    }
}
