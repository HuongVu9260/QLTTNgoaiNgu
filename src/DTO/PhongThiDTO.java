/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class PhongThiDTO {
    private String phongthiid;
    private String tenphongthi;
    private int cathiid;
    
    public PhongThiDTO(){
        phongthiid=null;
        tenphongthi=null;
        cathiid=0;
    }
    
    public PhongThiDTO(String phongthiid, String tenphongthi, int cathiid){
        this.phongthiid=phongthiid;
        this.tenphongthi=tenphongthi;
        this.cathiid=cathiid;
    }

    public String getPhongthiid() {
        return phongthiid;
    }

    public void setPhongthiid(String phongthiid) {
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
    
    
}
