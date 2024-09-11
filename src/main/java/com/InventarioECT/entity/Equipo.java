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
@Table(name = "equipo")
public class Equipo {
    @Id
    @Size(max = 50)
    @Column(name = "codigo_equipo", nullable = false, length = 50)
    private String codigoEquipo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_funcionario", nullable = false)
    private com.InventarioECT.entity.Funcionario idFuncionario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dependencia", nullable = false)
    private Dependencia idDependencia;

    @Size(max = 50)
    @NotNull
    @Column(name = "Nombre_Equipo", nullable = false, length = 50)
    private String nombreEquipo;

    @Size(max = 45)
    @NotNull
    @Column(name = "estado", nullable = false, length = 45)
    private String estado;

    @Column(name = "dependencia")
    private Integer dependencia;

    @Size(max = 45)
    @Column(name = "ubicacion", length = 45)
    private String ubicacion;

    @Size(max = 45)
    @Column(name = "usuario", length = 45)
    private String usuario;

    @Size(max = 45)
    @NotNull
    @Column(name = "dominio", nullable = false, length = 45)
    private String dominio;

    @Size(max = 45)
    @NotNull
    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

}