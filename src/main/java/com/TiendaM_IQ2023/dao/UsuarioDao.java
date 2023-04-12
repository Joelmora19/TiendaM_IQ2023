package com.TiendaM_IQ2023.dao;

import com.TiendaM_IQ2023.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

    Usuario finByUsername(String username);

    public Usuario findByUsername(String username);
}
