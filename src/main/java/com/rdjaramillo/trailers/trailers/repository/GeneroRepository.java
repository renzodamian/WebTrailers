package com.rdjaramillo.trailers.trailers.repository;

import com.rdjaramillo.trailers.trailers.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
