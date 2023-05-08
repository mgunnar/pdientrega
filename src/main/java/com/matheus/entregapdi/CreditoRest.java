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
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    @GetMapping("/clientes/buscar/buscar-todos")
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

        var novoCliente = new Cliente();

        novoCliente.setNome(cliente.getNome());
        novoCliente.setTipoCliente(cliente.getTipoCliente());
        novoCliente.setLimiteDeCreditoDisponivel(cliente.getTipoCliente().getLimiteCreditoInicial());

        var clienteSalvo = clienteService.salvar(novoCliente);

        LOGGER.info("Response {} -> {}", path, clienteSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);

    }

    @Operation(summary = "Buscar um cliente por ID", description = "Busca um cliente por ID inserido.")
    @GetMapping("/clientes/buscar/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") String id) {
        var path = "GET " + "/v1/clientes/" + id;

        LOGGER.info("Path: {}", path);

        var cliente = clienteService.buscarPorId(id);

        if (cliente == null) {
            LOGGER.info("Cliente com ID {} não encontrado.", id);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Excluir um cliente por ID", description = "Exclui um cliente por ID")
    @DeleteMapping("/clientes/apagar/{id}")
    public ResponseEntity excluirClientePorId(@PathVariable("id") String id) {
        var path = "DELETE " + "/v1/clientes/" + id;

        LOGGER.info("Path: {}", path);

        clienteService.apagar(id);

        LOGGER.info("Response {} -> NO CONTENT", path);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Registra uma nova compra.", description = "Salva uma nova compra no banco de dados.")
    @PostMapping("/compras/registrar")
    public ResponseEntity<Compra> cadastrarNovaCompra(@RequestBody CompraRequestDTO compra) {

        var path = "POST " + "/v1/compras/registrar";

        LOGGER.info("Path: {}", path);

        var novaCompra = new Compra();


        novaCompra.setClienteId(compra.getClienteId());
        novaCompra.setValorTotalCompra(compra.getValorTotalCompra());
        novaCompra.setHoraTransacao(Timestamp.valueOf(LocalDateTime.now()));
        var cliente = clienteService.buscarPorId(compra.getClienteId());

        if (cliente == null) {
            LOGGER.info("Cliente com ID {} não encontrado.", compra.getClienteId());
            return ResponseEntity.notFound().build();
        }

        var compraRegistrada =  transacoesService.comprar(cliente, novaCompra.getValorTotalCompra());;

        LOGGER.info("Response {} -> {}", path, compraRegistrada);

        return ResponseEntity.status(HttpStatus.CREATED).body(compraRegistrada);
    }

    @Operation(summary = "Buscar todas as compras.", description = "Retorna as compras registradas.")
    @GetMapping("/compras/buscar/buscar-todos")
    public ResponseEntity<List<Compra>> buscarTodasCompras() {

        var path = "GET " + "/v1/compras/buscar/buscar-todos";

        LOGGER.info("Path: {}", path);

        var response = transacoesService.buscarTodos();

        LOGGER.info("Response {} -> {}", path, response);

        return ResponseEntity.ok(response);
    }
}
