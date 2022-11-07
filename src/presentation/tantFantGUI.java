import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class tantFantGUI extends JFrame {

    // Variables x
    Dimension size;

    // Cosas del menu
    JMenuBar menuBar;
    JMenu manu;
    JMenuItem save, open, nuevo, salir;
    // Guardar
    JFileChooser choose;
    JFileChooser chooseSave;

    public tantFantGUI() {
        setTitle("tantFant");
        prepareElements();
        prepareActions();

    }

    public void prepareElements() {
        size = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) size.getWidth() / 2, (int) size.getHeight() / 2);
        setLocationRelativeTo(null);

        prepareElementsMenu();

    }

    private void prepareElementsMenu() {
        // Items
        save = new JMenuItem("save");
        open = new JMenuItem("open");
        nuevo = new JMenuItem("nuevo");
        salir = new JMenuItem("salir");

        // Bars
        menuBar = new JMenuBar();
        manu = new JMenu("Opciones");

        // adding them
        manu.add(nuevo);
        manu.add(open);
        manu.add(save);
        manu.add(salir);
        menuBar.add(manu);
        setJMenuBar(menuBar);

    }

    public void prepareActions() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepareActionsMenu();

    }

    public void prepareActionsMenu() {
        open.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                openAction();
            }

        });

        save.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                saveAction();
            }

        });

        nuevo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            }

        });

        salir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                confirmateClose();
            }

        });

    }

    // Metodos de accion
    private void confirmateClose() {
        int valor = JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void openAction() {
        choose = new JFileChooser();
        choose.setVisible(true);
        int action = choose.showOpenDialog(open);
        if (action == JFileChooser.APPROVE_OPTION) {
            File files = choose.getSelectedFile();
            JOptionPane.showMessageDialog(open,
                    "El archivo de nombre " + files.getName() + " que trata de abrir en la ruta " + files
                            + "\n NO se pudo abrir ya que esta la funcion se encuentra en construccion.",
                    "Advertencia", JOptionPane.YES_NO_OPTION);
        }
    }

    private void saveAction() {
        chooseSave = new JFileChooser(new File("c:\\"));
        chooseSave.setDialogTitle("Save a File");
        chooseSave.showSaveDialog(null);
    }

    public static void main(String[] args) {
        tantFantGUI xd = new tantFantGUI();
        xd.setVisible(true);
    }
}