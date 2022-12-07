package com.kelompok.pemdal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DataBeras {
    private JTextField textmerekberas;
    private JTextField textnamapembeli;
    private JTextField textharga;
    private JTextField textjumlah;
    private JButton buttonsave;
    private JTable tampilantabel;
    private JComboBox comboboxjenis;
    private JPanel root;

    private Oopberas objBeras;

    private DefaultTableModel tableModel;

    public DataBeras() {

        this.objBeras = new Oopberas();
        this.initComponents();

        buttonsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getmerekberas = textmerekberas.getText();
                String getnamapembeli = textnamapembeli.getText();
                String getjenisberas = comboboxjenis.getSelectedItem().toString();
                String gethargaberas = textharga.getText();
                String getjumlahdibeli = textjumlah.getText();

                objBeras.setMerekberas(getmerekberas);
                objBeras.setNamapembeli(getnamapembeli);
                objBeras.setJenisberas(getjenisberas);
                objBeras.setHargaberas(gethargaberas);
                objBeras.setJumlahdibeli(getjumlahdibeli);

                tableModel.addRow(new Object[] {getmerekberas, getnamapembeli, getjenisberas, gethargaberas, getjumlahdibeli});

                String hasil = "\nMEREK BERAS : " +getmerekberas + "\nNAMA PEMBELI :" +getnamapembeli + "\nJENIS BERAS : " +getjenisberas + "\nHARGA BERAS : " +gethargaberas +"\nJUMLAH DIBELI : " +getjumlahdibeli + "\n\n";
                FileWriter fw = null;
                String Temp = objBeras.getMerekberas()+"#"+ objBeras.getNamapembeli()+"#"+objBeras.getJenisberas()+"#"+objBeras.getHargaberas()+"#"+objBeras.getJumlahdibeli()+"\n";
                try {
                    fw = new FileWriter("StoredTextData.txt", true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    fw.write(hasil);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    fw = new FileWriter(System.getProperty("user.dir")+"/src/TEMPStrArr.txt",true);
                    fw.write(Temp);
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
        private void initComponents(){

            Object[] tableColumn = {"merek beras",
                    "Nama pembeli",
                    "jenis beras",
                    "harga beras",
                    "jumlah dibeli"};

            Object[][] row = {};

            try {
                tableModel = new DefaultTableModel(new Oopberas().getObjek(),tableColumn);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            tampilantabel.setModel(tableModel);
            tampilantabel.setAutoCreateRowSorter(true);

        }


    public JPanel getRoot() {
        return root;
    }
}
