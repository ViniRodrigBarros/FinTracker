package com.example.fintracker.controller;

import com.example.fintracker.filter.adapter.BitcoinDataAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bitcoin")
public class BitCoinController {

    @Value("${coin.gecko.api.url}")
    private String coinGeckoApiUrl;

    @GetMapping
    public ResponseEntity<String> getBitcoinInfo() {
        // O endpoint da API CoinGecko para informações detalhadas sobre o Bitcoin
        String apiUrl = coinGeckoApiUrl + "/coins/bitcoin";

        // Use RestTemplate para fazer uma solicitação GET à API
        RestTemplate restTemplate = new RestTemplate();
        String bitcoinInfo = restTemplate.getForObject(apiUrl, String.class);

        // Adaptar e filtrar as informações usando o Adapter
        BitcoinDataAdapter bitcoinDataAdapter = new BitcoinDataAdapter();
        String filteredInfo = bitcoinDataAdapter.adapt(bitcoinInfo);

        return ResponseEntity.ok(filteredInfo);
    }
}
