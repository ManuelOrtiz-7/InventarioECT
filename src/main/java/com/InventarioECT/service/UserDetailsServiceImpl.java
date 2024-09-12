package com.InventarioECT.service;

import com.InventarioECT.entity.Usuario;
import com.InventarioECT.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuario iUsuario;

    @Override//Metodo para traer un usuario desde la base de datos
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = iUsuario.findByUsername(username)//Return por si el usuario no existe
                .orElseThrow(()-> new UsernameNotFoundException("El usuario " + username + "no existe"));


        // Convertir el roles en objeto de tipo GrantedAuthority
        Collection<? extends GrantedAuthority> authorities = usuario.getRoles()//Obtener roles con una funcion landa
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getNombreRol().name())))
                .collect(Collectors.toSet());

        return new User(usuario.getUsername(),
                usuario.getPassword(),
                true, //Usuario activo o no activo
                true, //true para que no expire la cuenta
                true, //true para que las credenciales no expiren
                true, //true para que la cuenta no se bloquee
                authorities);
    }
}
