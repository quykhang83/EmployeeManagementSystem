/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ctu.em.helper;

import edu.ctu.em.model.Shift;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quykhang
 */
public class ShiftTool {
    public boolean insert(Shift s) throws Exception{
        String sql = "insert into shift(maNV, ngayLam, thoiGian, thangNamLam) values(?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            
            psmt.setString(1, s.getMaNV());
            psmt.setString(2, s.getNgayLam());
            psmt.setFloat(3, s.getThoiGian());
            psmt.setString(4, s.getThangNamLam());
            
            return psmt.executeUpdate() > 0;
        }
    }
    
    public Shift findByDate(String maNV, String ngayLam) throws Exception{
        String sql = "select * from shift where maNV = ? and ngayLam = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            psmt.setString(1, maNV);
            psmt.setString(2, ngayLam);
            ResultSet rs = psmt.executeQuery();
            
            if(rs.next()){
                Shift s = new Shift();
                s.setMaCa(rs.getInt("maCa"));
                s.setMaNV(rs.getString("maNV"));
                s.setNgayLam(rs.getString("ngayLam"));
                s.setThoiGian(rs.getFloat("thoiGian"));
                return s;
            }
            
            return null;
        }
    }
    
    public boolean update(Shift s) throws Exception{
        String sql = "update shift set thoiGian = ? where maNV = ? and ngayLam = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            
            psmt.setFloat(1, s.getThoiGian());
            psmt.setString(2, s.getMaNV());
            psmt.setString(3, s.getNgayLam());
            
            return psmt.executeUpdate() > 0;
        }
    }
    
    public boolean delete(Shift s) throws Exception{
        String sql = "delete from shift where maNV = ? and ngayLam = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            
            psmt.setString(1, s.getMaNV());
            psmt.setString(2, s.getNgayLam());
            
            return psmt.executeUpdate() > 0;
        }
    }
    
    public List<Shift> findByMonth(String maNV, String thangNamLam) throws Exception{
        String sql = "select * from shift where maNV = ? and thangNamLam = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement psmt = con.prepareStatement(sql);
            ){
            psmt.setString(1, maNV);
            psmt.setString(2, thangNamLam);
            
            ResultSet rs = psmt.executeQuery();
            List<Shift> list = new ArrayList<>();
            while(rs.next()){
                Shift s = new Shift();
                s.setMaCa(rs.getInt("maCa"));
                s.setNgayLam(rs.getString("ngayLam"));
                s.setThoiGian(rs.getFloat("thoiGian"));
                
                list.add(s);
            }
            
            return list;
        }
    }
}
