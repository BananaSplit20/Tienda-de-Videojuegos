/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author matia
 */
public class Juego {
    private int idJuego;
    private String Titulo;
    private String Programador;
    private int Precio;
    private boolean Disponible;
    private Date Publicacion;

    public Juego() {
    }

    public Juego(int idJuego, String Titulo, String Programador, int Precio, boolean Disponible, Date Publicacion) {
        this.idJuego = idJuego;
        this.Titulo = Titulo;
        this.Programador = Programador;
        this.Precio = Precio;
        this.Disponible = Disponible;
        this.Publicacion = Publicacion;
    } 

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getProgramador() {
        return Programador;
    }

    public void setProgramador(String Programador) {
        this.Programador = Programador;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public Date getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(Date Publicacion) {
        this.Publicacion = Publicacion;
    }

}