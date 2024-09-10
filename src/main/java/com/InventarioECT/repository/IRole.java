package com.InventarioECT.repository;

import com.InventarioECT.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRole extends CrudRepository<Role, Integer> {
}
