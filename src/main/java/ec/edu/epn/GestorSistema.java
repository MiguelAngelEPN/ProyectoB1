package ec.edu.epn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris
 */
public class GestorSistema {

    //protected GestorSistema gestor = new GestorSistema();
    ListaDEnlazada listaEmpleados = new ListaDEnlazada();
    ListaDEnlazada listaProductos = new ListaDEnlazada();
    TablaHashEnlazadaEmpleados tabla = new TablaHashEnlazadaEmpleados();
    NodoEmpleadoLista nuevoNodo = new NodoEmpleadoLista();
    protected Empleado emp = new Empleado();
    protected Producto prod = new Producto();
    protected int bandera = 0;
    protected Sucursal Sucursal1 = new Sucursal(1);
    protected Sucursal Sucursal2 = new Sucursal(2);
    protected Sucursal Sucursal3 = new Sucursal(3);
    protected Sucursal Sucursal4 = new Sucursal(4);
    protected String sucursal;

    // Constructor
    public GestorSistema() {
    }

    // Método para iniciar el sistema
    public void iniciarSistema() {
        while (bandera == 0) {
            System.out.println("SELECCIONE UNA OPCIÓN");
            System.out.println("================================================");
            System.out.println("1. Registro de empleados");
            System.out.println("2. Eliminación de empleados");
            System.out.println("3. Consulta de empleados");
            System.out.println("4. Actualización de empleados");
            System.out.println("================================================");
            System.out.println("5. Registro de productos");
            System.out.println("6. Eliminación de productos");
            System.out.println("7. Consulta de productos");
            System.out.println("8. Actualización de productos");
            System.out.println("================================================");
            System.out.println("9. Salir\n");

            Scanner entrada = new Scanner(System.in);
            int iEntrada = Integer.parseInt(entrada.nextLine());

            switch (iEntrada) {
                case 1:
                    iniciarRegistroEmpleados();
                    break;
                case 2:
                    iniciarEliminarEmpleados();
                    break;
                case 3:
                    iniciarConsultaEmpleados();
                    break;
                case 4:
                    iniciarActualizarEmpleados();
                    break;
                case 5:
                    iniciarRegistroProductos();
                    break;
                case 6:
                    iniciarEliminarProductos();
                    break;
                case 7:
                    iniciarConsultaProductos();
                    break;
                case 8:
                    iniciarActualizarProductos();
                    break;
                case 9:
                    bandera = 1;
                    break;
            }

        }
    }

