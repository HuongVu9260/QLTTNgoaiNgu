/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class KetQuaThiDTO {
    private int ketquathiid;
    private Float nghe;
    private Float noi;
    private Float doc;
    private Float viet;
    private Float trungbinh;
    private String xeploai;
    private int thisinhid;
    public KetQuaThiDTO(){
        ketquathiid=0;
        nghe=null;
        noi=null;
        doc=null;
        viet=null;
        trungbinh=null;
        xeploai=null;
        thisinhid=0;
    }
    public KetQuaThiDTO(int ketquathiid, Float nghe, Float noi, Float doc, Float viet, Float trungbinh, String xeploai, int thisinhid){
        this.ketquathiid=ketquathiid;
        this.nghe=nghe;
        this.noi=noi;
        this.doc=doc;
        this.viet=viet;
        this.trungbinh=trungbinh;
        this.xeploai=xeploai;
        this.thisinhid=thisinhid;
    }

    public int getKetquathiid() {
        return ketquathiid;
    }

    public void setKetquathiid(int ketquathiid) {
        this.ketquathiid = ketquathiid;
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

    public Float getTrungbinh() {
        return trungbinh;
    }

    public void setTrungbinh(Float trungbinh) {
        this.trungbinh = trungbinh;
    }

    public String getXeploai() {
        return xeploai;
    }

    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }

    public int getThisinhid() {
        return thisinhid;
    }

    public void setThisinhid(int thisinhid) {
        this.thisinhid = thisinhid;
    }
    
       
}
