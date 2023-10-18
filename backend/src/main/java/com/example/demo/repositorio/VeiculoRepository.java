package com.example.demo.repositorio;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findAllByEmail(String email);

    List<Veiculo> findAllById(Long idVeiculo);
}
