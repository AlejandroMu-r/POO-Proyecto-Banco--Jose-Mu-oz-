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



CuentaAhorro ahorro = new CuentaAhorro(
    "002", "Alejandro", 3000, 5.0
);

ahorro.aplicarinteresMensual();

System.out.println("\n--- DATOS FINALES ---");
ahorro.mostrarDatos();



    }
}


