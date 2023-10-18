package com.example.demo.repositorio;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.OrdemDeServico;
import com.example.demo.dominio.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long> {
    List<OrdemDeServico> findAllByVeiculo(Veiculo veiculo);
}
