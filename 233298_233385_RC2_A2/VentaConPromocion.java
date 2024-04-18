import java.util.Scanner;
import java.util.ArrayList;

public class VentaConPromocion extends Venta{
    private float promocion= 8;

    public VentaConPromocion(ArrayList<Refrescos> listaRefrescos, ArrayList<Refrescos> listaCarrito){
        super(listaRefrescos, listaCarrito);
    }

    public void calcularPago(){
        for (Refrescos refresco : listaCarrito) {
            for (Refrescos refrescos : listaRefrescos) {
                if (refresco.getpresentacionRefresco() == refrescos.getpresentacionRefresco()) {
                    costoTotal += refresco.getcantidadRefresco() * refrescos.getcostoRefresco();
                    
                    break;  
                }
            }
        }
        System.out.println("El costo total de la compra sin promocion es: $" + costoTotal);
        costoTotal= costoTotal-promocion;
        System.out.println("El costo total de la compra con promocion es:  $" + costoTotal);
        System.out.println("La promocion solo se aplica una vez por compra");
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
