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
        Cliente cliente1 = new Cliente("João", "joao@email.com", "11 96732-8989");
        Cliente cliente2 = new Cliente("Maria", "maria@email.com", "11 94567-3259");
        Cliente cliente3 = new Cliente("Pedro", "pedro@email.com", "21 98752-7621");
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        // Inicializa dados para a entidade Veiculo
        Veiculo veiculo1Joao = new Veiculo(cliente1,"joao@email.com", "Toyota", "Corolla", 2018);
        Veiculo veiculo2Maria = new Veiculo(cliente2,"maria@email.com", "Ford", "Fiesta", 2017);
        Veiculo veiculo3Pedro = new Veiculo(cliente3,"pedro@email.com", "Honda", "Civic", 2020);
        Veiculo veiculo4Joao = new Veiculo(cliente3,"joao@email.com", "Hyundai", "Hb-20", 2022);
        Veiculo veiculo5Joao = new Veiculo(cliente3,"joao@email.com", "Renault", "Clio", 2018);
        Veiculo veiculo6Maria = new Veiculo(cliente3,"pedro@email.com", "BMW", "118i", 2020);
        veiculoRepository.save(veiculo1Joao);
        veiculoRepository.save(veiculo2Maria);
        veiculoRepository.save(veiculo3Pedro);
        veiculoRepository.save(veiculo4Joao);
        veiculoRepository.save(veiculo5Joao);
        veiculoRepository.save(veiculo6Maria);

        // Adicione mais inserções conforme necessário para outras entidades
    }
}
