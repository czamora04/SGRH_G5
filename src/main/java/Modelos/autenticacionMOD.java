package Modelos;

public class autenticacionMOD {
    private int id;
    private String usuario;
    private String pass;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public autenticacionMOD() {
    }

    public autenticacionMOD(int id, String usuario, String pass, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    @Override
    public String toString() {
        return "id= " + id + ", usuario= " + usuario + ", nombre= " + nombre + ", apellido1= " + apellido1 + ", apellido2= " + apellido2;
    }
        
}
