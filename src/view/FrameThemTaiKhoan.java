package view;

import controller.PhanQuyenController;
import controller.TaiKhoanController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.entities.PhanQuyen;
import model.entities.TaiKhoan;
import view.interfaceView.iFrameListener;
import view.interfaceView.iMessageView;
import view.interfaceView.iModelComBox;

public class FrameThemTaiKhoan extends JFrame implements iMessageView, iModelComBox {

    private JPanel contentPane;
    private JTextField tfTaiKhoan;
    private JButton btnMini;
    private JButton btnClose;
    private JComboBox cbbPhanQuyen;
    private JButton btnDongY;
    private JButton btnHuy;

    private iFrameListener callBack;

    int xx = 0;
    int yy = 0;
    private JPanel pnFrameDrage;

    public FrameThemTaiKhoan(iFrameListener callBack) {
        this.callBack = callBack;
        initComponent();
        initData();
        initEvent();
    }

    private void initComponent() {

        setUndecorated(true);
        setSize(431, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        pnFrameDrage = new JPanel();
        pnFrameDrage.setBackground(new Color(0, 51, 51));
        contentPane.add(pnFrameDrage, BorderLayout.NORTH);
        pnFrameDrage.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 5));

        Icon miniIcon = new ImageIcon("Images/Mini.png");
        btnMini = new JButton(miniIcon);
        btnMini.setContentAreaFilled(false);
        btnMini.setFocusPainted(false);
        btnMini.setMargin(new Insets(0, 0, 0, 0));
        pnFrameDrage.add(btnMini);

        Icon closeIcon = new ImageIcon("Images/Close.png");
        btnClose = new JButton(closeIcon);
        btnClose.setMargin(new Insets(0, 0, 0, 0));
        btnClose.setContentAreaFilled(false);
        btnClose.setFocusPainted(false);
        pnFrameDrage.add(btnClose);

        JPanel pnCenter = new JPanel();
        contentPane.add(pnCenter, BorderLayout.CENTER);
        pnCenter.setLayout(new BorderLayout(0, 0));

        JPanel pnTieuDe = new JPanel();
        FlowLayout flowLayout = (FlowLayout) pnTieuDe.getLayout();
        flowLayout.setVgap(10);
        pnCenter.add(pnTieuDe, BorderLayout.NORTH);

        JLabel lblTieuDe = new JLabel("THÊM TÀI KHOẢN");
        lblTieuDe.setForeground(new Color(0, 51, 51));
        lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 25));
        pnTieuDe.add(lblTieuDe);

        JPanel pnThongTin = new JPanel();
        pnCenter.add(pnThongTin, BorderLayout.CENTER);
        pnThongTin.setLayout(new GridLayout(3, 1, 0, 0));

        JPanel pnTenTaiKhoan = new JPanel();
        FlowLayout fl_pnTenTaiKhoan = (FlowLayout) pnTenTaiKhoan.getLayout();
        fl_pnTenTaiKhoan.setHgap(10);
        fl_pnTenTaiKhoan.setAlignment(FlowLayout.LEFT);
        fl_pnTenTaiKhoan.setVgap(10);
        pnThongTin.add(pnTenTaiKhoan);

        JLabel lblTaiKhoan = new JLabel("Tài khoản:  ");
        lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnTenTaiKhoan.add(lblTaiKhoan);

        tfTaiKhoan = new JTextField();
        tfTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfTaiKhoan.setColumns(15);
        pnTenTaiKhoan.add(tfTaiKhoan);
        tfTaiKhoan.setColumns(20);

        JPanel pnPhanQuyen = new JPanel();
        FlowLayout fl_pnPhanQuyen = (FlowLayout) pnPhanQuyen.getLayout();
        fl_pnPhanQuyen.setHgap(10);
        fl_pnPhanQuyen.setAlignment(FlowLayout.LEFT);
        fl_pnPhanQuyen.setVgap(10);
        pnThongTin.add(pnPhanQuyen);

        JLabel lblPhanQuyen = new JLabel("Phân quyền:");
        lblPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnPhanQuyen.add(lblPhanQuyen);

        cbbPhanQuyen = new JComboBox();
        cbbPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbbPhanQuyen.setPreferredSize(new Dimension(260, 25));
        cbbPhanQuyen.setMaximumSize(new Dimension(260, 25));
        cbbPhanQuyen.setMinimumSize(new Dimension(260, 25));
        pnPhanQuyen.add(cbbPhanQuyen);

        JPanel pnButton = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) pnButton.getLayout();
        flowLayout_4.setAlignment(FlowLayout.RIGHT);
        flowLayout_4.setHgap(15);
        flowLayout_4.setVgap(10);
        pnThongTin.add(pnButton);

        btnDongY = new JButton("Đồng ý");
        btnDongY.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnButton.add(btnDongY);

        btnHuy = new JButton("Hủy");
        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnButton.add(btnHuy);
    }

    private void initEvent() {

        pnFrameDrage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                yy = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        pnFrameDrage.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - xx, y - yy);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        btnDongY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themMoiTaiKhoan();
            }
        });

        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearData();

            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                callBack.transferData(new Object[]{iFrameListener.TypeFrame.THEM_TAI_KHOAN});
            }
        });

        btnMini.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setState(Frame.ICONIFIED);
            }

        });
    }

    private void initData() {
        PhanQuyenController.getInstance().layToanBoDuLieuLenComBox(this);
    }

    @Override
    public void hienThiDuLieuLenComBox(List data, Object object) {
        cbbPhanQuyen.removeAllItems();
        for (Iterator it = data.iterator(); it.hasNext();) {
            PhanQuyen pq = (PhanQuyen) it.next();
            cbbPhanQuyen.addItem(pq);
        }
        cbbPhanQuyen.setSelectedIndex(-1);
    }

    @Override
    public void showMessageAndReloadData(String message, int type) {
        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        switch (type) {
            case iMessageView.NONE:
                break;
            case iMessageView.FAIL:
                break;
            case iMessageView.SUCCESS:
                clearData();
                break;
        }
    }

    private void clearData() {
        //xóa trắng màn hình
        tfTaiKhoan.setText("");
    }

    private void themMoiTaiKhoan() {
        if (cbbPhanQuyen.getSelectedIndex() != -1) {
            String tenDangNhap = tfTaiKhoan.getText();
            if (tenDangNhap.isEmpty()) {
                showMessageAndReloadData("Chưa nhập tên tài khoản", iMessageView.NONE);
                return;
            }
            PhanQuyen pq = (PhanQuyen) cbbPhanQuyen.getSelectedItem();
            TaiKhoan tk = new TaiKhoan(tenDangNhap, pq);
            TaiKhoanController.getInstance().themTaiKhoan(tk, FrameThemTaiKhoan.this);
        } else {
            showMessageAndReloadData("Chưa chọn loại phân quyền", iMessageView.NONE);
        }
    }
}
