package com.example.demo.repositorio;

import com.example.demo.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Boolean existsByEmail(String email);
}
