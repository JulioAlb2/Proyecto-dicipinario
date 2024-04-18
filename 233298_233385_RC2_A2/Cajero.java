import java.util.ArrayList;

public class Cajero{
    public static void main(String[] args) {
    
        ArrayList<Refrescos> listaRefrescos= new ArrayList<>();
        listaRefrescos.add(new Refrescos("Manzana", 8, 235));
        listaRefrescos.add(new Refrescos("Manzana", 12, 500));
        listaRefrescos.add(new Refrescos("Manzana", 13, 600));
        imprimirRefrescos(listaRefrescos);
    }
        public static void imprimirRefrescos(ArrayList<Refrescos> listaRefrescos){
        System.out.println("--------------------------Bienvenido a Walmart---------------------------\n\n  Estos son los productos de la marca Mi refresco que ofrecemos para ti\n");
        System.out.println("----------Refresco------------Presentacion--------------Costo------------\n");
        for (Refrescos refresco : listaRefrescos) {
            System.out.println("          "+refresco.getnombreRefresco()+ "                 "+ refresco.getpresentacionRefresco()+"                    $"+ refresco.getcostoRefresco());
        }
        System.out.println("-------------------------------------------------------------------------\n");
        carritoCompra carrito= new carritoCompra();
        carrito.añadirProductos(listaRefrescos);
    }

}

