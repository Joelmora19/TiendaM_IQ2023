package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.dao.ClienteDao;
import com.TiendaM_IQ2023.domain.cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    ClienteDao clienteDao;
    @GetMapping("/")
    public String inicio(Model model) {
//        log.info("Ahora desde MVC");
//        model.addAttribute("Mensaje", "Hola desde el controlador");
//        
//        cliente cliente = new cliente("Joel", "Mora Quesada", "moraquesaa09@gmail.com", "85344422");
//        model.addAttribute("objetoCliente", cliente);
//        
//        cliente cliente2 = new cliente("Juan","brenes Mora", "moraquesaa09@gmail.com", "85344422");
//        
//        cliente cliente3 = new cliente("Juan","brenes Mora", "moraquesaa09@gmail.com", "85344422");
        
//        List<cliente>clientes = Arrays.asList(cliente, cliente2, cliente3);
        
        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        
        return "index";
    }

}
