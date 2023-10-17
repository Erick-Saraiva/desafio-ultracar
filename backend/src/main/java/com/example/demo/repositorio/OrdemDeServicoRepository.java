package com.example.demo.repositorio;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long> {

}
