package com.exemplo.monitoramento;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoramentoController {

    @Autowired
    private MonitoramentoService monitoramentoService;

    @GetMapping("/status")
    public Map<String, String> statusServidores() {
        return monitoramentoService.getUltimoStatus();
    }
}
