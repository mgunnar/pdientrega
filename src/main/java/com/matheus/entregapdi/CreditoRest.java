package com.matheus.entregapdi;

import com.matheus.entregapdi.model.Cliente;
import com.matheus.entregapdi.model.Compra;
import com.matheus.entregapdi.model.dto.ClienteRequestDTO;
import com.matheus.entregapdi.model.dto.CompraRequestDTO;
import com.matheus.entregapdi.service.ClienteService;
import com.matheus.entregapdi.service.TransacoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Credito", description = "API - Credito")
@RequestMapping(path = CreditoRest.BASE_URL)
public class CreditoRest {
    protected static final String BASE_URL = "/v1/credito";
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditoRest.class);
    private final ClienteService clienteService;

    private final TransacoesService transacoesService;

    public CreditoRest(ClienteService clienteService, TransacoesService transacoesService) {
        this.clienteService = clienteService;
        this.transacoesService = transacoesService;
    }

    @Operation(summary = "Buscar todos os clientes.", description = "Retorna todos os clientes cadastrados.")
    @GetMapping("/clientes/buscar-todos")
    public ResponseEntity<List<Cliente>> buscarTodosClientes() {

        var path = "GET " + "/v1/clientes/buscar-todos";

        LOGGER.info("Path: {}", path);

        var response = clienteService.buscarTodos();

        LOGGER.info("Response {} -> {}", path, response);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cadastrar novo cliente.", description = "Cadastra um novo cliente")
    @PostMapping("/clientes/cadastrar")
    public ResponseEntity<Cliente> cadastrarNovoCliente(@RequestBody ClienteRequestDTO cliente) {

        var path = "POST " + "/v1/clientes/cadastrar";

        LOGGER.info("Path: {}", path);

        // Cria uma nova instância de Cliente com os valores recebidos na solicitação
        var novoCliente = new Cliente();

        novoCliente.setNome(cliente.getNome());
        novoCliente.setTipoCliente(cliente.getTipoCliente());

        var clienteSalvo = clienteService.salvar(novoCliente);

        LOGGER.info("Response {} -> {}", path, clienteSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }
}
