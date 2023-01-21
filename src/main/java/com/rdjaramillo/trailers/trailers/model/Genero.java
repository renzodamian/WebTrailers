package com.rdjaramillo.trailers.trailers.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genero {
    @Id
    @Column(name="id_genero")
    private Integer id;
    @NotBlank
    private String titulo;

    public Genero(String titulo) {
        this.titulo = titulo;
    }

    public Genero(Integer id) {
        this.id = id;
    }
}
