import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {public static void main(String[] args) {
        verMenu();
    }

    public static void verMenu() {
        Scanner sc = new Scanner(System.in);
        carritoDeCompras objCarritoDeCompras = new carritoDeCompras();
        ArrayList<Productos> listaProductos = new ArrayList<>();
        Inventario objInventario = new Inventario();
        Apartado objApartado = new Apartado(objInventario);
        registroDeVenta obRegistroVenta = new registroDeVenta();
        ventaProducto objventaProducto = new ventaProducto();

        
        int menu = 0;
        boolean valida = false;
        do {
            System.out.println("-------------------------------------------------------------------------------Bienvenida Patricia------------------------------------------------------------------------------");
            System.out.println("Que desea realizar? \n");
            System.out.println("1) Registro de ventas ");
            System.out.println("2) Comprar");
            System.out.println("3) Pagar apartado");
            System.out.println("4) Realizar un apartado");
            System.out.println("5) Inventario ");
            System.out.println("6) Salir");
            while (valida == false) {
                try {
                    menu = sc.nextInt();
                    valida = true;
                } catch (InputMismatchException e) {
                    System.err.println("Intentelo de nuevo");
                    sc.nextLine();
                }
            }
            valida = false;
            switch (menu) {
                case 1:
                    obRegistroVenta.imprimirRegistrosVenta(ventaProducto.getlistaVentas());
                    break;
                case 2:
                    objCarritoDeCompras.agregarProducto(objInventario.getListaProductos());
                    break;
                case 3:
                    objApartado.pagarApartado();
                    break;

                case 4:
                    objApartado.crearCuentaPendiente(listaProductos);
                    break;
                case 5:
                    objInventario.verMenu();
                    break;

                default:
                    break;
            }
        } while (menu != 6);
    }
}
