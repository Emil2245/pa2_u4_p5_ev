package com.uce.edu.avanzada.pa2_u4_p5_ev.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @SequenceGenerator(name = "generator_persona", allocationSize = 1,sequenceName = "seq_persona_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_persona")
    @Column(name = "pers_id")
    private Integer id;
    @Column(name = "pers_cedula")
    private String cedula;
    @Column(name = "pers_nombre")
    private String nombre;
    @Column(name = "pers_apellido")
    private String apellido;
    @Column(name = "pers_genero")
    private String genero;


    //////////////////////////////////////////////////////////////////////////


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
