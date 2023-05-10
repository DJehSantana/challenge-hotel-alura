package com.br.hotel.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuUsuario extends JFrame {
    private JPanel contentPane;
    int xMouse;
    int yMouse;
    private JLabel labelExit;
    private JLabel labelRegistro;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuUsuario frame = new MenuUsuario();
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public MenuUsuario() {
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 944, 609);
        this.contentPane = new JPanel();
        this.contentPane.setBackground(Color.WHITE);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        this.setUndecorated(true);
        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                MenuUsuario.this.headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                MenuUsuario.this.headerMousePressed(e);
            }
        });
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(12, 138, 199));
        panelMenu.setBounds(0, 0, 257, 609);
        this.contentPane.add(panelMenu);
        panelMenu.setLayout((LayoutManager)null);
        final JPanel btnBuscar = new JPanel();
        btnBuscar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnBuscar.setBackground(new Color(118, 187, 223));
            }

            public void mouseExited(MouseEvent e) {
                btnBuscar.setBackground(new Color(12, 138, 199));
            }

            public void mouseClicked(MouseEvent e) {
                Buscar buscar = new Buscar();
                buscar.setVisible(true);
                MenuUsuario.this.dispose();
            }
        });
        btnBuscar.setBounds(0, 312, 257, 56);
        btnBuscar.setBackground(new Color(12, 138, 199));
        btnBuscar.setLayout((LayoutManager)null);
        btnBuscar.setCursor(new Cursor(12));
        panelMenu.add(btnBuscar);
        JLabel lblBusquedaDeReservas = new JLabel("Buscar");
        //lblBusquedaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
        lblBusquedaDeReservas.setBounds(30, 11, 200, 34);
        lblBusquedaDeReservas.setHorizontalAlignment(2);
        lblBusquedaDeReservas.setForeground(Color.WHITE);
        lblBusquedaDeReservas.setFont(new Font("Roboto", 0, 18));
        btnBuscar.add(lblBusquedaDeReservas);
        JLabel logo = new JLabel("");
        logo.setBounds(50, 58, 150, 150);
        panelMenu.add(logo);
        //logo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));
        final JPanel btnRegistro = new JPanel();
        btnRegistro.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnRegistro.setBackground(new Color(118, 187, 223));
            }

            public void mouseExited(MouseEvent e) {
                btnRegistro.setBackground(new Color(12, 138, 199));
            }

            public void mouseClicked(MouseEvent e) {
                ReservasView reservas = new ReservasView();
                reservas.setVisible(true);
                MenuUsuario.this.dispose();
            }
        });
        btnRegistro.setBounds(0, 255, 257, 56);
        btnRegistro.setBackground(new Color(12, 138, 199));
        panelMenu.add(btnRegistro);
        btnRegistro.setLayout((LayoutManager)null);
        btnRegistro.setCursor(new Cursor(12));
        this.labelRegistro = new JLabel("Registro de reservas");
        //this.labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
        this.labelRegistro.setForeground(SystemColor.text);
        this.labelRegistro.setBounds(25, 11, 205, 34);
        this.labelRegistro.setFont(new Font("Roboto", 0, 18));
        this.labelRegistro.setHorizontalAlignment(2);
        btnRegistro.add(this.labelRegistro);
        JSeparator separator = new JSeparator();
        separator.setBounds(26, 219, 201, 2);
        panelMenu.add(separator);
        header.setLayout((LayoutManager)null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 944, 36);
        this.contentPane.add(header);
        final JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                MenuUsuario.this.labelExit.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(Color.white);
                MenuUsuario.this.labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout((LayoutManager)null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(891, 0, 53, 36);
        header.add(btnexit);
        this.labelExit = new JLabel("X");
        this.labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(this.labelExit);
        this.labelExit.setHorizontalAlignment(0);
        this.labelExit.setFont(new Font("Roboto", 0, 18));
        JPanel panelFecha = new JPanel();
        panelFecha.setBackground(new Color(118, 187, 223));
        panelFecha.setBounds(256, 84, 688, 121);
        this.contentPane.add(panelFecha);
        panelFecha.setLayout((LayoutManager)null);
        JLabel lblTituloPrincipal = new JLabel("Sistema de reservas Hotel Alura");
        lblTituloPrincipal.setBounds(180, 11, 356, 42);
        panelFecha.add(lblTituloPrincipal);
        lblTituloPrincipal.setForeground(Color.WHITE);
        lblTituloPrincipal.setFont(new Font("Roboto", 0, 24));
        JLabel labelFecha = new JLabel("New label");
        labelFecha.setBounds(35, 64, 294, 36);
        panelFecha.add(labelFecha);
        labelFecha.setForeground(Color.WHITE);
        labelFecha.setFont(new Font("Roboto", 0, 33));
        Date fechaActual = new Date();
        String fecha = (new SimpleDateFormat("dd/MM/yyyy")).format(fechaActual);
        labelFecha.setText("Hoje é " + fecha);
        JLabel lbltitulo = new JLabel("Bem-vindo");
        lbltitulo.setFont(new Font("Roboto", 1, 24));
        lbltitulo.setBounds(302, 234, 147, 46);
        this.contentPane.add(lbltitulo);
        String textoDescripcion = "<html><body>Sistema de reservas de hotéis. Controle e gerencie de forma otimizada e fácil <br> o fluxo de reservas e hóspedes do hotel   </body></html>";
        JLabel labelDescripcion_0 = new JLabel(textoDescripcion);
        labelDescripcion_0.setFont(new Font("Roboto", 0, 17));
        labelDescripcion_0.setBounds(312, 291, 598, 66);
        this.contentPane.add(labelDescripcion_0);
        String textoDescricao1 = "<html><body> Esta ferramenta permitirá que você mantenha um controle completo e detalhado de suas reservas e hóspedes, você terá acesso a ferramentas especiais para tarefas específicas como:</body></html>";
        JLabel labelDescricao_1 = new JLabel(textoDescricao1);
        labelDescricao_1.setFont(new Font("Roboto", 0, 17));
        labelDescricao_1.setBounds(311, 345, 569, 88);
        this.contentPane.add(labelDescricao_1);
        JLabel labelDescricao_2 = new JLabel("- Registro de Reservas e Hóspedes");
        labelDescricao_2.setFont(new Font("Roboto", 0, 17));
        labelDescricao_2.setBounds(312, 444, 295, 27);
        this.contentPane.add(labelDescricao_2);
        JLabel labelDescricao_3 = new JLabel("- Edição de Reservas e Hóspedes existentes");
        labelDescricao_3.setFont(new Font("Roboto", 0, 17));
        labelDescricao_3.setBounds(312, 482, 355, 27);
        this.contentPane.add(labelDescricao_3);
        JLabel labelDescricao_4 = new JLabel("- Excluir todos os tipos de registros");
        labelDescricao_4.setFont(new Font("Roboto", 0, 17));
        labelDescricao_4.setBounds(312, 520, 295, 27);
        this.contentPane.add(labelDescricao_4);
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

