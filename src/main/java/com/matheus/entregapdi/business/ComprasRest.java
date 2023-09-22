package com.matheus.entregapdi.business;

import com.matheus.entregapdi.model.Compra;
import com.matheus.entregapdi.model.dto.CompraRequestDTO;
import com.matheus.entregapdi.business.service.ClienteService;
import com.matheus.entregapdi.business.service.TransacoesService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = ComprasRest.BASE_URI)
@Slf4j
public class ComprasRest {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TransacoesService transacoesService;

    public static final String BASE_URI = "/v1";

    @Operation(summary = "Registra uma nova compra.", description = "Salva uma nova compra no banco de dados.")
    @PostMapping("/compras/registrar")
    public ResponseEntity<Compra> cadastrarNovaCompra(@RequestBody CompraRequestDTO compra) {

        var path = "POST " + "/v1/compras/registrar";

        log.info("Path: {}", path);

        var novaCompra = new Compra();


        novaCompra.setClienteId(compra.getClienteId());
        novaCompra.setValorTotalCompra(compra.getValorTotalCompra());
        novaCompra.setHoraTransacao(Timestamp.valueOf(LocalDateTime.now()));

        var cliente = clienteService.buscarPorId(compra.getClienteId());

        if (cliente.isEmpty()) {
            log.info("Cliente com ID {} não encontrado.", compra.getClienteId());
            return ResponseEntity.notFound().build();
        }

        var compraRegistrada =  transacoesService.comprar(cliente.get(), novaCompra.getValorTotalCompra());

        log.info("Response {} -> {}", path, compraRegistrada);

        return ResponseEntity.status(HttpStatus.CREATED).body(compraRegistrada);
    }

    @Operation(summary = "Buscar todas as compras.", description = "Retorna as compras registradas.")
    @GetMapping("/compras/buscar/buscar-todos")
    public ResponseEntity<List<Compra>> buscarTodasCompras() {

        var path = "GET " + "/v1/compras/buscar/buscar-todos";

        log.info("Path: {}", path);

        var response = transacoesService.buscarTodasAsTransacoes();

        log.info("Response {} -> {}", path, response);

        return ResponseEntity.ok(response);
    }
}
