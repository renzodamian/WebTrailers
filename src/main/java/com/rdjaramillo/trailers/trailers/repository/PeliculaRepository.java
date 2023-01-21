package com.rdjaramillo.trailers.trailers.repository;

import com.rdjaramillo.trailers.trailers.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
