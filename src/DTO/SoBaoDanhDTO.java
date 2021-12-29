/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class SoBaoDanhDTO {
    private String sobaodanh;
    private int thisinhid;
    public SoBaoDanhDTO(){
    }
    public SoBaoDanhDTO(String sobaodanh, int thisinhid){
        this.sobaodanh=sobaodanh;
        this.thisinhid=thisinhid;
    }

    public String getSobaodanh() {
        return sobaodanh;
    }

    public void setSobaodanh(String sobaodanh) {
        this.sobaodanh = sobaodanh;
    }

    public int getThisinhid() {
        return thisinhid;
    }

    public void setThisinhid(int thisinhid) {
        this.thisinhid = thisinhid;
    }
    
}
