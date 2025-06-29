package cr.ac.ucr.ciclos_Patrones.repository;

import cr.ac.ucr.ciclos_Patrones.modelo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Integer> {

    // Buscar todos los chats por un usuario específico
    List<Chat> findByUsuarioId(Integer usuarioId);

    // Buscar por título (opcional, si se quiere filtrar por texto exacto)
    List<Chat> findByTitulo(String titulo);

    // Buscar por título que contenga parte del texto (ignorando mayúsculas/minúsculas)
    List<Chat> findByTituloContainingIgnoreCase(String titulo);

    // Buscar por fecha de inicio (exacta)
    List<Chat> findByFechaInicio(LocalDateTime fechaInicio);

}
