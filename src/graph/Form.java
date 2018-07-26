package graph;

import java.awt.Dimension;
import java.awt.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.print.DocFlavor;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

public class Form extends javax.swing.JFrame{
   
    public static String [][] soru1;
    public static ArrayList <String> soru1text = new ArrayList <String> ();
    public static String [][] soru2;
    public static ArrayList <String> soru2text = new ArrayList <String> ();
  
    public static String[] bol1;
    public static String[] bol2;
    int uyari=0;
    
    public Form()
    {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        list1 = new java.awt.List();
        list2 = new java.awt.List();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Başlangıç Şehri                     :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Bitiş Şehri                              :");

        jTextField1.setNextFocusableComponent(jTextField2);

        jTextField2.setNextFocusableComponent(jTextField1);

        jButton1.setText("GİT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel3.setText("SONUÇ 1");

        list1.setBackground(new java.awt.Color(204, 255, 204));

        list2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel5.setText("SONUÇ 2");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Geçen Süre");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(244, 244, 244))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 606, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3))
                .addGap(108, 108, 108))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jButton1)
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        long startTime = System.nanoTime();
        
        if (jTextField1.getText().equals("") || Integer.parseInt(jTextField1.getText())<0 || Integer.parseInt(jTextField1.getText())>81
                || jTextField2.getText().equals("") ||Integer.parseInt(jTextField2.getText())<0 || Integer.parseInt(jTextField2.getText())>81)
        {
            
        }
        else
        {
            
            Zeplin zeplin=new Zeplin();
            zeplin.setBaslama(Integer.parseInt(jTextField1.getText())-1);
            zeplin.setBitirme(Integer.parseInt(jTextField2.getText())-1);
            zeplin.ucus();
            soru1=zeplin.getMaxKarListesi();
            soru2=zeplin.getMatris();
            
            
            for (int i = 0; i < soru1.length; i++) 
            {
                if (soru1[i][3].equals("-999999.9999") || soru1[i][3].equals("-Infinity")) {
                }
                else
                {
                    bol1=soru1[i][1].split(",");
                    StringBuilder stryapici1= new StringBuilder();
                    ArrayList<Integer> enkarliyol1=new ArrayList<>();
                   // StringBuilder stryapici11= new StringBuilder();
                    for (int j= 1; j < bol1.length; j++) 
                    {
                        stryapici1.append((Integer.parseInt(bol1[j])+1)+"-");
                        if (i==0) {
                             enkarliyol1.add(Integer.parseInt(bol1[j])+1);
                        }
                    }
                    if (i==0){
                        enkarliyol1.add(Integer.parseInt(jTextField2.getText()));
                        Map  kar= new Map();
                        kar.main(enkarliyol1,"En Karlı Yol");
                    }
                    stryapici1.append(jTextField2.getText());
                    soru1text.add("*Yolcu Sayısı:"+soru1[i][0]+" *Geçtiği Yollar:"+stryapici1.toString()+" *Yol Uzunluğu:"+soru1[i][2]+" *Kar:"+soru1[i][3]);
                }
            }
            for (int i = 0; i <soru1text.size() ; i++) 
            {
                list1.add(soru1text.get(i));
                uyari++;
            }
            //////////////////////////////////////////////////////////
            
            for (int i = 0; i < soru2.length; i++) 
            {
                if (soru2[i][3].equals("Infinity") || soru2[i][2].equals(String.valueOf(Double.MAX_VALUE))) {
                }
                else
                {
                    bol2=soru2[i][1].split(",");
                    StringBuilder stryapici2= new StringBuilder();
                    ArrayList<Integer> enkarliyol2=new ArrayList<>();
                    for (int j= 1; j < bol2.length; j++) 
                    {
                        stryapici2.append((Integer.parseInt(bol2[j])+1)+"-");
                        enkarliyol2.add(Integer.parseInt(bol2[j])+1);
                    }
                    enkarliyol2.add(Integer.parseInt(jTextField2.getText()));
                    stryapici2.append(jTextField2.getText());
                    soru2text.add("*Yolsu Sayısı:" + soru2[i][0] + " *Geçtiği Yollar:"+stryapici2.toString()+" *Yol Uzunluğu:" + soru2[i][2] + " *Kişi Başi Ücret:" + soru2[i][3]);
                    Map  a= new Map();
                    a.main(enkarliyol2,soru2[i][0]+" Yolcu ");
                }
            }
            for (int i = 0; i <soru2text.size() ; i++) 
            {
                list2.add(soru2text.get(i));
                uyari++;   
            }  
        }
        long endTime = System.nanoTime(); 
        long estimatedTime = endTime - startTime; // Geçen süreyi nanosaniye cinsinden elde ediyoruz
        double seconds = (double)estimatedTime/1000000000.00;
        jTextField3.setText(String.valueOf(new DecimalFormat("###.####").format(seconds))+" sn");
        if (uyari == 0) {
            JOptionPane.showMessageDialog(null, "Hiç Bir Yol Bulunamadı!", "YOL YOK", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form acilis=new Form();
                acilis.setResizable(false);
                acilis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                acilis.setTitle("GEZ");
                acilis.setLocationRelativeTo(null);
                acilis.setVisible(true);  
                JRootPane rootPane = acilis.getRootPane();
                rootPane.setDefaultButton(jButton1);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.awt.List list1;
    private java.awt.List list2;
    // End of variables declaration//GEN-END:variables
}
