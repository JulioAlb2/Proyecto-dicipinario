import java.util.ArrayList;

public class registroVenta {
    private ArrayList<Productos> listaProductos;
    private Cliente objCliente;

    public registroVenta() {}
    public registroVenta(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void imprimirRegistroDelDia() {
        System.out.println("Registro del día:");
        for (Productos producto : listaProductos) {
            System.out.println("Nombre: " + producto.getnombreProducto());
            System.out.println("Costo: " + producto.getcostoProducto());
            System.out.println("Cantidad: " + producto.getcantidadProducto());
            System.out.println("----------------------");
        }
    }
}
