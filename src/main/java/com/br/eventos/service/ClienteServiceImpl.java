package com.br.eventos.service;

import com.br.eventos.model.Cliente;
import com.br.eventos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll(Sort.by("id"));
    }

    @Override
    public Cliente findById(Long id) {
        Optional clienteList = clienteRepository.findById(id);
        if (!clienteList.isEmpty()){
            return (Cliente) clienteList.get();
        }
        else{
            return new Cliente();
        }
    }

    @Override
    public Cliente findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Override
    public Cliente findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
