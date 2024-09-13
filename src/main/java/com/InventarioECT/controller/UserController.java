package com.InventarioECT.controller;

import com.InventarioECT.controller.dto.CreateUserDTO;
import com.InventarioECT.entity.ERole;
import com.InventarioECT.entity.Role;
import com.InventarioECT.entity.Usuario;
import com.InventarioECT.repository.IUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private IUsuario iUsuario;

    // Creacion de un usuario.
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {

        Set<Role> roles = createUserDTO.getRoles().stream()//Obteniendo rol
                .map(role -> Role.builder()
                        .nombreRol(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        Usuario usuario = Usuario.builder()
                .nombreUsuario(createUserDTO.getNombreUsuario())
                .apellidoUsuario(createUserDTO.getApellidoUsuario())
                .username(createUserDTO.getUsername())
                .password(createUserDTO.getPassword())
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        iUsuario.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    //Eliminacion de usuario por id.
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id) {
        iUsuario.deleteById(Integer.parseInt(id));
        return "User deleted";
    }
/*
    //Actualizacion de un usuario por Id
    @PutMapping("/updateUser")
    public String updateUser(@RequestParam String id) {
        iUsuario.updateById(Integer.parseInt(id));
        return "Usuario Actualizado correctamente";
    }

    //Listar Usuarios

    @RequestMapping("listUser")
    public String listUser(@RequestParam String username) {
        iUsuario.findByUsername(username);
        return "Usuario Actualizado correctamente";
    }
*/
}
