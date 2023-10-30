/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan7;

import java.util.ArrayList;


public class DataTabel {
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>> ();
    
    //fungsi untuk menambahkan data ke ArrayList data
    public void setData(ArrayList<String> data) {
        this.data.add(data);
    }
    
    //fungsi untuk menghapus data ke ArrayList data
    public void remove(int row) {
        this.data.remove(row);
    }
    
    //fungsi untuk mendapatkan data ke ArrayList data
    public String getData(int row, int col) {
        return data.get(row).get(col);
    }
    
    //fungsi untuk mendapatkan data dalam 1 baris  ArrayList data
    public ArrayList<String> getDataRow (int row) {
        return data.get(row);
    }
    
    //fungsi untuk mengubah data dalam 1 baris  ArrayList data
     public void setDataRow(int row, int col, String value) {
        data.get(row).set(col, value);
    }
    
     //fungsi untuk mendapatkan jumlah kolom dari ArrayList data
     public int getSize(int row) {
        return data.get(row).size();
    }
     
     //fungsi untuk mendapatkan jumlah baris dari ArrayList data
    public int getSizeAll() {
        return data.size();
    }
}

