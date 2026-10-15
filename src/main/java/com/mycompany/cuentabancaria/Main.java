/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria;

/**
 *
 * @author aleja
 */

public class Main {

    public static void main(String[] args) {

        // 1. PRUEBA DE ENCAPSULAMIENTO

        System.out.println("--------- PRUEBA DE ENCAPSULAMIENTO---------");

        CuentaBancaria miCuenta = new CuentaBancaria("001", "Alejandro", 1000);

        // ERROR DE COMPILACION:
        // miCuenta.saldo = 50000;
        // No se puede acceder directamente a saldo porque
        // es private en la clase CuentaBancaria.
        // Para consultar el saldo utilizamos getSaldo().

        System.out.println("Saldo inicial: L. " + miCuenta.getSaldo());


        // 2. ACCESO DIRECTO A ATRIBUTOS PUBLICOS

        System.out.println("\n-----------ATRIBUTOS PUBLICOS-------");

        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Numero de cuenta: " + miCuenta.numeroCuenta);

        // Prueba adicional de deposito y retiro
        miCuenta.depositar(500);
        miCuenta.retirar(200);

        System.out.println("Saldo despues de operaciones: L. " + miCuenta.getSaldo());

        System.out.println("Total de transacciones: " + miCuenta.getTotalTransacciones());


        // 3. PRUEBA DE CUENTA DE AHORRO

        System.out.println("\n---------PRUEBA DE CUENTA AHORRO---------");

        CuentaAhorro miAhorro = new CuentaAhorro("002", "Joseph", 3000, 5.0);

        System.out.println("Saldo inicial: L. " + miAhorro.getSaldo());

        System.out.println("Tasa de interes anual: " + miAhorro.tasaInteresAnual + "%");

        System.out.println("\n---RETIRO1 ---");
        miAhorro.retirarConComision(100);

        System.out.println("\n---RETIRO 2---");
        miAhorro.retirarConComision(100);

        System.out.println("\n---RETIRO 3---");
        miAhorro.retirarConComision(100);

        System.out.println("\n---RETIRO 4: CON COMISION---");
        miAhorro.retirarConComision(100);

        System.out.println("Saldo despues de los 4 retiros: L. " + miAhorro.getSaldo());


        // 4. RENDIMIENTO DE AHORRO

        System.out.println("\n--------INTERES MENSUAL----------");

        miAhorro.aplicarinteresMensual();

        System.out.println("Saldo despues del interes: L. " + miAhorro.getSaldo());

        System.out.println("Transacciones de la cuenta de ahorro: " + miAhorro.getTotalTransacciones());


        // 5. PRUEBA DE CUENTA CORRIENTE

        System.out.println("\n---------PRUEBA DE CUENTA CORRIENTE---------");

        CuentaCorriente miCorriente = new CuentaCorriente("003", "Maria", 1000, "Mi Empresa", 5000);

        System.out.println("Saldo inicial: L. " + miCorriente.getSaldo());

        System.out.println("Limite de sobregiro: L. " + miCorriente.getlimiteSobregiro());

        System.out.println("\n--- RETIRO DE L. 3500 ---");

        miCorriente.retirarConSobregiro(3500);

        System.out.println("Saldo despues del retiro: L. " + miCorriente.getSaldo());

        System.out.println("Deuda por sobregiro, incluido el cargo: L. " + miCorriente.getSobregiroUtilizado());


        // 6. AMORTIZACION DE DEUDA

        System.out.println("\n---------PAGO DE SOBREGIRO-------------");

        miCorriente.pagarSobregiro(3000);

        System.out.println("\n---ESTADO FINAL DE CUENTA CORRIENTE---");

        miCorriente.mostrarDatos();

        System.out.println("Saldo final: L. " + miCorriente.getSaldo());

        System.out.println("Deuda final por sobregiro: L. " + miCorriente.getSobregiroUtilizado());

        System.out.println("\n-----FIN DE LAS PRUEBAS------");
    }
}

