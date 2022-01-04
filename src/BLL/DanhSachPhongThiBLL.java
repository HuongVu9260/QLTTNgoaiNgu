/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.DanhSachPhongThiDLL;
import DTO.DanhSachPhongThiDTO;
import java.util.List;

/**
 *
 * @author HAI HUONG
 */
public class DanhSachPhongThiBLL {
    public static List<DanhSachPhongThiDTO> ds;

    public void docDuLieu() throws Exception {
      DanhSachPhongThiDLL dao= new DanhSachPhongThiDLL();
        if (ds == null) {
            ds = dao.docDuLieu();
        }
    }
    
    public void getALL(int id) throws Exception {
      DanhSachPhongThiDLL dao= new DanhSachPhongThiDLL();
        if (ds == null) {
            ds = dao.getALL(id);
        }
    }

    public int them(DanhSachPhongThiDTO dd) {
        DanhSachPhongThiDLL dao= new DanhSachPhongThiDLL();
        int rs = dao.Them(dd);
        if (rs == 1) {
            ds.add(dd);
        }
        return rs;
    }

    public int xoa(int vitri) {
        DanhSachPhongThiDLL dao= new DanhSachPhongThiDLL();
        int rs = dao.xoa(ds.get(vitri).getThisinhid());
        if (rs == 1) {
            ds.remove(vitri);
        }
        return rs;
    }

    public int sua(int vitri, DanhSachPhongThiDTO dd) {
          DanhSachPhongThiDLL dao= new DanhSachPhongThiDLL();
        int rs = dao.sua(dd);
        if (rs == 1) {
            ds.set(vitri, dd);
        }
        return rs;
    }

    public DanhSachPhongThiDTO getDSPT (int ts_id) {
        for (DanhSachPhongThiDTO nv : ds) {
            if (nv.getThisinhid()== ts_id) {
                return nv;
            }
        }
        return null;
    }
}
