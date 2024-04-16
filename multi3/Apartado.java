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
        int decision = 0, opcion = 0, eliminar = 0, nuevaCantidad = 0, fechaLimiteAnticipo = 15, numCliente = 0, canProducto = 0;
        String nombreCliente = "";
        float cuentaTotal = 0, anticipo = 0, costoAnticipo = 0, saldoPendiente = 0;

        do {
            try {
                System.out.println("Estos son los productos disponibles \n");
                for (int i = 0; i < objInventario.getListaProductos().size(); i++) {
                    System.out.println(i + 1 + " )Nombre del producto:  "
                            + objInventario.getListaProductos().get(i).getnombreProducto());
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
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
                sc.next(); 
            }
        } while (opcion == 1);

        do {
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
                sc.next(); 
            }

        } while (decision == 1);
        for (int i = 0; i < cuentaApartado.size(); i++) {
            cuentaTotal += cuentaApartado.get(i).getcostoProducto() * cuentaApartado.get(i).getcantidadProducto();
        }

        anticipo = cuentaTotal * 0.3f;
        System.out.println("-----Cuenta final: ---- " + " $ " + cuentaTotal);
        sc.nextLine();

        System.out.println("-----Se requiere un anticipo del 30% ----");

        System.out.println("Esta es la cantidad del anticipo: $" + anticipo);
        do {
            try {
                System.out.println("Ingrese el anticipo:");
                costoAnticipo = sc.nextFloat();
                if (anticipo < costoAnticipo) {
                    System.out.println("Ingrese un anticipo válido. El anticipo debe ser al menos el 30% del costo total.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número flotante válido.");
                sc.next(); 
            }
        } while (anticipo < costoAnticipo);

        saldoPendiente = cuentaTotal - costoAnticipo;

        System.out.println("Este es el plazo de dias para poder pagar por completo  " + fechaLimiteAnticipo + ")Dias");
        System.out.println("Puede recoger el pedido minimo 3 días despues de haber hecho el pedido y haber saldado la cuenta ");
        sc.next();

        try {
            System.out.println("-----Por favor ingrese el nombre del cliente para un mejor registro----");
            sc.nextLine();
            nombreCliente = sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un nombre válido.");
            sc.next(); 
        }

        try {
            System.out.println("------ Ingrese el número de teléfono del cliente ----:");
            numCliente = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número entero válido.");
            sc.next();
        }

        Cliente cuentaCliente = new Cliente(nombreCliente, numCliente, cuentaApartado, saldoPendiente);
        listaClientes.add(cuentaCliente);

        System.out.println("---- Informe de Cuenta Pendiente ----");
        System.out.println("Nombre del Cliente: " + nombreCliente);
        System.out.println("Número de Teléfono del Cliente: " + numCliente);
        System.out.println("Anticipo ingresado: " + costoAnticipo);
        System.out.println("Anticipo minimo: " + anticipo);
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

    public ArrayList<Cliente> getCuentaApartadoClientes() {
        return listaClientes;
    }

    public void pagarApartado() {
        int opcion = 0;
        float pagoFinal = 0, saldoPendiente = 0;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Estas son las cuentas pendientes");
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).getSaldoPendiente() != 0) {
                    System.out.println(i + 1 + " )Cliente " + listaClientes.get(i).getNombreCliente() + "\n");
                }
            }
            System.out.println("Indique la cuenta que desea pagar");
            opcion = sc.nextInt();
            opcion--;
            System.out.println("Saldo pendiente" + listaClientes.get(opcion).getSaldoPendiente());
            System.out.println("Ingrese el saldo restante: ");
            pagoFinal = sc.nextFloat();
            saldoPendiente = listaClientes.get(opcion).getSaldoPendiente() - pagoFinal;
            if (saldoPendiente <= 0) {
                System.out.println("Su cambio es: " + Math.abs(saldoPendiente));
                listaClientes.get(opcion).setSaldoPendiente(0);
            } else {
                System.out.println("Su nuevo saldo pendiente es: " + saldoPendiente);
                listaClientes.get(opcion).setSaldoPendiente(saldoPendiente);
            }
            if (saldoPendiente == 0) {
                System.out.println("Ha liquidado su cuenta con éxito");
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número válido.");
            sc.next(); 
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }
    
}
