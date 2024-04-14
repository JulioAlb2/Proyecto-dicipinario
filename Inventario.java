import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Inventario {
    private ArrayList<Productos> listaProductos = new ArrayList<>();

    public Inventario() {

    }

    public void verMenu() {
        Scanner sc = new Scanner(System.in);
        int desicion;

        System.out.println("Que operacion desea realiazar? \n");
        System.out.println("1) Ingresar articulos 2) Modificar articulos \n");
        System.out.println("3) Eliminar Productos 4) Ver Inventario");
        desicion = sc.nextInt();

        switch (desicion) {
            case 1:
                crearInventarioFake();
                break;

            case 2:
                modificarListaProductos();
                break;

            case 3:
                eliminarProductos();
                break;

            case 4:
                imprimirListaProducto();
                break;

            default:
                break;
        }
    }

    public void IngresarProductos() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        String nomProductos, marcaProductos, descProducto;
        float costProductos = 0;
        int cantidadProductos = 0;
        int desicion = 0;
        boolean valida = false;

        do {
            System.out.println("Ingrese los datos del Producto");
            System.out.println("Ingrese el nombre del producto");
            nomProductos = sc.nextLine();

            System.out.println("Ingrese el costo del producto");
            while (valida == false) {
                try {
                    costProductos = sc.nextFloat();
                    while (costProductos <= 0) {
                        System.out.println("No es una cantidad valida, intente de nuevo");
                        costProductos = sc.nextFloat();
                    }
                    valida = true;
                } catch (InputMismatchException e) {
                    System.err.println("Oh oh, a ingresado un caracter invalido intentelo de nuevo");
                    sc.nextLine();
                }
            }
            valida = false;
            sc.nextLine();

            System.out.println("Ingrese la cantidad de productos");
            while (valida == false) {
                try {
                    cantidadProductos = sc.nextInt();
                    while (cantidadProductos <= 0) {
                        System.out.println("No es una cantidad valida, Ingrese de nuevo");
                        cantidadProductos = sc.nextInt();
                    }
                    valida = true;
                } catch (InputMismatchException e) {
                    System.err.println("Oh no, ah ingresado un caracter invalido intente de nuevo");
                    sc.nextLine();
                }
            }
            valida = false;
            sc.nextLine();
            System.out.println("Ingrese la marca del producto");
            marcaProductos = sc.nextLine();

            System.out.println("Ingrese la descripcion del producto");
            descProducto = sc.nextLine();

            System.out.println("Desea agregar otro producto?");
            System.out.println("1) SI      2) NO");
            while (valida == false) {
                try {
                    desicion = sc.nextInt();
                    while (desicion <= 0 || desicion > 2) {
                        System.out.println("Intentelo de nuevo");
                        desicion = sc.nextInt();
                    }
                    valida = true;
                } catch (InputMismatchException e) {
                    System.err.println("Intentelo de nuevo");
                    sc.nextLine();
                }
            }
            valida = false;
            sc.nextLine();

            Productos producto = new Productos(nomProductos, costProductos, marcaProductos, descProducto,
                    cantidadProductos);
            listaProductos.add(producto);

        } while (desicion != 2);
    }

    public void modificarListaProductos() {

        Scanner sc = new Scanner(System.in);
        String nuevoNombre, nuevaDescripcion;
        int nuevoPrecio, nuevaCantidad, modificar = 0, opcion = 0;
        boolean valida = false;

        System.out.println("Indique que articulo quiere modificar");
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println(i + 1 + ")nombre del producto: " + listaProductos.get(i).getnombreProducto());
        }
        while (valida == false) {
            try {
                opcion = sc.nextInt();
                while (opcion <= 0 || opcion > listaProductos.size()) {
                    System.out.println("No existe elemento intente de nuevo");
                    opcion = sc.nextInt();

                }
                valida = true; // se necesita para validar esta instruccion
            } catch (InputMismatchException e) {
                System.err.println("A ingresado un caracter invalido intente de nuevo");
                sc.nextLine();
            }
        }
        valida = false;
        sc.nextLine(); // lo utilize por que tenia un bug el cual a veces se saltaba la sig parte de
                       // ingresar los datos

        System.out.println("Deseas modificar el nombre? 1.-si 2.-no");
        // este ciclo sirve para las excepciones que accidentalmente ingrese el usuario
        while (valida == false) {
            // la excepcion como tal
            try {
                modificar = sc.nextInt();
                if (modificar == 1) {
                    System.out.println("Modificar nombre");
                    sc.nextLine();
                    nuevoNombre = sc.nextLine();
                    listaProductos.get(opcion - 1).setnombreProducto(nuevoNombre);
                }

                valida = true;
            } catch (InputMismatchException e) {
                System.err.println("A ingresado un caracter invalido");
                sc.nextLine(); // para las excepciones de ley de debe poner esta instruccion
            }
        }
        valida = false; // se necesita para que se pueda seguir utilizando esta variable con los ciclos
                        // while

        System.out.println("Deseas modificar el precio? 1.-si 2.-no");
        while (valida == false) {
            try {
                modificar = sc.nextInt();
                if (modificar == 1) {
                    System.out.println(" Modificar precio unitario");
                    nuevoPrecio = sc.nextInt();
                    listaProductos.get(opcion - 1).setcostoProducto(nuevoPrecio);
                }
                valida = true;
            } catch (InputMismatchException e) {
                System.err.println("A ingresado un caracter invalido, intente de nuevo");
                sc.nextLine();
            }
        }
        valida = false;
        System.out.println("Deseas modificar la cantidad ? 1.-si 2.-no");

        while (valida == false) {
            try {
                modificar = sc.nextInt();
                if (modificar == 1) {
                    System.out.println(" Modificar cantidad");
                    nuevaCantidad = sc.nextInt();
                    System.out.println(nuevaCantidad);
                    listaProductos.get(opcion - 1).setcantidadProducto(nuevaCantidad);
                }
                valida = true;
            } catch (Exception e) {
                System.err.println("A ingresado un caracter invalido, intente de nuevo");
                sc.nextLine();
            }
        }

        valida = false;
        System.out.println("Deseas modificar la descripcion? 1.-si 2.-no");
        while (valida == false) {
            try {
                modificar = sc.nextInt();
                if (modificar == 1) {
                    System.out.println(" Modificar la descripcion");
                    sc.nextLine();
                    nuevaDescripcion = sc.nextLine();
                    listaProductos.get(opcion - 1).setdescripcionProducto(nuevaDescripcion);
                }
                valida = true;
            } catch (InputMismatchException e) {
                System.err.println("A ingresado un caracter invalido, intente de nuevo");
                sc.nextLine();
            }
        }

    }

    public void imprimirListaProducto() {
        System.out.println("Este es el inventario actual");
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println("  ");
            System.out.println(i + 1 + ")nombre del producto: " + listaProductos.get(i).getnombreProducto() + "  "
                    + "Marca del producto): " + listaProductos.get(i).getmarcaProducto() + " Costo unitario): " + "  $ "
                    + listaProductos.get(i).getcostoProducto() + "  " + " Cantidad disponible): "
                    + listaProductos.get(i).cantidadProducto() + "  " + "Descripcion del producto):"
                    + listaProductos.get(i).getdescripcionProducto());
            System.out.println(" ");
        }
    }

    public void eliminarProductos() {
        int opcion = 0;
        boolean validar = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique que articulo quiere eliminar");
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println(i + 1 + ")nombre del producto: " + listaProductos.get(i).getnombreProducto());
        }

        while (validar == false) {
            try {
                opcion = sc.nextInt();
                while (opcion <= 0 || opcion > listaProductos.size()) {
                    System.out.println("No existe elemento intente de nuevo");
                    opcion = sc.nextInt();
                }
                validar = true;
            } catch (InputMismatchException e) {
                System.out.println("A ingresado un caracter invalido, intente de nuevo");
                sc.nextLine();
            }
        }
        validar = false;
        listaProductos.remove(opcion - 1);

    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    private void crearInventarioFake() {

        Productos producto = new Productos("Labial", 25, "Avon", "sadas",
                10);

        Productos producto2 = new Productos("rubor", 15, "Avn", "sadas",
                10);

        Productos producto3 = new Productos("delineador", 55, "von", "sadas",
                10);

        Productos producto4 = new Productos("sombra", 45, "Aon", "sadas",
                10);

        Productos producto5 = new Productos("jabones", 15, "Avo", "sadas",
                10);

        listaProductos.add(producto);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);
        listaProductos.add(producto5);

    }


}
