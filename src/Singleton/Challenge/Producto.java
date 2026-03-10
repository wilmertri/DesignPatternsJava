package Singleton.Challenge;

public class Producto {

    private final int    id;
    private final String nombre;
    private final String categoria;
    private       double precio;
    private       int    stock;

    public Producto(int id, String nombre, String categoria, double precio, int stock) {
        this.id        = id;
        this.nombre    = nombre;
        this.categoria = categoria;
        this.precio    = precio;
        this.stock     = stock;
    }

    public int    getId()        { return id; }
    public String getNombre()    { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecio()    { return precio; }
    public int    getStock()     { return stock; }

    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock)      { this.stock  = stock; }

    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    @Override
    public String toString() {
        return String.format(
                "Producto{id=%d, nombre='%s', categoria='%s', precio=$%.2f, stock=%d}",
                id, nombre, categoria, precio, stock
        );
    }
}