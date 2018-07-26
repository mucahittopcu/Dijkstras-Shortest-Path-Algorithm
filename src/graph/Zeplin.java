package graph;

import java.util.*;
import java.io.*;

public class Zeplin {

    public Zeplin() {

    }

    public static int komsu[][];
    public static double latLong[][];
    public static int yolcuSayisi = 5;
    public static int egim = 75;
    public static double[][] graf;
    public static String[][] matris1;
    public static String[][] matris;
    public static int baslama, bitirme;
    public static String[][] maxKarListesi = new String[46][4];
    public static String[][] yazdir;
    public static int sayac = 0;

    public static String[][] getMaxKarListesi() {
        return maxKarListesi;
    }

    public static void setMaxKarListesi(String[][] maxKarListesi) {
        Zeplin.maxKarListesi = maxKarListesi;
    }

    public void ucus() {
        Infos bilgiler = new Infos();
        Zeplin nesne = new Zeplin();

        latLong = bilgiler.latLongRakimOku();
        komsu = bilgiler.komsuluklarOku();
        graf = new double[81][81];

        nesne.grafReset(graf);

        for (int i = 0; i < graf.length; i++) {
            for (int j = 0; j < graf.length; j++) {

                System.out.print(graf[i][j] + "-");
            }
            System.out.println("");
        }

//        Scanner key = new Scanner(System.in);
//        System.out.println("başlangıç şehri giriniz: ");
//        baslama = key.nextInt();
//        System.out.println("bitiş şehri seçiniz: ");
//        bitirme = key.nextInt();
//        
        matris1 = nesne.maxKarProblemi(graf, baslama, bitirme);

        matris = nesne.yuzdeElliKarProblemi(graf, baslama, bitirme);

        nesne.maxKarProblemiSiralama(matris1);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {

                System.out.print(matris[i][j] + "-");
            }
            System.out.println("");
        }

