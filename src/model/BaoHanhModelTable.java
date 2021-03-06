/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entities.BaoHanh;

/**
 *
 * @author THAITHANG
 */

public class BaoHanhModelTable extends AbstractTableModel{
    private List<BaoHanh> data;
    private String[] columns = {"Mã BH",
                                "Số hóa đơn bán",
                                "Mã SP",
                                "Serial",
                                "Yêu cầu bảo hành",
                                "Nhân viên nhận",
                                "Ngày nhận",
                                "Tình trạng",
                                "Nhân viên trả",
                                "Ngày trả"                
    };

    public BaoHanhModelTable() {
        this.data = new ArrayList<>();
    }
    
    public BaoHanhModelTable(List<BaoHanh> data) {
        this.data = data;
    }

    public List<BaoHanh> getData() {
        return data;
    }

    public void setData(List<BaoHanh> data) {
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
         //To change body of generated methods, choose Tools | Templates.
        return columns.length;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col]; //To change body of generated methods, choose Tools | Templates.
    }
    
    public BaoHanh getSelectedRow(int row) {
        if(row < data.size() && row > -1)
                return data.get(row);
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex > getRowCount() || columnIndex > getColumnCount()) {
            return null;
        }
        BaoHanh bh = data.get(rowIndex);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        switch (columnIndex) {
            case 0:
                return bh.getMaBh();
            case 1:
                return bh.getHoadonban().getSohdBan();
            case 2:
                return bh.getSanpham().getMaSp();
            case 3:
                return bh.getSerial();
            case 4:
                return bh.getYeucauBh();
            case 5:
                return bh.getNhanvienByNhanvienNhan().getMaNv();
            case 6:
                String ngayNhan = dateFormat.format(bh.getNgaynhan());
                return ngayNhan;
            case 7:
                return bh.getTinhtrang();
                
            case 8:
                if(bh.getNhanvienByNhanvienTra() == null) return "";
                return bh.getNhanvienByNhanvienTra().getMaNv();
            case 9:
                if(bh.getNgaytra()==null) return "";
                String ngayTra = dateFormat.format(bh.getNgaytra());
                return ngayTra;
            default:
                return null;
        }
    }
    
    public void addRow(BaoHanh object) {
        data.add(object);
        fireTableDataChanged();
    }

    public void addRow(int row, BaoHanh object){
        data.add(row, object);
        fireTableDataChanged();
    }
    
    public boolean removeRow(int row) {
        boolean result;
        if(row < data.size()) {
            data.remove(row);
            fireTableDataChanged();
            return true;
        }
        return false;
    }

    public boolean removeRow(BaoHanh object) {
        boolean result = data.remove(object);
        fireTableDataChanged();
        return result;
    }
    
    public void clearData(){
        data.clear();
        fireTableDataChanged();
    }
}
