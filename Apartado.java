import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Apartado {
    private ArrayList<Productos> cuentaApartado;
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    Inventario objInventario;

    public Apartado() {
    }

    public Apartado(Inventario objInventario) {
        this.objInventario = objInventario;
    }

    public void crearCuentaPendiente(ArrayList<Productos> inventarioProductos) {
        cuentaApartado = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int decision, opcion = 0, eliminar = 0, nuevaCantidad = 0, fechaLimiteAnticipo = 15, numCliente, canProducto ;
        String nombreCliente;
        float cuentaTotal = 0, anticipo, costoAnticipo, saldoPendiente;

        do {
            System.out.println("Estos son los productos disponibles \n");
            for (int i = 0; i < objInventario.getListaProductos().size(); i++) {
                System.out.println(i + 1 + " )Nombre del producto:  "
                        + objInventario.getListaProductos().get(i).getnombreProducto() );
            }
            System.out.println("\n --------Indique la posicion del articulo --------");
            decision = sc.nextInt();
            decision--;

            System.out.println("\n --------Ingrese la cantidad del producto---------- \n");
            canProducto = sc.nextInt();
            Productos productoApartado = objInventario.getListaProductos().get(decision);
            productoApartado.setcantidadProducto(canProducto);
            cuentaApartado.add(productoApartado);

            System.out.println("\n -------Desea agregar otro articulo?-------- \n");
            System.out.println("1) Si   2) No");
            opcion = sc.nextInt();

            System.out.println("\n ------Productos apartados: ----- \n ");
            for (int i = 0; i < cuentaApartado.size(); i++) {
                System.out.println(
                        cuentaApartado.get(i).getnombreProducto() + ": " + cuentaApartado.get(i).cantidadProducto());
            }
        } while (opcion == 1);

        do {
            System.out.println("\n ----------Desea eliminar algun articulo? -----------\n");
            System.out.println("1) Si  2) NO");
            decision = sc.nextInt();
            if (decision == 1) {
                for (int i = 0; i < cuentaApartado.size(); i++) {
                    System.out.println(i + 1 + ")Nombre del articulo: " + cuentaApartado.get(i).getnombreProducto());

                }
                System.out.println("\n ----Indique la posicion del articulo ----\n");
                opcion = sc.nextInt();
                sc.nextLine();
                System.out.println("\n -----Cuantos productos desea eliminar?----- \n");
                eliminar = sc.nextInt();
                nuevaCantidad = cuentaApartado.get((opcion - 1)).getcantidadProducto() - eliminar;
                cuentaApartado.get((opcion - 1)).setcantidadProducto(nuevaCantidad);

            }

        } while (decision == 1);
        for (int i = 0; i < cuentaApartado.size(); i++) {
            cuentaTotal += cuentaApartado.get(i).getcostoProducto() * cuentaApartado.get(i).getcantidadProducto();
        }

        anticipo = cuentaTotal * 0.3f;
        System.out.println("-----este es tu cuenta final---- " + " $ " + cuentaTotal);
        sc.nextLine();

        System.out.println("-----Se requiere un anticipo del 30% ----");

        System.out.println("Esta es la cantidad del anticipo: $" + anticipo);

        System.out.println("Por favor ingrese la cantidad del anticipo");
        costoAnticipo = sc.nextFloat();
        saldoPendiente = cuentaTotal - costoAnticipo;
        

        System.out.println("Este es el plazo de dias para poder pagar por completo  " + fechaLimiteAnticipo + ")Dias");
        sc.nextLine();

        System.out.println("-----Por favor ingrese su nombre para un mejor registro----");
        nombreCliente = sc.nextLine();
        

        System.out.println("------ Ingrese el número de teléfono del cliente ----:");
        int numTelefono = sc.nextInt();
       
        Cliente cuentaCliente = new Cliente(nombreCliente, numTelefono, cuentaApartado,saldoPendiente );
        listaClientes.add(cuentaCliente);

        System.out.println("---- Informe de Cuenta Pendiente ----");
        System.out.println("Nombre del Cliente: " + nombreCliente);
        System.out.println("Número de Teléfono del Cliente: " + numTelefono);
        System.out.println("Anticipo: " + anticipo);
        System.out.println("Costo Total: " + cuentaTotal);
        System.out.println("Saldo Pendiente: " + saldoPendiente);
        System.out.println("Fecha Límite de Anticipo: " + fechaLimiteAnticipo + "Dias");
        System.out.println("Productos:");
        for (Productos prod : cuentaApartado) {
            System.out.println("- Nombre: " + prod.getnombreProducto() + ", Cantidad: " +
                    prod.getcantidadProducto());
        }
        System.out.println("-------------------------------------");
    }

    public ArrayList<Cliente> getCuentaApartadoClietnes() {
        return listaClientes;
    }

    // public void ingresarProductosApartados() {
    // Scanner scanner = new Scanner(System.in);
    // String respuesta;

    // do {
    // System.out.println("Ingrese el nombre del producto:");
    // String nombreProducto = scanner.next();

    // System.out.println("Ingrese el costo del producto:");
    // float costoProducto = scanner.nextFloat();

    // System.out.println("Ingrese la marca del producto:");
    // String marcaProducto = scanner.next();

    // System.out.println("Ingrese la descripción del producto:");
    // String descripcionProducto = scanner.next();

    // System.out.println("Ingrese la cantidad del producto:");
    // int cantidadProducto = scanner.nextInt();

    // Productos producto = new Productos(nombreProducto, costoProducto,
    // marcaProducto, descripcionProducto, cantidadProducto);
    // objInventario.getListaProductos().add(producto);

    // System.out.println("¿Desea agregar más productos? (S/N)");
    // respuesta = scanner.next();
    // } while (respuesta.equalsIgnoreCase("S"));

    // // Cuando se selecciona "N", llamar automáticamente a la función
    // crearCuentaPendiente
    // if (respuesta.equalsIgnoreCase("N")) {
    // crearCuentaPendiente();
    // }
    // }

    // public void crearCuentaPendiente() {
    // Scanner scanner = new Scanner(System.in);
    // Cliente objCliente = new Cliente();
    // costoTotal = 0;
    // for (Productos producto : inventarioProductos) {
    // costoTotal += producto.getcostoProducto() * producto.cantidadProducto();
    // }
    // System.out.println("El costo total es: " + costoTotal);
    // float anticipoMinimo = 0.3f * costoTotal;
    // System.out.println("Anticipo Mínimo(referente al costo total): " +
    // anticipoMinimo);
    // float anticipo;
    // do {
    // System.out.println("Ingrese el anticipo");
    // anticipo = scanner.nextFloat();
    // scanner.nextLine();
    // if (anticipo < anticipoMinimo) {
    // System.out.println("Ingrese un anticipo válido, el anticipo debe ser al menos
    // el 30% del costo total");
    // }
    // } while (anticipo < anticipoMinimo);

    // System.out.println("Ingrese la fecha límite del anticipo:");
    // fechaLimiteAnticipo = scanner.nextInt();
    // scanner.nextLine(); // Limpiar el buffer

    // System.out.println("Ingrese el nombre del cliente:");
    // String nombreCliente = scanner.next();
    // this.objCliente.setNombreCliente(nombreCliente);

    // System.out.println("Ingrese el número de teléfono del cliente:");
    // int numTelefono = scanner.nextInt();
    // this.objCliente.setNumTelefono(numTelefono);
    // scanner.next();

    // System.out.println("---- Informe de Cuenta Pendiente ----");
    // System.out.println("Nombre del Cliente: " + nombreCliente);
    // System.out.println("Número de Teléfono del Cliente: " + numTelefono);
    // System.out.println("Anticipo: " + anticipo);
    // System.out.println("Costo Total: " + costoTotal);
    // System.out.println("Fecha Límite de Anticipo: " + fechaLimiteAnticipo);
    // System.out.println("Productos:");
    // for (Productos prod : inventarioProductos) {
    // System.out.println("- Nombre: " + prod.getNombreProducto() + ", Cantidad: " +
    // prod.getCantidadProducto());
    // }
    // System.out.println("-------------------------------------");

    // System.out.println("¿Desea realizar otro apartado? (S/N)");
    // String respuesta = scanner.nextLine();
    // if (respuesta.equalsIgnoreCase("S")) {
    // ingresarProductosApartados();
    // }
    // scanner.close();
    // }
}
