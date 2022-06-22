package ec.edu.epn;

import javax.lang.model.SourceVersion;

/**
 *
 * @author santiago
 */
public class NodoEmpleado {
    String codigo;
    NodoEmpleado enlace;

    public NodoEmpleado(String codigo){
        this.codigo = codigo;
        this.enlace = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public NodoEmpleado getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoEmpleado enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return "Nodo: " + "codigo=" + codigo + ", enlace=" + enlace;
    }



}
