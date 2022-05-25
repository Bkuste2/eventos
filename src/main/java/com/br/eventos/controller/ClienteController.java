package com.br.eventos.controller;

import com.br.eventos.model.Cliente;
import com.br.eventos.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/cliente/add")
    public String clienteAdd(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente/add";
    }

    @GetMapping("/cliente/list")
    public String clienteList(Model model){
        model.addAttribute("cliente", clienteService.findAll());
        return "/cliente/list";
    }

    @PostMapping("/cliente/save")
    public String save(Cliente cliente, Model model){
        try{
            clienteService.save(cliente);
            model.addAttribute("cliente", cliente);
            model.addAttribute("isSave", true);
            return "cliente/add";
        }catch (Exception e){
            model.addAttribute("cliente", cliente);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());

            return "cliente/add";
        }
    }
}
