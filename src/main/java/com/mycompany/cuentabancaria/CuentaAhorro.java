/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria;

/**
 *
 * @author aleja
 */

    public class CuentaAhorro extends CuentaBancaria{
        
        public double tasaInteresAnual;
        
        private int retirosRealizadosMes = 0;
        
        private double comisionPorExceso = 20.0;
        
        public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual){
            
            super(numeroCuenta, titular, saldoInicial);
            
            this.tasaInteresAnual = tasaInteresAnual;
            this.retirosRealizadosMes = 0; 
            this.comisionPorExceso = 20.0;
            
            
        }
        
        public boolean retirarConComision(double monto){
            
            double montoTotal = monto;
            
            if(retirosRealizadosMes >= 3){
                
                montoTotal = monto + comisionPorExceso;
            }
            
            boolean exito = super.retirar(montoTotal);
            
            if(exito){
                
                retirosRealizadosMes++;
            }
            
            return exito;
        }
        
        public void aplicarinteresMensual(){
            
            double interes = (getSaldo() * (tasaInteresAnual/100))/12;
            
            depositar(interes);
            
            System.out.println("Interes Mensual aplicado: L." + interes);
        }
    }

