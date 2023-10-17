package com.example.demo.repositorio;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
