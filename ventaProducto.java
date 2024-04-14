import java.util.ArrayList;
import java.util.Scanner;

public class ventaProducto {
    protected float cuentaTotal;
    protected float pago;
    protected ArrayList<Productos> listaProductos;
    protected ArrayList<Cliente> listaClientes;

    public ventaProducto(ArrayList<Productos> listaProductos, ArrayList<Cliente> listaClientes) {
        this.listaProductos = listaProductos;
        this.listaClientes = listaClientes;
    }
    public ventaProducto(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ventaProducto() {

    }

    
    protected void verMenu() {
        Scanner sc = new Scanner(System.in);
        int desicion;
        System.out.println("Elija la opcion a pagar");
        System.out.println("1) Pagar ahora mismo   2)Pagar productos apartados");
        desicion = sc.nextInt();

        switch (desicion) {
            case 1:
                pagarAhora(listaProductos);
                break;
            case 2:
                pagarApartado(listaClientes);
                break;
        
            default:
                break;
        }
        
        // for (Productos producto : listaProductos) {
        // cuentaTotal += producto.getcostoProducto() * producto.getCantidadProducto();
        // }

        // if (cuentaTotal >= 1000) {
        // ventaConDescuento descuento = new ventaConDescuento(listaProductos,
        // cuentaTotal);
        // descuento.realizarPago();
        // } else if (cuentaTotal >= 800) {
        // ventaConPromocion promocion = new ventaConPromocion(listaProductos,
        // cuentaTotal);
        // promocion.realizarPago();
        // } else {
        // System.out.println("Costo total de la compra: " + cuentaTotal);
        // System.out.println("Ingrese su efectivo:");
        // pago = scanner.nextFloat();
        // while (pago < cuentaTotal) {
        // System.out.println("Ingrese un pago válido, el pago debe cubrir el costo
        // total");
        // pago = scanner.nextFloat();
        // }
        // float cambio = pago - cuentaTotal;
        // System.out.println("La compra fue realizada con éxito. Su cambio es de: " +
        // cambio);
        // }
        // registroVenta objRegistroVenta = new registroVenta(listaProductos);
        // objRegistroVenta.imprimirRegistroDelDia();
    }

    public void pagarAhora( ArrayList<Productos> listaCarrito){
        System.out.println("Estos son los productos de su carrito");
        for (int i = 0; i < listaCarrito.size(); i++) {
            System.out.println(i + 1 + ")nombre del producto: " + listaCarrito.get(i).getnombreProducto());
        }
    }
    protected void realizarPago() {}

    public void pagarApartado(ArrayList<Cliente> listaClientes){
        int opcion=0;
        float pagoFinal, saldoPendiente;
        Scanner sc = new Scanner(System.in);
        System.out.println("Estas son las cuentas pendientes");
        for(int i = 0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getSaldoPendiente() != 0){
                System.out.println(i+1+" )Cliente "+listaClientes.get(i).getNombreCliente()+"\n");
            }
        }
        System.out.println("Indique la cuenta que desea pagar");
        opcion = sc.nextInt();
        opcion --;
        System.out.println("Saldo pendiente" + listaClientes.get(opcion).getSaldoPendiente());
        System.out.println("Ingrese el saldo restante: ");
        pagoFinal = sc.nextFloat();
        saldoPendiente = listaClientes.get(opcion).getSaldoPendiente() - pagoFinal;
        if (saldoPendiente <= 0) {
            System.out.println("Su cambio es: " + Math.abs(saldoPendiente));
            listaClientes.get(opcion).setSaldoPendiente(0);
        }else{
            System.out.println("Su nuevo saldo pendiente es: " + saldoPendiente);
            listaClientes.get(opcion).setSaldoPendiente(saldoPendiente);
        }
       
            // ArrayList<Productos> productosApartados = listaClientes.get(i).getaApartados();
            // System.out.println("Indique que cuenta va a pagar \n");
            // opcion = sc.nextInt();



            // System.out.println("Apartados del cliente \n");
            // for(int j = 0; j < productosApartados.size(); j++ ){
            //     System.out.println("Producto: "+productosApartados.get(i).getnombreProducto() + productosApartados.get(i).cantidadProducto());
            //     opcion = sc.nextInt();
            // }
       
        
    }
}