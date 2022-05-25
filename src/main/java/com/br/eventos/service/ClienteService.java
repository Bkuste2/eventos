package com.br.eventos.service;

import com.br.eventos.model.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public Cliente findByNome(String nome);
    public Cliente findByEmail(String email);
    public Cliente findByCpf(String cpf);
    public Cliente save(Cliente cliente);

}
