package presentation;

import javax.swing.*;
import java.awt.*;

class tantFantGUI extends JFrame{
    public tantFantGUI(){
        setTitle("tantFant");
        prepareElements();
        prepareActions();
        createMenu();
    }
    public void prepareElements(){
        Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)size.getWidth()/2,(int)size.getHeight()/2);
        setLocationRelativeTo(null);

    }

    private void createMenu(){
        //Items
        JMenuItem save = new JMenuItem("save");
        JMenuItem open = new JMenuItem("open");


        //Bars
        JMenuBar menuBar= new JMenuBar();
        JMenu manu = new JMenu("Opciones");

        //adding them
        manu.add(open);
        manu.add(save);
        menuBar.add(manu);
        setJMenuBar(menuBar);
    }
    public void prepareActions() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * //acciones
           open.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            opener();
        }
    });
     save.addActionListener(new ActionListener(){

     public void actionPerformed(ActionEvent e) {
     saver();
     }
     });
     */
    public static void main(String[] args) {
        tantFantGUI xd = new tantFantGUI();
        xd.setVisible(true);
    }
}