package graph;

public class Graph {
    
    public int giris_index=0;
    public int cikis_index=3;
    public int satirsayisi=3;
    public int sutunsayisi=3;
    public static String[][] yol;
    public static String gidis;
    public static String mesafe;
    public Graph(){
        
    }
    public Graph(int giris_index,int cikis_index){
        this.giris_index=giris_index;
        this.cikis_index=cikis_index;
        
    }
    public void enkisaYol(double[][] graf) {
        this.satirsayisi = graf.length + 2;
        this.sutunsayisi = (graf.length * 2) + 1;
        yol= new String[satirsayisi][sutunsayisi];
        yol[0][0] = "indis";
        boolean dizi[] = new boolean[graf.length];
        for (int i = 0; i < graf.length; i++) {
            dizi[i] = false;
        }
        int a = 0;
        for (int j = 1; j < sutunsayisi; j++) {
            String ab = Integer.toString(a);
            yol[0][j] = ab + ".yol";
            yol[0][j + 1] = ab + ".uzaklık";
            j++;
            a++;
        }
        double max = Double.MAX_VALUE;
        String sonsuz = Double.toString(max);
        yol[1][0] = "-";
        for (int i = 1; i < sutunsayisi; i++) {
            yol[1][i] = "-";
            yol[1][i + 1] = sonsuz;
            i++;
        }
        System.out.println("");
        
        int index, yolsatir = 2;
        
        String deger1 = Integer.toString(giris_index);
        
        yol[1][2 + (2 * giris_index)] = "0";
        yol[1][1 + (2 * giris_index)] = deger1;

        index = giris_index;
        for (int i = 0; i < 9; i++) {
            System.out.print(yol[1][i] + "  ");
        }

        while (true) {
            int tut = 1;
            if(index==-1){
                System.out.println("bitirrrrrrrrrr.r.r.r.rr.r...");
                break;
            }
            yol[yolsatir][0] = Integer.toString(index);
//            System.out.println("genel döngü içine giriş: " + yolsatir);
//            System.out.println("başlangıç: " + yol[yolsatir][0] + "index: " + index);
//            System.out.println("graf boyutu:: " + graf.length);
            for (int i = 0; i < graf.length; i++) {
                if (i == giris_index) {
                    int indexbulma;
                    String deger = Integer.toString(i);
                    indexbulma = 1 + (2 * giris_index);
                    yol[yolsatir][indexbulma] = deger;
                    yol[yolsatir][indexbulma + 1] = "0";
//                    System.out.println("başlangıc değer");
                } else if (graf[index][i] != 0 && dizi[i] == false) {
//                    System.out.println("komşusu var: " + yolsatir + " i: " + i);
                    double ustdeger = Double.parseDouble(yol[yolsatir - 1][tut + 1]);
//                    System.out.println("ustdeger: " + ustdeger);
                    String gelen = kaclageldik(yol, yolsatir, index);
//                    System.out.println(kaclageldik(yol, yolsatir, index));
                    double olandeger = Double.parseDouble(gelen);
                    double topla = graf[index][i] + olandeger;
//                    System.out.println("toplam: " + topla);
                    if (ustdeger >= topla) {
//                        System.out.println("küçükse");
                        yol[yolsatir][tut + 1] = Double.toString(topla);
//                        System.out.println("küçükse yazdır: " + yol[yolsatir][tut + 1]);
                        if (yol[yolsatir - 1][tut] == "-") {
                            yol[yolsatir][tut] = nerdengeldik(yol, yolsatir, index) + "," + yol[yolsatir][0];
//                            System.out.println("satir başını cızık varsa yaz: " + yol[yolsatir][tut]);
                        } else {
                            yol[yolsatir][tut] = nerdengeldik(yol, yolsatir, index) + "," + yol[yolsatir][0];
//                            System.out.println("nerden geldiğimize ekleme yap" + yol[yolsatir][tut]);
                        }
                    } else {
                        yol[yolsatir][tut + 1] = yol[yolsatir - 1][tut + 1];
                        yol[yolsatir][tut] = yol[yolsatir - 1][tut];
//                        System.out.println("aynı kalsın");
                    }
                } else {
                    yol[yolsatir][tut + 1] = yol[yolsatir - 1][tut + 1];
                    yol[yolsatir][tut] = yol[yolsatir - 1][tut];
//                    System.out.println("aynı kalsın mı" + i);
//                    System.out.println("yok artık");
                }
                tut = tut + 2;
            }
            //System.out.println("İNDEX:  " + index);

            dizi[index] = true;
            System.out.print("DİZİ:  ");
            for (int i = 0; i < dizi.length; i++) {
                System.out.print(dizi[i] + "-");
            }
            int cikis = 0;
            for (int i = 0; i < dizi.length; i++) {
                if (dizi[i] == true) {
                    cikis++;
                }
            }
            if (cikis == dizi.length) {
                System.out.println("cikalim");
                break;
            }
            index = hangikomsu(graf, dizi, index, yol, yolsatir);
            yolsatir++;
        }
        
        yolTablosuYazdir();
        
        gidis=yol[yolsatir-1][(cikis_index*2)+1];
        mesafe=yol[yolsatir-1][(cikis_index*2)+2];
        System.out.println("");
        System.out.println("index: "+yol[yolsatir-1][0]);
        System.out.println("yolsatir: "+yolsatir);
        System.out.println("Düğümler: "+ gidis);
        System.out.println("Yol mesafesi: "+ mesafe);
        
    }
    public String getDugumler(){
        if(gidis=="-"){
            gidis="Bu yolcu sayısı ile yol yok!";
        }
        return gidis;
    }
    public String getMesafe(){
        
        return mesafe;
    }
    public int getsatirsayisi(){
        return this.satirsayisi;
    }
    public int getsutunsayisi(){
        return this.sutunsayisi;
    }
    public void yolTablosuYazdir(){
        for (int i = 0; i < this.satirsayisi; i++) {
            for (int j = 0; j < this.sutunsayisi; j++) {
                if (i == 0) {
                    System.out.print(yol[i][j] + " ");
                } else {
                    System.out.print(" " + yol[i][j] + "      ");
                }

            }
            System.out.println("");
        }
    }

