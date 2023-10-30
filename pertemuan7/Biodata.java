package pertemuan7;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.*;
import java.util.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Biodata extends JFrame {
    
    private DataTabel dt = new DataTabel();
    
    
    public Biodata() {
       
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        
        // Atur ukuran panjang dan lebar serta posisi x dan y
        JLabel labelHeader = new JLabel("Form Biodata", JLabel.CENTER);
        labelHeader.setBounds(60, 20, 350, 10);
        
        JLabel labelInput = new JLabel("Nama : "); //menamakan label
        labelInput.setBounds(15,30,100,30);
        
        JTextField textField = new JTextField(); //kotak pada label yang akan diisi
        textField.setBounds(15, 60, 150, 30);
        
        JLabel labelInput2 = new JLabel("Nomer HP: ");//menamakan label
        labelInput2.setBounds(15, 100, 400, 10);
        
        JTextField textField2 = new JTextField();//kotak pada label yang akan diisi
        textField2.setBounds(15, 120, 150, 30);
        
        //pemilihan jenis kelamin yang hanya bisa dipilih 1 saja
        JLabel labelRadio = new JLabel ("Jenis kelamin : ");
        labelRadio.setBounds(15,160,350,10);
        
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15,170,350,30);
        
        JRadioButton radioButton2 = new JRadioButton("Perempuan", true);
        radioButton2.setBounds(15,195,350,30);
        
         JLabel labelInput3 = new JLabel("Alamat: ");//menamakan label
        labelInput3.setBounds(15, 223, 350, 30);
        
       JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,250,450,100);
      
        //pembuatan grup pada radio button untuk pemilihan jenis kelamin
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
       
        //membuat tombol simpan 
        JButton button = new JButton("SIMPAN");
        button.setBounds(15,360,100,40);
        
        JButton button2 = new JButton("EDIT");
        button2.setBounds(120,360,100,40);
        
        JButton button3 = new JButton("HAPUS");
        button3.setBounds(225,360,100,40);
       
        JButton button4 = new JButton("SIMPAN KE FILE");
        button4.setBounds(330,360,130,40);
        
        
        //membuat dan memanggil tabel
        JTable table = new JTable(); //komponen yang digunakan untuk menampilkan data dalam bentuk tabel.
        // mengaktifkan pengguliran jika tabel memiliki banyak baris)
        JScrollPane scrollableTable =  new JScrollPane(table);
        // mengatur lokasi dan ukuran JScrollPane
        scrollableTable.setBounds(15,410,450,200);
        //menyediakan data yang akan ditampilkan dalam tabel.
        MyTable tableModel = new MyTable();
        table.setModel(tableModel);
        
        //untuk menangani peristiwa ketika tombol diklik. 
         button.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){                    
                
                 //menginisialisasi sebuah variabel jenisKelamin sebagai string kosong.
                 String jenisKelamin = "";
                 //pengkondisian pada jenis kelamin
                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                    radioButton1.setSelected(false);
                }
                 if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                    radioButton2.setSelected(false);
                }
                 
                 //mengambil teks dari sebuah TextField dan menyimpannya dalam variabel nama
                   String nama = textField.getText();
                   //mengambil teks dari sebuah TextField dan menyimpannya dalam variabel nomer
                   String nomer = textField2.getText();
                   String alamat = txtOutput.getText();
                   
                   //menampilkan nama, nomor, jenis kelamin, wna
                   tableModel.add(new ArrayList<>(Arrays.asList(nama, nomer, jenisKelamin, alamat)));
                
                   
                   // Jika nama, telepon dan alamat bernilai kosong
                if (nama.equalsIgnoreCase("") && nomer.equalsIgnoreCase("") && alamat.equalsIgnoreCase("")) {
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Biodata.this, "Nama, telepon dan alamat belum terisi", "Perhatian",
                            JOptionPane.WARNING_MESSAGE);
                    return;
              } else {
                    // Jika nama bernilai kosong
                    if (nama.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                        // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                        JOptionPane.showMessageDialog(Biodata.this, "Nama belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // Jika telepon bernilai kosong
                    if (nomer.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                        // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                        JOptionPane.showMessageDialog(Biodata.this, "Telepon belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // Jika alamat bernilai kosong
                    if (alamat.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                        // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                        JOptionPane.showMessageDialog(Biodata.this, "Alamat belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                        "Apakah anda yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                // Jika confirmation berinilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Tambahkan variable nama, telepon, jenisKelamin, dan wna ke objek ArrayList
                    // dan dikirim lagi ke objek tableModel dan dt melalui method add
                    tableModel.add(new ArrayList<>(Arrays.asList(nama, nomer, jenisKelamin, alamat)));
                    dt.setData(new ArrayList<>(Arrays.asList(nama, nomer, jenisKelamin, alamat)));
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Biodata.this, "Data tersimpan", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                // Jika confirmation nilai opsi no
                else {
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Biodata.this, "Data tidak tersimpan", "Perhatian",
                            JOptionPane.ERROR_MESSAGE);
                }
                // Kembalikan isi textFieldNama ke kondisi kosong
                textField.setText("");
                // Kembalikan isi textFieldTelepon ke kondisi kosong
                textField2.setText("");
                // Kembalikan isi textare ke kondisi kosong
                txtOutput.setText("");
            }
        });

        // Menambahkan action listener ke button ubah
        button2.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Jika table sedang diedit dan user mengklik button ubah
                if (table.isEditing()) {
                    // Hentikan editing pada table
                    table.getCellEditor().stopCellEditing();
                }

                // Variable row untuk menyimpan nilai baris yang dipilih
                int row = table.getSelectedRow();
                // Variable column untuk menyimpan nilai kolom yang dipilih
                int column = table.getSelectedColumn();
                // Variable newValue untuk menyimpan nilai dari table yang diedit
                String newValue = (String) table.getModel().getValueAt(row, column);

                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                        "Apakah anda yakin ingin mengubah data?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Ubah nilai dari tableModel dan dt dengan nilai newValue pada baris dan kolom
                    // yang dipilih
                    tableModel.setValueAt(newValue, row, column);
                    dt.setDataRow(row, column, newValue);
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Biodata.this, "Data berhasil diubah", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Jika batal diubah, kembalikan nilai dari tableModel dan dt ke kondisi semula
                    for (int i = 0; i < dt.getSize(row); i++) {
                        tableModel.setValueAt(dt.getData(row, i),
                                row,
                                i);
                    }
                }
            }
        });

        // Menambahkan action listener ke button hapus
        button3.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Variable row untuk menyimpan nilai baris yang dipilih
                int row = table.getSelectedRow();
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                        "Apakah anda yakin ingin menghapus data?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Hapus baris yang dipilih dari tableModel dan dt
                    tableModel.remove(row);
                    dt.remove(row);

                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Biodata.this, "Data berhasil dihapus", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Menambahkan action listener ke button file
        button4.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                        "Apakah anda yakin ingin menyimpan data ke file?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Instansiasi JFileChooser dengan nama fileChooser
                    JFileChooser fileChooser = new JFileChooser();
                    // Atur title dari fileChooser
                    fileChooser.setDialogTitle("Simpan Data ke File");
                    // Atur filter dari fileChooser
                    fileChooser.setFileFilter(new FileNameExtensionFilter("File Teks", "txt"));
                    // Variable userSelection untuk menyimpan nilai dari fileChooser
                    int userSelection = fileChooser.showSaveDialog(Biodata.this);

                    // Jika userSelection bernilai opsi approve
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        try {
                            // Instansiasi FileWriter dengan nama writer
                            FileWriter writer = new FileWriter("data.txt");

                            // Dapatkan data dari baris dt
                            for (int i = 0; i < dt.getSizeAll(); i++) {
                                // Dapatkan data dari kolom dt
                                for (int j = 0; j < dt.getSize(i); j++) {
                                    if (j == 3) {
                                        // Tulis data dari dt ke file, jika j == 3 maka tambahkan baris baru
                                        writer.write(dt.getData(i, j).toString() + "\n");
                                    } else {
                                        // Tulis data dari dt ke file, jika j != 3 maka tambahkan koma
                                        writer.write(dt.getData(i, j).toString() + ",");
                                    }
                                }
                            }

                            // Tutup file
                            writer.close();

                            // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                            // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                            JOptionPane.showMessageDialog(Biodata.this, "Data berhasil disimpan ke file",
                                    "Perhatian",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException ex) {
                            // Tampilkan error pada console
                           ex.printStackTrace();
                        }
                    }
                }

             }  
             
       });
        
        // Menambahkan window listener ke frame
        this.addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
                
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                        "Apakah anda yakin ingin keluar aplikasi?\nSemua data yang belum disimpan, tidak akan tersimpan.",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Dapatkan data dari baris tableModel
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        // Dapatkan data dari kolom tableModel
                        for (int j = 0; j < tableModel.getColCount(i); j++) {
                            // Tulis data dari tableModel dari dt
                            tableModel.setValueAt(dt.getData(i, j),
                                    i,
                                    j);
                        }
                    }
                    // Keluar dari aplikasi
                    System.exit(0);
                } else {
                    
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        // menambahkan komponen ke kontainer utama merupakan sebuah panel atau frame
        this.add(labelHeader);
        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(textField);
        this.add(textField2);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput);
        this.add(labelInput2);
        this.add(txtOutput);
         this.add(labelInput3);
        this.add(scrollableTable);
   
        
        this.setSize(500, 700);
        this.setLayout(null);
        
                
    }
    
    //membuat supaya kodingan supaya bisa di run
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
            Biodata h = new Biodata();
            h.setVisible(true);
            }
        });
    }
    }

    

