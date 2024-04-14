import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class caritoDeCompras {
    private static ArrayList<Productos> listaProductos = new ArrayList<>();

    public caritoDeCompras(){

    }

    public static void carritoDeCompras() throws InputMismatchException{
        Scanner sc = new Scanner(System.in);
        int respuesta = 0, cantidad=0, desicion;
        boolean bandera = false;

        System.out.println("Estos son los articulos en venta");
        for (int i = 0; i <listaProductos.size() ; i++) {
            System.out.println(i + 1 + "Nombre del producto" + listaProductos.get(i).getnombreProducto() );
            sc.nextInt();
        }
    }
}
