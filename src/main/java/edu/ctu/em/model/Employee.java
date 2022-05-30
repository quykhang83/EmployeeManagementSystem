/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ctu.em.model;

/**
 *
 * @author quykhang
 */
public class Employee {
    private String maNV, hotenNV, emailNV, sdtNV, diachiNV;
    private int gioitinhNV;
    private double luongNV;
    private byte[] hinhNV;

    public Employee() {
        this.maNV = new String();
        this.hotenNV = new String();
        this.emailNV = new String();
        this.sdtNV = new String();
        this.diachiNV = new String();
        this.gioitinhNV = 0;
        this.luongNV = 0.0;
        this.hinhNV = null;
    }

    public Employee(String maNV, String hotenNV, String emailNV, String sdtNV, String diachiNV, int gioitinhNV, double luongNV, byte[] hinhNV) {
        this.maNV = maNV;
        this.hotenNV = hotenNV;
        this.emailNV = emailNV;
        this.sdtNV = sdtNV;
        this.diachiNV = diachiNV;
        this.gioitinhNV = gioitinhNV;
        this.luongNV = luongNV;
        this.hinhNV = hinhNV;
    }

    public String getmaNV() {
        return maNV;
    }

    public void setmaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHotenNV() {
        return hotenNV;
    }

    public void setHotenNV(String hotenNV) {
        this.hotenNV = hotenNV;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getDiachiNV() {
        return diachiNV;
    }

    public void setDiachiNV(String diachiNV) {
        this.diachiNV = diachiNV;
    }

    public int getGioitinhNV() {
        return gioitinhNV;
    }

    public void setGioitinhNV(int gioitinhNV) {
        this.gioitinhNV = gioitinhNV;
    }

    public double getLuongNV() {
        return luongNV;
    }

    public void setLuongNV(double luongNV) {
        this.luongNV = luongNV;
    }

    public byte[] getHinhNV() {
        return hinhNV;
    }

    public void setHinhNV(byte[] hinhNV) {
        this.hinhNV = hinhNV;
    }
      
}
