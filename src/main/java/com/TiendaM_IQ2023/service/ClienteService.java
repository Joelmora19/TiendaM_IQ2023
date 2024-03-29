package com.TiendaM_IQ2023.service;

import com.TiendaM_IQ2023.domain.cliente;
import java.util.List;

public interface ClienteService {

    public List<cliente> getClientes();
    
    public cliente getCliente(cliente cliente);
    
    public void save(cliente cliente); // para insertar o modificar(Si viene el idCliente o no)
    
    public void delete(cliente cliente);
    
//    public List<cliente> getClientePorNombre(String nombre);
//    
//    public List<cliente> getClientePorTelefono(String telefono);
//    
//    public List<cliente> getClientePorNombreApellidosTelefono(String nombre, String Apellidos, String telefono);
    
}
