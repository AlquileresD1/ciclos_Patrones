package cr.ac.ucr.ciclos_Patrones.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="tb_mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;
    @Column(nullable = false, length = 500)
    private String contenido;
    @Column(nullable = false)
    private boolean esUsuario; // true: usuario, false: asistente
    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    //Metodo constructor con parametros
    public Mensaje(Integer id, LocalDateTime fechaHora, String contenido, boolean esUsuario, Chat chat) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.esUsuario = esUsuario;
        this.chat = chat;
    }

    //Metodo constructor sin parametros
    public Mensaje() {
        this.id = 0;                            // o null si prefieres dejarlo sin asignar
        this.fechaHora = LocalDateTime.now();   // fecha-hora actuales
        this.contenido = "Sin contenido";       // texto genérico
        this.esUsuario = false;                 // por defecto lo marca como mensaje del sistema
        this.chat = new Chat();                 // asume que Chat tiene constructor vacío
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    //-----------------------------------------------------------\\

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    //-----------------------------------------------------------\\

    public boolean isEsUsuario() {
        return esUsuario;
    }

    public void setEsUsuario(boolean esUsuario) {
        this.esUsuario = esUsuario;
    }

    //-----------------------------------------------------------\\

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    //-----------------------------------------------------------\\

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", contenido='" + contenido + '\'' +
                ", esUsuario=" + esUsuario +
                ", chat=" + chat +
                '}';
    }

}//Fin de la clase mensaje
