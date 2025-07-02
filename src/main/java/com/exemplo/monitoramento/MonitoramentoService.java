package com.exemplo.monitoramento;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MonitoramentoService {
    private static final Logger logger = LoggerFactory.getLogger(MonitoramentoService.class);

    private Map<String, String> ultimoStatus = new HashMap<>();

    private final List<String> servidores = Arrays.asList(
        "https://www.google.com",
        "https://www.github.com",
        "http://localhost:8080"
    );

    @Scheduled(fixedDelay = 60000) // a cada 60 segundos
    public void atualizarStatus() {
        logger.info("Iniciando monitoramento dos servidores...");
        Map<String, String> statusAtual = new HashMap<>();
        for (String url : servidores) {
            try {
                logger.debug("Checando servidor: " + url);
                long start = System.currentTimeMillis();
                HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(5000);
                con.setReadTimeout(5000);
                int responseCode = con.getResponseCode();
                long elapsed = System.currentTimeMillis() - start;
                if (responseCode >= 200 && responseCode < 300) {
                    statusAtual.put(url, "OK - " + elapsed + "ms");
                } else {
                    statusAtual.put(url, "ERRO HTTP " + responseCode);
                }
            } catch (Exception e) {
                logger.error("Erro ao checar " + url, e);
                statusAtual.put(url, "ERRO - " + e.getMessage());
            }
        }
        ultimoStatus = statusAtual;
        logger.info("Monitoramento concluído.");
    }

    public Map<String, String> getUltimoStatus() {
        return ultimoStatus;
    }
}
