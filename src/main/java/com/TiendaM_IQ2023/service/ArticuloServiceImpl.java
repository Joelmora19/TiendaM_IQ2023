package com.TiendaM_IQ2023.service;
import com.TiendaM_IQ2023.dao.ArticuloDao;
import com.TiendaM_IQ2023.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    ArticuloDao articuloDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
      List<Articulo> lista = (List<Articulo>) articuloDao.findAll();    //4=3A y 1i
      
      if(activos){
          lista.removeIf(e -> !e.isActivo());   //tambien puede ser asi  lista.removeIf(e -> e.isActivo() == false); 
      }
          return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }
}