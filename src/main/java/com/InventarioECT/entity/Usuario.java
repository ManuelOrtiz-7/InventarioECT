package com.InventarioECT.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_funcionario")
    private Integer idFuncionario;

    @Size(max = 255)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Size(max = 255)
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;

    @Size(max = 50)
    @Column(name = "username", length = 50)
    private String username;

    @Size(max = 255)
    @Column(name = "`contraseña`")
    private String password;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


}