package ec.edu.epn;

/**
 *
 * @author santiago
 */
public class NodoEmpleadoLista {
    public Empleado info;
    public NodoEmpleadoLista adelante;
    public NodoEmpleadoLista atras;

    public void crearNodo(Empleado empleado){
        this.info = empleado;
        this.adelante = null;
        this.atras = null;
    }

    public NodoEmpleadoLista(){

    }

    public Empleado getInfo() {
        return info;
    }

    public void setInfo(Empleado info) {
        this.info = info;
    }

    public NodoEmpleadoLista getAdelante() {
        return adelante;
    }

    public void setAdelante(NodoEmpleadoLista adelante) {
        this.adelante = adelante;
    }

    public NodoEmpleadoLista getAtras() {
        return atras;
    }

    public void setAtras(NodoEmpleadoLista atras) {
        this.atras = atras;
    }
}