    public int hangikomsu(double[][] graf, boolean[] dizi, int index, String[][] yol, int yolsatir) {
        double enkucuk = Double.MAX_VALUE;
        int enkucukyolindex = -1;
        while (enkucukyolindex == -1) {
            for (int i = 0; i < graf.length; i++) {
                if (graf[index][i] != 0.0 && graf[index][i] < enkucuk && dizi[i] == false) {
                    enkucuk = graf[index][i];
                    enkucukyolindex = i;
                }
            }
            if (enkucukyolindex != -1) {
//                System.out.println("enkucukyolindeximiz2: " + enkucukyolindex);
                break;
            }
            if(yol[yolsatir - 1][0]=="-"){
//                System.out.println(enkucukyolindex);
                enkucukyolindex=-1;
                break;
            }
            int sayi = Integer.parseInt(yol[yolsatir - 1][0]);
//            System.out.println("indexleme: " + sayi);
//            System.out.println("enkucukyolindeximiz1: " + enkucukyolindex);
            index = sayi;
//            System.out.println("yolsatirimiz: " + yolsatir);
            yolsatir--;
        }
//        System.out.println("en kucuk alındı:" + enkucukyolindex);
        return enkucukyolindex;
    }

    public String nerdengeldik(String[][] yol, int yolsatir, int index) {
        return yol[yolsatir - 1][1 + (2 * index)];
    }

    public String kaclageldik(String[][] yol, int yolsatir, int index) {
        return yol[yolsatir - 1][2 + (2 * index)];
    }

}
