/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

public class ThiSinhDTO {
    private int thisinhid;
    private String hoten;
    private Date ngaysinh;
    private String noisinh;
    private String cmnd;
    private String sdt;
    private String email;
    
    public ThiSinhDTO(){
        thisinhid=0;
        hoten=null;
        ngaysinh=null;
        noisinh=null;
        cmnd=null;
        sdt=null;
        email=null;
    }
    public ThiSinhDTO(int thisinhid, String hoten, Date ngaysinh, String noisinh, String cmnd, String sdt, String email){
        this.thisinhid=thisinhid;
        this.hoten=hoten;
        this.ngaysinh=ngaysinh;
        this.noisinh=noisinh;
        this.cmnd=cmnd;
        this.sdt=sdt;
        this.email=email;
    }

    public int getThisinhid() {
        return thisinhid;
    }

    public void setThisinhid(int thisinhid) {
        this.thisinhid = thisinhid;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void getThisinhid(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
