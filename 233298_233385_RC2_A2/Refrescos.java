public class Refrescos {
    private String nombreRefresco;
    private int costoRefresco;
    private int presentacionRefresco;
    private int cantidadRefresco;

    public Refrescos(String nombreRefresco, int costoRefresco, int presentacionRefresco){
        this.nombreRefresco=nombreRefresco;
        this.costoRefresco=costoRefresco;
        this.presentacionRefresco=presentacionRefresco;
    }
    public Refrescos(int presentacionRefresco, int cantidadRefresco){
        this.presentacionRefresco=presentacionRefresco;
        this.cantidadRefresco= cantidadRefresco;
    }
    
    public Refrescos(){
    }
    public void setnombreRefresco(String nombreRefresco){
        this.nombreRefresco=nombreRefresco;
    }
    public String getnombreRefresco(){
        return nombreRefresco;
    }
    public void setcostoRefresco(int costoRefresco){
        this.costoRefresco=costoRefresco;
    }
    public int getcostoRefresco(){
        return costoRefresco;
    }
    public void setpresentacionRefresco(int presentacionRefresco){
        this.presentacionRefresco=presentacionRefresco;
    }
    public int getpresentacionRefresco(){
        return presentacionRefresco;
    }
    public void setcantidadRefresco(int cantidadRefresco){
        this.cantidadRefresco=cantidadRefresco;
    }
    public int getcantidadRefresco(){
        return cantidadRefresco;
    }
}
