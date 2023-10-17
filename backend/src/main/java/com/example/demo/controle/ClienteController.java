package com.example.demo.controle;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.Veiculo;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(clientes);

    }

    @GetMapping("/verificar-cliente/{email}")
    public ResponseEntity<String> verificarCliente(@PathVariable String email) {
        Boolean emailCliente = clienteRepository.existsByEmail(email);
        if (emailCliente) {
            return ResponseEntity.status(200)
                    .body("Email cadastrado, seguindo para a próxima página.");
        } else {
            return ResponseEntity.status(404)
                    .body("Email não cadastrado!");
        }
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

}
