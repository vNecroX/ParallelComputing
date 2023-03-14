package practica5_componentesycontenedores__20110388;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Practica5_ComponentesYContenedores__20110388 extends JFrame{
    
    public Practica5_ComponentesYContenedores__20110388(){
        setTitle("Prueba");
        setSize(500, 700);
        //setLayout(new GridLayout(5,5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(100,100,100,20);
        add(nombre);
        
        JTextArea area = new JTextArea("Escribe tu opinion:");
        area.setBounds(10,30,200,200);
        add(area);
        
        JButton guardar = new JButton("Guardar");
        guardar.setBounds(100,100,100,50);
        add(guardar);
        
        JCheckBox boxUno = new JCheckBox("Femenino");
        boxUno.setBounds(100,100,50,50);
        add(boxUno);
        
        JRadioButton radio1 = new JRadioButton("Bird");
        radio1.setBounds(75,50,100,30);
        add(radio1);
        
        DefaultListModel<String> lista = new DefaultListModel<>();
        lista.addElement("Lunes");
        lista.addElement("Martes");
        JList<String> list = new JList<>(lista);
        list.setBounds(100,100,75,75);
        add(list);
        
        String nombres[] = {"Rosa", "Mariana", "Karla"};
        JComboBox combo = new JComboBox(nombres);
        combo.setBounds(100,100,100,20);
        add(combo);
        
        JScrollBar scroll = new JScrollBar();
        scroll.setBounds(100,100,50,100);
        add(scroll);
        
        String data[][] = {{"14110265", "Rosa", "89.9"},
                           {"14112323", "Alonso", "96.6"}};
        String column[] = {"Rgistro", "Nombre", "Promedio"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30,40,200,300);
        JScrollPane sp = new JScrollPane(jt);
        add(sp);
        
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem opc1 = new JMenuItem("Rojo");
        JMenuItem opc2 = new JMenuItem("Amarillo");
        menu.add(opc1);
        menu.addSeparator();
        menu.add(opc2);
        barra.add(menu);
        setJMenuBar(barra);
        
        setVisible(true);
    }

    //32:19
    public static void main(String[] args) {
        Practica5_ComponentesYContenedores__20110388 frame = new Practica5_ComponentesYContenedores__20110388();
    }
}
