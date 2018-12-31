package view;

import controller.NhaCungCapController;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.entities.NhaCungCap;
import view.interfaceView.iMessageView;

public class FrameThemNhaCungCap extends JFrame implements iMessageView{

    private JPanel contentPane;
    private JTextField tfTenNCC;
    private JTextField tfSoDT;
    private JTextField tfDiaChi;
    private JButton btnMini;
    private JButton btnClose;
    private JButton btnDongY;
    private JButton btnHuy;

    public FrameThemNhaCungCap() {
        initComponent();
        initEvent();
    }

    private void initComponent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 470, 368);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel pnTop = new JPanel();
        pnTop.setBackground(new Color(0, 51, 51));
        contentPane.add(pnTop, BorderLayout.NORTH);
        pnTop.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 5));

        btnMini = new JButton("Mini");
        pnTop.add(btnMini);

        btnClose = new JButton("Close");
        pnTop.add(btnClose);

        JPanel pnCenter = new JPanel();
        contentPane.add(pnCenter, BorderLayout.CENTER);
        pnCenter.setLayout(new BorderLayout(0, 0));

        JPanel pnTieuDe = new JPanel();
        FlowLayout flowLayout = (FlowLayout) pnTieuDe.getLayout();
        flowLayout.setVgap(10);
        pnCenter.add(pnTieuDe, BorderLayout.NORTH);

        JLabel lblTieuDe = new JLabel("THÊM NHÀ CUNG CẤP");
        lblTieuDe.setForeground(new Color(0, 51, 51));
        lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 25));
        pnTieuDe.add(lblTieuDe);

        JPanel pnThongTin = new JPanel();
        pnCenter.add(pnThongTin, BorderLayout.CENTER);
        pnThongTin.setLayout(new GridLayout(4, 1, 0, 0));

        JPanel pnTenNCC = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) pnTenNCC.getLayout();
        flowLayout_1.setHgap(10);
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        flowLayout_1.setVgap(10);
        pnThongTin.add(pnTenNCC);

        JLabel lblTenNCC = new JLabel("Tên nhà cung cấp: ");
        lblTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnTenNCC.add(lblTenNCC);

        tfTenNCC = new JTextField();
        tfTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnTenNCC.add(tfTenNCC);
        tfTenNCC.setColumns(20);

        JPanel pnSoDT = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) pnSoDT.getLayout();
        flowLayout_2.setHgap(10);
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        flowLayout_2.setVgap(10);
        pnThongTin.add(pnSoDT);

        JLabel lblSoDT = new JLabel("Số điện thoại:        ");
        lblSoDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnSoDT.add(lblSoDT);

        tfSoDT = new JTextField();
        tfSoDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnSoDT.add(tfSoDT);
        tfSoDT.setColumns(20);

        JPanel pnDiaChi = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) pnDiaChi.getLayout();
        flowLayout_3.setHgap(10);
        flowLayout_3.setAlignment(FlowLayout.LEFT);
        flowLayout_3.setVgap(10);
        pnThongTin.add(pnDiaChi);

        JLabel lblDiaChi = new JLabel("Địa chỉ:                ");
        lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnDiaChi.add(lblDiaChi);

        tfDiaChi = new JTextField();
        tfDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnDiaChi.add(tfDiaChi);
        tfDiaChi.setColumns(20);

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
        btnDongY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenNCC = tfTenNCC.getText();
                int soDT = 0;
                String diaChi = tfDiaChi.getText();
                
                try{
                    soDT = Integer.valueOf(tfSoDT.getText());
                }catch(NumberFormatException ex){
                    ex.printStackTrace();
                }
                
                NhaCungCap ncc = new NhaCungCap(tenNCC, diaChi, soDT, 1);
                
                NhaCungCapController.getInstance().themNhaSanXuat(ncc, FrameThemNhaCungCap.this);
            }
        });
        
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameThemNhaCungCap.this.setVisible(false);
            }
        });
    }

    @Override
    public void showMessageAndReloadData(String message, int type) {
        JOptionPane.showMessageDialog(null, message,"Thông báo",JOptionPane.INFORMATION_MESSAGE);
        switch(type){
            case iMessageView.NONE:
                break;
            case iMessageView.FAIL:
                break;
            case iMessageView.SUCCESS:
                FrameThemNhaCungCap.this.setVisible(false);
                break;
        }
    }

}