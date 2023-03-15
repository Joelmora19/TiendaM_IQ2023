package com.TiendaM_IQ2023.service;

import com.TiendaM_IQ2023.dao.ClienteDao;
import com.TiendaM_IQ2023.dao.CreditoDao;
import com.TiendaM_IQ2023.domain.Credito;
import com.TiendaM_IQ2023.domain.cliente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service    //Importante para que levante todos los metedos y tiene que ir en el lugar especifico
public class ClienteServiceimpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;
    @Autowired
    CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<cliente> getClientes() {
        return (List<cliente>) clienteDao.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public cliente getCliente(cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);  
        
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }

}
