/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.SoBaoDanhDLL;
import DTO.SoBaoDanhDTO;
import java.util.List;

/**
 *
 * @author HAI HUONG
 */
public class SoBaoDanhBLL {
    public static List<SoBaoDanhDTO> ds;

    public void docDuLieu() throws Exception {
     SoBaoDanhDLL data = new SoBaoDanhDLL();
        if (ds == null) {
            ds = data.docDuLieu();
        }
    }

    public int them(SoBaoDanhDTO dd) {
         SoBaoDanhDLL dao = new SoBaoDanhDLL();
        int rs = dao.Them(dd);
        if (rs == 1) {
            ds.add(dd);
        }
        return rs;
    }

    public int xoa(String vitri) {
       SoBaoDanhDLL dao = new SoBaoDanhDLL();
        int rs = dao.xoa(ds.get(vitri).getSobaodanh());
        if (rs == 1) {
            ds.remove(vitri);
        }
        return rs;
    }

    public int sua(int vitri, SoBaoDanhDTO dd) {
             SoBaoDanhDLL dao = new SoBaoDanhDLL();
        int rs = dao.sua(dd);
        if (rs == 1) {
            ds.set(vitri, dd);
        }
        return rs;
    }
}
