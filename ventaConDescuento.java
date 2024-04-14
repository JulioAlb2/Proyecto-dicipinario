import java.util.ArrayList;
import java.util.Scanner;

public class ventaConDescuento extends ventaProducto {
    private float precioDescuento;

    public ventaConDescuento(ArrayList<Productos> listaProductos, float cuentaTotal3) {
        super(listaProductos);
        // super(listaProductos);
        this.cuentaTotal = cuentaTotal;
    }

    @Override
    protected void realizarPago() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por la compra de más de 1000 pesos en productos, se le hace un 20% de descuento.");
        precioDescuento = cuentaTotal * 0.8f;
        System.out.println("Costo total de la compra con descuento: " + precioDescuento);
        System.out.println("Ingrese su efectivo:");
        pago = scanner.nextFloat();
        while (pago < precioDescuento) {
            System.out.println("Ingrese un pago válido, el pago debe cubrir el costo total con descuento");
            pago = scanner.nextFloat();
        }
        float cambio = pago - precioDescuento;
        System.out.println("La compra fue realizada con éxito. Su cambio es de: " + cambio);
    }
}