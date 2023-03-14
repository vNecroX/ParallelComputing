package proyecto2parcial_clasificadorparimpar__20110388;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Proyecto2Parcial_ClasificadorParImpar__20110388 extends JFrame implements ActionListener{
    static int[] array = new int[100]; static int sizeArray = 50;
    static int[] evenArray = new int[50]; static int sizeEvenArray;
    static int[] oddArray = new int[50]; static int sizeOddArray;
    static String stringArray = new String();
    static long startTime; static long stopTime; static long calcTime;
    
    static JButton button0; static JTextArea textArea0;
    
    static JButton evenButton;
    static JButton btEvenSeq; static JButton btEvenFJ; static JButton btEvenES;
    static JLabel ttEvenSeq; static JLabel ttEvenFJ; static JLabel ttEvenES;
    static JTextArea taEvenSeq; static JTextArea taEvenFJ; static JTextArea taEvenES;
    
    static JButton oddButton;
    static JButton btOddSeq; static JButton btOddFJ; static JButton btOddES;
    static JLabel ttOddSeq; static JLabel ttOddFJ; static JLabel ttOddES;
    static JTextArea taOddSeq; static JTextArea taOddFJ; static JTextArea taOddES;
    
    static int evenOrOdd;
    
    static SequentialMethod sequentialMethod = new SequentialMethod();
    static ForkJoinPool forkJoinPool = new ForkJoinPool();
    static FJMethod fjMethod;
    static Future<Void> first;
    static ExecutorService executorService;
    static ESMethod esMethod; 
    
    public Proyecto2Parcial_ClasificadorParImpar__20110388(){
        setTitle("Clasificador de números par e impar.");
        setSize(535, 755);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button0 = new JButton("Nuevo arreglo.");
        button0.setBounds(10, 25, 160, 20);
        button0.addActionListener(this);
        add(button0);
        
        textArea0 = new JTextArea();
        textArea0.setBounds(10, 50, 500, 60);
        textArea0.setLineWrap(true);
        textArea0.setWrapStyleWord(true);
        add(textArea0);
        
        evenButton = new JButton("Par.");
        evenButton.setBounds(10, 145, 160, 20);
        evenButton.addActionListener(this);
        add(evenButton);
        
        btEvenSeq = new JButton("~Secuencial~");
        btEvenSeq.setBounds(232, 170, 120, 15);
        btEvenSeq.addActionListener(this);
        add(btEvenSeq);
        
        ttEvenSeq = new JLabel("Tiempo.");
        ttEvenSeq.setBounds(420, 170, 80, 15);
        add(ttEvenSeq);
        
        taEvenSeq = new JTextArea();
        taEvenSeq.setBounds(10, 195, 500, 45);
        taEvenSeq.setLineWrap(true);
        taEvenSeq.setWrapStyleWord(true);
        add(taEvenSeq);
        
        btEvenFJ = new JButton("~Fork Join~");
        btEvenFJ.setBounds(231, 250, 120, 15);
        btEvenFJ.addActionListener(this);
        add(btEvenFJ);
        
        ttEvenFJ = new JLabel("Tiempo.");
        ttEvenFJ.setBounds(420, 250, 80, 15);
        add(ttEvenFJ);
        
        taEvenFJ = new JTextArea();
        taEvenFJ.setBounds(10, 275, 500, 45);
        taEvenFJ.setLineWrap(true);
        taEvenFJ.setWrapStyleWord(true);
        add(taEvenFJ);
        
        btEvenES = new JButton("~Execute Service~");
        btEvenES.setBounds(230, 330, 160, 15);
        btEvenES.addActionListener(this);
        add(btEvenES);
        
        ttEvenES = new JLabel("Tiempo.");
        ttEvenES.setBounds(420, 330, 80, 15);
        add(ttEvenES);
        
        taEvenES = new JTextArea();
        taEvenES.setBounds(10, 355, 500, 45);
        taEvenES.setLineWrap(true);
        taEvenES.setWrapStyleWord(true);
        add(taEvenES);
        
        oddButton = new JButton("Impar.");
        oddButton.setBounds(10, 435, 160, 20);
        oddButton.addActionListener(this);
        add(oddButton);
        
        btOddSeq = new JButton("~Secuencial~");
        btOddSeq.setBounds(232, 460, 120, 15);
        btOddSeq.addActionListener(this);
        add(btOddSeq);
        
        ttOddSeq = new JLabel("Tiempo.");
        ttOddSeq.setBounds(420, 460, 80, 15);
        add(ttOddSeq);
        
        taOddSeq = new JTextArea();
        taOddSeq.setBounds(10, 485, 500, 45);
        taOddSeq.setLineWrap(true);
        taOddSeq.setWrapStyleWord(true);
        add(taOddSeq);
        
        btOddFJ = new JButton("~Fork Join~");
        btOddFJ.setBounds(231, 540, 120, 15);
        btOddFJ.addActionListener(this);
        add(btOddFJ);
        
        ttOddFJ = new JLabel("Tiempo.");
        ttOddFJ.setBounds(420, 540, 80, 15);
        add(ttOddFJ);
        
        taOddFJ = new JTextArea();
        taOddFJ.setBounds(10, 565, 500, 45);
        taOddFJ.setLineWrap(true);
        taOddFJ.setWrapStyleWord(true);
        add(taOddFJ);
        
        btOddES = new JButton("~Execute Service~");
        btOddES.setBounds(230, 620, 160, 15);
        btOddES.addActionListener(this);
        add(btOddES);
        
        ttOddES = new JLabel("Tiempo.");
        ttOddES.setBounds(420, 620, 80, 15);
        add(ttOddES);
        
        taOddES = new JTextArea();
        taOddES.setBounds(10, 645, 500, 45);
        taOddES.setLineWrap(true);
        taOddES.setWrapStyleWord(true);
        add(taOddES);
        
        setVisible(true);
    }
    
    public static void main(String[] args){ new Proyecto2Parcial_ClasificadorParImpar__20110388(); }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button0){
            sizeEvenArray = 0;
            sizeOddArray = 0;
            
            textArea0.setText(null);
            
            taEvenSeq.setText(null);
            taOddSeq.setText(null);
            
            taEvenFJ.setText(null);
            taOddFJ.setText(null);
            
            taEvenES.setText(null);
            taOddES.setText(null);
            
            stringArray = new String();
            
            newArray(0);
        }
        else if(e.getSource() == evenButton)
            evenOrOdd = 0;
        else if(e.getSource() == oddButton)
            evenOrOdd = 1;
        else if(e.getSource() == btEvenSeq){
            taEvenSeq.setText(null);
            stringArray = new String();
            getNumbersSeq(evenOrOdd, 1);
        }
        else if(e.getSource() == btEvenFJ){
            taEvenFJ.setText(null);
            stringArray = new String();
            getNumbersFJ(evenOrOdd, 2);
        }
        else if(e.getSource() == btEvenES){
            taEvenES.setText(null);
            stringArray = new String();
            getNumbersES(evenOrOdd, 3);
        }
        else if(e.getSource() == btOddSeq){
            taOddSeq.setText(null);
            stringArray = new String();
            getNumbersSeq(evenOrOdd, 4);
        }
        else if(e.getSource() == btOddFJ){
            taOddFJ.setText(null);
            stringArray = new String();
            getNumbersFJ(evenOrOdd, 5);
        }
        else if(e.getSource() == btOddES){
            taOddES.setText(null);
            stringArray = new String();
            getNumbersES(evenOrOdd, 6);
        }
    }
    
    public static void newArray(int source){
        Random rand = new Random();
        
        for(int i=0; i<sizeArray; i++){
            array[i] = rand.nextInt(1000-1) + 1;
            System.out.println(array[i]);
            
            if(array[i] % 2 == 0)
                sizeEvenArray++;
            else
                sizeOddArray++;
        }
        
        printCurrentArray(array, sizeArray, source);
    }
    
    public static void getNumbersSeq(int evenOrOd, int source){
        startTime = System.nanoTime();
        sequentialMethod.extractNumbers(array, sizeArray, evenOrOdd);
        stopTime = System.nanoTime();
        calcTime = stopTime - startTime;
        
        if(evenOrOdd == 0)
            printCurrentArray(evenArray, sizeEvenArray, source);
        else
            printCurrentArray(oddArray, sizeOddArray, source);
    }
    
    public static void getNumbersFJ(int evenOrOdd, int source){
        startTime = System.nanoTime();
        fjMethod = new FJMethod(array, sizeArray, evenOrOdd);
        forkJoinPool.invoke(fjMethod);
        stopTime = System.nanoTime();
        calcTime = stopTime - startTime;
        
        if(evenOrOdd == 0)
            printCurrentArray(evenArray, sizeEvenArray, source);
        else 
            printCurrentArray(oddArray, sizeOddArray, source);
    }
    
    public static void getNumbersES(int evenOrOdd, int source){
        startTime = System.nanoTime();
        esMethod = new ESMethod(array, sizeArray, evenOrOdd);
        executorService = Executors.newSingleThreadExecutor();
        try{
            first = executorService.submit(esMethod);
            executorService.shutdown();
        }
        catch(Exception e){ System.out.println(e); }
        stopTime = System.nanoTime();
        calcTime = stopTime - startTime;
        
        if(evenOrOdd == 0)
            printCurrentArray(evenArray, sizeEvenArray, source);
        else
           printCurrentArray(oddArray, sizeOddArray, source);
    }
    
    public static void printCurrentArray(int[] arr, int s, int source){
        for(int i=0; i<s; i++){
            stringArray += Integer.toString(arr[i]);
            
            if(i+1 != s)
                stringArray += ", ";
        }
        
        switch(source){
            case 0 -> textArea0.setText(stringArray);
            case 1 -> {
                ttEvenSeq.setText(Long.toString(calcTime) + "ns");
                taEvenSeq.setText(stringArray);
            }
            case 2 -> {
                ttEvenFJ.setText(Long.toString(calcTime) + "ns");
                taEvenFJ.setText(stringArray);
            }
            case 3 -> {
                ttEvenES.setText(Long.toString(calcTime) + "ns");
                taEvenES.setText(stringArray);
            }
            case 4 -> {
                ttOddSeq.setText(Long.toString(calcTime) + "ns");
                taOddSeq.setText(stringArray);
            }
            case 5 -> {
                ttOddFJ.setText(Long.toString(calcTime) + "ns");
                taOddFJ.setText(stringArray);
            }
            case 6 -> {
                ttOddES.setText(Long.toString(calcTime) + "ns");
                taOddES.setText(stringArray);
            }
            default -> {}
        }
    }
}
