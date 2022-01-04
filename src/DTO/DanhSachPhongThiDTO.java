/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class DanhSachPhongThiDTO {
    private int thisinhid;
    private int phongthiid;
    private String sobaodanh;
    private Float nghe;
    private Float noi;
    private Float doc;
    private Float viet;
    public DanhSachPhongThiDTO(){
        thisinhid=0;
        phongthiid=0;
        sobaodanh=null;
        nghe=null;
        noi=null;
        doc=null;
        viet=null;
    }

    public DanhSachPhongThiDTO(int thisinhid, int phongthiid, String sobaodanh, Float nghe, Float noi, Float viet) {
        this.thisinhid = thisinhid;
        this.phongthiid = phongthiid;
        this.sobaodanh = sobaodanh;
        this.nghe = nghe;
        this.noi = noi;
        this.viet = viet;
    }

    public int getThisinhid() {
        return thisinhid;
    }

    public void setThisinhid(int thisinhid) {
        this.thisinhid = thisinhid;
    }

    public int getPhongthiid() {
        return phongthiid;
    }

    public void setPhongthiid(int phongthiid) {
        this.phongthiid = phongthiid;
    }

    public String getSobaodanh() {
        return sobaodanh;
    }

    public void setSobaodanh(String sobaodanh) {
        this.sobaodanh = sobaodanh;
    }

    public Float getNghe() {
        return nghe;
    }

    public void setNghe(Float nghe) {
        this.nghe = nghe;
    }

    public Float getNoi() {
        return noi;
    }

    public void setNoi(Float noi) {
        this.noi = noi;
    }

    public Float getDoc() {
        return doc;
    }

    public void setDoc(Float doc) {
        this.doc = doc;
    }

    public Float getViet() {
        return viet;
    }

    public void setViet(Float viet) {
        this.viet = viet;
    }
    
    
    
}
