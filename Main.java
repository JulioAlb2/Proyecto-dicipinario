import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        verMenu();
    }

    public static void verMenu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Productos> listaProductos = new ArrayList<>();
        Inventario objInventario = new Inventario();
        Apartado objApartado = new Apartado(objInventario);
        registroVenta obRegistroVenta = new registroVenta();
        ventaProducto obVentaProducto = new ventaProducto(listaProductos, objApartado.getCuentaApartadoClietnes());
        carritoDeCompras objCarritoDeCompras = new carritoDeCompras();
        int menu = 0;
        boolean valida = false;
        do {
            System.out.println("Bienvenida Patricia ");
            System.out.println("Que desea realizar? \n");
            System.out.println("1) Registro de ventas ");
            System.out.println("2) Realizar ventas");
            System.out.println("3) Realizar un apartado");
            System.out.println("4) Inventario ");
            System.out.println("5) Salir");
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
                    obRegistroVenta.imprimirRegistroDelDia();
                    break;

                case 2:
                    obVentaProducto.verMenu();
                    break;

                case 3:
                    objApartado.crearCuentaPendiente(listaProductos);
                    
                    break;

                case 4:
                    objInventario.verMenu();
                    listaProductos = objInventario.getListaProductos();
                    break;

                default:
                    break;
            }
        } while (menu != 5);
    }
}
