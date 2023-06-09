package com.br.hotel.views;


import com.br.hotel.dao.ReservaDao;
import com.br.hotel.model.Reserva;
import com.br.hotel.util.CalculaDiarias;
import com.br.hotel.util.FactoryUtil;
import com.toedter.calendar.JDateChooser;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReservasView extends JFrame {
    private JPanel contentPane;
    public static JTextField txtValor;
    public static JDateChooser txtDataE;
    public static JDateChooser txtDataS;
    public static JComboBox<String> txtFormaPagamento;
    int xMouse;
    int yMouse;
    private JLabel labelExit;
    private JLabel lblValorSimbolo;
    private JLabel labelAtras;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReservasView frame = new ReservasView();
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public ReservasView() {
        super("Reserva");
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 910, 560);
        this.setResizable(false);
        this.contentPane = new JPanel();
        this.contentPane.setBackground(SystemColor.control);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        this.setUndecorated(true);
        JPanel panel = new JPanel();
        panel.setBorder((Border)null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 910, 560);
        this.contentPane.add(panel);
        panel.setLayout((LayoutManager)null);
        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(SystemColor.textHighlight);
        separator_1_2.setBounds(68, 195, 289, 2);
        separator_1_2.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_2);
        JSeparator separator_1_3 = new JSeparator();
        separator_1_3.setForeground(SystemColor.textHighlight);
        separator_1_3.setBackground(SystemColor.textHighlight);
        separator_1_3.setBounds(68, 453, 289, 2);
        panel.add(separator_1_3);
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(SystemColor.textHighlight);
        separator_1_1.setBounds(68, 281, 289, 11);
        separator_1_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_1);
        txtDataE = new JDateChooser();
        txtDataE.getCalendarButton().setBackground(SystemColor.textHighlight);
        //txtDataE.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
        txtDataE.getCalendarButton().setFont(new Font("Roboto", 0, 12));
        txtDataE.setBounds(68, 161, 289, 35);
        txtDataE.getCalendarButton().setBounds(268, 0, 21, 33);
        txtDataE.setBackground(Color.WHITE);
        txtDataE.setBorder(new LineBorder(SystemColor.window));
        txtDataE.setDateFormatString("yyyy-MM-dd");
        txtDataE.setFont(new Font("Roboto", 0, 18));
        panel.add(txtDataE);
        this.lblValorSimbolo = new JLabel("$");
        this.lblValorSimbolo.setVisible(false);
        this.lblValorSimbolo.setBounds(121, 332, 17, 25);
        this.lblValorSimbolo.setForeground(SystemColor.textHighlight);
        this.lblValorSimbolo.setFont(new Font("Roboto", 1, 17));
        panel.add(this.lblValorSimbolo);
        JLabel lblCheckIn = new JLabel("DATA DE CHECK IN");
        lblCheckIn.setForeground(SystemColor.textInactiveText);
        lblCheckIn.setBounds(68, 136, 169, 14);
        lblCheckIn.setFont(new Font("Roboto Black", 0, 18));
        panel.add(lblCheckIn);
        JLabel lblCheckOut = new JLabel("DATA DE CHECK OUT");
        lblCheckOut.setForeground(SystemColor.textInactiveText);
        lblCheckOut.setBounds(68, 221, 187, 14);
        lblCheckOut.setFont(new Font("Roboto Black", 0, 18));
        panel.add(lblCheckOut);
        txtDataS = new JDateChooser();
        //txtDataS.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
        txtDataS.getCalendarButton().setFont(new Font("Roboto", 0, 11));
        txtDataS.setBounds(68, 246, 289, 35);
        txtDataS.getCalendarButton().setBounds(267, 1, 21, 31);
        txtDataS.setBackground(Color.WHITE);
        txtDataS.setFont(new Font("Roboto", 0, 18));
        txtDataS.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
            }
        });
        txtDataS.setDateFormatString("yyyy-MM-dd");
        txtDataS.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtDataS.setBorder(new LineBorder(new Color(255, 255, 255), 0));
        panel.add(txtDataS);
        txtValor = new JTextField();
        txtValor.setBackground(SystemColor.text);
        txtValor.setHorizontalAlignment(0);
        txtValor.setForeground(Color.BLACK);
        txtValor.setBounds(78, 328, 43, 33);
        txtValor.setEditable(false);
        txtValor.setFont(new Font("Roboto Black", 1, 17));
        txtValor.setBorder(BorderFactory.createEmptyBorder());
        panel.add(txtValor);
        txtValor.setColumns(10);
        JLabel lblValor = new JLabel("VALOR DA RESERVA");
        lblValor.setForeground(SystemColor.textInactiveText);
        lblValor.setBounds(72, 303, 196, 14);
        lblValor.setFont(new Font("Roboto Black", 0, 18));
        panel.add(lblValor);
        txtFormaPagamento = new JComboBox();
        txtFormaPagamento.setBounds(68, 417, 289, 38);
        txtFormaPagamento.setBackground(SystemColor.text);
        txtFormaPagamento.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        txtFormaPagamento.setFont(new Font("Roboto", 0, 16));
        txtFormaPagamento.setModel(new DefaultComboBoxModel(new String[]{"Cartão de Crédito", "Cartão de Débito", "Dinheiro"}));
        panel.add(txtFormaPagamento);
        JLabel lblFormaPago = new JLabel("FORMA DE PAGAMENTO");
        lblFormaPago.setForeground(SystemColor.textInactiveText);
        lblFormaPago.setBounds(68, 382, 213, 24);
        lblFormaPago.setFont(new Font("Roboto Black", 0, 18));
        panel.add(lblFormaPago);
        JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
        lblTitulo.setBounds(109, 60, 219, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto", 1, 20));
        panel.add(lblTitulo);
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(428, 0, 482, 560);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout((LayoutManager)null);
        JLabel logo = new JLabel("");
        logo.setBounds(197, 68, 104, 107);
        panel_1.add(logo);
        //logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));
        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 140, 500, 409);
        panel_1.add(imagenFondo);
        imagenFondo.setBackground(Color.WHITE);
        //imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));
        final JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MenuPrincipal principal = new MenuPrincipal();
                principal.setVisible(true);
                ReservasView.this.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                ReservasView.this.labelExit.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(12, 138, 199));
                ReservasView.this.labelExit.setForeground(Color.white);
            }
        });
        btnexit.setLayout((LayoutManager)null);
        btnexit.setBackground(new Color(12, 138, 199));
        btnexit.setBounds(429, 0, 53, 36);
        panel_1.add(btnexit);
        this.labelExit = new JLabel("X");
        this.labelExit.setForeground(Color.WHITE);
        this.labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(this.labelExit);
        this.labelExit.setHorizontalAlignment(0);
        this.labelExit.setFont(new Font("Roboto", 0, 18));
        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                ReservasView.this.headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                ReservasView.this.headerMousePressed(e);
            }
        });
        header.setLayout((LayoutManager)null);
        header.setBackground(Color.WHITE);
        panel.add(header);
        final JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                ReservasView.this.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                ReservasView.this.labelAtras.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                ReservasView.this.labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout((LayoutManager)null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);
        this.labelAtras = new JLabel("<");
        this.labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(this.labelAtras);
        this.labelAtras.setHorizontalAlignment(0);
        this.labelAtras.setFont(new Font("Roboto", 0, 23));
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(SystemColor.textHighlight);
        separator_1.setBounds(68, 362, 289, 2);
        separator_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1);
        JPanel btnProximo = new JPanel();
        btnProximo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (ReservasView.txtDataE.getDate() != null && ReservasView.txtDataS.getDate() != null) {

                    Date dataEntrada = ReservasView.txtDataE.getDate();
                    Date dataSaida = ReservasView.txtDataS.getDate();
                    String formaPagamento = ReservasView.txtFormaPagamento.getSelectedItem().toString();

                    criarReserva(dataEntrada, dataSaida, formaPagamento);
                    RegistroHospede registro = new RegistroHospede();
                    registro.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Deve preencher todos os campos.");
                }

            }
        });
        btnProximo.setLayout((LayoutManager)null);
        btnProximo.setBackground(SystemColor.textHighlight);
        btnProximo.setBounds(238, 493, 122, 35);
        panel.add(btnProximo);
        btnProximo.setCursor(new Cursor(12));
        JLabel lblSeguinte = new JLabel("PRÓXIMO");
        lblSeguinte.setHorizontalAlignment(0);
        lblSeguinte.setForeground(Color.WHITE);
        lblSeguinte.setFont(new Font("Roboto", 0, 18));
        lblSeguinte.setBounds(0, 0, 122, 35);
        btnProximo.add(lblSeguinte);
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

    private void criarReserva(Date dataEntrada, Date dataSaida, String pagamento) {

        EntityManager em = FactoryUtil.getEntityManager();
        ReservaDao reservaDao = new ReservaDao(em, Reserva.class);
        BigDecimal valorDiaria = BigDecimal.valueOf(123.05);

        CalculaDiarias calculaDiarias = new CalculaDiarias();

        BigDecimal valorTotal = calculaDiarias.calcularValorTotal(dataEntrada, dataSaida, valorDiaria);

        Reserva reserva = new Reserva(dataEntrada, dataSaida, valorTotal, pagamento);

        em.getTransaction().begin();
        reservaDao.create(reserva);
        em.getTransaction().commit();
        em.close();
    }
}
