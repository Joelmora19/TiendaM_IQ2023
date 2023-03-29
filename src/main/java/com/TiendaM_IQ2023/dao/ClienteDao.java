package com.TiendaM_IQ2023.dao;

import org.springframework.data.repository.CrudRepository;
import com.TiendaM_IQ2023.domain.cliente;
import java.util.List;

public interface ClienteDao extends CrudRepository<cliente, Long> {
     
//    public List<cliente>findByNombre(String nombre);
//    
//    public List<cliente>findByTelefono(String telefono);
//    
//    public List<cliente>findByNombreandApellidosOrTelefono(String nombre, String apellidos, String telefono);

}
