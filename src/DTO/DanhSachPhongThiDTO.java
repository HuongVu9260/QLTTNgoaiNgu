/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class DanhSachPhongThiDTO {
    private int thisinhid;
    private String phongthiid;
    public DanhSachPhongThiDTO(){
        thisinhid=0;
        phongthiid=null;
    }
    public DanhSachPhongThiDTO(int thisinhid, String phongthiid){
        this.thisinhid=thisinhid;
        this.phongthiid=phongthiid;
    }

    public int getThisinhid() {
        return thisinhid;
    }

    public void setThisinhid(int thisinhid) {
        this.thisinhid = thisinhid;
    }

    public String getPhongthiid() {
        return phongthiid;
    }

    public void setPhongthiid(String phongthiid) {
        this.phongthiid = phongthiid;
    }
    
}
