package presentation;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import java.io.File;

class tantFantGUI extends JFrame {

    // JPanels
    private JPanel panelGame;
    private JPanel[] colmena;

    // Buttons
    private JPanel road;
    // Variables x
    private Dimension size;
    private Color color;

    // Cosas del menu
    private JMenuBar menuBar;
    private JMenu manu;
    private JMenuItem save, open, nuevo, salir;
    // Guardar
    private JFileChooser choose;
    private JFileChooser chooseSave;

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
        prepareElementsBoard();

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

    private void prepareElementsBoard() {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panelGame = new JPanel();
        panelGame.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new TitledBorder("Board TantFant")));
        colmena = new JPanel[4];
        panelGame.setLayout(new BorderLayout());
        road = new JPanel();
        road.setLayout(new GridLayout(2, 2));
        for (JPanel a : colmena) {
            a = new JPanel() {
                @Override
                public void paintComponents(Graphics gr) {
                    int width = getWidth();
                    int height = getHeight();

                    super.paintComponents(gr);
                    gr.setColor(Color.BLUE);
                    gr.drawLine(0, 0, width - 1, height - 1);
                }
            };
            a.setBorder(blackline);
            road.add(a);
        }
        panelGame.add(road, BorderLayout.CENTER);

        add(panelGame);

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