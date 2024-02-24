package com.uce.edu.avanzada.pa2_u4_p5_ev.service;

import com.uce.edu.avanzada.pa2_u4_p5_ev.repository.model.Persona;

import java.util.List;

public interface IPersonaService {
    void guardar(Persona persona);
    void actualizar(Persona persona);
    Persona buscarPorCedula(String cedula);
    List<Persona> buscarTodo();
    void eliminarPorCedula(String cedula);
}
