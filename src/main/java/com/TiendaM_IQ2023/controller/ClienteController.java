package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.cliente;
import com.TiendaM_IQ2023.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {
    
     @Autowired
    ClienteService clienteService;

     @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();
        
        var limiteTotal=0;
        for (var c: clientes) {
            limiteTotal+=c.getCredito().getLimite();
        }
        model.addAttribute("limiteTotal",limiteTotal);
        model.addAttribute("totalClientes",clientes.size());
        
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(cliente cliente, Model model) {
        cliente=clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    
    }
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(cliente cliente){
        clienteService.delete(cliente);
            return "redirect:/cliente/listado";
    }
    
//    @GetMapping("/cliente/buscar")
//    public String buscar(cliente cliente){
//        return "/cliente/buscarCliente";
//    }
//    
//    @PostMapping("/cliente/busqueda")
//    public String busqueda(cliente cliente, Model model){
//        var clientes = clienteService.getClientePorNombre(cliente.getNombre());
//        model.addAttribute("resultados", clientes);
//        return "/cliente/buscarCliente/";
//        
//        
//    }
    
    
    
    
    
}
