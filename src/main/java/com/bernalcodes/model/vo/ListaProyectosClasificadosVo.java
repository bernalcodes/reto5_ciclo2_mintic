package com.bernalcodes.model.vo;

public class ListaProyectosClasificadosVo {
    private Integer id, habitaciones;
    private String constructora, ciudad;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getHabitaciones() {
        return habitaciones;
    }
    
    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }
    
    public String getConstructora() {
        return constructora;
    }
    
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
