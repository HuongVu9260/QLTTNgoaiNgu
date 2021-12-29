/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.PhongThiDLL;
import DTO.PhongThiDTO;
import java.util.List;

/**
 *
 * @author HAI HUONG
 */
public class PhongThiBLL {
    public static List<PhongThiDTO> ds;

    public void docDuLieu() throws Exception {
        PhongThiDLL data = new PhongThiDLL();
        if (ds == null) {
            ds = data.docDuLieu();
        }
    }

    public int them(PhongThiDTO dd) {
        PhongThiDLL dao = new PhongThiDLL();
        int rs = dao.Them(dd);
        if (rs == 1) {
            ds.add(dd);
        }
        return rs;
    }

    public int xoa(String vitri) {
        PhongThiDLL dao = new PhongThiDLL();
        int rs = dao.xoa(ds.get(vitri).getPhongthiid());
        if (rs == 1) {
            ds.remove(vitri);
        }
        return rs;
    }

    public int sua(int vitri, PhongThiDTO dd) {
        PhongThiDLL dao = new PhongThiDLL();
        int rs = dao.sua(dd);
        if (rs == 1) {
            ds.set(vitri, dd);
        }
        return rs;
    }

    public PhongThiDTO getPhongthi(String phongthi_id) {
        for (PhongThiDTO nv : ds) {
            if (nv.getPhongthiid()== phongthi_id) {
                return nv;
            }
        }
        return null;
    }
}
