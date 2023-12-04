package com.example.fintracker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//IMPLEMENTAR o ADAPTER
//IMPLEMENTAR TEMPLATE METHOD COM MOEDAS DIFERENTES
@RestController
@RequestMapping("/bitcoin-price")
public class BitCoinController {

    @Value("${coin.gecko.api.url}")
    private String coinGeckoApiUrl;

    @GetMapping
    public ResponseEntity<String> getBitcoinPrice() {
        // O endpoint da API CoinGecko para o preço atual do Bitcoin em USD
        String apiUrl = coinGeckoApiUrl + "/simple/price?ids=bitcoin&vs_currencies=usd";

        // Use RestTemplate para fazer uma solicitação GET à API
        RestTemplate restTemplate = new RestTemplate();
        String bitcoinPrice = restTemplate.getForObject(apiUrl, String.class);

        return ResponseEntity.ok(bitcoinPrice);
    }
}
