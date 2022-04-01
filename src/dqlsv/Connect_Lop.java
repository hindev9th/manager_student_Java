/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dqlsv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hien
 */
public class Connect_Lop {
    Connection con;
     String dt = "csdl/QuanLySV.accdb";
     String url = "jdbc:ucanaccess://" + dt;        
          
    public ResultSet getdata(String stringSQL){
        // đối tượng này chứa kết quả trả về từ sql
         ResultSet rs = null;
        try {
            //đối tượng này tạo đường dẫn kết nối tớ sql 
            con = DriverManager.getConnection(url);
            Statement state = con.createStatement();
            rs = state.executeQuery(stringSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Connect_Lop.class.getName()).log(Level.SEVERE, null,ex);
        }
        return rs;
    }
    public  int ExcuteSQLInsert(String [] stringSQL){
        int rowsInserted = 0;
        String sql = "Insert INTO LOP (MAKHOA,MALOP,TENLOP) values (?,?,?)";
        //đối tượng này giống Statement , nó là con của Statemnt nhưng nó đã đc cải tiến để tối ưu nhanh hơn
        PreparedStatement statement;
        try {
            con = DriverManager.getConnection(url);
            statement = con.prepareStatement(sql);
            statement.setString(1,stringSQL[0]);
            statement.setString(2,stringSQL[1]);         
            statement.setString(3,stringSQL[2]); 
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect_Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    // hàm update
    public  int ExcuteSQLUpdate(String [] stringSQL){
        int rowsInserted = 0;
        String sql = "Update LOP Set MAKHOA = ?,TENLOP=? Where MALOP =?";
        //đối tượng này giống Statement , nó là con của Statemnt nhưng nó đã đc cải tiến để tối ưu nhanh hơn
        PreparedStatement statement;
        try {
            con = DriverManager.getConnection(url);
            statement = con.prepareStatement(sql);
            statement.setString(1,stringSQL[0]);
            statement.setString(2,stringSQL[1]);
            statement.setString(3,stringSQL[2]);     
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect_Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    //Ham Delete
    public  int ExcuteSQLDelete(String [] stringSQL){
        int rowsInserted = 0;
        String sql = "Delete From LOP Where MALOP =?";
        //đối tượng này giống Statement , nó là con của Statemnt nhưng nó đã đc cải tiến để tối ưu nhanh hơn
        PreparedStatement statement;
        try {
            con = DriverManager.getConnection(url);
            statement = con.prepareStatement(sql);
            statement.setString(1,stringSQL[0]);
                    
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect_Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
}
