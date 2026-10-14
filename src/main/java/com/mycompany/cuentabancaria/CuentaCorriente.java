/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria;

/**
 *
 * @author aleja
 */
public class CuentaCorriente extends CuentaBancaria {
    
    
    public String nombreEmpresa;
    
    private double limiteSobregiro;
    
    private double SobregiroUtilizado = 0.0;
            
         
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro){
    
    super(numeroCuenta, titular, saldoInicial);
    
    this.nombreEmpresa = nombreEmpresa;
    
    if(limiteSobregiro >= 0){
        
        this.limiteSobregiro = limiteSobregiro;
    }
    else{
        
        this.limiteSobregiro = 0.0;
    }
    
    this.SobregiroUtilizado = 0.0;
}
    
    public double getlimiteSobregiro(){
        
        
        return limiteSobregiro;
    }
    
    public double getSobregiroUtilizado(){
        
        return SobregiroUtilizado;
    }
    
    public boolean retirarConSobregiro(double monto){
        
        if(monto <= 0){
            
            System.out.println("Error: el monto debe ser mayor que cero. ");
            return false;
            
        }
        
        if(monto <= getSaldo()){
            
            return super.retirar(monto);
        }
        
        double creditoNecesario = monto - getSaldo();
        
        double creditoDisponible = limiteSobregiro - SobregiroUtilizado;
        
        if(creditoNecesario > creditoDisponible){
            
            System.out.println("Error: se supera el limite de sobregiro.");
            return false;
        }
        
        double saldoActual = getSaldo();
        
        if(saldoActual > 0){
            
            super.retirar(saldoActual);
        }
        
        double cargoServicio = creditoNecesario * 0.03;
        
        SobregiroUtilizado += creditoNecesario + cargoServicio;
        
        System.out.println("Retiro con sobregiro exitoso. ");
        System.out.println("Credito utilizado: L." + creditoNecesario);
        System.out.println("Cargo por Servicio: L." + cargoServicio);
        
        return true;
    }
    
    public void pagarSobregiro(double monto){
        
        if(monto <= 0){
            
            System.out.println("Error: el pago debe ser mayor que cero: ");
            return;
        }
        
        if(SobregiroUtilizado == 0){
            
            System.out.println("No existe deuda por sobregiro.");
            return;
        }
        
        if (monto <= SobregiroUtilizado){
            
            SobregiroUtilizado -= monto;
            
            System.out.println("Pago de sobregiro exitoso. ");
            System.out.println("Deuda restante: L. " + SobregiroUtilizado);
        }
        else{
            double sobrante = monto - SobregiroUtilizado;
            
            SobregiroUtilizado = 0;
            
            depositar(sobrante);
            
            System.out.println("Sobregiro pegado completamente.");
            System.out.println("Dinero sobrante depositado: L. " + sobrante);
        }
        
    }
    
}
