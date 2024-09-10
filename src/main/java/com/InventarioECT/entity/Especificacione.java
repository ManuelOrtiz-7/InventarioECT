package com.InventarioECT.entity;

import jakarta.persistence.*;
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
@Table(name = "especificaciones")
public class Especificacione {
    @Id
    @Column(name = "id_especificaciones", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nombre_equipo", nullable = false)
    private Equipo nombreEquipo;

    @Size(max = 45)
    @NotNull
    @Column(name = "almacenamiento", nullable = false, length = 45)
    private String almacenamiento;

    @Size(max = 45)
    @NotNull
    @Column(name = "RAM", nullable = false, length = 45)
    private String ram;

    @Size(max = 45)
    @NotNull
    @Column(name = "CPU", nullable = false, length = 45)
    private String cpu;

    @Size(max = 45)
    @NotNull
    @Column(name = "sistema_operativo", nullable = false, length = 45)
    private String sistemaOperativo;

    @Size(max = 45)
    @NotNull
    @Column(name = "serial", nullable = false, length = 45)
    private String serial;

    @Size(max = 45)
    @NotNull
    @Column(name = "modelo", nullable = false, length = 45)
    private String modelo;

}