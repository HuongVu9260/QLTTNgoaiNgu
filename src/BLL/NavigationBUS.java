package BLL;

import DTO.ListDTO;
import GUI.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import GUI.thisinhGUI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NavigationBUS {

    private JPanel root;
    private String kindSelected = "";
    private ArrayList<ListDTO> listItem = null;

    public NavigationBUS(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "Tour";

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new thisinhGUI());
        root.validate();
        root.repaint();
    }

    public void setEvent(ArrayList<ListDTO> listItem) {
        this.listItem = listItem;
        listItem.forEach((item) -> {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        });
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlblItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jLblItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlblItem = jLblItem;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            switch (kind) {
                case "thisinh":
                    node = new thisinhGUI();
                    break;
//                case "cathi":
//                   node = new CathiGUI();
//                  
//                    break;
                case "khoathi":
                    node = new KhoaThiGUI();

                    break;
                case "phongthi": {
                    try {
                        node = new PhongThiGUI();
                    } catch (Exception ex) {
                        Logger.getLogger(NavigationBUS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "phieudangky": {
                    try {
                        node = new PhieuDangKyGUI();
                    } catch (Exception ex) {
                        Logger.getLogger(NavigationBUS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "timkiem":
                    node = new TimKiemGUI();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            jpnItem.setBackground (new Color (180,159,220));
//            jlblItem.setBackground (new Color (180,159,220));
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            if (!kindSelected.equalsIgnoreCase (kind)){
//                jpnItem.setBackground (new Color (119, 153, 204));
//                jlblItem.setBackground (new Color (119, 153, 204));
//            }    
        }
    }

    private void setChangeBackgroud(String kind) {
        listItem.forEach((item) -> {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(103, 17, 49));
                item.getJlb().setBackground(new Color(103, 17, 49));
            } else {
                item.getJpn().setBackground(new Color(125, 21, 59));
                item.getJlb().setBackground(new Color(125, 21, 59));
            }
        });
    }
}
