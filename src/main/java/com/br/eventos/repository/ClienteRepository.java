package com.br.eventos.repository;

import com.br.eventos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findAll();
    public Cliente findByNome(String nome);
    public Cliente findByEmail(String email);
    public Cliente findByCpf(String cpf);

}
