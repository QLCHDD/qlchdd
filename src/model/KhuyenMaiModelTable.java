/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.entities.KhuyenMai;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class KhuyenMaiModelTable extends AbstractTableModel{
    private List<KhuyenMai> data;
    private String[] columns = {"Mã KM",
                                "Tên KM",
                                "Hệ số",
                                "Ngày bắt đầu",
                                "Ngày kết thúc"
    };
    
      public KhuyenMaiModelTable(List<KhuyenMai> data) {
        this.data = data;
    }

    public List<KhuyenMai> getData() {
        return data;
    }

    public void setData(List<KhuyenMai> data) {
        this.data = data;
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
    
        public KhuyenMai getSelectedRow(int row) {
        if(row < data.size() && row > -1)
                return data.get(row);
        return null;
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
