/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class PhongThiDTO {
    private int phongthiid;
    private String tenphongthi;
    private int cathiid;
    private int khoathiid;
    private String trinhdo;
    public PhongThiDTO(){
        phongthiid=0;
        tenphongthi=null;
        cathiid=0;
        khoathiid=0;
        trinhdo=null;
    }
    
    public PhongThiDTO(int phongthiid, String tenphongthi, int cathiid, int khoathiid,String trinhdo){
        this.phongthiid=phongthiid;
        this.tenphongthi=tenphongthi;
        this.cathiid=cathiid;
        this.khoathiid=khoathiid;
        this.trinhdo=trinhdo;
    }

    public int getPhongthiid() {
        return phongthiid;
    }

    public void setPhongthiid(int phongthiid) {
        this.phongthiid = phongthiid;
    }
    
    
    
    public String getTenphongthi() {
        return tenphongthi;
    }

    public void setTenphongthi(String tenphongthi) {
        this.tenphongthi = tenphongthi;
    }

    public int getCathiid() {
        return cathiid;
    }

    public void setCathiid(int cathiid) {
        this.cathiid = cathiid;
    }

    public int getKhoathiid() {
        return khoathiid;
    }

    public void setKhoathiid(int khoathiid) {
        this.khoathiid = khoathiid;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
    
    
}
