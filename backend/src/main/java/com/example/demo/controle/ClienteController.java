package com.example.demo.controle;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.OrdemDeServico;
import com.example.demo.dominio.Veiculo;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.OrdemDeServicoRepository;
import com.example.demo.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private OrdemDeServicoRepository ordemDeServicoRepository;

    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(clientes);

    }

    @GetMapping("/buscar-veiculos/{email}")
    public ResponseEntity<List<Veiculo>> buscarVeiculos(@PathVariable String email) {
        Boolean emailCliente = clienteRepository.existsByEmail(email);

        if (emailCliente) {
            List<Veiculo> veiculosDoCliente = veiculoRepository.findAllByEmail(email);
            return ResponseEntity.status(200)
                    .body(veiculosDoCliente);
        } else {
            return ResponseEntity.status(404)
                    .build();
        }
    }

    @GetMapping("/gerar-relatorio/{idVeiculo}")
    public ResponseEntity<String> gerarRelatorio(@PathVariable Long idVeiculo) {
        List<Veiculo> veiculosDoCliente = veiculoRepository.findAllById(idVeiculo);

        if (!veiculosDoCliente.isEmpty()) {
            for (Veiculo veiculo: veiculosDoCliente) {
                List<OrdemDeServico> servicos = ordemDeServicoRepository.findAllByVeiculo(veiculo);
                return ResponseEntity.status(200).body(servicos.toString());
            }
        }
        return ResponseEntity.status(404).body("Não temos nenhum relatório ou problema nesse carro.");
    }
}
