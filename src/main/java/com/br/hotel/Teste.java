package com.br.hotel;

import com.br.hotel.dao.ClienteDao;
import com.br.hotel.dao.ReservaDao;
import com.br.hotel.dao.UsuarioDao;
import com.br.hotel.model.Cliente;
import com.br.hotel.model.Reserva;
import com.br.hotel.model.Usuario;
import com.br.hotel.util.FactoryUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.*;

public class Teste {

    public static void main(String[] args) {
        popularBanco();
        EntityManager em = FactoryUtil.getEntityManager();

        UsuarioDao usuarioDao = new UsuarioDao(em, Usuario.class);
        ReservaDao reservaDao = new ReservaDao(em, Reserva.class);
        Usuario usuarioCadastrado = cadastrarUsuario();

        boolean autenticado = usuarioDao.validarLogin(usuarioCadastrado.getLogin(), usuarioCadastrado.getSenha());

        System.out.println(reservaDao.findById(1l).getCliente().getReservas());
        System.out.println(autenticado);
    }

    public static void popularBanco() {
        cadastrarCliente("José", "da Silva", "17/06/1991", "argentina", "15987651234");
        cadastrarCliente("Jaqueline", "Mota", "14/05/1996", "brasileira", "1856789432");

        LocalDate dataEntrada = LocalDate.of(2023, 5, 12);
        LocalDate dataSaida = LocalDate.of(2023, 5, 15);
        BigDecimal valorDiaria = BigDecimal.valueOf(123.05);

        cadastrarReserva(dataEntrada, dataSaida, valorDiaria, "dinheiro");
    }

    public static void cadastrarCliente(String nome, String sobrenome, String dataNascimento, String nacionalidade, String telefone){
        EntityManager em = FactoryUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em, Cliente.class);

        Cliente cliente = new Cliente(nome, sobrenome, dataNascimento, nacionalidade, telefone);

        em.getTransaction().begin();
        clienteDao.create(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static Usuario  cadastrarUsuario() {
        EntityManager em = FactoryUtil.getEntityManager();
        UsuarioDao usuarioDao = new UsuarioDao(em, Usuario.class);

        Usuario usuario = new Usuario("admin", "admin");

        em.getTransaction().begin();
        usuarioDao.create(usuario);
        em.getTransaction().commit();
        em.close();

        return usuario;
    }

    public static void cadastrarReserva(LocalDate dataEntrada, LocalDate dataSaida, BigDecimal valorDiaria, String formaPagamento) {
        EntityManager em = FactoryUtil.getEntityManager();
        ReservaDao reservaDao = new ReservaDao(em, Reserva.class);
        ClienteDao clienteDao = new ClienteDao(em, Cliente.class);
        List<Cliente> clientes = clienteDao.findAll("SELECT c FROM Cliente c");

        Cliente cliente = clientes.get(1);

        int diaEntrada = dataEntrada.getDayOfMonth();
        int diaSaida = dataSaida.getDayOfMonth();
        int diarias = diaSaida - diaEntrada;
        BigDecimal valorTotal = valorDiaria.multiply(new BigDecimal(diarias));

        Reserva reserva = new Reserva(dataEntrada, dataSaida, valorTotal, formaPagamento);
        reserva.setCliente(cliente);

        em.getTransaction().begin();
        reservaDao.create(reserva);
        em.getTransaction().commit();
        em.close();
    }
}
