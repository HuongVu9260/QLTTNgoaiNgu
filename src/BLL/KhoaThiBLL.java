/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.KhoaThiDLL;
import DTO.KhoaThiDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HAI HUONG
 */
public class KhoaThiBLL {

    public static List<KhoaThiDTO> ds;

    public void docDuLieu() throws Exception {
        KhoaThiDLL data = new KhoaThiDLL();
        if (ds == null) {
            ds = data.docDuLieu();
        }
    }

    public ArrayList<KhoaThiDTO> getAllL_Hang() throws Exception {
        KhoaThiDLL da = new KhoaThiDLL();
        return da.docDuLieu();
    }

    public void docduLieusearch(Map<String, String> nv) throws Exception {
        KhoaThiDLL dao = new KhoaThiDLL();

        ds = dao.getThisinh(nv);

    }

    public int them(KhoaThiDTO dd) {
        KhoaThiDLL dao = new KhoaThiDLL();
        int rs = dao.Them(dd);
        if (rs == 1) {
            ds.add(dd);
        }
        return rs;
    }

    public int xoa(int vitri) {
        KhoaThiDLL dao = new KhoaThiDLL();
        int rs = dao.xoa(ds.get(vitri).getKhoathiid());
        if (rs == 1) {
            ds.remove(vitri);
        }
        return rs;
    }

    public int sua(int vitri, KhoaThiDTO dd) {
        KhoaThiDLL dao = new KhoaThiDLL();
        int rs = dao.sua(dd);
        if (rs == 1) {
            ds.set(vitri, dd);
        }
        return rs;
    }

    public KhoaThiDTO getKhoathi(int khoathi_id) {
        for (KhoaThiDTO nv : ds) {
            if (nv.getKhoathiid() == khoathi_id) {
                return nv;
            }
        }
        return null;
    }

    public String remindKhoathiID() {// tự sinh mãã
        int max = 0;
        String s = "";
        for (KhoaThiDTO kh : ds) {
            int id = (kh.getKhoathiid());
            if (id > max) {
                max = id;
            }
        }
        for (int i = 0; i < 3 - String.valueOf(max + 1).length(); i++) {
            s += "0";
        }
        return s + (max + 1);
    }
}