    // Método para iniciar la opción 1 del Sistema
    public void iniciarRegistroEmpleados() {
        String codigo = "", ultSucursal = "";
        String sNombre = "", sApellido = "", sCargo = "";
        String sDireccion = "", sCorreo = "", sTelefono = "";

        // Registrar Nombre
        boolean flag = true;
        while (flag) {
            System.out.print("Nombre del empleado: ");
            Scanner entradaNombre = new Scanner(System.in);
            sNombre = entradaNombre.nextLine();
            // verificar nombre
            if (emp.esNombreValido(sNombre)) {
                flag = false;
            } else {
                System.out.println("Su nombre no puede contener números ni caracteres especiales");
            }
        }
        flag = true;
        // Registrar Apellido
        while (flag) {
            System.out.print("Apellido del empleado: ");
            Scanner entradaApellido = new Scanner(System.in);
            sApellido = entradaApellido.nextLine();
            // verificar apellido
            if (emp.esApellidoValido(sApellido)) {
                flag = false;
            } else {
                System.out.println("Su apellido no puede contener números ni caracteres especiales");
            }
        }
        flag = true;
        // Seleccionar cargo / generar código
        while (flag) {
            System.out.println("Seleccione el cargo del empleado");
            System.out.println("a. Vendedor");
            System.out.println("b. Contador");
            System.out.println("c. Encargado de Bodega");
            Scanner entradaCargo = new Scanner(System.in);
            sCargo = entradaCargo.nextLine();

            switch (sCargo) {
                case "a":
                    sCargo = "Vendedor";
                    codigo += "VD";
                    codigo += "-";
                    codigo += emp.generarDigitos();
                    //NodoEmpleadoLista nodoEmpleado = new NodoEmpleadoLista();
                    while (nuevoNodo.adelante != null && codigo.equals(emp.getCodigo())) {
                        codigo = "VD";
                        codigo += "-";
                        codigo += emp.generarDigitos();
                        nuevoNodo = nuevoNodo.adelante;
                    }
                    flag = false;
                    break;
                case "b":
                    sCargo = "Contador";
                    codigo += "CT";
                    codigo += "-";
                    codigo += emp.generarDigitos();
                    while (nuevoNodo.adelante != null && codigo.equals(emp.getCodigo())) {
                        codigo = "CT";
                        codigo += "-";
                        codigo += emp.generarDigitos();
                        nuevoNodo = nuevoNodo.adelante;
                    }
                    flag = false;
                    break;
                case "c":
                    sCargo = "Encargado de Bodega";
                    codigo += "EB";
                    codigo += "-";
                    codigo += emp.generarDigitos();
                    while (nuevoNodo.adelante != null && codigo.equals(emp.getCodigo())) {
                        codigo = "EB";
                        codigo += "-";
                        codigo += emp.generarDigitos();
                        nuevoNodo = nuevoNodo.adelante;
                    }
                    flag = false;
                    break;
                default:
                    //System.out.println("Opcion no válida, vuelva a intentarlo");
                    break;
            }
        }
        flag = true;
        // Generar Última Sucursal
        ultSucursal = String.valueOf((int) (Math.random() * 3 + 1));
        // Registrar Dirección
        while (flag) {
            System.out.print("Dirección del empleado: ");
            Scanner entradaDireccion = new Scanner(System.in);
            sDireccion = entradaDireccion.nextLine();

            if (emp.esDireccionValida(sDireccion)) {
                flag = false;
            } else {
                System.out.println("Su direccion no puede contener caracteres especiales");
            }
        }
        flag = true;
        // Registrar Correo Electrónico
        while (flag) {
            System.out.print("Correo Electrónico del empleado: ");
            Scanner entradaCorreo = new Scanner(System.in);
            sCorreo = entradaCorreo.nextLine();
            if (emp.esCorreoValido(sCorreo)) {
                flag = false;
            } else {
                System.out.println("Correo inválido, vuelva a ingresarlo");
            }
        }
        flag = true;
        // Registrar Número de Teléfono
        while (flag) {
            System.out.print("Número de teléfono del empleado: ");
            Scanner entradaTelefono = new Scanner(System.in);
            sTelefono = entradaTelefono.nextLine();
            if (emp.esTelefonoValido(sTelefono)) {
                flag = false;
            } else {
                System.out.println("Número de teléfono inválido, vuelva a ingresarlo");
            }
        }

        System.out.println("\n");

        emp.setCodigo(codigo);
        emp.setNombre(sNombre);
        emp.setApellido(sApellido);
        emp.setCargo(sCargo);
        emp.setUltimaSucursal(ultSucursal);
        emp.setDireccion(sDireccion);
        emp.setCorreo(sCorreo);
        emp.setNumTelf(sTelefono);

        File fichero = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        String cadena = "";
        try {
            fichero = new File("registroEmpleados2.txt");
            fw = new FileWriter(fichero, true);
            pw = new PrintWriter(fw);
            cadena += emp.getCodigo() + ",";
            cadena += emp.getNombre() + ",";
            cadena += emp.getApellido() + ",";
            cadena += emp.getCargo() + ",";
            cadena += emp.getUltimaSucursal() + ",";
            cadena += emp.getDireccion() + ",";
            cadena += emp.getCorreo() + ",";
            cadena += emp.getNumTelf();
            String cadena2 = cadena;
            pw.println(cadena2);
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

    public void iniciarEliminarEmpleados() {
        System.out.println("Ingrese el ID del empleado a eliminar");
        Scanner entrada = new Scanner(System.in);
        String codigo = entrada.nextLine();
        eliminarEmpleado(codigo);
    }

    public void eliminarEmpleado(String codigo) {
        try {
            File archivo = new File("registroEmpleados2.txt");
            if (!archivo.isFile()) {
                System.out.println("El archivo no existe");
                return;
            }
            // Se instancia un nuevo archivo que contendrá la nueva lista
            // y que luego será renombrado
            File temp = new File(archivo.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader("registroEmpleados2.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(temp));
            String linea = null;
            // Leer del archivo original y escribir en el nuevo
            // a menos que el código sea el indicado
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().contains(codigo)) {
                    pw.println(linea);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            // Eliminando el archivo original
            if (!archivo.delete()) {
                System.out.println("El archivo no se pudo eliminar");
                return;
            }
            // Renombrando el archivo temporal con el nombre original
            if (!temp.renameTo(archivo)) {
                System.out.println("No se pudo renombrar el archivo");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void iniciarConsultaEmpleados() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("registroEmpleados2.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            Empleado nuevoEmpleado = new Empleado();
            while ((linea = br.readLine()) != null) {
                String cadena = "";
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                String dato = tokens.nextToken();

                nuevoEmpleado.setCodigo(dato);
                cadena += "|" + nuevoEmpleado.getCodigo() + "| -> ";

                dato = tokens.nextToken();
                nuevoEmpleado.setNombre(dato);
                cadena += nuevoEmpleado.getNombre() + " ";

                dato = tokens.nextToken();
                nuevoEmpleado.setApellido(dato);
                cadena += nuevoEmpleado.getApellido() + ", ";

                dato = tokens.nextToken();
                nuevoEmpleado.setCargo(dato);
                cadena += nuevoEmpleado.getCargo() + ", ";

                dato = tokens.nextToken();
                nuevoEmpleado.setUltimaSucursal(dato);
                cadena += "Sucursal " + nuevoEmpleado.getUltimaSucursal() + ", ";

                dato = tokens.nextToken();
                nuevoEmpleado.setDireccion(dato);
                cadena += nuevoEmpleado.getDireccion() + ", ";

                dato = tokens.nextToken();
                nuevoEmpleado.setCorreo(dato);
                cadena += nuevoEmpleado.getCorreo() + ", ";

                dato = tokens.nextToken();
                nuevoEmpleado.setNumTelf(dato);
                cadena += nuevoEmpleado.getNumTelf();

                System.out.println(cadena);
            }
            System.out.println("\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void iniciarActualizarEmpleados() {
        System.out.println("Ingrese el ID del empleado que desea actualizar");
        Scanner entrada = new Scanner(System.in);
        String codigo = entrada.nextLine();
        System.out.println("Empleado: " + obtenerEmpleado(codigo));
        actualizarEmpleado(codigo);
    }

    public void actualizarEmpleado(String codigo) {
        boolean flag = true;
        Empleado empActualizado = new Empleado();
        String empl = obtenerEmpleado(codigo);
        while (flag) {
            StringTokenizer tokens = new StringTokenizer(empl, ",");
            String dato = tokens.nextToken();
            empActualizado.setCodigo(dato);
            dato = tokens.nextToken();
            empActualizado.setNombre(dato);
            dato = tokens.nextToken();
            empActualizado.setApellido(dato);
            dato = tokens.nextToken();
            empActualizado.setCargo(dato);
            dato = tokens.nextToken();
            empActualizado.setUltimaSucursal(dato);
            dato = tokens.nextToken();
            empActualizado.setDireccion(dato);
            dato = tokens.nextToken();
            empActualizado.setCorreo(dato);
            dato = tokens.nextToken();
            empActualizado.setNumTelf(dato);
            System.out.println("¿Qué campo desea actualizar?");
            System.out.println("a. Dirección");
            System.out.println("b. Número de Teléfono");
            System.out.println("c. Correo Electrónico");
            System.out.println("d. Salir");
            Scanner entrada = new Scanner(System.in);
            String opcion = entrada.nextLine();
            switch (opcion) {
                case "a":
                    eliminarEmpleado(codigo);
                    int x = 0;
                    while (x == 0) {
                        System.out.println("Ingrese la nueva dirección:");
                        Scanner entradaDir = new Scanner(System.in);
                        String dir = entradaDir.nextLine();
                        if (empActualizado.esDireccionValida(dir)) {
                            empActualizado.setDireccion(dir);
                            ingresarEmpleado(empActualizado);
                            x = 1;
                        } else {
                            System.out.println("Su direccion no puede contener caracteres especiales");
                        }
                    }
                    break;
                case "b":
                    eliminarEmpleado(codigo);
                    int y = 0;
                    while (y == 0) {
                        System.out.println("Ingrese el nuevo número de teléfono:");
                        Scanner entradaNum = new Scanner(System.in);
                        String num = entradaNum.nextLine();
                        if (empActualizado.esTelefonoValido(num)) {
                            empActualizado.setNumTelf(num);
                            ingresarEmpleado(empActualizado);
                            y = 1;
                        } else {
                            System.out.println("Número de teléfono inválido, vuelva a ingresarlo");
                        }
                    }
                    break;
                case "c":
                    eliminarEmpleado(codigo);
                    int z = 0;
                    while (z == 0) {
                        System.out.println("Ingrese el nuevo correo electrónico:");
                        Scanner entradaCorreo = new Scanner(System.in);
                        String correo = entradaCorreo.nextLine();
                        if (empActualizado.esCorreoValido(correo)) {
                            empActualizado.setCorreo(correo);
                            ingresarEmpleado(empActualizado);
                            z = 1;
                        } else {
                            System.out.println("Correo inválido, vuelva a ingresarlo");
                            System.out.println("Correo inválido, vuelva a ingresarlo");
                            System.out.println("Número de teléfono inválido, vuelva a ingresarlo");
                        }
                    }
                    break;
                case "d":
                    flag = false;
                    break;
                default:
                    System.out.println("Opción no válida, vuelva a ingresar");
                    break;
            }
        }
    }

    public String obtenerEmpleado(String codigo) {
        String empleado = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("registroEmpleados2.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(codigo)) {
                    empleado = linea.trim();
                }
            }
            if (empleado.equals("")) {
                System.out.println("El empleado con código " + codigo
                        + " no existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return empleado;
    }

    public void ingresarEmpleado(Empleado empl) {
        File fichero = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        String cadena = "";
        try {
            fichero = new File("registroEmpleados2.txt");
            fw = new FileWriter(fichero, true);
            pw = new PrintWriter(fw);
            cadena += empl.getCodigo() + ",";
            cadena += empl.getNombre() + ",";
            cadena += empl.getApellido() + ",";
            cadena += empl.getCargo() + ",";
            cadena += empl.getUltimaSucursal() + ",";
            cadena += empl.getDireccion() + ",";
            cadena += empl.getCorreo() + ",";
            cadena += empl.getNumTelf();
            String cadena2 = cadena;
            pw.println(cadena2);
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

    public void iniciarRegistroProductos() {
        String sCodigo = "", sNombre = "";
        String sFecha = "", sPrecioUnit = "", sStock = "";
        String sProveedor = "", sMarca = "", sDescripcion = "";

        // Registrar Codigo
        boolean flag = true;
        while (flag) {
            System.out.print("Código del Producto: ");
            Scanner entradaCodigo = new Scanner(System.in);
            sCodigo = entradaCodigo.nextLine();
            // verificar nombre
            if (prod.esCodigoValido(sCodigo)) {
                flag = false;
            } else {
                System.out.println("Código inválido - Intente nuevamente");
            }
        }
        flag = true;
        // Registrar Nombre
        while (flag) {
            System.out.print("Nombre del producto: ");
            Scanner entradaNombre = new Scanner(System.in);
            sNombre = entradaNombre.nextLine();
            // verificar apellido
            if (prod.esNombreValido(sNombre)) {
                flag = false;
            } else {
                System.out.println("Nombre inválido - Intente nuevamente");
            }
        }
        flag = true;
        // Registrar Fecha
        while (flag) {
            System.out.print("Fecha de ingreso del producto: ");
            Scanner entradaFecha = new Scanner(System.in);
            sFecha = entradaFecha.nextLine();
            if (prod.esFechaValida(sFecha)) {
                flag = false;
            } else {
                System.out.println("Fecha inválida - Intente nuevamente");
            }
        }
        flag = true;
        // Registrar Precio Unitario
        while (flag) {
            System.out.print("Precio Unitario: ");
            Scanner entradaPrecioUnit = new Scanner(System.in);
            sPrecioUnit = entradaPrecioUnit.nextLine();
            if (prod.esPrecioValido(sPrecioUnit)) {
                flag = false;
            } else {
                System.out.println("Precio Unitario inválido - Intente nuevamente");
            }
        }
        flag = true;
        // Registrar Stock
        while (flag) {
            System.out.print("Stock: ");
            Scanner entradaStock = new Scanner(System.in);
            sStock = entradaStock.nextLine();
            if (prod.esStockValido(sStock)) {
                flag = false;
            } else {
                System.out.println("Stock inválido - Intente nuevamente");
            }
        }
        flag = true;
        // Registrar Proveedor
        while (flag) {
            System.out.print("Proveedor: ");
            Scanner entradaProveedor = new Scanner(System.in);
            sProveedor = entradaProveedor.nextLine();
            if (prod.esProveedorValido(sProveedor)) {
                flag = false;
            } else {
                System.out.println("Proveedor inválido - Intente nuevamente");
            }
        }
        flag = true;
        // Registrar Marca
        while (flag) {
            System.out.print("Marca: ");
            Scanner entradaMarca = new Scanner(System.in);
            sMarca = entradaMarca.nextLine();
            if (prod.esMarcaValida(sMarca)) {
                flag = false;
            } else {
                System.out.println("Marca inválida - Intente nuevamente");
            }
        }
        flag = true;
        // Registrar Descripción
        while (flag) {
            System.out.print("Descripción: ");
            Scanner entradaDescripcion = new Scanner(System.in);
            sDescripcion = entradaDescripcion.nextLine();
            if (prod.esDescripcionValida(sDescripcion)) {
                flag = false;
            } else {
                System.out.println("Descripción inválida - Intente nuevamente");
            }
        }

        System.out.println("\n");

        prod.codigo = sCodigo;
        prod.nombre = sNombre;
        prod.fecha = sFecha;
        prod.precioUnitario = sPrecioUnit;
        prod.stock = sStock;
        prod.proveedor = sProveedor;
        prod.marca = sMarca;
        prod.descripcion = sDescripcion;

        sobrescribirArchivoProd(prod);

    }

    public void iniciarEliminarProductos() {
        System.out.println("Ingrese el ID del producto a eliminar");
        Scanner entrada = new Scanner(System.in);
        String codigo = entrada.nextLine();
        eliminarProducto(codigo);
    }

    public void eliminarProducto(String codigo) {
        try {
            File archivo = new File("registroProductos.txt");
            if (!archivo.isFile()) {
                System.out.println("El archivo no existe");
                return;
            }
            // Se instancia un nuevo archivo que contendrá la nueva lista
            // y que luego será renombrado
            File temp = new File(archivo.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader("registroProductos.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(temp));
            String linea = null;
            // Leer del archivo original y escribir en el nuevo
            // a menos que el código sea el indicado
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().contains(codigo)) {
                    pw.println(linea);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            // Eliminando el archivo original
            if (!archivo.delete()) {
                System.out.println("El archivo no se pudo eliminar");
                return;
            }
            // Renombrando el archivo temporal con el nombre original
            if (!temp.renameTo(archivo)) {
                System.out.println("No se pudo renombrar el archivo");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void iniciarConsultaProductos() {
        boolean flag = true;
        while (flag) {
            System.out.println("¿Qué desea consultar?");
            System.out.println("a. Productos fuera de stock");
            System.out.println("b. Todos los productos");
            System.out.println("c. Productos ingresados en una fecha específica");
            System.out.println("d. Salir");
            Scanner entrada = new Scanner(System.in);
            String opcion = entrada.nextLine();
            Producto product = new Producto();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            switch (opcion) {
                case "a":
                    try {
                        archivo = new File("registroProductos.txt");
                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);
                        String linea;
                        String cadena = "";
                        while ((linea = br.readLine()) != null) {
                            StringTokenizer tokens = new StringTokenizer(linea, ",");
                            String line = "";
                            while (tokens.hasMoreTokens()) {
                                line = tokens.nextToken();
                                if (line.equals("0")) {
                                    cadena += linea.trim() + "\n";
                                }
                            }
                        }
                        System.out.println("PRODUCTOS FUERA DE STOCK:");
                        System.out.println(cadena);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    break;
                case "b":
                    try {
                        archivo = new File("registroProductos.txt");
                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);
                        String linea;
                        String cadena = "";
                        while ((linea = br.readLine()) != null) {
                            cadena += linea.trim() + "\n";
                        }
                        System.out.println(cadena);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    break;
                case "c":
                    boolean flag2 = true;
                    Producto p = new Producto();
                    while (flag2 == true) {
                        System.out.println("Ingrese la fecha de consulta (DD/MM/AA)");
                        Scanner entradaFecha = new Scanner(System.in);
                        String fecha = entradaFecha.nextLine();
                        if (!p.esFechaValida(fecha)) {
                            System.out.println("Fecha inválida - Intente nuevamente");
                        } else {
                            try {
                                archivo = new File("registroProductos.txt");
                                fr = new FileReader(archivo);
                                br = new BufferedReader(fr);
                                String linea;
                                String cadena = "";
                                while ((linea = br.readLine()) != null) {
                                    StringTokenizer tokens = new StringTokenizer(linea, ",");
                                    String line = "";
                                    while (tokens.hasMoreTokens()) {
                                        line = tokens.nextToken();
                                        if (line.equals(fecha)) {
                                            cadena += linea.trim() + "\n";
                                        }
                                    }
                                }
                                System.out.println("PRODUCTOS INGRESADOS EN LA FECHA "+fecha+": ");
                                System.out.println(cadena);
                                flag2 = false;
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    if (null != fr) {
                                        fr.close();
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }

                    break;
                case "d":
                    flag = false;
                    break;
                default:
                    System.out.println("Opción no válida, vuelva a ingresar");
                    break;
            }
        }
    }

    public void iniciarActualizarProductos() {
        System.out.println("Ingrese el ID del producto que desea actualizar");
        Scanner entrada = new Scanner(System.in);
        String codigo = entrada.nextLine();
        System.out.println("Producto: " + obtenerProducto(codigo));
        actualizarProducto(codigo);
    }

    public void actualizarProducto(String codigo) {
        boolean flag = true;
        Producto prodActualizado = new Producto();
        String prod = obtenerProducto(codigo);
        while (flag) {
            StringTokenizer tokens = new StringTokenizer(prod, ",");
            String dato = tokens.nextToken();
            prodActualizado.codigo = dato;
            dato = tokens.nextToken();
            prodActualizado.nombre = dato;
            dato = tokens.nextToken();
            prodActualizado.fecha = dato;
            dato = tokens.nextToken();
            prodActualizado.precioUnitario = dato;
            dato = tokens.nextToken();
            prodActualizado.stock = dato;
            dato = tokens.nextToken();
            prodActualizado.proveedor = dato;
            dato = tokens.nextToken();
            prodActualizado.marca = dato;
            dato = tokens.nextToken();
            prodActualizado.descripcion = dato;
            System.out.println("¿Qué campo desea actualizar?");
            System.out.println("a. Nombre");
            System.out.println("b. Descripción");
            System.out.println("c. Precio Unitario");
            System.out.println("d. Stock");
            System.out.println("e. Salir");
            Scanner entrada = new Scanner(System.in);
            String opcion = entrada.nextLine();
            switch (opcion) {
                case "a":
                    eliminarProducto(codigo);
                    int x = 0;
                    while (x == 0) {
                        System.out.println("Ingrese el nuevo nombre:");
                        Scanner entradaNom = new Scanner(System.in);
                        String nom = entradaNom.nextLine();
                        if (prodActualizado.esNombreValido(nom)) {
                            prodActualizado.nombre = nom;
                            ingresarProducto(prodActualizado);
                            x = 1;
                        } else {
                            System.out.println("Nombre inválido - Intente nuevamente");
                        }
                    }
                    break;
                case "b":
                    eliminarProducto(codigo);
                    int y = 0;
                    while (y == 0) {
                        System.out.println("Ingrese la nueva descripción:");
                        Scanner entradaDesc = new Scanner(System.in);
                        String desc = entradaDesc.nextLine();
                        if (prodActualizado.esDescripcionValida(desc)) {
                            prodActualizado.descripcion = desc;
                            ingresarProducto(prodActualizado);
                            y = 1;
                        } else {
                            System.out.println("Descripción inválida - Intente nuevamente");
                        }
                    }
                    break;
                case "c":
                    eliminarProducto(codigo);
                    int z = 0;
                    while (z == 0) {
                        System.out.println("Ingrese el nuevo precio unitario:");
                        Scanner entradaPrecio = new Scanner(System.in);
                        String pUnitario = entradaPrecio.nextLine();
                        if (prodActualizado.esPrecioValido(pUnitario)) {
                            prodActualizado.precioUnitario = pUnitario;
                            ingresarProducto(prodActualizado);
                            z = 1;
                        } else {
                            System.out.println("Precio Unitario inválido - Intente nuevamente");
                        }
                    }
                    break;
                case "d":
                    eliminarProducto(codigo);
                    int b = 0;
                    while (b == 0) {
                        System.out.println("Ingrese el nuevo stock:");
                        Scanner entradaStock = new Scanner(System.in);
                        String stock = entradaStock.nextLine();
                        if (prodActualizado.esStockValido(stock)) {
                            prodActualizado.stock = stock;
                            ingresarProducto(prodActualizado);
                            b = 1;
                        } else {
                            System.out.println("Stock inválido - Intente nuevamente");
                        }
                    }
                    break;
                case "e":
                    flag = false;
                    break;
                default:
                    System.out.println("Opción no válida, vuelva a ingresar");
                    break;
            }
        }
    }

    public String obtenerProducto(String codigo) {
        String producto = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("registroProductos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(codigo)) {
                    producto = linea.trim();
                }
            }
            if (producto.equals("")) {
                System.out.println("El producto con código " + codigo
                        + " no existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return producto;
    }

    public void ingresarProducto(Producto prod) {
        File fichero = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        String cadena = "";
        try {
            fichero = new File("registroProductos.txt");
            fw = new FileWriter(fichero, true);
            pw = new PrintWriter(fw);
            cadena += prod.codigo + ",";
            cadena += prod.nombre + ",";
            cadena += prod.fecha + ",";
            cadena += prod.precioUnitario + ",";
            cadena += prod.stock + ",";
            cadena += prod.proveedor + ",";
            cadena += prod.marca + ",";
            cadena += prod.descripcion;
            String cadena2 = cadena;
            pw.println(cadena2);
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

    public void sobrescribirArchivoProd(Producto prod) {
        File fichero = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        String cadena = "";
        try {
            fichero = new File("registroProductos.txt");
            fw = new FileWriter(fichero, true);
            pw = new PrintWriter(fw);
            cadena += prod.codigo + ",";
            cadena += prod.nombre + ",";
            cadena += prod.fecha + ",";
            cadena += prod.precioUnitario + ",";
            cadena += prod.stock + ",";
            cadena += prod.proveedor + ",";
            cadena += prod.marca + ",";
            cadena += prod.descripcion;
            pw.println(cadena);
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

    public void inicializarArchivos() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("registroEmpleados2.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                String dato = tokens.nextToken();
                Empleado nuevoEmpleado = new Empleado();
                nuevoEmpleado.setCodigo(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setNombre(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setApellido(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setCargo(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setUltimaSucursal(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setDireccion(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setCorreo(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setNumTelf(dato);

                listaEmpleados.insertarOrdenado(nuevoEmpleado);

                if (nuevoEmpleado.getCargo().equals("Vendedor")) {
                    tabla.inicializar(nuevoEmpleado.getCodigo(), nuevoEmpleado.getUltimaSucursal());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
