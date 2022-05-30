/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ctu.em.model;

/**
 *
 * @author quykhang
 */
public class Shift {
    private int maCa;
    private String maNV, ngayLam;
    private float thoiGian;

    public Shift() {
        this.maCa = 0;
        this.maNV = new String();
        this.ngayLam = new String();
        this.thoiGian = 0.0F;
    }
    
    public Shift(int maCa, String maNV, String ngayLam, float thoiGian) {
        this.maCa = maCa;
        this.maNV = maNV;
        this.ngayLam = ngayLam;
        this.thoiGian = thoiGian;
    }

    public int getMaCa() {
        return maCa;
    }

    public void setMaCa(int maCa) {
        this.maCa = maCa;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(String ngayLam) {
        this.ngayLam = ngayLam;
    }

    public float getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(float thoiGian) {
        this.thoiGian = thoiGian;
    }
    
    public String getThangNamLam() {
        return ngayLam.substring(3);
    }
    
}
