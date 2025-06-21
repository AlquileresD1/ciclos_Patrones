package cr.ac.ucr.ciclos_Patrones.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="resgistroDiario_db")
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Integer id;
    @Column(name="date", nullable = false)
    private LocalDate date;
    @Column(name="estadoAnimo", nullable = false, length = 50)
    private String estadoAnimo;
    @Column(name="sintomas", nullable = false, length = 50)
    private String sintomas;
    @Column(name="observaciones", nullable = false)
    private String observaciones;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public RegistroDiario(Integer id, LocalDate date, String estadoAnimo, String sintomas, String observaciones, Usuario usuario) {
        this.id = id;
        this.date = date;
        this.estadoAnimo = estadoAnimo;
        this.sintomas = sintomas;
        this.observaciones = observaciones;
        this.usuario = usuario;
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
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
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
                ", sintomas='" + sintomas + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", usuario=" + usuario.getId() +  // o .getNombre()
                '}';
    }

}//Fin de la clase ResgistroDiario
