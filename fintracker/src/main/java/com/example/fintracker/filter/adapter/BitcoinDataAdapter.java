package com.example.fintracker.filter.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BitcoinDataAdapter {

    public String adapt(String bitcoinInfo) {
        try {
            // Converte a string JSON para um objeto JsonNode usando Jackson ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(bitcoinInfo);

            // Adapta as informações conforme necessário
            String currentPriceUSD = jsonNode.path("market_data").path("current_price").path("usd").asText();
            String priceHistory = jsonNode.path("market_data").path("sparkline_7d").path("price").toString();

            // Constrói uma string com as informações adaptadas
            StringBuilder adaptedInfo = new StringBuilder();
            adaptedInfo.append("Preço Atual em USD: ").append(currentPriceUSD).append("\n");
            adaptedInfo.append("Histórico de Preços (últimos 7 dias): ").append(priceHistory);

            return adaptedInfo.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao processar as informações do Bitcoin.";
        }
    }
}
