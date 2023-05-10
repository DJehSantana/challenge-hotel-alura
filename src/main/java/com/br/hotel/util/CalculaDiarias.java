package com.br.hotel.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class CalculaDiarias {
    public BigDecimal calcularValorTotal(Date dataEntrada, Date dataSaida, BigDecimal valorDiaria) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEntrada);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(dataSaida);

        int diaEntrada = calendar.get(Calendar.DAY_OF_MONTH);
        int diaSaida = calendar1.get(Calendar.DAY_OF_MONTH);
        int diarias = diaSaida - diaEntrada;

        BigDecimal valorTotal = valorDiaria.multiply(new BigDecimal(diarias));

        return valorTotal;
    }
}
