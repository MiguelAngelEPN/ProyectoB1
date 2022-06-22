package ec.edu.epn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cris
 */
public class Producto {
    protected String codigo;
    protected String nombre;
    protected String fecha;
    protected String precioUnitario;
    protected String stock;
    protected String proveedor;
    protected String marca;
    protected String descripcion;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String fecha, String precioUnitario, String stock, String proveedor, String marca, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.proveedor = proveedor;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public boolean esCodigoValido(String codigo) {
        return codigo.matches("([0-9]{5})");
    }

    public boolean esNombreValido(String nombre){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,254}");
        Matcher m = p.matcher(nombre);
        return m.matches();
    }

    public boolean esFechaValida(String fecha){
        Pattern p = Pattern.compile("^(?:3[01]|[12][0-9]|0?[1-9])([-/.])(0?[1-9]|1[1-2])\\1\\d{4}$");
        Matcher m = p.matcher(fecha);
        return m.matches();
    }

    public boolean esPrecioValido(String precio){
        Pattern p = Pattern.compile("^[0-9]+([.][0-9]+)?$");
        Matcher m = p.matcher(precio);
        return m.matches();
    }

    public boolean esStockValido(String stock) {
        Pattern p = Pattern.compile("\\d*");
        Matcher m = p.matcher(stock);
        return m.matches();
    }

    public boolean esProveedorValido(String proveedor) {
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,300}");
        Matcher m = p.matcher(proveedor);
        return m.matches();
    }

    public boolean esMarcaValida(String marca){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,100}");
        Matcher m = p.matcher(marca);
        return m.matches();
    }

    public boolean esDescripcionValida(String descripcion){
        Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]{1,1000}");
        Matcher m = p.matcher(descripcion);
        return m.matches();
    }
}
