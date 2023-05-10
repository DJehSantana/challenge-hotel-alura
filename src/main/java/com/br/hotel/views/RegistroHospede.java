package com.br.hotel.views;


import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;

public class RegistroHospede extends JFrame {
    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtTelefone;
    private JTextField txtNreserva;
    private JDateChooser txtDataN;
    private JComboBox<Format> txtNacionalidade;
    private JLabel labelExit;
    private JLabel labelAtras;
    int xMouse;
    int yMouse;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistroHospede frame = new RegistroHospede();
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public RegistroHospede() {
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHospede.class.getResource("/imagenes/lOGO-50PX.png")));
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 910, 634);
        this.contentPane = new JPanel();
        this.contentPane.setBackground(SystemColor.text);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.setLocationRelativeTo((Component)null);
        this.setUndecorated(true);
        this.contentPane.setLayout((LayoutManager)null);
        JPanel header = new JPanel();
        header.setBounds(-54, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                RegistroHospede.this.headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                RegistroHospede.this.headerMousePressed(e);
            }
        });
        final JPanel btnexit = new JPanel();
        btnexit.setBounds(857, 0, 53, 36);
        this.contentPane.add(btnexit);
        btnexit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MenuPrincipal principal = new MenuPrincipal();
                principal.setVisible(true);
                RegistroHospede.this.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                RegistroHospede.this.labelExit.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(Color.white);
                RegistroHospede.this.labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout((LayoutManager)null);
        btnexit.setBackground(Color.white);
        this.labelExit = new JLabel("X");
        this.labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(this.labelExit);
        this.labelExit.setHorizontalAlignment(0);
        this.labelExit.setForeground(SystemColor.black);
        this.labelExit.setFont(new Font("Roboto", 0, 18));
        header.setLayout((LayoutManager)null);
        header.setBackground(SystemColor.text);
        header.setOpaque(false);
        header.setBounds(0, 0, 910, 36);
        this.contentPane.add(header);
        final JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ReservasView reservas = new ReservasView();
                reservas.setVisible(true);
                RegistroHospede.this.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                RegistroHospede.this.labelAtras.setForeground(Color.black);
            }

            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                RegistroHospede.this.labelAtras.setForeground(Color.white);
            }
        });
        btnAtras.setLayout((LayoutManager)null);
        btnAtras.setBackground(new Color(12, 138, 199));
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);
        this.labelAtras = new JLabel("<");
        this.labelAtras.setHorizontalAlignment(0);
        this.labelAtras.setForeground(Color.WHITE);
        this.labelAtras.setFont(new Font("Roboto", 0, 23));
        this.labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(this.labelAtras);
        this.txtNome = new JTextField();
        this.txtNome.setFont(new Font("Roboto", 0, 16));
        this.txtNome.setBounds(560, 135, 285, 33);
        this.txtNome.setBackground(Color.WHITE);
        this.txtNome.setColumns(10);
        this.txtNome.setBorder(BorderFactory.createEmptyBorder());
        this.contentPane.add(this.txtNome);
        this.txtSobrenome = new JTextField();
        this.txtSobrenome.setFont(new Font("Roboto", 0, 16));
        this.txtSobrenome.setBounds(560, 204, 285, 33);
        this.txtSobrenome.setColumns(10);
        this.txtSobrenome.setBackground(Color.WHITE);
        this.txtSobrenome.setBorder(BorderFactory.createEmptyBorder());
        this.contentPane.add(this.txtSobrenome);
        this.txtDataN = new JDateChooser();
        this.txtDataN.setBounds(560, 278, 285, 36);
        //this.txtDataN.getCalendarButton().setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagenes/icon-reservas.png")));
        this.txtDataN.getCalendarButton().setBackground(SystemColor.textHighlight);
        this.txtDataN.setDateFormatString("yyyy-MM-dd");
        this.contentPane.add(this.txtDataN);
        this.txtNacionalidade = new JComboBox();
        this.txtNacionalidade.setBounds(560, 350, 289, 36);
        this.txtNacionalidade.setBackground(SystemColor.text);
        this.txtNacionalidade.setFont(new Font("Roboto", 0, 16));
        this.txtNacionalidade.setModel(new DefaultComboBoxModel(new String[]{"alemão", "andorrano", "angolano", "antiguano", "saudita", "argelino", "argentino", "armênio", "australiano", "austríaco", "azerbaijano", "bahamense", "bangladês, bangladense", "barbadiano", "bahreinita", "belga", "belizenho", "beninês", "belarusso", "boliviano", "bósnio", "botsuanês", "brasileiro", "bruneíno", "búlgaro", "burkineonse, burkinabé", "burundês", "butanês", "cabo-verdiano", "camerounês", "cambojano", "catariano", "canadense", "cazaque", "chadiano", "chileno", "chinês", "cipriota", "colombiano", "comoriano", "congolês", "congolês", "sul-coreano", "norte-coreano", "costa-marfinense, marfinense", "costa-ricense", "croata", "cubano", "dinamarquês", "djiboutiano", "dominiquense", "egípcio", "salvadorenho", "emiradense, emirático", "equatoriano", "eritreu", "eslovaco", "esloveno", "espanhol", "estadunidense, (norte-)americano", "estoniano", "etíope", "fijiano", "filipino", "finlandês", "francês", "gabonês", "gambiano", "ganês ou ganense", "georgiano", "granadino", "grego", "guatemalteco", "guianês", "guineense", "guineense, bissau-guineense", "equato-guineense", "haitiano", "hondurenho", "húngaro", "iemenita", "cookiano", "marshallês", "salomonense", "indiano", "indonésio", "iraniano", "iraquiano", "irlandês", "islandês", "34", "jamaicano", "japonês", "jordaniano", "kiribatiano", "kuwaitiano", "laosiano", "lesotiano", "letão", "libanês", "liberiano", "líbio", "liechtensteiniano", "lituano", "luxemburguês", "macedônio", "madagascarense", "malásio37", "malawiano", "maldivo", "maliano", "maltês", "marroquino", "mauriciano", "mauritano", "mexicano", "myanmarense", "micronésio", "moçambicano", "moldovo", "monegasco", "mongol", "montenegrino", "namibiano", "nauruano", "nepalês", "nicaraguense", "nigerino", "nigeriano", "niuiano", "norueguês", "neozelandês", "omani", "neerlandês", "palauano", "palestino", "panamenho", "papua, papuásio", "paquistanês", "paraguaio", "peruano", "polonês, polaco", "português", "queniano", "quirguiz", "britânico", "centro-africano", "tcheco", "dominicano", "romeno", "ruandês", "russo", "samoano", "santa-lucense", "são-cristovense", "samarinês", "santomense", "são-vicentino", "seichelense", "senegalês", "sérvio", "singapurense", "sírio", "somaliano, somali", "sri-lankês", "suázi", "sudanês", "sul-sudanês", "sueco", "suíço", "surinamês", "tajique", "tailandês", "tanzaniano", "timorense", "togolês", "tonganês", "trinitário", "tunisiano", "turcomeno", "turco", "tuvaluano", "ucraniano", "ugandês", "uruguaio", "uzbeque", "vanuatuense", "vaticano", "venezuelano", "vietnamita", "zambiano", "zimbabueano"}));
        this.contentPane.add(this.txtNacionalidade);
        JLabel lblNome = new JLabel("NOME");
        lblNome.setBounds(562, 119, 253, 14);
        lblNome.setForeground(SystemColor.textInactiveText);
        lblNome.setFont(new Font("Roboto Black", 0, 18));
        this.contentPane.add(lblNome);
        JLabel lblSobrenome = new JLabel("SOBRENOME");
        lblSobrenome.setBounds(560, 189, 255, 14);
        lblSobrenome.setForeground(SystemColor.textInactiveText);
        lblSobrenome.setFont(new Font("Roboto Black", 0, 18));
        this.contentPane.add(lblSobrenome);
        JLabel lblDataN = new JLabel("DATA DE NASCIMENTO");
        lblDataN.setBounds(560, 256, 255, 14);
        lblDataN.setForeground(SystemColor.textInactiveText);
        lblDataN.setFont(new Font("Roboto Black", 0, 18));
        this.contentPane.add(lblDataN);
        JLabel lblNacionalidade = new JLabel("NACIONALIDADE");
        lblNacionalidade.setBounds(560, 326, 255, 14);
        lblNacionalidade.setForeground(SystemColor.textInactiveText);
        lblNacionalidade.setFont(new Font("Roboto Black", 0, 18));
        this.contentPane.add(lblNacionalidade);
        JLabel lblTelefone = new JLabel("TELEFONE");
        lblTelefone.setBounds(562, 406, 253, 14);
        lblTelefone.setForeground(SystemColor.textInactiveText);
        lblTelefone.setFont(new Font("Roboto Black", 0, 18));
        this.contentPane.add(lblTelefone);
        this.txtTelefone = new JTextField();
        this.txtTelefone.setFont(new Font("Roboto", 0, 16));
        this.txtTelefone.setBounds(560, 424, 285, 33);
        this.txtTelefone.setColumns(10);
        this.txtTelefone.setBackground(Color.WHITE);
        this.txtTelefone.setBorder(BorderFactory.createEmptyBorder());
        this.contentPane.add(this.txtTelefone);
        JLabel lblTitulo = new JLabel("REGISTRO HÓSPEDE");
        lblTitulo.setBounds(606, 55, 234, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto Black", 0, 23));
        this.contentPane.add(lblTitulo);
        JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
        lblNumeroReserva.setBounds(560, 474, 253, 14);
        lblNumeroReserva.setForeground(SystemColor.textInactiveText);
        lblNumeroReserva.setFont(new Font("Roboto Black", 0, 18));
        this.contentPane.add(lblNumeroReserva);
        this.txtNreserva = new JTextField();
        this.txtNreserva.setFont(new Font("Roboto", 0, 16));
        this.txtNreserva.setBounds(560, 495, 285, 33);
        this.txtNreserva.setColumns(10);
        this.txtNreserva.setBackground(Color.WHITE);
        this.txtNreserva.setBorder(BorderFactory.createEmptyBorder());
        this.contentPane.add(this.txtNreserva);
        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(560, 170, 289, 2);
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        this.contentPane.add(separator_1_2);
        JSeparator separator_1_2_1 = new JSeparator();
        separator_1_2_1.setBounds(560, 240, 289, 2);
        separator_1_2_1.setForeground(new Color(12, 138, 199));
        separator_1_2_1.setBackground(new Color(12, 138, 199));
        this.contentPane.add(separator_1_2_1);
        JSeparator separator_1_2_2 = new JSeparator();
        separator_1_2_2.setBounds(560, 314, 289, 2);
        separator_1_2_2.setForeground(new Color(12, 138, 199));
        separator_1_2_2.setBackground(new Color(12, 138, 199));
        this.contentPane.add(separator_1_2_2);
        JSeparator separator_1_2_3 = new JSeparator();
        separator_1_2_3.setBounds(560, 386, 289, 2);
        separator_1_2_3.setForeground(new Color(12, 138, 199));
        separator_1_2_3.setBackground(new Color(12, 138, 199));
        this.contentPane.add(separator_1_2_3);
        JSeparator separator_1_2_4 = new JSeparator();
        separator_1_2_4.setBounds(560, 457, 289, 2);
        separator_1_2_4.setForeground(new Color(12, 138, 199));
        separator_1_2_4.setBackground(new Color(12, 138, 199));
        this.contentPane.add(separator_1_2_4);
        JSeparator separator_1_2_5 = new JSeparator();
        separator_1_2_5.setBounds(560, 529, 289, 2);
        separator_1_2_5.setForeground(new Color(12, 138, 199));
        separator_1_2_5.setBackground(new Color(12, 138, 199));
        this.contentPane.add(separator_1_2_5);
        JPanel btnsalvar = new JPanel();
        btnsalvar.setBounds(723, 560, 122, 35);
        btnsalvar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnsalvar.setLayout((LayoutManager)null);
        btnsalvar.setBackground(new Color(12, 138, 199));
        this.contentPane.add(btnsalvar);
        btnsalvar.setCursor(new Cursor(12));
        JLabel labelSalvar = new JLabel("SALVAR");
        labelSalvar.setHorizontalAlignment(0);
        labelSalvar.setForeground(Color.WHITE);
        labelSalvar.setFont(new Font("Roboto", 0, 18));
        labelSalvar.setBounds(0, 0, 122, 35);
        btnsalvar.add(labelSalvar);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 489, 634);
        panel.setBackground(new Color(12, 138, 199));
        this.contentPane.add(panel);
        panel.setLayout((LayoutManager)null);
        JLabel imageFundo = new JLabel("");
        imageFundo.setBounds(0, 121, 479, 502);
        panel.add(imageFundo);
        //imageFundo.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagenes/registro.png")));
        JLabel logo = new JLabel("");
        logo.setBounds(194, 39, 104, 107);
        panel.add(logo);
        //logo.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagenes/Ha-100px.png")));
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
