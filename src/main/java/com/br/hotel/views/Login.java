package com.br.hotel.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    int xMouse;
    int yMouse;
    private JLabel labelExit;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public Login() {
        this.setResizable(false);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 788, 527);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.setLocationRelativeTo((Component)null);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 788, 527);
        panel.setBackground(Color.WHITE);
        this.contentPane.add(panel);
        panel.setLayout((LayoutManager)null);
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(12, 138, 199));
        panel_1.setBounds(484, 0, 304, 527);
        panel.add(panel_1);
        panel_1.setLayout((LayoutManager)null);
        JLabel imgHotel = new JLabel("");
        imgHotel.setBounds(0, 0, 304, 538);
        panel_1.add(imgHotel);
        //imgHotel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/img-hotel-login-.png")));
        final JPanel btnexit = new JPanel();
        btnexit.setBounds(251, 0, 53, 36);
        panel_1.add(btnexit);
        btnexit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                Login.this.labelExit.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(12, 138, 199));
                Login.this.labelExit.setForeground(Color.white);
            }
        });
        btnexit.setBackground(new Color(12, 138, 199));
        btnexit.setLayout((LayoutManager)null);
        btnexit.setCursor(new Cursor(12));
        this.labelExit = new JLabel("X");
        this.labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(this.labelExit);
        this.labelExit.setForeground(SystemColor.text);
        this.labelExit.setFont(new Font("Roboto", 0, 18));
        this.labelExit.setHorizontalAlignment(0);
        this.txtUsuario = new JTextField();
        this.txtUsuario.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (Login.this.txtUsuario.getText().equals("Digite seu nome de usuario")) {
                    Login.this.txtUsuario.setText("");
                    Login.this.txtUsuario.setForeground(Color.black);
                }

                if (String.valueOf(Login.this.txtSenha.getPassword()).isEmpty()) {
                    Login.this.txtSenha.setText("********");
                    Login.this.txtSenha.setForeground(Color.gray);
                }

            }
        });
        this.txtUsuario.setFont(new Font("Roboto", 0, 16));
        this.txtUsuario.setText("Digite seu nome de usuario");
        this.txtUsuario.setBorder(BorderFactory.createEmptyBorder());
        this.txtUsuario.setForeground(SystemColor.activeCaptionBorder);
        this.txtUsuario.setBounds(65, 256, 324, 32);
        panel.add(this.txtUsuario);
        this.txtUsuario.setColumns(10);
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 120, 215));
        separator.setBounds(65, 292, 324, 2);
        panel.add(separator);
        JLabel labelTitulo = new JLabel("LOGIN");
        labelTitulo.setForeground(SystemColor.textHighlight);
        labelTitulo.setFont(new Font("Roboto Black", 0, 26));
        labelTitulo.setBounds(196, 150, 89, 26);
        panel.add(labelTitulo);
        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(SystemColor.textHighlight);
        separator_1.setBounds(65, 393, 324, 2);
        panel.add(separator_1);
        this.txtSenha = new JPasswordField();
        this.txtSenha.setText("********");
        this.txtSenha.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (String.valueOf(Login.this.txtSenha.getPassword()).equals("********")) {
                    Login.this.txtSenha.setText("");
                    Login.this.txtSenha.setForeground(Color.black);
                }

                if (Login.this.txtUsuario.getText().isEmpty()) {
                    Login.this.txtUsuario.setText("Digite seu nome de usuario");
                    Login.this.txtUsuario.setForeground(Color.gray);
                }

            }
        });
        this.txtSenha.setForeground(SystemColor.activeCaptionBorder);
        this.txtSenha.setFont(new Font("Roboto", 0, 16));
        this.txtSenha.setBorder(BorderFactory.createEmptyBorder());
        this.txtSenha.setBounds(65, 353, 324, 32);
        panel.add(this.txtSenha);
        JLabel LabelUsuario = new JLabel("USUARIO");
        LabelUsuario.setForeground(SystemColor.textInactiveText);
        LabelUsuario.setFont(new Font("Roboto Black", 0, 20));
        LabelUsuario.setBounds(65, 219, 107, 26);
        panel.add(LabelUsuario);
        JLabel lblSenha = new JLabel("SENHA");
        lblSenha.setForeground(SystemColor.textInactiveText);
        lblSenha.setFont(new Font("Roboto Black", 0, 20));
        lblSenha.setBounds(65, 316, 140, 26);
        panel.add(lblSenha);
        final JPanel btnLogin = new JPanel();
        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(0, 156, 223));
            }

            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(SystemColor.textHighlight);
            }

            public void mouseClicked(MouseEvent e) {
                Login.this.Login();
            }
        });
        btnLogin.setBackground(SystemColor.textHighlight);
        btnLogin.setBounds(65, 431, 122, 44);
        panel.add(btnLogin);
        btnLogin.setLayout((LayoutManager)null);
        btnLogin.setCursor(new Cursor(12));
        JLabel lblEntrar = new JLabel("ENTRAR");
        lblEntrar.setBounds(0, 0, 122, 44);
        btnLogin.add(lblEntrar);
        lblEntrar.setForeground(SystemColor.controlLtHighlight);
        lblEntrar.setHorizontalAlignment(0);
        lblEntrar.setFont(new Font("Roboto", 0, 18));
        JLabel logo = new JLabel("");
        logo.setHorizontalAlignment(0);
        //logo.setIcon(new ImageIcon(Login.class.getResource("/imagenes/lOGO-50PX.png")));
        logo.setBounds(65, 65, 48, 59);
        panel.add(logo);
        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Login.this.headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Login.this.headerMousePressed(e);
            }
        });
        header.setBackground(SystemColor.window);
        header.setBounds(0, 0, 784, 36);
        panel.add(header);
        header.setLayout((LayoutManager)null);
    }

    private void Login() {
        String Usuario = "admin";
        String Senha = "admin";
        String senhaa = new String(this.txtSenha.getPassword());
        if (this.txtUsuario.getText().equals(Usuario) && senhaa.equals(Senha)) {
            MenuUsuario menu = new MenuUsuario();
            menu.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario ou Senha não válidos");
        }

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
