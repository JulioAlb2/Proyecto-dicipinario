import java.util.Scanner;
import java.util.ArrayList;

public class Venta {
    protected float costoTotal;
    protected float pago;
    protected ArrayList<Refrescos> listaRefrescos = new ArrayList<>();
    protected ArrayList<Refrescos> listaCarrito = new ArrayList<>();

    protected Venta(ArrayList<Refrescos> listaRefrescos, ArrayList<Refrescos> listaCarrito) {
        this.listaRefrescos = listaRefrescos;
        this.listaCarrito = listaCarrito;
    }

    public void calcularPago() {
        Scanner scanner = new Scanner(System.in);

        int presentacion500 = 0;
        int presentacion235o600 = 0;
        int totalCantidad = 0;

        for (Refrescos refresco : listaCarrito) {
            totalCantidad += refresco.getcantidadRefresco();
            if (refresco.getpresentacionRefresco() == 500) {
                presentacion500 += refresco.getcantidadRefresco();
            }
            if (refresco.getpresentacionRefresco() == 235 || refresco.getpresentacionRefresco() == 600) {
                presentacion235o600 += refresco.getcantidadRefresco();
            }
        }
        if (presentacion500 >= 2 && presentacion235o600 == 0) {
            System.out.println("Su compra aplica para venta con promocion, se le da un refresco gratis de la presentacion 235");
            VentaConPromocion ventaPromo= new VentaConPromocion(listaRefrescos, listaCarrito);
            ventaPromo.calcularPago();
        } else if (totalCantidad <= presentacion235o600 && presentacion500 <= 1) {
            System.out.println("Su compra aplica para venta con descuento, se le aplicará un descuento del 15% a los productos en promocion");
            VentaConDescuento ventaDes= new VentaConDescuento(listaRefrescos, listaCarrito);
            ventaDes.calcularPago();

        } else if (totalCantidad >= 3 && presentacion235o600 >= 1 && presentacion500 >= 2) {
            System.out.println("Su compra aplica para venta con promocion y descuento\n Decida que oferta elegir 1)Con promocion  2)Con descuento");
    int decision;
    do {
        System.out.println("Por favor, ingrese 1 para la opción con promoción o 2 para la opción con descuento:");
        decision = scanner.nextInt();
    } while (decision != 1 && decision != 2);

    if (decision == 1) {
        VentaConPromocion ventaPromo= new VentaConPromocion(listaRefrescos, listaCarrito);
        ventaPromo.calcularPago();
    } else if (decision == 2) {
        VentaConDescuento ventaDes= new VentaConDescuento(listaRefrescos, listaCarrito);
            ventaDes.calcularPago();
        
    }
}
            

        if (presentacion500 == 1) {
            System.out.println("Su compra no aplica para ninguna oferta");
            for (Refrescos refresco : listaCarrito) {
                for (Refrescos refrescos : listaRefrescos) {
                    if (refresco.getpresentacionRefresco() == refrescos.getpresentacionRefresco()) {
                        costoTotal += refresco.getcantidadRefresco() * refrescos.getcostoRefresco();
                        break;
                    }
                }
            }
            System.out.println("El costo total de la compra es: $" + costoTotal);
            realizarPago();
        }
    }

    public void realizarPago() {
        Scanner scanner = new Scanner(System.in);
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
