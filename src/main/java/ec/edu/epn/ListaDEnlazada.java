package ec.edu.epn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.lang.model.SourceVersion;

/**
 *
 * @author User
 */
public class ListaDEnlazada {

    private NodoEmpleadoLista cabecera; // Este es el nodo inicial de la lista

    public ListaDEnlazada() {
        this.cabecera = null;
    }

    public NodoEmpleadoLista getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoEmpleadoLista cabecera) {
        this.cabecera = cabecera;
    }

    public String mostrar() {
        String texto = "";
        if (this.cabecera == null) {
            return null;
        }
        texto += null + " <--- ";
        NodoEmpleadoLista actual = this.cabecera;
        while (actual.getAdelante() != null) {
            texto += actual.getInfo() + " <---> ";
            actual = actual.getAdelante();
        }
        texto += actual.getInfo() + " ---> " + null;
        return texto;
    }

    public void insertarOrdenado(Empleado empleado) {
        NodoEmpleadoLista insertObject = new NodoEmpleadoLista();
        insertObject.crearNodo(empleado);
        if (this.cabecera == null) {
            this.cabecera = insertObject;
            this.cabecera.setAtras(null);
            this.cabecera.setAdelante(null);
        } else {
            NodoEmpleadoLista temp = this.cabecera;
            if (empleado.getCodigo().compareTo(temp.getInfo().getCodigo()) < 0) {
                insertObject.setAdelante(temp);
                temp.setAtras(insertObject);
                insertObject.setAtras(null);
                this.cabecera = insertObject;
            } else {
                NodoEmpleadoLista tempIzq = temp;
                NodoEmpleadoLista tempDer = temp.getAdelante();
                while (tempIzq.getAdelante() != null) {
                    if (empleado.getCodigo().compareTo(tempDer.getInfo().getCodigo()) < 0) {
                        insertObject.setAdelante(tempDer);
                        insertObject.setAtras(tempIzq);
                        tempIzq.setAdelante(insertObject);
                        tempDer.setAtras(insertObject);
                        break;
                    } else {
                        tempIzq = tempIzq.getAdelante();
                        tempDer = tempDer.getAdelante();
                    }
                }
                if (tempIzq.getAdelante() == null) {
                    insertObject.setAtras(tempIzq);
                    tempIzq.setAdelante(insertObject);
                    insertObject.setAdelante(null);
                }
            }
        }
    }

    public String obtenerEmpleado(String codigo) {
        String empleado = "";
        NodoEmpleadoLista actual = this.cabecera;
        while (!actual.getInfo().getCodigo().equals(codigo)) {
            actual = actual.getAdelante();
        }
        empleado += actual.getInfo().getNombre();
        empleado += " " + actual.getInfo().getApellido();
        return empleado;
    }

    public void actualizaFichero() {
        File fichero = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        NodoEmpleadoLista actual = this.cabecera;
        String cadena = "";
        try {
            int j = 0;
            while (j == 0) {
                if (actual.adelante != null) {
                    fichero = new File("registroEmpleados2.txt");
                    fw = new FileWriter(fichero);
                    pw = new PrintWriter(fw);
                    String cadena2 = generarTokens(actual);
                    pw.println(cadena2);
                    actual = actual.adelante;
                } else {
                    fichero = new File("registroEmpleados2.txt");
                    fw = new FileWriter(fichero);
                    pw = new PrintWriter(fw);
                    cadena = generarTokens(actual);
                    pw.println(cadena);
                    j = 1;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String generarTokens(NodoEmpleadoLista actual) {
        String cadena = "";
        cadena += actual.getInfo().getCodigo() + ",";
        cadena += actual.getInfo().getNombre() + ",";
        cadena += actual.getInfo().getApellido() + ",";
        cadena += actual.getInfo().getCargo() + ",";
        cadena += actual.getInfo().getUltimaSucursal() + ",";
        cadena += actual.getInfo().getDireccion() + ",";
        cadena += actual.getInfo().getCorreo() + ",";
        cadena += actual.getInfo().getNumTelf();

        return cadena;
    }

}
