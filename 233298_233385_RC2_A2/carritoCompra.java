import java.util.ArrayList;
import java.util.Scanner;

public class carritoCompra {
    private ArrayList<Refrescos> listaCarrito= new ArrayList<>();

    public void añadirProductos(ArrayList<Refrescos> listaRefrescos){
        Scanner scanner = new Scanner(System.in);
        listaCarrito.clear();
        boolean agregar = true;
        while (agregar) {
            System.out.println("Ingrese la presentación de refresco que desee:");
            int presentacionRefresco = scanner.nextInt();

            boolean presentacionValida = false;
            for (Refrescos refresco : listaRefrescos) {
                if (refresco.getpresentacionRefresco() == presentacionRefresco) {
                    presentacionValida = true;
                    break;
                }
            }

            if (!presentacionValida) {
                System.out.println("Presentación de refresco no válida. Intente nuevamente.");
                continue;
            }

            int cantidad = 0;
            while (cantidad <= 0) {
                System.out.println("Ingrese la cantidad de productos que desea:");
                cantidad = scanner.nextInt();
                if (cantidad <= 0) {
                    System.out.println("Cantidad no válida. Debe ser mayor que cero.");
                }
                Refrescos refresco = new Refrescos(presentacionRefresco, cantidad);
                listaCarrito.add(refresco);
            }

            System.out.println("Refresco agregado al carrito.");
            System.out.println("¿Desea agregar más refrescos? (1. Sí / 2. No)");
            int respuesta = scanner.nextInt();
            while (respuesta!=1 && respuesta !=2) {
                System.out.println("Ingrese una opcion correcta: ");
                respuesta = scanner.nextInt();
                
            }
            if (respuesta != 1) {
                agregar = false;
                System.out.println("Refrescos en el carrito:");
                for (Refrescos refresco : listaCarrito) {
                    System.out.println("Presentacion: "+refresco.getpresentacionRefresco()+ ", Cantidad: "+refresco.getcantidadRefresco());
                }
                Venta venta = new Venta(listaRefrescos, listaCarrito);
                venta.calcularPago();
            }
        }
    }
}


