/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan7;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*; 

public class MyTable  extends AbstractTableModel {
    
    //untuk menginisialisasi model tabel atau membuat tampilan kolom dalam tabel.
    private String[] columnNames = {"Nama", "Nomer HP","Jenis Kelamin", "Alamat"};
    //digunakan untuk menyimpan data dalam bentuk baris dan kolom.
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    // untuk mengembalikan jumlah kolom yang akan ditampilkan dalam tabel. 
    public int getColumnCount() {
        return columnNames.length;
    }
    
    // untuk mengembalikan jumlah baris yang akan ditampilkan dalam tabel. 
    public int getRowCount() {       
        return data.size();      
    }
    
    //digunakan untuk mendapatkan jumlah baris dalam kolom tertentu dari 
    //struktur data tabel
     public int getColCount(int col) {       
        return data.get(col).size();      
    }
    
    //untuk mendapatkan nama kolom yang akan ditampilkan dalam tabel. 
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    //untuk mengambil nilai dari sel tabel pada baris row dan kolom col
    public Object getValueAt(int row, int col) {
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }
    
    //untuk menentukan apakah sel tertentu dalam tabel dapat diedit atau tidak. 
    public boolean isCellEditable(int row, int col) {
       return row >=0 && col >= 0; 
    }
    
    //untuk mengubah nilai dari baris dan kolom tertentu
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        List<String> rowItem = data.get(rowIndex);
        rowItem.set(columnIndex, (String) aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    //fungsi untuk menghapus nilai dari baris tertentu
    public void remove(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    //fungsi untuk mengatasi error saat menghapus baris
    void removeRow(int selectedRow) {

        throw new UnsupportedOperationException("Not supported yet.");
    
    }
    //untuk menambahkan baris baru ke model tabel. 
    public void add(ArrayList<String> value) {
        data.add(value);
        fireTableRowsInserted(data.size() -1, data.size() - 1);
    }

    

    
    
}

    

