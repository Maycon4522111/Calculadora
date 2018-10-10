/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ROMERA
 */@Entity
public class historico {
   @Id    //Define a variavel id ao Id chave primaria da tabela
   @GeneratedValue(strategy = GenerationType.IDENTITY) // faz a geração do id automático
    private Integer Id;
    private Double primeiroValor;
    private Double segundoValor;
    private String operador;
    private Double resultado;
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public double getPrimeiroValor() {
        return primeiroValor;
    }

    public void setPrimeiroValor(double primeiroValor) {
        this.primeiroValor = primeiroValor;
    }

    public double getSegundoValor() {
        return segundoValor;
    }

    public void setSegundoValor(double segundoValor) {
        this.segundoValor = segundoValor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
 }
