package cr.ac.ucr.cicloVital.repository;

import cr.ac.ucr.cicloVital.modelo.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {

    // Obtener todos los mensajes de un chat específico
    List<Mensaje> findByChatId(Integer chatId);

    // Obtener todos los mensajes de un chat ordenados por fechaHora
    List<Mensaje> findByChatIdOrderByFechaHoraAsc(Integer chatId);

    // Buscar mensajes que contienen texto específico en su contenido (sin distinción entre mayúsculas/minúsculas)
    List<Mensaje> findByContenidoContainingIgnoreCase(String texto);

    // Filtrar mensajes por si fueron escritos por el usuario o el sistema
    List<Mensaje> findByEsUsuario(boolean esUsuario);

    // Obtener mensajes dentro de un rango de tiempo específico
    List<Mensaje> findByFechaHoraBetween(LocalDateTime desde, LocalDateTime hasta);
}
