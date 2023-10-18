package com.example.demo;

import com.example.demo.dominio.*;
import com.example.demo.repositorio.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;
    private final ObservacaoRepository observacaoRepository;
    private final PecaRepository pecaRepository;
    private final ServicoRepository servicoRepository;
    private final OrdemDeServicoRepository ordemDeServicoRepository;

    @Autowired
    public DataInitializer(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository,
                           ObservacaoRepository observacaoRepository, PecaRepository pecaRepository,
                           ServicoRepository servicoRepository, OrdemDeServicoRepository ordemDeServicoRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
        this.observacaoRepository = observacaoRepository;
        this.pecaRepository = pecaRepository;
        this.servicoRepository = servicoRepository;
        this.ordemDeServicoRepository = ordemDeServicoRepository;
    }

    @PostConstruct
    public void init() {
        // Inicializa dados para a classe Cliente
        Cliente cliente1Joao = new Cliente("João", "joao@email.com", "11 96732-8989");
        Cliente cliente2Maria = new Cliente("Maria", "maria@email.com", "11 94567-3259");
        Cliente cliente3Pedro = new Cliente("Pedro", "pedro@email.com", "21 98752-7621");
        clienteRepository.save(cliente1Joao);
        clienteRepository.save(cliente2Maria);
        clienteRepository.save(cliente3Pedro);

        // Inicializa dados para a classe Veiculo
        Veiculo veiculo1DoJoao = new Veiculo(cliente1Joao,"joao@email.com", "Toyota", "Corolla", 2018);
        Veiculo veiculo1DaMaria = new Veiculo(cliente2Maria,"maria@email.com", "Ford", "Fiesta", 2015);
        Veiculo veiculo1DoPedro = new Veiculo(cliente3Pedro,"pedro@email.com", "Honda", "Civic", 2020);
        Veiculo veiculo2DoJoao = new Veiculo(cliente1Joao,"joao@email.com", "Hyundai", "Hb-20", 2022);
        Veiculo veiculo3DoJoao = new Veiculo(cliente1Joao,"joao@email.com", "Renault", "Clio", 2018);
        Veiculo veiculo2DaMaria = new Veiculo(cliente3Pedro,"pedro@email.com", "BMW", "118i", 2020);
        veiculoRepository.save(veiculo1DoJoao);
        veiculoRepository.save(veiculo1DaMaria);
        veiculoRepository.save(veiculo1DoPedro);
        veiculoRepository.save(veiculo2DoJoao);
        veiculoRepository.save(veiculo3DoJoao);
        veiculoRepository.save(veiculo2DaMaria);

        // Inicializa dados para a classe observação
        Observacao observacaoVeiculo1DoJoao = new Observacao(veiculo1DoJoao, "Trocar filtro de óleo",
                LocalDateTime.now());
        Observacao observacaoVeiculo1DaMaria = new Observacao(veiculo1DaMaria, "Problemas no câmbio",
                LocalDateTime.now());
        Observacao observacaoVeiculo1DoPedro = new Observacao(veiculo1DoPedro, "Bateria ruim",
                LocalDateTime.now());
        Observacao observacaoVeiculo2DoJoao = new Observacao(veiculo2DoJoao, "Correia dentada com muito uso",
                LocalDateTime.now());
        observacaoRepository.save(observacaoVeiculo1DoJoao);
        observacaoRepository.save(observacaoVeiculo1DaMaria);
        observacaoRepository.save(observacaoVeiculo1DoPedro);
        observacaoRepository.save(observacaoVeiculo2DoJoao);

        // Inicializa dados para a classe Peca
        Peca pecaDoVeiculo1DoJoao = new Peca("Filtro Óleo Toyota Corolla 1.8 2.0 2011 A 2019 Tecfil",
                "Filtro de óleo para troca em um Toyota Corolla", 13.0);

        Peca pecaDoVeiculo1DaMaria = new Peca("Caixa Câmbio Manual Ford New Fiesta 1.6 2011 À 2015",
                "Câmbio Manual para um ford Fiesta", 1700.0);

        Peca pecaDoVeiculo1DoPedro = new Peca("Bateria M50JR Lxs 1.8 Flex",
                "Bateria para um Honda Civic", 550.0);

        Peca pecaDoVeiculo2DoJoao = new Peca("Kit Correias Alternador Acessórios Hyundai Hb20 1.0 Original",
                "Kit de Correias Alternador Acessórios para um Hyundai Hb20", 400.0);
        pecaRepository.save(pecaDoVeiculo1DoJoao);
        pecaRepository.save(pecaDoVeiculo1DaMaria);
        pecaRepository.save(pecaDoVeiculo1DoPedro);
        pecaRepository.save(pecaDoVeiculo2DoJoao);

        // Inicializa dados para a classe Serviço
        Servico servicoDoVeiculo1DoJoao = new Servico("Troca do filtro",
                "Serviço da troca do filtro de óleo do veiculo 1 do João, um Corolla");
        Servico servicoDoVeiculo1DaMaria = new Servico("Caixa de câmbio",
                "Serviço da troca da caixa de câmbio do veiculo da Maria, um Fiesta");
        Servico servicoDoVeiculo1DoPedro = new Servico("Troca de bateria",
                "Serviço da troca de bateria do veiculo 1 do Pedro, um Civic");
        Servico servicoDoVeiculo2DoJoao = new Servico("Troca de correias",
                "Serviço da troca de correias do veiculo 2 do João, um Hb-20");
        servicoRepository.save(servicoDoVeiculo1DoJoao);
        servicoRepository.save(servicoDoVeiculo1DaMaria);
        servicoRepository.save(servicoDoVeiculo1DoPedro);
        servicoRepository.save(servicoDoVeiculo2DoJoao);

        // Inicializa dados para a classe Ordem de Serviço
        OrdemDeServico ordemDeServicoDoVeiculo1DoJoao = new OrdemDeServico(veiculo1DoJoao, servicoDoVeiculo1DoJoao,
                pecaDoVeiculo1DoJoao, "Sem problemas", LocalDateTime.now(), true);
        OrdemDeServico ordemDeServicoDoVeiculo1DaMaria = new OrdemDeServico(veiculo1DaMaria, servicoDoVeiculo1DaMaria,
                pecaDoVeiculo1DaMaria, "Sem problemas", LocalDateTime.now(), true);
        OrdemDeServico ordemDeServicoDoVeiculo1DoPedro = new OrdemDeServico(veiculo1DoPedro, servicoDoVeiculo1DoPedro,
                pecaDoVeiculo1DoPedro, "Sem problemas", LocalDateTime.now(), true);
        OrdemDeServico ordemDeServicoDoVeiculo2DoJoao = new OrdemDeServico(veiculo2DoJoao, servicoDoVeiculo2DoJoao,
                pecaDoVeiculo2DoJoao, "Sem problemas", LocalDateTime.now(), true);
        ordemDeServicoRepository.save(ordemDeServicoDoVeiculo1DoJoao);
        ordemDeServicoRepository.save(ordemDeServicoDoVeiculo1DaMaria);
        ordemDeServicoRepository.save(ordemDeServicoDoVeiculo1DoPedro);
        ordemDeServicoRepository.save(ordemDeServicoDoVeiculo2DoJoao);

    }
}
