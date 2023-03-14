
package practica3_interfazgrafica;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class View extends JFrame
{
    public static final Color PASTEL_GREEN = new Color(228,244,237);
    public static final Color PASTEL_BLUE = new Color(20,173,198);
    
    public View()
    {
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Practica 3 Interfaz Grafica");
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,3));
        getContentPane().setBackground(PASTEL_GREEN);
        initVisualComponents();
        setVisible(true);
        initFunctionality();
    }
    
    JTextArea jTAOriginalArray;
    
    JTextArea jTASecuencialArray;
    JTextArea jTAForkJoinArray;
    JTextArea jTAExecutorServiceArray;
    
    JLabel jLSecuencialArray;
    JLabel jLForkJoinArray;
    JLabel jLExecutorServiceArray;
    
    public void initVisualComponents()
    {
        //-------------------------------------------------------- First row
        jTAOriginalArray = new JTextArea("Arreglo original");
        jTAOriginalArray.setBounds(0, 30, 390, 150);
        jTAOriginalArray.setLineWrap(true);
        jTAOriginalArray.setWrapStyleWord(true);
        
        JPanel containerR1C1 = new JPanel();
        containerR1C1.setBounds(0, 0, 80, 60);
        containerR1C1.setBackground(PASTEL_GREEN);
        
        JPanel containerR1C2 = new JPanel();
        containerR1C2.setLayout(null);
        containerR1C2.setBounds(0, 0, 80, 60);
        containerR1C2.setBackground(PASTEL_GREEN);
        containerR1C2.add(jTAOriginalArray);
        
        JPanel containerR1C3 = new JPanel();
        containerR1C3.setBounds(0, 0, 80, 60);
        containerR1C3.setBackground(PASTEL_GREEN);
        
        add(containerR1C1);
        add(containerR1C2);
        add(containerR1C3);
        
        //-------------------------------------------------------- Second row
        jTASecuencialArray = new JTextArea("Secuencial");
        jTASecuencialArray.setBounds(30,0, 330, 400);
        jTASecuencialArray.setLineWrap(true);
        jTASecuencialArray.setWrapStyleWord(true);
        
        jTAForkJoinArray = new JTextArea("Fork-Join");
        jTAForkJoinArray.setBounds(30,0, 330, 400);
        jTAForkJoinArray.setLineWrap(true);
        jTAForkJoinArray.setWrapStyleWord(true);
        
        jTAExecutorServiceArray = new JTextArea("Executor Service");
        jTAExecutorServiceArray.setBounds(30,0, 330, 400);
        jTAExecutorServiceArray.setLineWrap(true);
        jTAExecutorServiceArray.setWrapStyleWord(true);
        
        JPanel containerR2C1 = new JPanel();
        containerR2C1.setLayout(null);
        containerR2C1.setBackground(PASTEL_GREEN);
        containerR2C1.add(jTASecuencialArray);
        
        JPanel containerR2C2 = new JPanel();
        containerR2C2.setLayout(null);
        containerR2C2.setBackground(PASTEL_GREEN);
        containerR2C2.add(jTAForkJoinArray);
        
        JPanel containerR2C3 = new JPanel();
        containerR2C3.setLayout(null);
        containerR2C3.setBackground(PASTEL_GREEN);
        containerR2C3.add(jTAExecutorServiceArray);
                
        add(containerR2C1);
        add(containerR2C2);
        add(containerR2C3);
        
        //-------------------------------------------------------- Third row
        jLSecuencialArray = new JLabel("Secuencial");
        jLSecuencialArray.setBounds(30, 10, 330, 30);
        jLSecuencialArray.setHorizontalAlignment(SwingConstants.CENTER);
        
        jLForkJoinArray = new JLabel("Fork-Join");
        jLForkJoinArray.setBounds(30, 10, 330, 30);
        jLForkJoinArray.setHorizontalAlignment(SwingConstants.CENTER);
        
        jLExecutorServiceArray = new JLabel("Executor Service");
        jLExecutorServiceArray.setBounds(30, 10, 330, 30);
        jLExecutorServiceArray.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton jBSecuencialArray = new JButton("Secuencial");
        jBSecuencialArray.setBounds(30, 160, 330, 40);
        jBSecuencialArray.setBackground(PASTEL_BLUE);
        jBSecuencialArray.setForeground(Color.white);
        jBSecuencialArray.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {
                calcSecuencialArray();
            }
        });
        
        JButton jBForkJoinArray = new JButton("Fork-Join");
        jBForkJoinArray.setBounds(30, 160, 330, 40);
        jBForkJoinArray.setBackground(PASTEL_BLUE);
        jBForkJoinArray.setForeground(Color.white);
        jBForkJoinArray.addActionListener(event -> calcForkJoinArray());
        
        JButton jBExecutorServiceArray = new JButton("Executor Service");
        jBExecutorServiceArray.setBounds(30, 160, 330, 40);
        jBExecutorServiceArray.setBackground(PASTEL_BLUE);
        jBExecutorServiceArray.setForeground(Color.white);
        jBExecutorServiceArray.addActionListener(event -> calcExecutorServiceArray());
        
        JPanel containerR3C1 = new JPanel();
        containerR3C1.setLayout(null);
        containerR3C1.setBackground(PASTEL_GREEN);
        containerR3C1.add(jLSecuencialArray);
        containerR3C1.add(jBSecuencialArray);
        
        JPanel containerR3C2 = new JPanel();
        containerR3C2.setLayout(null);
        containerR3C2.setBackground(PASTEL_GREEN);
        containerR3C2.add(jLForkJoinArray);
        containerR3C2.add(jBForkJoinArray);
        
        JPanel containerR3C3 = new JPanel();
        containerR3C3.setLayout(null);
        containerR3C3.setBackground(PASTEL_GREEN);
        containerR3C3.add(jLExecutorServiceArray);
        containerR3C3.add(jBExecutorServiceArray);
        
        add(containerR3C1);
        add(containerR3C2);
        add(containerR3C3);
    }
    
    int[] originalArray;
    
    private void initFunctionality()
    {
        Random rand = new Random();
        
        int quantity = 100;
        
        originalArray = new int[quantity];
        
        for(int i=0; i<quantity; i++)
            originalArray[i] = rand.nextInt(100);
        
        jTAOriginalArray.setText(Arrays.toString(originalArray));
    }

    private void calcSecuencialArray()
    {
        int[] array = getCopyArray(originalArray);
        Recorder.start();
        new MergeSortSecuencial(array).calc();
        Recorder.stop();
        jLSecuencialArray.setText("Tiempo: " + Recorder.get() + " milisegundos");
        jTASecuencialArray.setText(Arrays.toString(array));
    }
    
    private void calcExecutorServiceArray()
    {
        int[] array = getCopyArray(originalArray);
        
        Recorder.start();
        
        new MergeSortExecutorService(array).calcular();
        
        Recorder.stop();
        
        jLExecutorServiceArray.setText("Tiempo: " + Recorder.get() + " milisegundos");
        jTAExecutorServiceArray.setText(Arrays.toString(array));
    }
    
    private void calcForkJoinArray()
    {
        int[] array = getCopyArray(originalArray);
        Recorder.start();
        new MergeSortForkJoin(array).calc();
        Recorder.stop();
        jLForkJoinArray.setText("Tiempo: " + Recorder.get() + " milisegundos");
        jTAForkJoinArray.setText(Arrays.toString(array));
    }
    
    private int[] getCopyArray(int[] o)
    {
        int[] a = new int[o.length];
        System.arraycopy(o, 0, a, 0, o.length);
        return a;
    }
    
    
    
    
}
