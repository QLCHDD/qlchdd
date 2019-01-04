/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panelquanly.taikhoan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author RanRan
 */
public class pnPhanQuyen extends JPanel {

    private JTextField tfMaPhanQuyen;
    private JTextField tfQuyenTruyCap;
    private JButton btnTimKiemPQ;
    private JButton btnCapNhatPQ;
    private JButton btnHuyPQ;
    private JTable tablePhanQuyen;

    public pnPhanQuyen(){
        initComponent();
    }

    private void initComponent() {

                setBorder(new LineBorder(new Color(0, 51, 51), 2));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_53 = new JPanel();
		add(panel_53, BorderLayout.NORTH);
		
		JLabel lblTieuDeQLPQ = new JLabel("QUẢN LÝ PHÂN QUYỀN");
		lblTieuDeQLPQ.setForeground(new Color(0, 51, 51));
		lblTieuDeQLPQ.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_53.add(lblTieuDeQLPQ);
		
		JPanel panel_54 = new JPanel();
		add(panel_54, BorderLayout.CENTER);
		panel_54.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_55 = new JPanel();
		panel_54.add(panel_55);
		panel_55.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel pnMaPhanQuyen = new JPanel();
		FlowLayout flowLayout_83 = (FlowLayout) pnMaPhanQuyen.getLayout();
		flowLayout_83.setVgap(10);
		flowLayout_83.setHgap(10);
		flowLayout_83.setAlignment(FlowLayout.LEFT);
		panel_55.add(pnMaPhanQuyen);
		
		JLabel lblMaPhanQuyen = new JLabel("Mã phân quyền:");
		lblMaPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnMaPhanQuyen.add(lblMaPhanQuyen);
		
		tfMaPhanQuyen = new JTextField();
		tfMaPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfMaPhanQuyen.setColumns(20);
		pnMaPhanQuyen.add(tfMaPhanQuyen);
		
		JPanel pnQuyenTruyCap = new JPanel();
		FlowLayout flowLayout_84 = (FlowLayout) pnQuyenTruyCap.getLayout();
		flowLayout_84.setVgap(10);
		flowLayout_84.setHgap(10);
		flowLayout_84.setAlignment(FlowLayout.LEFT);
		panel_55.add(pnQuyenTruyCap);
		
		JLabel lblQuyenTruyCap = new JLabel("Quyền truy cập:");
		lblQuyenTruyCap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnQuyenTruyCap.add(lblQuyenTruyCap);
		
		tfQuyenTruyCap = new JTextField();
		tfQuyenTruyCap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfQuyenTruyCap.setColumns(20);
		pnQuyenTruyCap.add(tfQuyenTruyCap);
		
		JPanel pnButtonQLPQ = new JPanel();
		FlowLayout flowLayout_85 = (FlowLayout) pnButtonQLPQ.getLayout();
		flowLayout_85.setVgap(10);
		flowLayout_85.setHgap(10);
		flowLayout_85.setAlignment(FlowLayout.RIGHT);
		panel_55.add(pnButtonQLPQ);
		
		btnTimKiemPQ = new JButton("Tìm kiếm");
		btnTimKiemPQ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnButtonQLPQ.add(btnTimKiemPQ);
		
		btnCapNhatPQ = new JButton("Cập nhật");
		btnCapNhatPQ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnButtonQLPQ.add(btnCapNhatPQ);
		
		btnHuyPQ = new JButton("Hủy");
		btnHuyPQ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnButtonQLPQ.add(btnHuyPQ);
		
		JPanel panel_61 = new JPanel();
		panel_54.add(panel_61);
		panel_61.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneTablePhanQuyen = new JScrollPane();
		panel_61.add(scrollPaneTablePhanQuyen, BorderLayout.CENTER);
		
		tablePhanQuyen = new JTable();
		scrollPaneTablePhanQuyen.setViewportView(tablePhanQuyen);		
    }
}
