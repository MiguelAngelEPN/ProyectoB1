package ec.edu.epn;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        GestorSistema gestor = new GestorSistema();
        gestor.inicializarArchivos();
        System.out.println("Bienvenido al Sistema de Gestión de Empleados y Productos\n"
                + "de la Distribuidora Espinoza");
        gestor.iniciarSistema();
    }
}