/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.CaThiDLL;
import DTO.CaThiDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HAI HUONG
 */
public class CaThiBLL {

    public static List<CaThiDTO> ds;

    public void docDuLieu() throws Exception {
        CaThiDLL data = new CaThiDLL();
        if (ds == null) {
            ds = data.docDuLieu();
        }
    }

    public ArrayList<CaThiDTO> getAllL_Hang() throws Exception {
        CaThiDLL da = new CaThiDLL();
        return da.docDuLieu();
    }

    public int them(CaThiDTO dd) {
        CaThiDLL dao = new CaThiDLL();
        int rs = dao.Them(dd);
        if (rs == 1) {
            ds.add(dd);
        }
        return rs;
    }

    public int xoa(int vitri) {
        CaThiDLL dao = new CaThiDLL();
        int rs = dao.xoa(ds.get(vitri).getCathiid());
        if (rs == 1) {
            ds.remove(vitri);
        }
        return rs;
    }

    public int sua(int vitri, CaThiDTO dd) {
        CaThiDLL dao = new CaThiDLL();
        int rs = dao.sua(dd);
        if (rs == 1) {
            ds.set(vitri, dd);
        }
        return rs;
    }

    public CaThiDTO getCathi(int cathi_id) {
        for (CaThiDTO nv : ds) {
            if (nv.getCathiid() == cathi_id) {
                return nv;
            }
        }
        return null;
    }

    public String remindCathiID() {// tự sinh mã
        int max = 0;
        String s = "";
        for (CaThiDTO kh : ds) {
            int id = (kh.getCathiid());
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
