package com.uce.edu.avanzada.pa2_u4_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u4_p5_ev.repository.model.Persona;

import java.util.List;

public interface IPersonaRepository {
    void insertar(Persona persona);
    void actualizar(Persona persona);
    Persona consultarPorCedula(String cedula);
    List<Persona> consultarTodo();
    void eliminarPorCedula(String cedula);
}
