package cr.ac.ucr.ciclos_Patrones.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;
    @Column(name="nombre", nullable = false, length = 30)
    private String nombre;
    @Column(name="edad", nullable = false)
    private Integer edad;
    @Column(name="correo", nullable = false, length = 150)
    private String correo;
    @Column(name="password", nullable = false, length = 8)
    private String password; //Password para no usar la ñ
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroDiario> registros = new ArrayList<>();

    //Metodo constructor
    public Usuario(){
        this.id = 0;
        this.nombre = "Marito";
        this.edad = 38;
        this.correo = "MaritoMortadela@gmail.com";
        this.password = "password";
    }

    //Metodo constructor
    public Usuario(Integer id, String nombre, Integer edad, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.password = password;
    }

//-------------------------------------------------------------------------------------------------------
    //Metodos sets, gets y toString

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //-----------------------------------------------------------\\

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //-----------------------------------------------------------\\

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    //-----------------------------------------------------------\\

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //-----------------------------------------------------------\\

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //-----------------------------------------------------------\\

    public List<RegistroDiario> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroDiario> registros) {
        this.registros = registros;
    }

    //-----------------------------------------------------------

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", registros=" + registros +
                '}';
    }

}//Fin de la clase Usuario
