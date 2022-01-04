/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.PhieuDangKyDLL;
import DTO.PhieuDangKyDTO;
import DTO.ThiSinhDTO;
import java.util.List;

/**
 *
 * @author HAI HUONG
 */
public class PhieuDangKyBLL {
    public static List<PhieuDangKyDTO> ds;

    public void docDuLieu() throws Exception {
      PhieuDangKyDLL data = new PhieuDangKyDLL();
        if (ds == null) {
            ds = data.docDuLieu();
        }
    }

    public int them(PhieuDangKyDTO dd) {
        PhieuDangKyDLL dao = new PhieuDangKyDLL();
        int rs = dao.Them(dd);
        /*if (rs == 1) {
            ds.add(dd);
        }*/
        return rs;
    }

    public int xoa(int vitri) {
           PhieuDangKyDLL dao = new PhieuDangKyDLL();
        int rs = dao.xoa(ds.get(vitri).getThisinhid());
        if (rs == 1) {
            ds.remove(vitri);
        }
        return rs;
    }

    public int sua(int vitri, PhieuDangKyDTO dd) {
             PhieuDangKyDLL dao = new PhieuDangKyDLL();
        int rs = dao.sua(dd);
        if (rs == 1) {
            ds.set(vitri, dd);
        }
        return rs;
    }

    public PhieuDangKyDTO getKetquathi (int thisinhid) {
        for (PhieuDangKyDTO kq : ds) {
            if (kq.getThisinhid()== thisinhid) {
                return kq;
            }
        }
        return null;
    }

    
}
