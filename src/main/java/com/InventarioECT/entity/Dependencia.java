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
@Table(name = "dependencias")
public class Dependencia {
    @Id
    @Column(name = "id_dependencia", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre_dependencia", nullable = false, length = 100)
    private String nombreDependencia;

}

