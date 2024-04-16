import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ventaProducto {
    protected float cuentaTotal;
    protected float pago;
    protected Inventario objInventario = new Inventario();
    protected ArrayList<Productos> listaProductos = objInventario.getListaProductos();
    protected ArrayList<Productos> listaCarrito = new ArrayList<>();
    protected static ArrayList<registroDeVenta> listaVentas= new ArrayList<>();
    protected String tipoVenta;

    public ventaProducto(ArrayList<Productos> listaCarrito) {
        for (Productos producto : listaCarrito) {
            this.listaCarrito.add(new Productos(producto.getnombreProducto(), producto.getcantidadProducto()));
        }
    }

    public ventaProducto() {

    }

    public static ArrayList<registroDeVenta> getlistaVentas(){
        return listaVentas;
    }

    protected void realizarPago() {
        Scanner scanner = new Scanner(System.in);
        for (Productos productoCarrito : listaCarrito) {
            for (Productos productoInventario : listaProductos) {
                if (productoCarrito.getnombreProducto().equalsIgnoreCase(productoInventario.getnombreProducto())) {
                    cuentaTotal += productoInventario.getcostoProducto() * productoCarrito.getcantidadProducto();
                    break;
                }
            }
        }

        if (cuentaTotal >= 1000) {
            ventaConDescuento descuento = new ventaConDescuento(listaCarrito);
            descuento.realizarPago();
        } else if (cuentaTotal >= 800) {
            ventaConPromocion promocion = new ventaConPromocion(listaCarrito);
            promocion.realizarPago();
        } else {
            System.out.println("Costo total de la compra: " + cuentaTotal);
            do {
                try {
                    System.out.println("Ingrese su efectivo:");
                    pago = scanner.nextFloat();
                    if (pago < cuentaTotal) {
                        throw new InputMismatchException("El pago debe cubrir el costo total.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Por favor, ingrese un monto válido en efectivo que cubra el costo total.");
                    scanner.nextLine();
                }
            } while (true);
            float cambio = pago - cuentaTotal;
            tipoVenta= ("Venta normal");
            System.out.println("--------------------------------------------------------");
            System.out.println("La compra fue realizada con éxito. Su cambio es de: " + cambio);
            registroDeVenta venta = new registroDeVenta(listaCarrito, cuentaTotal, tipoVenta);
            listaVentas.add(venta);
            for (Productos productoCarrito : listaCarrito) {
                for (Productos productoInventario : listaProductos) {
                    if (productoCarrito.getnombreProducto().equalsIgnoreCase(productoInventario.getnombreProducto())) {
                        System.out.println("Nombre: " + productoCarrito.getnombreProducto());
                        System.out.println("Precio unitario: " + productoInventario.getcostoProducto());
                        System.out.println("Cantidad: " + productoCarrito.getcantidadProducto());
                        System.out.println("Cuenta Total: " + cuentaTotal);
                        break;
                    }
                }
            }
        }
    }

    public void imprimirVentas(){
        registroDeVenta ventas = new registroDeVenta(listaCarrito, cuentaTotal,tipoVenta);
        ventas.imprimirRegistrosVenta(listaVentas);
    }
}
