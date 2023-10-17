package com.example.demo.repositorio;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecaRepository extends JpaRepository<Peca, Long> {

}
