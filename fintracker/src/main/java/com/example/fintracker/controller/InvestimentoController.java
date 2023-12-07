package com.example.fintracker.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {

    @GetMapping("/bitcoin")
    public String calcularBitcoinInvestimento(@RequestParam double valorEntrada) {
        BitcoinInvestimento bitcoinInvestimento = new BitcoinInvestimento();
        return bitcoinInvestimento.calcularEstimativaLucro(valorEntrada);
    }

    @GetMapping("/bolsa")
    public String calcularBolsaDeValoresInvestimento(@RequestParam double valorEntrada) {
        BolsaDeValoresInvestimento bolsaDeValoresInvestimento = new BolsaDeValoresInvestimento();
        return bolsaDeValoresInvestimento.calcularEstimativaLucro(valorEntrada);
    }

    @GetMapping("/poupanca")
    public String calcularPoupancaInvestimento(@RequestParam double valorEntrada) {
        PoupancaInvestimento poupancaInvestimento = new PoupancaInvestimento();
        return poupancaInvestimento.calcularEstimativaLucro(valorEntrada);
    }
}

abstract class InvestimentoTemplate {

    protected abstract double calcularLucroMaximo(double valorEntrada);

    protected abstract double calcularPerdaMaxima(double valorEntrada);

    protected abstract String calcularRisco(double valorEntrada);

    public final String calcularEstimativaLucro(double valorEntrada) {
        double lucroMaximo = calcularLucroMaximo(valorEntrada);
        double perdaMaxima = calcularPerdaMaxima(valorEntrada);
        String risco = calcularRisco(valorEntrada);

        // Saída formatada
        return "{ \"entrada\": " + valorEntrada +
                ", \"lucro maximo\": " + lucroMaximo +
                ", \"perda maxima\": " + perdaMaxima +
                ", \"risco\": \"" + risco + "\" }";
    }
}

class BitcoinInvestimento extends InvestimentoTemplate {

    @Override
    protected double calcularLucroMaximo(double valorEntrada) {
        return 3 * valorEntrada;
    }

    @Override
    protected double calcularPerdaMaxima(double valorEntrada) {
        return 0.8 * valorEntrada;
    }

    @Override
    protected String calcularRisco(double valorEntrada) {
        return "alto";
    }
}

class BolsaDeValoresInvestimento extends InvestimentoTemplate {

    @Override
    protected double calcularLucroMaximo(double valorEntrada) {
        return 2 * valorEntrada;
    }

    @Override
    protected double calcularPerdaMaxima(double valorEntrada) {
        return 0.5 * valorEntrada;
    }

    @Override
    protected String calcularRisco(double valorEntrada) {
        return "baixo";
    }
}

class PoupancaInvestimento extends InvestimentoTemplate {

    @Override
    protected double calcularLucroMaximo(double valorEntrada) {
        return 0.1 * valorEntrada;
    }

    @Override
    protected double calcularPerdaMaxima(double valorEntrada) {
        return 0.0;
    }

    @Override
    protected String calcularRisco(double valorEntrada) {
        return "inexistente";
    }
}
