/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.ThiSinhDLL;
import DTO.ThiSinhDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HAI HUONG
 */
public class ThiSinhBLL {

    public static List<ThiSinhDTO> ds;

    public void docDuLieu() throws Exception {
        ThiSinhDLL data = new ThiSinhDLL();
        if (ds == null) {
            ds = data.docDuLieu();
        }
    }

    public void docduLieusearch(Map<String, String> nv) throws Exception {
        ThiSinhDLL dao = new ThiSinhDLL();

        ds = dao.getThisinh(nv);

    }

    public int them(ThiSinhDTO dd) {
        ThiSinhDLL dao = new ThiSinhDLL();
        int rs = dao.Them(dd);
        if (rs == 1) {
            ds.add(dd);
        }
        return rs;
    }

    public int xoa(int vitri) {
        ThiSinhDLL dao = new ThiSinhDLL();
        int rs = dao.xoa(ds.get(vitri).getThisinhid());
        if (rs == 1) {
            ds.remove(vitri);
        }
        return rs;
    }

    public int sua(int vitri, ThiSinhDTO dd) {
        ThiSinhDLL dao = new ThiSinhDLL();
        int rs = dao.sua(dd);
        if (rs == 1) {
            ds.set(vitri, dd);
        }
        return rs;
    }

    public ThiSinhDTO getThisinh(int ts_id) {
        for (ThiSinhDTO nv : ds) {
            if (nv.getThisinhid() == ts_id) {
                return nv;
            }
        }
        return null;
    }

    public String remindThisinhID() {// tự sinh mã
        int max = 0;
        String s = "";
        for (ThiSinhDTO ts : ds) {
            int id = (ts.getThisinhid());
            if (id > max) {
                max = id;
            }
        }
        for (int i = 0; i < 3 - String.valueOf(max + 1).length(); i++) {
            s += "0";
        }
        return s + (max + 1);
    }

    public List<ThiSinhDTO> getthisinhsearch(Map<String, String> nv) throws Exception {
        ThiSinhDLL dao = new ThiSinhDLL();
        List<ThiSinhDTO> dsts = dao.getThisinh(nv);
        return dsts;
    }
}
