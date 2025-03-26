package com.actividad.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;  // Importación correcta de Pageable
import org.springframework.stereotype.Component;

import com.actividad.demo.excepciones.NaveExcepciones;
import com.actividad.demo.model.Nave;
import com.actividad.demo.repository.NaveRepository;






@Component
public class NaveService {


    @Autowired
    private NaveRepository naveRepository;



    //Añadir Nave
    public Nave añadirNave(Nave nave){
       
        if (nave.getNave().isEmpty()) {
            throw new NaveExcepciones("El nombre de la nave no puede estar vacio");
        }
        return naveRepository.save(nave);

    }


   
    //Listar Naves Sin Paginación
/* 
    public List<Nave> ListaNaves(){
        return naveRepository.findAll();

    }
*/


    //Listar Naves + Paginación
    public Page<Nave> listaNaves(Pageable pageable) {
        Page<Nave> nave = naveRepository.findAll(pageable);

        if (nave == null || nave.isEmpty()) {
            throw new NaveExcepciones("La lista de Naves esta vacia");
        }
        return nave;
    }




    //Eliminar Nave por id
    public void eliminarNave(Integer id){


        if(id== null || !naveRepository.existsById(id)){
            throw new NaveExcepciones("Tienes que introducir una id valida para Eliminar una Nave");
        }
        naveRepository.deleteById(id);
}


    //buscar Nave por ID
@Cacheable(value="naves", key="#id")
public Nave buscarNaveId(Integer id){

    Optional <Nave> nave = naveRepository.findById(id);

    if(nave.isPresent()){
        return nave.get();
    }else{
        throw new NaveExcepciones("La nave no esta presente");
    }

   
    
}

    //modificar
    
public Nave modificarNave(Nave nave){

    if (nave.getId()==null || nave.getNave()== null) {
        throw new NaveExcepciones("No puedes modificar una nave no presente");
    }
    return naveRepository.save(nave);
}


    //http://localhost:8000/api/naves/buscar?parametro=a
    //buscar por un parametro específico

public List<Nave>buscarPorParametro(String parametro){
     List<Nave> naves =naveRepository.findByNaveContainingIgnoreCase(parametro);


     if (naves.isEmpty()) {
        throw new NaveExcepciones("No puedes buscar por parámetro ya que la lista esta vacia");
    }
     return naves;

}
    


}
