/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

public class KhoaThiDTO {
    private int khoathiid;
    private String tenkhoathi;
    private Date ngaybatdau;
    
    public KhoaThiDTO(){
        khoathiid=0;
        tenkhoathi=null;
        ngaybatdau=null;
    }
    
    public KhoaThiDTO(int khoathiid, String tenkhoathi, Date ngaybatdau){
        this.khoathiid=khoathiid;
        this.tenkhoathi=tenkhoathi;
        this.ngaybatdau=ngaybatdau;
    }

    public int getKhoathiid() {
        return khoathiid;
    }

    public void setKhoathiid(int khoathiid) {
        this.khoathiid = khoathiid;
    }

    public String getTenkhoathi() {
        return tenkhoathi;
    }

    public void setTenkhoathi(String tenkhoathi) {
        this.tenkhoathi = tenkhoathi;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }
    
}
