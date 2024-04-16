import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class carritoDeCompras {
    static Inventario objInventario = new Inventario();
    private static ArrayList<Productos> listaCarrito = new ArrayList<>();

    public carritoDeCompras() {}

    public void agregarProducto(ArrayList<Productos> listaProductos) {
        listaCarrito.clear();
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        System.out.println("Productos disponibles en el inventario:");
        for (int i = 0; i < objInventario.getListaProductos().size(); i++) {
            System.out.println(i + 1 + " )Nombre del producto:  "+ listaProductos.get(i).getnombreProducto() + ", cantidad: " +  listaProductos.get(i).getcantidadProducto());
        }
        do {
            String nombreProducto;
            boolean encontrado = false;
            int cantidadDisponible = 0;
            do {
                System.out.println("Ingrese el nombre del producto:");
                nombreProducto = scanner.next();

                for (Productos producto : listaProductos) {
                    if (producto.getnombreProducto().equalsIgnoreCase(nombreProducto)) {
                        encontrado = true;
                        cantidadDisponible = producto.getcantidadProducto();
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("El producto no existe en el inventario.");
                }
            } while (!encontrado);

            int cantidadProducto;
            do {
                System.out.println("Ingrese la cantidad del producto (disponible: " + cantidadDisponible + "):");
                cantidadProducto = scanner.nextInt();

                if (cantidadProducto > cantidadDisponible) {
                    System.out.println("No hay suficiente cantidad de producto disponible en el inventario.");
                }
            } while (cantidadProducto > cantidadDisponible);
            for (Productos producto : listaProductos) {
                if (producto.getnombreProducto().equalsIgnoreCase(nombreProducto)) {
                    producto.setcantidadProducto(producto.getcantidadProducto() - cantidadProducto);
                    break;
                }
            }

            Productos producto = new Productos(nombreProducto, cantidadProducto);
            listaCarrito.add(producto);
            System.out.println("Producto agregado al carrito.");

            System.out.println("¿Desea agregar otro producto? (S/N)");
            respuesta = scanner.next();
        } while (respuesta.equalsIgnoreCase("S"));

        System.out.println("Productos en el carrito:");
        for (Productos producto : listaCarrito) {
            System.out.println("Nombre: "+producto.getnombreProducto()+ "\n Cantidad: "+producto.getcantidadProducto());
        }
        System.out.println("¿Desea eliminar algún producto del carrito? (S/N)");
        respuesta = scanner.next();
        if (respuesta.equalsIgnoreCase("S")) {
            modificarProducto();
        }
        else{
            ventaProducto venta = new ventaProducto(listaCarrito);
            venta.realizarPago();
        }
    }

    public static void modificarProducto() {
        Scanner scanner = new Scanner(System.in);
        boolean productoEliminado = false;

        while (!productoEliminado) {
            System.out.println("Seleccione el número del producto que desea eliminar:");
            int numeroProducto = scanner.nextInt();
            scanner.nextLine();
            if (numeroProducto >= 1 && numeroProducto <= listaCarrito.size()) {
                listaCarrito.remove(numeroProducto - 1);
                System.out.println("Producto eliminado exitosamente del carrito.");
                productoEliminado = true;
                ventaProducto venta = new ventaProducto(listaCarrito);
                venta.realizarPago();
            } else {
                System.out.println("Número de producto no válido. Por favor, seleccione un número válido.");
            }
        }
    }
}
