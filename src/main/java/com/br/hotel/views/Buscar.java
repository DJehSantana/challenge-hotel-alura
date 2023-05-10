package com.br.hotel.views;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;

public class Buscar extends JFrame {
        private JPanel contentPane;
        private JTextField txtBuscar;
        private JTable tbHospedes;
        private JTable tbReservas;
        private DefaultTableModel modelo;
        private DefaultTableModel modeloHospedes;
        private JLabel labelAtras;
        private JLabel labelExit;
        int xMouse;
        int yMouse;

        public static void main(String[] args) {
            Class<?> clazz = Buscar.class;
            URL url = clazz.getResource("");
            String path = url.getPath();
            System.out.println ("Diretório base do classpath: " + path);

            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    try {
                        Buscar frame = new Buscar();
                        frame.setVisible(true);
                    } catch (Exception var2) {
                        var2.printStackTrace();
                    }

                }
            });
        }

        public Buscar() {
            //this.setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("imagenes/lOGO-50PX.png")));
            this.setDefaultCloseOperation(3);
            this.setBounds(100, 100, 910, 571);
            this.contentPane = new JPanel();
            this.contentPane.setBackground(Color.WHITE);
            this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.setContentPane(this.contentPane);
            this.contentPane.setLayout((LayoutManager)null);
            this.setLocationRelativeTo((Component)null);
            this.setUndecorated(true);
            this.txtBuscar = new JTextField();
            this.txtBuscar.setBounds(536, 127, 193, 31);
            this.txtBuscar.setBorder(BorderFactory.createEmptyBorder());
            this.contentPane.add(this.txtBuscar);
            this.txtBuscar.setColumns(10);
            JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
            lblTitulo.setForeground(new Color(12, 138, 199));
            lblTitulo.setFont(new Font("Roboto Black", 1, 24));
            lblTitulo.setBounds(331, 62, 280, 42);
            this.contentPane.add(lblTitulo);
            JTabbedPane panel = new JTabbedPane(1);
            panel.setBackground(new Color(12, 138, 199));
            panel.setFont(new Font("Roboto", 0, 16));
            panel.setBounds(20, 169, 865, 328);
            this.contentPane.add(panel);
            this.tbReservas = new JTable();
            this.tbReservas.setSelectionMode(0);
            this.tbReservas.setFont(new Font("Roboto", 0, 16));
            this.modelo = (DefaultTableModel)this.tbReservas.getModel();
            this.modelo.addColumn("Numero de Reserva");
            this.modelo.addColumn("Data Check In");
            this.modelo.addColumn("Data Check Out");
            this.modelo.addColumn("Valor");
            this.modelo.addColumn("Forma de Pago");
            JScrollPane scroll_table = new JScrollPane(this.tbReservas);
            //panel.addTab("Reservas", new ImageIcon(Buscar.class.getResource("/imagenes/reservado.png")), scroll_table, (String)null);
            scroll_table.setVisible(true);
            this.tbHospedes = new JTable();
            this.tbHospedes.setSelectionMode(0);
            this.tbHospedes.setFont(new Font("Roboto", 0, 16));
            this.modeloHospedes = (DefaultTableModel)this.tbHospedes.getModel();
            this.modeloHospedes.addColumn("Numero de Hóspede");
            this.modeloHospedes.addColumn("Nome");
            this.modeloHospedes.addColumn("Sobrenome");
            this.modeloHospedes.addColumn("Data de Nascimento");
            this.modeloHospedes.addColumn("Nacionalidade");
            this.modeloHospedes.addColumn("Telefone");
            this.modeloHospedes.addColumn("Numero de Reserva");
            JScrollPane scroll_tableHuespedes = new JScrollPane(this.tbHospedes);
            //panel.addTab("Huéspedes", new ImageIcon(Buscar.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, (String)null);
            scroll_tableHuespedes.setVisible(true);
            JLabel lblNewLabel_2 = new JLabel("");
            //lblNewLabel_2.setIcon(new ImageIcon(Buscar.class.getResource("/imagenes/Ha-100px.png")));
            lblNewLabel_2.setBounds(56, 51, 104, 107);
            this.contentPane.add(lblNewLabel_2);
            JPanel header = new JPanel();
            header.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    Buscar.this.headerMouseDragged(e);
                }
            });
            header.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    Buscar.this.headerMousePressed(e);
                }
            });
            header.setLayout((LayoutManager)null);
            header.setBackground(Color.WHITE);
            header.setBounds(0, 0, 910, 36);
            this.contentPane.add(header);
            final JPanel btnAtras = new JPanel();
            btnAtras.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    MenuUsuario usuario = new MenuUsuario();
                    usuario.setVisible(true);
                    Buscar.this.dispose();
                }

                public void mouseEntered(MouseEvent e) {
                    btnAtras.setBackground(new Color(12, 138, 199));
                    Buscar.this.labelAtras.setForeground(Color.white);
                }

                public void mouseExited(MouseEvent e) {
                    btnAtras.setBackground(Color.white);
                    Buscar.this.labelAtras.setForeground(Color.black);
                }
            });
            btnAtras.setLayout((LayoutManager)null);
            btnAtras.setBackground(Color.WHITE);
            btnAtras.setBounds(0, 0, 53, 36);
            header.add(btnAtras);
            this.labelAtras = new JLabel("<");
            this.labelAtras.setHorizontalAlignment(0);
            this.labelAtras.setFont(new Font("Roboto", 0, 23));
            this.labelAtras.setBounds(0, 0, 53, 36);
            btnAtras.add(this.labelAtras);
            final JPanel btnexit = new JPanel();
            btnexit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    MenuUsuario usuario = new MenuUsuario();
                    usuario.setVisible(true);
                    Buscar.this.dispose();
                }

                public void mouseEntered(MouseEvent e) {
                    btnexit.setBackground(Color.red);
                    Buscar.this.labelExit.setForeground(Color.white);
                }

                public void mouseExited(MouseEvent e) {
                    btnexit.setBackground(Color.white);
                    Buscar.this.labelExit.setForeground(Color.black);
                }
            });
            btnexit.setLayout((LayoutManager)null);
            btnexit.setBackground(Color.WHITE);
            btnexit.setBounds(857, 0, 53, 36);
            header.add(btnexit);
            this.labelExit = new JLabel("X");
            this.labelExit.setHorizontalAlignment(0);
            this.labelExit.setForeground(Color.BLACK);
            this.labelExit.setFont(new Font("Roboto", 0, 18));
            this.labelExit.setBounds(0, 0, 53, 36);
            btnexit.add(this.labelExit);
            JSeparator separator_1_2 = new JSeparator();
            separator_1_2.setForeground(new Color(12, 138, 199));
            separator_1_2.setBackground(new Color(12, 138, 199));
            separator_1_2.setBounds(539, 159, 193, 2);
            this.contentPane.add(separator_1_2);
            JPanel btnbuscar = new JPanel();
            btnbuscar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {

                }
            });
            btnbuscar.setLayout((LayoutManager)null);
            btnbuscar.setBackground(new Color(12, 138, 199));
            btnbuscar.setBounds(748, 125, 122, 35);
            btnbuscar.setCursor(new Cursor(12));
            this.contentPane.add(btnbuscar);
            JLabel lblBuscar = new JLabel("BUSCAR");
            lblBuscar.setBounds(0, 0, 122, 35);
            btnbuscar.add(lblBuscar);
            lblBuscar.setHorizontalAlignment(0);
            lblBuscar.setForeground(Color.WHITE);
            lblBuscar.setFont(new Font("Roboto", 0, 18));
            JPanel btnEditar = new JPanel();
            btnEditar.setLayout((LayoutManager)null);
            btnEditar.setBackground(new Color(12, 138, 199));
            btnEditar.setBounds(635, 508, 122, 35);
            btnEditar.setCursor(new Cursor(12));
            this.contentPane.add(btnEditar);
            JLabel lblEditar = new JLabel("EDITAR");
            lblEditar.setHorizontalAlignment(0);
            lblEditar.setForeground(Color.WHITE);
            lblEditar.setFont(new Font("Roboto", 0, 18));
            lblEditar.setBounds(0, 0, 122, 35);
            btnEditar.add(lblEditar);
            JPanel btnDeletar = new JPanel();
            btnDeletar.setLayout((LayoutManager)null);
            btnDeletar.setBackground(new Color(12, 138, 199));
            btnDeletar.setBounds(767, 508, 122, 35);
            btnDeletar.setCursor(new Cursor(12));
            this.contentPane.add(btnDeletar);
            JLabel lblExcluir = new JLabel("DELETAR");
            lblExcluir.setHorizontalAlignment(0);
            lblExcluir.setForeground(Color.WHITE);
            lblExcluir.setFont(new Font("Roboto", 0, 18));
            lblExcluir.setBounds(0, 0, 122, 35);
            btnDeletar.add(lblExcluir);
            this.setResizable(false);
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
