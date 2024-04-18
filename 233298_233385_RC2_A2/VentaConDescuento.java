import java.util.ArrayList;
import java.util.Scanner;
public class VentaConDescuento extends Venta{
    private float descuento= 0.85f;
    

    public VentaConDescuento(ArrayList<Refrescos> listaRefrescos, ArrayList<Refrescos> listaCarrito){
        super(listaRefrescos, listaCarrito);
    }

    public void calcularPago(){
        
        float costoTotal235o600 = 0;
        float costoTotal500 = 0;

        for (Refrescos refresco : listaCarrito) {
            if (refresco.getpresentacionRefresco() == 235 || refresco.getpresentacionRefresco() == 600) {
                for (Refrescos refrescoLista : listaRefrescos) {
                    if (refresco.getpresentacionRefresco() == refrescoLista.getpresentacionRefresco()) {
                        costoTotal235o600 += refresco.getcantidadRefresco() * refrescoLista.getcostoRefresco();
                        break;
                    }
                }
            }
            if (refresco.getpresentacionRefresco() == 500) {
                for (Refrescos refrescoLista : listaRefrescos) {
                    if (refresco.getpresentacionRefresco() == refrescoLista.getpresentacionRefresco()) {
                        costoTotal500 += refresco.getcantidadRefresco() * refrescoLista.getcostoRefresco();
                        break;
                    }
                }
            }
        }
        costoTotal= costoTotal235o600+costoTotal500;
        System.out.println("El costo total de la compra sin descuento es: $" + costoTotal);
        costoTotal235o600= costoTotal235o600*descuento;
        costoTotal= costoTotal235o600+costoTotal500;
        System.out.println("El costo total de la compra con descuento es:  $" + costoTotal);
            realizarPago();

    }
    public void realizarPago() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("¿Cómo desea pagar? (1 - Efectivo, 2 - Tarjeta)");
        int metodoPago = scanner.nextInt();
        
        if (metodoPago == 1) {
            System.out.println("Ingrese su efectivo:");
            pago = scanner.nextFloat();
            while (pago < costoTotal) {
                System.out.println("Ingrese un pago válido, el pago debe cubrir el costo total");
                pago = scanner.nextFloat();
            }
            float cambio = pago - costoTotal;
            System.out.println("--------------------------------------------------------");
            System.out.println("La compra fue realizada con éxito. Su cambio es de: $" + cambio);
            Cajero cajero = new Cajero();
            cajero.imprimirRefrescos(listaRefrescos);
        } else if (metodoPago == 2) { 
            System.out.println("Ingrese el NIP de su tarjeta (4 dígitos):");
            int nip = scanner.nextInt();
            if (nip >999 && nip<=9999) {
                System.out.println("Procesando pago con tarjeta...");
                System.out.println("--------------------------------------------------------");
            System.out.println("La compra fue realizada con éxito\n");
            Cajero cajero = new Cajero();
            cajero.imprimirRefrescos(listaRefrescos);
            } else {
                System.out.println("NIP inválido. Debe ser un número de 4 dígitos.");
                realizarPago(); 
            }
        } else {
            System.out.println("Opción de pago inválida. Por favor, seleccione 1 o 2.");
            realizarPago();
        }
    }
}
