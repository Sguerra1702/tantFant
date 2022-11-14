package presentation;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import java.io.File;

class tantFantGUI extends JFrame {

    // JPanels
    private JPanel panelGame, midPanel;
    private JPanel[] colmena;

    // gridslot
    private JPanel road;
    // Variables x
    private Dimension size;
    private Color color;

    // Cosas del menu
    private JMenuBar menuBar;
    private JMenu manu;
    private JMenuItem save, open, nuevo, salir, changeColor, changeSize;
    // Guardar
    private JFileChooser choose;
    private JFileChooser chooseSave;

    private JButton[][] gridslot;

    private int sizeBoard;

    private static int i = 0;

    public tantFantGUI() {
        setTitle("tantFant");
        sizeBoard = Integer.parseInt(JOptionPane.showInputDialog(null, "Tamaño del tablero?"));
        prepareElements();
        prepareActions();

    }

    public void prepareElements() {
        size = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) size.getWidth() / 2, (int) size.getHeight() / 2);
        setLocationRelativeTo(null);

        prepareElementsMenu();
        prepareElementsBoard(sizeBoard);

    }

    private void prepareElementsMenu() {
        // Items
        save = new JMenuItem("save");
        open = new JMenuItem("open");
        nuevo = new JMenuItem("nuevo");
        salir = new JMenuItem("salir");
        changeColor = new JMenuItem("Cambiar Color");
        changeSize = new JMenuItem("Cambiar tamaño del tablero");

        // Bars
        menuBar = new JMenuBar();
        manu = new JMenu("Opciones");

        // adding them
        manu.add(nuevo);
        manu.add(open);
        manu.add(save);
        manu.add(salir);
        manu.add(changeColor);
        manu.add(changeSize);
        menuBar.add(manu);
        setJMenuBar(menuBar);

    }

    public void prepareActions() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepareActionsMenu();

    }

    private void prepareElementsBoard(int sizeBoard) {
        gridslot = new JButton[sizeBoard][sizeBoard];
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panelGame = new JPanel();
        panelGame.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new TitledBorder("Board TantFant")));
        colmena = new JPanel[4];
        panelGame.setLayout(new GridLayout(sizeBoard, sizeBoard));
        road = new JPanel();
        road.setLayout(new GridLayout(2, 2));
        for(int i=0;i<(sizeBoard);i++) {
            for (int j = 0; j < (sizeBoard); j++) {
                if (i == 0) {
                    gridslot[i][j] = new JButton("X");
                    panelGame.add(gridslot[i][j]);
                    gridslot[i][j].setFocusable(false);
                    gridslot[i][j].setForeground(Color.red);
                    gridslot[i][j].setBackground(Color.WHITE);
                } else if (i == sizeBoard - 1) {
                    gridslot[i][j] = new JButton("O");
                    panelGame.add(gridslot[i][j]);
                    gridslot[i][j].setFocusable(false);
                    gridslot[i][j].setForeground(Color.black);
                    gridslot[i][j].setBackground(Color.WHITE);
                } else {
                    gridslot[i][j] = new JButton();
                    panelGame.add(gridslot[i][j]);
                    gridslot[i][j].setBackground(new Color(255, 255, 255));
                    gridslot[i][j].setFocusable(false);
                }
                gridslot[i][j].setFont(new Font("Monocraft", Font.BOLD, 50));
            }
        }
        add(panelGame);
        midPanel = new JPanel();
        midPanel.setBorder(new LineBorder(color, 3));
        midPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 4, 4));
        midPanel.setBackground(color);
        JPanel stats = new JPanel();
        stats.setLayout(new GridLayout(2, 1, 5, 5));
        stats.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        stats.setBackground(Color.LIGHT_GRAY);
        JLabel textMovimientos = new JLabel("MOVIMIENTOS");
        JLabel textFichas = new JLabel("JUGADOR TURNO");
        int movimientos = 0;
        JLabel moves = new JLabel(Integer.toString(movimientos));
        String turnoJugador = "J1";
        JLabel fichasCap = new JLabel(turnoJugador);
        stats.add(textMovimientos);
        stats.add(moves);
        stats.add(textFichas);
        stats.add(fichasCap);
        midPanel.add(stats, BorderLayout.WEST);
        add(midPanel, BorderLayout.WEST);

    }

    public void refresh() {
        this.setBackground(color);
        panelGame.setBackground(color);
        midPanel.setBackground(color);
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
        changeColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBckgrndFondo();
            }
        });
        changeSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                chngBoardSize();
            }
        });

    }

    public void setBckgrndFondo(){
        changeColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(null, "Seleccione un color", Color.black);
                panelGame.setBackground(color);
                midPanel.setBackground(color);
            }
        });



    }

    public void chngBoardSize(){
        changeSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panelGame);
                sizeBoard = Integer.parseInt(JOptionPane.showInputDialog(null, "Tamaño del tablero?"));
                prepareElementsBoard(sizeBoard);
                refresh();
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