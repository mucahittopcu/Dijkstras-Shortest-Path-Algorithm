package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Infos {

    public Infos() 
    {
        
    }
    public double[][] latLongRakimOku()
    {
        String info[] = new String[82];
        String ayrac[] = new String[4];
        double mainInfo[][] = new double[81][4];
        try {
            File file = new File("latlong.txt");
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(file));
            String satir1 = reader.readLine();
            int i = 0;
            while (satir1 != null) {
                info[i] = satir1;
                i++;
                satir1 = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 81; i++) 
        {
            ayrac = info[i].split(",");
            for (int j = 0; j < 4; j++)
            {
                if (j >= 2) 
                {
                    mainInfo[i][j] = Integer.parseInt(ayrac[j]);
                } 
                else 
                {
                    mainInfo[i][j] = Double.parseDouble(ayrac[j]);
                }
            }
        }
        return mainInfo;
    }
    
    public int[][] komsuluklarOku()
    {
        String infoKomsu[] = new String[81];
        String ayracKomsu[];
        int  mainInfoKomsu[][] = new int[81][10];
        try {
            File file = new File("komsuluk.txt");
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(file));
            String satir1 = reader.readLine();
            int i = 0;
            while (satir1 != null) {
                infoKomsu[i] = satir1;
                i++;
                satir1 = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 81; i++) 
        {
            ayracKomsu = infoKomsu[i].split(",");
            for (int j = 0; j <10; j++)
            {
                if (j<ayracKomsu.length) 
                {
                    mainInfoKomsu[i][j] = Integer.parseInt(ayracKomsu[j]); 
                }
                else
                {
                    mainInfoKomsu[i][j]=0;
                }    
            }
        }
        return mainInfoKomsu;
    }
}
