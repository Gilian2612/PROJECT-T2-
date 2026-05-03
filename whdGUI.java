package Presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
/**
 * whdGUI - Clase principal de la interfaz gráfica
 * The World's Hardest Game
 * 
 * Crea la ventana principal con menú, mensaje de bienvenida
 * y botones de Jugar y Exit.
 */
public class whdGUI extends JFrame {
 
    private JMenuBar barraMenu;
    private JMenu menuArchivo;
    private JMenuItem itemNuevoJuego;
    private JMenuItem itemSalir;
 
    private JLabel lblTitulo;
    private JLabel lblDescripcion;
    private JButton btnJugar;
    private JButton btnExit;
 
    public whdGUI() {
        configurarVentana();
        crearMenu();
        crearContenido();
        setVisible(true);
    }
 
    /**
     * Configura las propiedades del JFrame principal.
     */
    private void configurarVentana() {
        setTitle("The World's Hardest Game");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
 
    /**
     * Crea la barra de menú con la opción "Archivo".
     */
    private void crearMenu() {
        barraMenu = new JMenuBar();
 
        menuArchivo = new JMenu("Archivo");
 
        itemNuevoJuego = new JMenuItem("Nuevo juego");
        itemNuevoJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });
 
        itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
 
        menuArchivo.add(itemNuevoJuego);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);
 
        barraMenu.add(menuArchivo);
        setJMenuBar(barraMenu);
    }
 
    /**
     * Crea el contenido central: título, descripción y botones.
     */
    private void crearContenido() {
        // Panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(44, 62, 80));
 
        // --- Panel central: título y descripción ---
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(44, 62, 80));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(60, 40, 20, 40));
 
        lblTitulo = new JLabel("THE WORLD'S HARDEST GAME");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(231, 76, 60));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        lblDescripcion = new JLabel("<html><center>"
                + "Lleva al jugador desde la zona de inicio hasta la meta.<br>"
                + "Recoge todas las monedas y esquiva a los enemigos.<br>"
                + "¡Un solo toque y vuelves al inicio!"
                + "</center></html>");
        lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
        lblDescripcion.setForeground(Color.WHITE);
        lblDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblDescripcion.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
 
        panelCentro.add(lblTitulo);
        panelCentro.add(lblDescripcion);
 
        // --- Panel inferior: botones Jugar y Exit ---
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));
        panelBotones.setBackground(new Color(44, 62, 80));
 
        btnJugar = new JButton("Jugar");
        btnJugar.setPreferredSize(new Dimension(140, 45));
        btnJugar.setFont(new Font("Arial", Font.BOLD, 16));
        btnJugar.setBackground(new Color(46, 204, 113));
        btnJugar.setForeground(Color.WHITE);
        btnJugar.setFocusPainted(false);
        btnJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });
 
        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension(140, 45));
        btnExit.setFont(new Font("Arial", Font.BOLD, 16));
        btnExit.setBackground(new Color(231, 76, 60));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                        whdGUI.this,
                        "¿Estás seguro que deseas salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
 
        panelBotones.add(btnJugar);
        panelBotones.add(btnExit);
 
        // Ensamblar todo
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
 
        setContentPane(panelPrincipal);
    }
 
    /**
     * Inicia el juego. Aquí se conectará con la lógica del dominio.
     */
    private void iniciarJuego() {
        JOptionPane.showMessageDialog(
                this,
                "¡El juego va a comenzar!",
                "The World's Hardest Game",
                JOptionPane.INFORMATION_MESSAGE
        );
        // TODO: Aquí se crea la pantalla de juego y se inicia la partida
        // Ejemplo: new PantallaJuego(this);
    }
 
    /**
     * Punto de entrada de la aplicación.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new whdGUI();
            }
        });
    }
}