package practica6_mergesortexecutorservice__20110388;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Practica6_MergeSortExecutorService__20110388 extends JFrame implements ActionListener{
    static int[] array; static int[] auxArray; static int size;
    static JButton button0;
    static String stringArray = new String();
    static JTextArea textArea0;
    static JButton button1; static JButton button2; static JButton button3;
    static JTextArea textArea1; static JTextArea textArea2; static JTextArea textArea3;
    static JLabel textTime1; static JLabel textTime2; static JLabel textTime3;
    static long startTime; static long stopTime; static long calcTime;
    
    public Practica6_MergeSortExecutorService__20110388(){
        setTitle("MergeSort");
        setSize(535, 360);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button0 = new JButton("Nuevo arreglo.");
        button0.setBounds(10, 25, 160, 20);
        button0.addActionListener(this);
        add(button0);
        
        JLabel text0 = new JLabel("Arreglo:");
        text0.setBounds(10, 50, 60, 15);
        add(text0);
        
        textArea0 = new JTextArea();
        textArea0.setBounds(60, 50, 450, 15);
        add(textArea0);
        
        button1 = new JButton("Secuencial.");
        button1.setBounds(10, 100, 160, 20);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("ForkJoin.");
        button2.setBounds(180, 100, 160, 20);
        button2.addActionListener(this);
        add(button2);
        
        button3 = new JButton("ExecuteService.");
        button3.setBounds(350, 100, 160, 20);
        button3.addActionListener(this);
        add(button3);
        
        textArea1 = new JTextArea("");
        textArea1.setBounds(10, 125, 160, 160);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        add(textArea1);
        
        textArea2 = new JTextArea("");
        textArea2.setBounds(180, 125, 160, 160);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        add(textArea2);
        
        textArea3 = new JTextArea("");
        textArea3.setBounds(350, 125, 160, 160);
        textArea3.setLineWrap(true);
        textArea3.setWrapStyleWord(true);
        add(textArea3);
        
        textTime1 = new JLabel("Tiempo1");
        textTime1.setBounds(10, 285, 160, 15);
        add(textTime1);
        
        textTime2 = new JLabel("Tiempo2");
        textTime2.setBounds(180, 285, 160, 15);
        add(textTime2);
        
        textTime3 = new JLabel("Tiempo3");
        textTime3.setBounds(350, 285, 160, 15);
        add(textTime3);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Practica6_MergeSortExecutorService__20110388();
        newArray(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button0){
            textArea1.setText(null);
            textArea2.setText(null);
            textArea3.setText(null);
            
            stringArray = new String();
            newArray(0);
        }
        else if(e.getSource() == button1){
            stringArray = new String();
            sequentialMergeSort(1);
        }
        else if(e.getSource() == button2){
            stringArray = new String();
            forkJoinMergeSort(2);
        }
        else if(e.getSource() == button3){
            stringArray = new String();
            executorServiceMergeSort(3);
        }
    }
    
    public static void newArray(int source){
        Random rand = new Random();
        size = rand.nextInt(25-5) + 5;
        array = new int[size+10];
        auxArray = new int[size+10];
        
        for(int i=0; i<size; i++)
            array[i] = rand.nextInt(100-1) + 1;
        
        for(int i=0; i<size; i++)
            auxArray[i] = array[i]; 
        
        printArray(array, size, source);
    }
    
    public static void sequentialMergeSort(int source){
        restoreArray();
        
        startTime = System.nanoTime();
        SeqMergeSort seqMergeSort = new SeqMergeSort();
        seqMergeSort.sort(array, 0, size - 1);
        stopTime = System.nanoTime();
        calcTime = stopTime - startTime;
        
        System.out.println("Elementos ordenados del arreglo, secuencial: ");
        printArray(array, size, source);
    }
    
    public static void forkJoinMergeSort(int source){
        restoreArray();
        
        startTime = System.nanoTime();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new FJMergeSort(array, 0, size - 1));
        stopTime = System.nanoTime();
        calcTime = stopTime - startTime;
        
        System.out.println("Elementos ordenados del arreglo, FJ: ");
        printArray(array, size, source);
    }
    
    public static void executorServiceMergeSort(int source){
        restoreArray();
        
        startTime = System.nanoTime();
        ExecutorService executorService = Executors.newCachedThreadPool();
        try{
            Future<Void> first = executorService.submit(new ESMergeSort(array, 0, size - 1));
            first.get();
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.DAYS);
        }
        catch(ExecutionException | InterruptedException e){ System.out.println(e); }
        stopTime = System.nanoTime();
        calcTime = stopTime - startTime;
        
        System.out.println("Elementos ordenados del arreglo, ES: ");
        printArray(array, size, source);
    }
    
    public static void restoreArray(){
        for(int i=0; i<size; i++)
            array[i] = auxArray[i]; 
    }
    
    public static void printArray(int arr[], int s, int source){
        for(int i=0; i<s; i++){
            System.out.print(arr[i]);
            stringArray += Integer.toString(arr[i]);
            
            if(i+1 != s){
                System.out.print(", ");
                stringArray += ", ";
            }
            else{
                System.out.print("\n\n");
                stringArray += "";
            }
        }
        
        switch (source) {
            case 0 -> textArea0.setText(stringArray);
            case 1 -> {
                textArea1.setText(stringArray);
                textTime1.setText(Long.toString(calcTime) + "ns");
            }
            case 2 -> {
                textArea2.setText(stringArray);
                textTime2.setText(Long.toString(calcTime) + "ns");
            }
            case 3 -> {
                textArea3.setText(stringArray);
                textTime3.setText(Long.toString(calcTime) + "ns");
            }
            default -> {
            }
        }
    }
}
