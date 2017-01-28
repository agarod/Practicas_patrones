package patrones.view;

import javax.swing.*;

import java.awt.BorderLayout;

public class View {
      
    private JFrame frame;
    private JLabel label;
    private JButton button;
    private JButton button2;
    private JRadioButton check;
    private JRadioButton check2;
    private JCheckBox check3;
    private JPanel Pane;

    
    public View(String text){
        frame = new JFrame("CodEraser");                                    
        frame.getContentPane().setLayout(new BorderLayout());                                          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(600,200);        
        frame.setVisible(true);
        Pane = new JPanel();
        
        check = new JRadioButton("Random Change");
        Pane.add(check, BorderLayout.CENTER);

        check2 = new JRadioButton("Row Change");
        Pane.add(check2);
//        frame.getContentPane().add(check,BorderLayout.NORTH);
        
        frame.add(Pane);
        
        button2 = new JButton("Abrir Archivo");        
        frame.getContentPane().add(button2, BorderLayout.WEST); 
        
        button = new JButton("Ejecutar");
        frame.getContentPane().add(button, BorderLayout.EAST);
    }
        
    public JButton getButton(){
        return button;
    }
    
    public JButton getButton2(){
    	return button2;
    }
    
    public JRadioButton getCB(){
    	return check;
    }
    
    public JRadioButton getCB2(){
    	return check2;
    }
        
    public void setText(String text){
        label.setText(text);
    }
    
    
}