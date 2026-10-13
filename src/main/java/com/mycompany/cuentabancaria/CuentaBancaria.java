/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cuentabancaria;

/**
 *
 * @author aleja
 */
public class CuentaBancaria {

    public String numeroCuenta;
    public String titular;
    
    private double saldo;
    private int totalTransacciones;
    
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial){
        
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        
        if(saldoInicial < 0){
            
            this.saldo = 0.0;
        }
        else{
            this.saldo = saldoInicial;
            
        }
        
        this.totalTransacciones = 0;
    }
    
    //consultar saldo
    
    double getSaldo(){
        
        return saldo;
    }
    // consultar transacciones
    
    int getTotalTransacciones(){
        
        return totalTransacciones;
    }
    
    public void depositar(double monto){
        
        if(monto > 0 ){
            
            saldo = saldo + monto;
            
            totalTransacciones++;
            
            System.out.println("Deposito exitoso de L. " + monto);
        }
        else{ 
            
            System.out.println("Error: el monto debe ser mayor que cero.");
        }
         
    }
    
    public boolean retirar(double monto){
            
            if(monto > 0 && monto <= saldo){
                
                saldo = saldo - monto;
                
                totalTransacciones++;
                
                System.out.println("Retiro exitoso de L." + monto);
                
                return true;
            }
            else{
                System.out.println("Error: monto invalido");
                
                return false;
            }
        }
    
    public void mostrarDatos(){
        
    System.out.println("Numero de cuenta: " + numeroCuenta);
    System.out.println("Titular: " + titular);
    System.out.println("Saldo actual: L. " + getSaldo());
    System.out.println("Total de transacciones: " + getTotalTransacciones());
        
    }
    
}
