package com.rdjaramillo.trailers.trailers.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pelicula")
    private Integer id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String sinopsis;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaEstreno;
    @NotBlank
    private String youtubeTrailerId;
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="genero_pelicula",
            joinColumns =@JoinColumn(name="id_pelicula"),
            inverseJoinColumns = @JoinColumn(name="id_genero"))
    private List<Genero> generos;
    @Transient
    private MultipartFile portada;

    public Pelicula(String titulo, String sinopsis, LocalDate fechaEstreno, String youtubeTrailerId, List<Genero> generos, MultipartFile portada) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.youtubeTrailerId = youtubeTrailerId;
        this.generos = generos;
        this.portada = portada;
    }
}
