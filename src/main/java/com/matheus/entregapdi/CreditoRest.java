package com.matheus.entregapdi;

import com.matheus.entregapdi.model.Cliente;
import com.matheus.entregapdi.model.dto.ClienteRequestDTO;
import com.matheus.entregapdi.business.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@Tag(name = "Credito", description = "API - Clientes e Crédito")
@RequestMapping(path = CreditoRest.BASE_URL)
public class CreditoRest {
    protected static final String BASE_URL = "/v1/credito";
    private ClienteService clienteService;

    @Operation(summary = "Buscar todos os clientes.", description = "Retorna todos os clientes cadastrados.")
    @GetMapping("/clientes/buscar/buscar-todos")
    public ResponseEntity<List<Cliente>> buscarTodosClientes() {

        var path = "GET " + "/v1/clientes/buscar-todos";

//        log.info("Path: {}", path);

        var response = clienteService.buscarTodos();

//        log.info("Response {} -> {}", path, response);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cadastrar novo cliente.", description = "Cadastra um novo cliente")
    @PostMapping("/clientes/cadastrar")
    public ResponseEntity<Cliente> cadastrarNovoCliente(@RequestBody ClienteRequestDTO cliente) {

        var path = "POST " + "/v1/clientes/cadastrar";

//        log.info("Path: {}", path);

        var novoCliente = new Cliente();

        novoCliente.setNome(cliente.nome());
        novoCliente.setTipoCliente(cliente.tipoCliente());
        novoCliente.setLimiteDeCreditoDisponivel(cliente.tipoCliente().getLimiteCreditoInicial());

        var clienteSalvo = clienteService.salvar(novoCliente);

//        log.info("Response {} -> {}", path, clienteSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);

    }

    @Operation(summary = "Buscar um cliente por ID", description = "Busca um cliente por ID inserido.")
    @GetMapping("/clientes/buscar/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") Long id) {
        var path = "GET " + "/v1/clientes/" + id;



//        log.info("Path: {}", path);

        var cliente = clienteService.buscarPorId(id);

        if (cliente.isEmpty()) {
//            log.info("Cliente com ID {} não encontrado.", id);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente.get());
    }
}
