package com.bernalcodes.model.vo;

public class ListaComprasClasificadasVo {
    private Integer id;
    private String constructora, banco;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getConstructora() {
        return constructora;
    }
    
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    
    public String getBanco() {
        return banco;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }
}