        //String [][] matris1=nesne.yuzdeElliKarProblemi(graf, baslama, bitirme);
    }

    public void uzaklik(double[][] graf, int baslama, int bitirme) {

        for (int i = 0; i < graf.length; i++) {
            for (int j = 0; j < graf.length; j++) {
                for (int k = 0; k < 10; k++) {

                    if (graf[i][j] == 1.0) {
                        double basLat = latLong[i][0];
                        double basLong = latLong[i][1];
                        double bitLat = latLong[komsu[j][k] - 1][0];
                        double bitLong = latLong[komsu[j][k] - 1][1];
                        double araUzaklik = 0;
                        double rakimfarki;
                        double egikUzaklik;

                        double a = Math.cos(Math.toRadians(basLat)) * Math.cos(Math.toRadians(basLong))
                                * Math.cos(Math.toRadians(bitLat)) * Math.cos(Math.toRadians(bitLong));
                        double b = Math.cos(Math.toRadians(basLat)) * Math.sin(Math.toRadians(basLong))
                                * Math.cos(Math.toRadians(bitLat)) * Math.sin(Math.toRadians(bitLong));
                        double c = Math.sin(Math.toRadians(basLat)) * Math.sin(Math.toRadians(bitLat));
                        araUzaklik = Math.acos(a + b + c) * 6371;
                        araUzaklik = Math.abs(araUzaklik);

                        if (i == baslama || i == bitirme) {
                            rakimfarki = (latLong[i][3]) - (latLong[komsu[j][k] - 1][3] + 50);
                            rakimfarki = Math.abs(rakimfarki);
                        } else {
                            rakimfarki = (latLong[i][3] + 50) - (latLong[komsu[j][k] - 1][3] + 50);
                            rakimfarki = Math.abs(rakimfarki);
                        }

                        double arctandegeri = Math.toDegrees(Math.atan(rakimfarki / araUzaklik));

                        if (arctandegeri <= egim) {
                            //System.out.println("GİDİLEBİLİR..");
                            egikUzaklik = Math.sqrt(Math.pow(araUzaklik, 2) + Math.pow(((rakimfarki) / 1000), 2));
                            graf[i][j] = egikUzaklik;
                        } else {
                            //System.out.println("GİDEMİYOR..");
                            graf[i][j] = 0.0;

                        }
                    }
                }
            }
        }

        if (sayac == 0 || sayac == 47) {
            dosyayazdir(graf);
        }
        sayac++;
    }

    public String[][] maxKarProblemi(double[][] graf, int baslama, int bitirme) {

        int ucret = 100;
        Graph arama = new Graph(baslama, bitirme);
        String[][] yollar = new String[46][4];
        int j = 0;
        for (int i = 5; i <= 50; i++) {
            grafReset(graf);
            yolcuSayisi = i;
            egim = 80 - yolcuSayisi;
            uzaklik(graf, baslama, bitirme);
            arama.enkisaYol(graf);

            yollar[j][0] = Integer.toString(i);
            yollar[j][1] = arama.getDugumler();
            yollar[j][2] = arama.getMesafe();

            double mesafe = Double.parseDouble(yollar[j][2]);
            double kar = (ucret * i) - (mesafe * 10.0);
            String kar1 = Double.toString(kar);
            yollar[j][3] = kar1;

            j++;
        }

        return yollar;

    }

    public void maxKarProblemiSiralama(String[][] matris) {

        double maxkar;
        int maxkarindex;

        for (int m = 0; m < 46; m++) {
            maxkar = -999999.9999;
            maxkarindex = 0;
            for (int i = 0; i < 46; i++) {

                double karsilastir = Double.parseDouble(matris[i][3]);
                if (karsilastir >= maxkar) {
                    maxkar = karsilastir;
                    maxkarindex = i;
                }

            }

            maxKarListesi[m][0] = matris[maxkarindex][0];
            maxKarListesi[m][1] = matris[maxkarindex][1];
            maxKarListesi[m][2] = matris[maxkarindex][2];
            maxKarListesi[m][3] = matris[maxkarindex][3];
            System.out.println("m: " + m);
            System.out.println(maxKarListesi[m][0] + " - " + maxKarListesi[m][1] + " - " + maxKarListesi[m][2] + " - " + maxKarListesi[m][3]);
            matris[maxkarindex][3] = "-999999.9999";

        }
        for (int i = 0; i < 46; i++) {
            for (int j = 0; j < 4; j++) {
                if (maxKarListesi[i][3] != "-999999.9999") {
                    System.out.print(" - " + maxKarListesi[i][j] + " - ");
                }
            }
            System.out.println("");
        }

    }

    public String[][] yuzdeElliKarProblemi(double[][] graf, int baslama, int bitirme) {

        Graph arama = new Graph(baslama, bitirme);
        String[][] yollar1 = new String[5][4];

        int j = 0;
        for (int i = 10; i <= 50; i++) {
            grafReset(graf);
            yolcuSayisi = i;
            egim = 80 - yolcuSayisi;
            uzaklik(graf, baslama, bitirme);
            arama.enkisaYol(graf);
            yollar1[j][0] = Integer.toString(i);
            yollar1[j][1] = arama.getDugumler();
            yollar1[j][2] = arama.getMesafe();

            double mesafe = Double.parseDouble(arama.getMesafe());
            double alinacak = ((mesafe * 10.0) * 1.5) / i;
            String alinacak1 = Double.toString(alinacak);
            yollar1[j][3] = alinacak1;

            i = i + 9;
            j++;
        }

        return yollar1;

    }

    public void grafReset(double[][] graf) {

        for (int i = 0; i < graf.length; i++) {
            for (int j = 0; j < graf.length; j++) {
                graf[i][j] = 0.0;
            }
        }
        for (int i = 0; i < 81; i++) {
            for (int j = 1; j < 10; j++) {
                if (komsu[i][j] != 0) {
                    graf[i][komsu[i][j] - 1] = 1.0;
                }

            }
        }

    }

    public void dosyayazdir(double[][] graf) {

        if (sayac == 0) {
            try {
                FileWriter fileWriter = new FileWriter("save1.txt");
                PrintWriter dosyayaz = new PrintWriter(fileWriter);

                for (int i = 0; i < graf.length; i++) {
                    for (int j = 0; j < graf.length; j++) {
                        dosyayaz.print(graf[i][j] + " -- ");
                    }
                    dosyayaz.println();
                }

                dosyayaz.close();
            } catch (IOException e) {
                System.out.println("Hata!");
            }

        } else {
            try {
                FileWriter fileWriter = new FileWriter("save2.txt");
                PrintWriter dosyayaz = new PrintWriter(fileWriter);

                for (int i = 0; i < graf.length; i++) {
                    for (int j = 0; j < graf.length; j++) {
                        dosyayaz.print(graf[i][j] + " -- ");
                    }
                    dosyayaz.println();
                }

                dosyayaz.close();
            } catch (IOException e) {
                System.out.println("Hata!");
            }
        }

    }

    public void grafYazdir(double[][] graf) {
        for (int i = 0; i < graf.length; i++) {
            for (int j = 0; j < graf.length; j++) {

                System.out.print(graf[i][j] + "-");
            }
            System.out.println("");
        }
    }

    public static String[][] getMatris1() {
        return matris1;
    }

    public static void setMatris1(String[][] matris1) {
        Zeplin.matris1 = matris1;
    }

    public static String[][] getMatris() {
        return matris;
    }

    public static void setMatris(String[][] matris) {
        Zeplin.matris = matris;
    }

    public static int getBaslama() {
        return baslama;
    }

    public static void setBaslama(int baslama) {
        Zeplin.baslama = baslama;
    }

    public static int getBitirme() {
        return bitirme;
    }

    public static void setBitirme(int bitirme) {
        Zeplin.bitirme = bitirme;
    }
}
