/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ctu.em.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import edu.ctu.em.model.Employee;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author quykhang
 */
public class EmployeeTool{
    public boolean insert(Employee em) throws Exception{
        String sql = "insert into employee(maNV, hotenNV, gioitinhNV, luongNV, emailNV, soDTNV, diachiNV, hinhNV) values(?,?,?,?,?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            psmt.setString(1, em.getmaNV());
            psmt.setString(2, em.getHotenNV());
            psmt.setInt(3, em.getGioitinhNV());
            psmt.setDouble(4, em.getLuongNV());
            psmt.setString(5, em.getEmailNV());
            psmt.setString(6, em.getSdtNV());
            psmt.setString(7, em.getDiachiNV());
//            File input = null;
//            BufferedImage read = ImageIO.read(input);
            
            if(em.getHinhNV() != null){
                Blob img = new SerialBlob(em.getHinhNV());
                psmt.setBlob(8, img);
            }else{
                Blob img = null;
                psmt.setBlob(8, img);
            }
            
            
            return psmt.executeUpdate() > 0;
        }
    }
    
    public Employee findById(String maNV) throws Exception{
        String sql = "select * from employee where maNV = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            psmt.setString(1, maNV);
            ResultSet rs = psmt.executeQuery();
            
            if(rs.next()){
                Employee em = createEmployee(rs);
                
                return em;
            }
            
            return null;
        }
    }
    
    public List<Employee> findAll(String maNV) throws Exception{
        String sql = "select * from employee";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            
            ResultSet rs = psmt.executeQuery();
            List<Employee> list = new ArrayList<>();
            while(rs.next()){
                Employee em = createEmployee(rs);
                
                list.add(em);
            }
            
            return list;
        }
    }

    private Employee createEmployee(final ResultSet rs) throws SQLException {
        Employee em = new Employee();
        em.setmaNV(rs.getString("maNV"));
        em.setHotenNV(rs.getString("hotenNV"));
        em.setGioitinhNV(rs.getInt("gioitinhNV"));
        em.setLuongNV(rs.getDouble("luongNV"));
        em.setEmailNV(rs.getString("emailNV"));
        em.setSdtNV(rs.getString("soDTNV"));
        em.setDiachiNV(rs.getString("diachiNV"));
        Blob blob = rs.getBlob("hinhNV");
        if(blob != null)
            em.setHinhNV(blob.getBytes(1, (int) blob.length()));
        return em;
    }
    
    public boolean update(Employee em) throws Exception{
        String sql = "update employee set hotenNV = ?, gioitinhNV = ?, luongNV = ?, emailNV = ?, soDTNV = ?, diachiNV = ?, hinhNV = ? "
                    + " where maNV = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            psmt.setString(8, em.getmaNV());
            psmt.setString(1, em.getHotenNV());
            psmt.setInt(2, em.getGioitinhNV());
            psmt.setDouble(3, em.getLuongNV());
            psmt.setString(4, em.getEmailNV());
            psmt.setString(5, em.getSdtNV());
            psmt.setString(6, em.getDiachiNV());
//            File input = null;
//            BufferedImage read = ImageIO.read(input);
            
            if(em.getHinhNV() != null){
                Blob img = new SerialBlob(em.getHinhNV());
                psmt.setBlob(7, img);
            }else{
                Blob img = null;
                psmt.setBlob(7, img);
            }
            return psmt.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String maNV) throws Exception{
        String sql = "delete from employee where maNV = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            
            psmt.setString(1, maNV);
            
            return psmt.executeUpdate() > 0;
        }
    }
}
