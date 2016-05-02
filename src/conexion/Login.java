package conexion;

import java.io.Serializable;


public class Login implements Serializable {
	private int idUsr;
	private int TUsr ;
	private String nom;
	private String ape;
        private String usr;
        private String contra;

    public Login() {
    }
        
    public Login(int Id_user, int T_usuario, String Nombre, String Apellido, String Usuario, String Contrasena) {
        this.idUsr = Id_user;
        this.TUsr = T_usuario;
        this.nom = Nombre;
        this.ape = Apellido;
        this.usr = Usuario;
        this.contra = Contrasena;
    }

    public int getId_user() {
        return idUsr;
    }

    public void setId_user(int Id_user) {
        this.idUsr = Id_user;
    }

    public int getT_usuario() {
        return TUsr;
    }

    public void setT_usuario(int T_usuario) {
        this.TUsr = T_usuario;
    }

    public String getNombre() {
        return nom;
    }

    public void setNombre(String Nombre) {
        this.nom = Nombre;
    }

    public String getApellido() {
        return ape;
    }

    public void setApellido(String Apellido) {
        this.ape = Apellido;
    }

    public String getUsuario() {
        return usr;
    }

    public void setUsuario(String Usuario) {
        this.usr = Usuario;
    }

    public String getContrasena() {
        return contra;
    }

    public void setContrasena(String Contrasena) {
        this.contra = Contrasena;
    }

    @Override
    public String toString() {
        return    "\n --------------------------"
                + "\n   Id usuario: " + idUsr 
                + "\n   Tipo usuario: " + TUsr 
                + "\n   Nombre: " + nom 
                + "\n   Apellido: "+ape
                + "\n   Usuario: "+usr
                + "\n   Contraseña: "+contra
                + "\n --------------------------"; //To change body of generated methods, choose Tools | Templates.
    }

    
        
}
