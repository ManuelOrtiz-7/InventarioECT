package com.InventarioECT.repository;


import com.InventarioECT.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);


}
