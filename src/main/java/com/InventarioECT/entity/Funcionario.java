package com.InventarioECT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @Column(name = "id_funcionario", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Size(max = 45)
    @NotNull
    @Column(name = "email", nullable = false, length = 45)
    private String email;

}