/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author HAI HUONG
 */
public class PhieuDangKyDTO {
    private int thisinhid;
    private int khoathiid;
    private String trinhdo;
    private Date ngaydangky;
    
    public PhieuDangKyDTO(){
        thisinhid=0;
        khoathiid=0;
        trinhdo=null;
        ngaydangky=null;
    }

    public PhieuDangKyDTO(int thisinhid, int khoathiid, String trinhdo, Date ngaydangky) {
        this.thisinhid = thisinhid;
        this.khoathiid = khoathiid;
        this.trinhdo = trinhdo;
        this.ngaydangky = ngaydangky;
    }

    public int getThisinhid() {
        return thisinhid;
    }

    public void setThisinhid(int thisinhid) {
        this.thisinhid = thisinhid;
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

    public Date getNgaydangky() {
        return ngaydangky;
    }

    public void setNgaydangky(Date ngaydangky) {
        this.ngaydangky = ngaydangky;
    }
  
    
}
