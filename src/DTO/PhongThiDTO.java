/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class PhongThiDTO {
    private int phongthiid;
    private String tenphongthi;
    private int khoathiid;
    private String trinhdo;
    private int soluong;
    public PhongThiDTO(){
        phongthiid=0;
        tenphongthi=null;
        khoathiid=0;
        trinhdo=null;
        soluong=0;
    }
    
    public PhongThiDTO(int phongthiid, String tenphongthi, int khoathiid,String trinhdo, int soluong){
        this.phongthiid=phongthiid;
        this.tenphongthi=tenphongthi;
        this.khoathiid=khoathiid;
        this.trinhdo=trinhdo;
        this.soluong=soluong;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    
}
