package practica3_interfazgrafica__20110388;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Practica3_InterfazGrafica__20110388 extends JFrame{
    JLabel text1;
    JTextArea textArea1; JTextArea textArea2; JTextArea textArea3;
    JLabel textTime1; JLabel textTime2; JLabel textTime3;
    
    public Practica3_InterfazGrafica__20110388(){
        setTitle("MergeSort");
        setSize(535, 360);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton button0 = new JButton("Nuevo arreglo.");
        button0.setBounds(10, 25, 160, 20);
        add(button0);
        
        JLabel text0 = new JLabel("Arreglo:");
        text0.setBounds(10, 50, 60, 15);
        add(text0);
        
        text1 = new JLabel("[1, 2]");
        text1.setBounds(60, 50, 60, 15);
        add(text1);
        
        JButton button1 = new JButton("Secuencual.");
        button1.setBounds(10, 100, 160, 20);
        add(button1);
        
        JButton button2 = new JButton("ForkJoin.");
        button2.setBounds(180, 100, 160, 20);
        add(button2);
        
        JButton button3 = new JButton("ExecuteService.");
        button3.setBounds(350, 100, 160, 20);
        add(button3);
        
        textArea1 = new JTextArea("");
        textArea1.setBounds(10, 125, 160, 160);
        add(textArea1);
        
        textArea2 = new JTextArea("");
        textArea2.setBounds(180, 125, 160, 160);
        add(textArea2);
        
        textArea3 = new JTextArea("");
        textArea3.setBounds(350, 125, 160, 160);
        add(textArea3);
        
        textTime1 = new JLabel("Tiempo1");
        textTime1.setBounds(10, 285, 60, 15);
        add(textTime1);
        
        textTime2 = new JLabel("Tiempo2");
        textTime2.setBounds(180, 285, 60, 15);
        add(textTime2);
        
        textTime3 = new JLabel("Tiempo3");
        textTime3.setBounds(350, 285, 60, 15);
        add(textTime3);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Practica3_InterfazGrafica__20110388();
    }
}
