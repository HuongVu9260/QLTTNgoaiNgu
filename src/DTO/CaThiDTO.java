/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

public class CaThiDTO {
    private int cathiid;
    private String giothi;
    public CaThiDTO(){
        cathiid=0;
        giothi=null;
    }
    public CaThiDTO(int cathiid, String giothi){
        this.cathiid=cathiid;
        this.giothi=giothi;
    }

    public int getCathiid() {
        return cathiid;
    }

    public void setCathiid(int cathiid) {
        this.cathiid = cathiid;
    }

    public String getGiothi() {
        return giothi;
    }

    public void setGiothi(String giothi) {
        this.giothi = giothi;
    }

    
    
}
