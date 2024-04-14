import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class carritoDeCompras {
    static Inventario objInventario = new Inventario();

    private static ArrayList<Productos> listaCarrito = new ArrayList<>();

    public carritoDeCompras() {

    }

    public void agregarProducto(ArrayList<Productos> inventarioProductos) {
        Scanner scanner = new Scanner(System.in);
        int respuesta = 0, cantidad = 0, desicion;
        boolean bandera = false;

        System.out.println("estos son los productos disponibles");
        for (int i = 0; i < inventarioProductos.size(); i++) {
            System.out.println(i + 1 + ")Nombre del producto" + inventarioProductos.get(i).getnombreProducto());
        }

        System.out.println("Que producto desea comprar??");
        while (bandera == false) {
            try {
                respuesta = scanner.nextInt();
                while (respuesta <= 0 || respuesta > inventarioProductos.size()) {
                    System.out.println("Ese elemento no existe, intente de nuevo");
                    respuesta = scanner.nextInt();
                }
                bandera = true;

            } catch (InputMismatchException e) {
                System.out.println("A ingresado un caracter invalido intente de nuevo");
                scanner.nextInt();
            }
        }
        bandera = false;
        scanner.nextLine();

        System.out.println("Cuantos productos desea?");
        while (bandera == false) {
            try {
                cantidad = scanner.nextInt();
                while (cantidad <= 0 || cantidad > inventarioProductos.get(cantidad).cantidadProducto()) {
                    System.out.println("Ingrese una cantidad valida");
                }

            } catch (InputMismatchException e) {
                System.out.println("A ingresado un caracter invalido, intente de nuevo");
                cantidad = scanner.nextInt();
            }
        }
        for (int i = 0; i < cantidad; i++) {
            listaCarrito.add(inventarioProductos.get(respuesta - 1));
        }

        System.out.println("Desea agregar otro producto del carrito?");
        System.out.println("1) Si    2)No");
        while (bandera = false) {
            try {
                desicion = scanner.nextInt();
                while (desicion == 1) {
                    System.out.println("estos son los productos disponibles");
                    for (int i = 0; i < inventarioProductos.size(); i++) {
                        System.out
                                .println(i + 1 + ")nombre del producto: "
                                        + inventarioProductos.get(i).getnombreProducto());
                    }

                    System.out.println("Que producto desea comprar??");
                    while (bandera == false) {
                        try {
                            respuesta = scanner.nextInt();
                            while (respuesta <= 0 || respuesta > inventarioProductos.size()) {
                                System.out.println("Ese elemento no existe, intente de nuevo");
                                respuesta = scanner.nextInt();
                            }
                            bandera = true;

                        } catch (InputMismatchException e) {
                            System.out.println("A ingresado un caracter invalido intente de nuevo");
                            scanner.nextInt();
                        }
                    }
                    bandera = false;
                    scanner.nextLine();

                    System.out.println("Cuantos productos desea?");
                    while (bandera == false) {
                        try {
                            cantidad = scanner.nextInt();
                            while (cantidad <= 0 || cantidad > inventarioProductos.get(cantidad).cantidadProducto()) {
                                System.out.println("Ingrese una cantidad valida");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("A ingresado un caracter invalido, intente de nuevo");
                            cantidad = scanner.nextInt();
                        }
                    }
                    for (int i = 0; i < cantidad; i++) {
                        listaCarrito.add(inventarioProductos.get(respuesta - 1));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("A ingresado un caracter invalido");
                System.out.println("Intente de nuevo");
                desicion = scanner.nextInt();
            }
        }

    }

    // do {
    // System.out.println("Ingrese el nombre del producto:");
    // String nombreProducto = scanner.next();

    // System.out.println("Ingrese el costo del producto:");
    // float costoProducto = scanner.nextFloat();
    // scanner.nextLine(); // Limpiar el buffer

    // System.out.println("Ingrese la marca del producto:");
    // String marcaProducto = scanner.next();

    // System.out.println("Ingrese la descripción del producto:");
    // String descripcionProducto = scanner.next();

    // System.out.println("Ingrese la cantidad del producto:");
    // int cantidadProducto = scanner.nextInt();

    // Productos producto = new Productos(nombreProducto, costoProducto,
    // marcaProducto, descripcionProducto, cantidadProducto);
    // listaCarrito.add(producto);

    // System.out.println("¿Desea agregar otro producto? (S/N)");
    // respuesta = scanner.next();
    // } while (respuesta.equalsIgnoreCase("S"));

    // System.out.println("Productos en el carrito:");
    // for (Productos producto : listaCarrito) {
    // System.out.println("Nombre: "+producto.getnombreProducto()+ " Cantidad:
    // "+producto.getCantidadProducto());
    // }
    // System.out.println("¿Desea eliminar algún producto del carrito? (S/N)");
    // respuesta = scanner.next();
    // if (respuesta.equalsIgnoreCase("S")) {
    // modificarProducto();
    // }
    // else{
    // ventaProducto venta = new ventaProducto(listaCarrito);
    // venta.realizarPago();
    // }

    // public static void modificarProducto() {
    // Scanner scanner = new Scanner(System.in);
    // boolean productoEliminado = false;

    // while (!productoEliminado) {
    // System.out.println("Seleccione el número del producto que desea eliminar:");
    // int numeroProducto = scanner.nextInt();
    // scanner.nextLine();
    // if (numeroProducto >= 1 && numeroProducto <= listaCarrito.size()) {
    // listaCarrito.remove(numeroProducto - 1);
    // System.out.println("Producto eliminado exitosamente del carrito.");
    // productoEliminado = true;
    // ventaProducto venta = new ventaProducto(listaCarrito);
    // venta.realizarPago();
    // } else {
    // System.out.println("Número de producto no válido. Por favor, seleccione un
    // número válido.");
    // }
    // }
    // }

    public ArrayList<Productos> getCarrito() {
        return listaCarrito;
    }
}
