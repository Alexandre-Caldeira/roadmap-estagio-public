package desafio1_draft1;

import javax.swing.JOptionPane;

// https://mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
public class SingleInputDialog1 {

    public static void main(String[] args){
        String m = JOptionPane.showInputDialog("Anyone there?");
        System.out.println(Integer.parseInt(m));

    }

}
