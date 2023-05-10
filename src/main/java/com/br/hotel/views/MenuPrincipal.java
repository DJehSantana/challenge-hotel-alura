package com.br.hotel.views;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MenuPrincipal extends JFrame {
    private final JPanel contentPane;
    private final JLabel labelExit;
    int xMouse;
    int yMouse;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public MenuPrincipal() {
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagenes/aH-40px.png")));
        this.setDefaultCloseOperation(0);
        this.setBounds(100, 100, 910, 537);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        this.setUndecorated(true);
        Panel panel = new Panel();
        panel.setBackground(SystemColor.window);
        panel.setBounds(0, 0, 910, 537);
        this.contentPane.add(panel);
        panel.setLayout((LayoutManager)null);
        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(-50, 0, 732, 501);
        //imagenFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/menu-img.png")));
        panel.add(imagenFondo);
        JLabel logo = new JLabel("");
        logo.setBounds(722, 80, 150, 156);
        //logo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/aH-150px.png")));
        panel.add(logo);
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 500, 910, 37);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout((LayoutManager)null);
        JLabel lblCopyR = new JLabel("Desenvolvido por Fulanita de Tal © 2023");
        lblCopyR.setBounds(315, 11, 301, 19);
        lblCopyR.setForeground(new Color(240, 248, 255));
        lblCopyR.setFont(new Font("Roboto", 0, 16));
        panel_1.add(lblCopyR);
        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                MenuPrincipal.this.headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                MenuPrincipal.this.headerMousePressed(e);
            }
        });
        header.setLayout((LayoutManager)null);
        header.setBackground(Color.WHITE);
        panel.add(header);
        final JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                MenuPrincipal.this.labelExit.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(Color.white);
                MenuPrincipal.this.labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout((LayoutManager)null);
        btnexit.setCursor(new Cursor(12));
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);
        this.labelExit = new JLabel("X");
        this.labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(this.labelExit);
        this.labelExit.setHorizontalAlignment(0);
        this.labelExit.setFont(new Font("Roboto", 0, 18));
        JPanel btnLogin = new JPanel();
        btnLogin.setBounds(754, 300, 83, 70);
        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
                login.setVisible(true);
                MenuPrincipal.this.dispose();
            }
        });
        btnLogin.setLayout((LayoutManager)null);
        btnLogin.setCursor(new Cursor(12));
        btnLogin.setBackground(SystemColor.window);
        panel.add(btnLogin);
        JLabel imageLogin = new JLabel("");
        imageLogin.setBounds(0, 0, 80, 70);
        btnLogin.add(imageLogin);
        imageLogin.setHorizontalAlignment(0);
        //imageLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/login.png")));
        JLabel lblTitulo = new JLabel("LOGIN");
        lblTitulo.setBounds(754, 265, 83, 24);
        lblTitulo.setBackground(SystemColor.window);
        panel.add(lblTitulo);
        lblTitulo.setHorizontalAlignment(0);
        lblTitulo.setForeground(SystemColor.textHighlight);
        lblTitulo.setFont(new Font("Roboto Light", 0, 20));
    }

    private void headerMousePressed(MouseEvent evt) {
        this.xMouse = evt.getX();
        this.yMouse = evt.getY();
    }

    private void headerMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }
}
