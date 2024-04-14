import java.util.ArrayList;
import java.util.Scanner;

public class ventaConPromocion extends ventaProducto {
    private float precioPromocion;


    public ventaConPromocion(ArrayList<Productos> listaProductos, float precioPromocion){
        super(listaProductos);
    }

    protected void realizarPago() {
        Scanner scanner = new Scanner(System.in);
        // Calcular el costo total de la compra
        for (Productos producto : listaProductos) {
            cuentaTotal += producto.getcostoProducto() * producto.getcantidadProducto();
        }

        // Encontrar el índice del producto más barato
        int indiceProductoMasBarato = 0;
        for (int i = 1; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getcostoProducto() < listaProductos.get(indiceProductoMasBarato)
                    .getcostoProducto()) {
                indiceProductoMasBarato = i;

            }
        }

        // Obtener el producto más barato y eliminarlo de la lista
        Productos productoMasBarato = listaProductos.remove(indiceProductoMasBarato);
        cuentaTotal -= productoMasBarato.getcostoProducto();

        // Calcular el precio con la promoción
        precioPromocion = cuentaTotal;

        // Imprimir el nuevo costo total con la promoción aplicada
        System.out.println("Por comprar más de 800 pesos, te llevas el producto más barato gratis.");
        System.out.println("Costo total con promoción: " + precioPromocion);
        System.out.println("Ingrese su efectivo:");
        pago = scanner.nextFloat();
        while (pago < precioPromocion) {
            System.out.println("Ingrese un pago válido, el pago debe cubrir el costo total con descuento");
            pago = scanner.nextFloat();
        }
        float cambio = pago - precioPromocion;
        System.out.println("La compra fue realizada con éxito. Su cambio es de: " + cambio);
    }

}