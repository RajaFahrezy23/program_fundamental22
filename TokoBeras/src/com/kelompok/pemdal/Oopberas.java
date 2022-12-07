package com.kelompok.pemdal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oopberas {
    private String merekberas;
    private String namapembeli;
    private String jenisberas;
    private String hargaberas;
    private String jumlahdibeli;

    public String getMerekberas() {
        return merekberas;
    }

    public void setMerekberas(String merekberas) {
        this.merekberas = merekberas;
    }

    public String getNamapembeli() {
        return namapembeli;
    }

    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }

    public String getJenisberas() {
        return jenisberas;
    }

    public void setJenisberas(String jenisberas) {
        this.jenisberas = jenisberas;
    }

    public String getHargaberas() {
        return hargaberas;
    }

    public void setHargaberas(String hargaberas) {
        this.hargaberas = hargaberas;
    }

    public String getJumlahdibeli() {
        return jumlahdibeli;
    }

    public void setJumlahdibeli(String jumlahdibeli) {
        this.jumlahdibeli = jumlahdibeli;
    }
    private String[][] Objek;

    public String[][]getObjek()throws FileNotFoundException {
        this.readingData();
        return Objek;
    }
    public void readingData()throws FileNotFoundException{
        File file = new File(System.getProperty("user dir")+"/src/TEMPStrArr.txt");
        Scanner sc2 = new Scanner(file);
        Scanner sc = new Scanner(file);

        int totalLine = 0;
        while(sc2.hasNextLine()){
            sc2.nextLine();
            totalLine +=1;
        }
        String[][] StoDArray = new String[totalLine][6];
        int starLoopMain =  0;
        while (sc.hasNextLine()){
            String[]sObject = String.valueOf(sc.hasNextLine()).split("#");
            for(int i = 0; i < sObject.length;i++){
                StoDArray[starLoopMain][i]=sObject[i];
            }
          starLoopMain++;
        }
        this.Objek = StoDArray;
    }
}
