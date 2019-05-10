/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis44groupproject;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author admin
 */

public class Start {
    public static void main(String[] args){
        LinkedBag<Student> studentBag = new LinkedBag<>();
        Queue<Student> waitingList = new Queue<>();
        Stack<Student> studentStack = new Stack<>();
        
        SplashScreen Splash = new SplashScreen();
        Splash.setVisible(true);
        Menu start = new Menu(studentBag, waitingList, studentStack);
        
        String[] fNames = {"Aaron", "Blake", "Charice", "Dillion", "Eve", "Fiona", "Gill", "Hannah", "Ian", "James", "Kaitlyn", "Leon", "Michelle"};

        String[] lNames = {"Nolan", "Otis", "Phillips", "Quinton", "Roberts", "Stockton", "Thompson", "Ubaldo", "Vallen", "Walters", "Xanders", "Young", "Zabinski"};
        
        Double minGPA = 0.0;
        Double maxGPA = 4.0; 
        
        int inClass = 21;
        int inwaitList = 8;

        
        DecimalFormat df = new DecimalFormat("0.##");
       
        for (int i = 0; i < inClass; i++) {
            double gpa = (Math.random() * (maxGPA - minGPA)) + minGPA; 
     
            Student st1 = new Student(fNames[new Random().nextInt(fNames.length)], lNames[new Random().nextInt(fNames.length)], Double.parseDouble(df.format(gpa)));
            studentBag.add(st1);
        }
        for (int i = 0; i < inwaitList; i++) {
            double gpa = (Math.random() * (maxGPA - minGPA)) + minGPA; 
  
            Student st2 = new Student(fNames[new Random().nextInt(fNames.length)], lNames[new Random().nextInt(fNames.length)], Double.parseDouble(df.format(gpa)));
            waitingList.enqueue(st2);
        }
        System.out.println("IN the start constructor " + studentBag.getCurrentSize());
       // System.out.println(studentBag.getCurrentSize());
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
try {
            for (int i = 0; i <=100; i++){
               
                Thread.sleep(40);
                Splash.loadingnum.setText(Integer.toString(i) + "%");
                Splash.loadingbar.setValue(i);
                if(i==100){
                    Splash.setVisible(false);
                    
                    start.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
    }
}
