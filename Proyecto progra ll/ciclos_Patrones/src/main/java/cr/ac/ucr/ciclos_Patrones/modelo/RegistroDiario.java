package cr.ac.ucr.ciclos_Patrones.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tb_resgistroDiario")
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Integer id;
    @Column(name="date", nullable = false)
    private LocalDate date;
    @Column(name="estadoAnimo", nullable = false)
    private String estadoAnimo;
    @Column(name="sintoma", nullable = false)
    private String sintoma;
    @Column(name="observaciones", nullable = false)
    private String observaciones;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    //Metodo constructor con parametros
    public RegistroDiario(Integer id, LocalDate date, String estadoAnimo, String sintomas, String observaciones, Usuario usuario) {
        this.id = id;
        this.date = date;
        this.estadoAnimo = estadoAnimo;
        this.sintoma = sintomas;
        this.observaciones = observaciones;
        this.usuario = usuario;
    }

    //Metodo constructor sin parametros
    public RegistroDiario() {
        this.id = 0;
        this.date = LocalDate.now(); // Fecha actual
        this.estadoAnimo = "No especificado";
        this.sintoma = "Sin síntomas";
        this.observaciones = "Sin observaciones";
        this.usuario = new Usuario(); // Asumiendo que Usuario tiene un constructor vacío
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //-----------------------------------------------------------\\

    public String getEstadoAnimo() {
        return estadoAnimo;
    }

    public void setEstadoAnimo(String estadoAnimo) {
        this.estadoAnimo = estadoAnimo;
    }

    //-----------------------------------------------------------\\

    public String getSintomas() {
        return sintoma;
    }

    public void setSintomas(String sintoma) {
        this.sintoma = sintoma;
    }

    //-----------------------------------------------------------\\

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    //-----------------------------------------------------------\\

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //-----------------------------------------------------------\\

    @Override
    public String toString() {
        return "RegistroDiario{" +
                "id=" + id +
                ", date=" + date +
                ", estadoAnimo='" + estadoAnimo + '\'' +
                ", sintomas='" + sintoma + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", usuario=" + usuario.getId() +  // o .getNombre()
                '}';
    }

}//Fin de la clase ResgistroDiario
