package com.example.demo;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.Veiculo;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.VeiculoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;

    @Autowired
    public DataInitializer(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
    }

    @PostConstruct
    public void init() {
        // Inicializa dados para a entidade Cliente
        Cliente cliente1 = new Cliente("João", "joao@example.com", "11 96732-8989");
        Cliente cliente2 = new Cliente("Maria", "maria@example.com", "11 94567-3259");
        Cliente cliente3 = new Cliente("Pedro", "pedro@example.com", "21 98752-7621");
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        // Inicializa dados para a entidade Veiculo
        Veiculo veiculo1 = new Veiculo(cliente1,"joao@example.com", "Toyota", "Corolla", 2018);
        Veiculo veiculo2 = new Veiculo(cliente2,"maria@example.com", "Ford", "Fiesta", 2019);
        Veiculo veiculo3 = new Veiculo(cliente3,"pedro@example.com", "Honda", "Civic", 2020);
        veiculoRepository.save(veiculo1);
        veiculoRepository.save(veiculo2);
        veiculoRepository.save(veiculo3);

        // Adicione mais inserções conforme necessário para outras entidades
    }
}
