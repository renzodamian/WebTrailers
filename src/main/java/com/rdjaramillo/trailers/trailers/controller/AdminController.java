package com.rdjaramillo.trailers.trailers.controller;

import com.rdjaramillo.trailers.trailers.model.Genero;
import com.rdjaramillo.trailers.trailers.model.Pelicula;
import com.rdjaramillo.trailers.trailers.repository.GeneroRepository;
import com.rdjaramillo.trailers.trailers.repository.PeliculaRepository;
import com.rdjaramillo.trailers.trailers.service.AlamcenServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private GeneroRepository   generoRepository;

    @Autowired
    private AlamcenServicioImpl alamcenServicio;


    @GetMapping("")
    public ModelAndView verPaginaDeInicio(@PageableDefault(sort = "titulo", size = 5) Pageable pageable) {
        Page<Pelicula> peliculas = peliculaRepository.findAll(pageable);
        return new ModelAndView("index").addObject("peliculas", peliculas);
    }


    @GetMapping("/peliculas/nuevo")
    public ModelAndView mostrarFormularioDeNuevaPelicula() {
        List<Genero> generos = generoRepository.findAll(Sort.by("titulo"));
        return new ModelAndView("admin/nueva-pelicula")
                .addObject("pelicula", new Pelicula())
                .addObject("generos",generos);
    }
}
