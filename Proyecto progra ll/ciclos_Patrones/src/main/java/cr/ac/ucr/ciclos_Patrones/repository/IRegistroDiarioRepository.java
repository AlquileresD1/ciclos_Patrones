package cr.ac.ucr.ciclos_Patrones.repository;

import cr.ac.ucr.ciclos_Patrones.modelo.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRegistroDiarioRepository extends JpaRepository<RegistroDiario, Integer> {

    //Todos los registros de un usuario
    List<RegistroDiario> findByUsuarioId(Integer usuarioId);

    //Registros en una fecha exacta
    List<RegistroDiario> findByDate(LocalDate date);

    //Registros dentro de un rango de fechas
    List<RegistroDiario> findByDateBetween(LocalDate start, LocalDate end);

    //Buscar por emoción
    List<RegistroDiario> findByEstadoAnimoContainingIgnoreCase(String estadoAnimo);

    //Buscar por síntoma
    List<RegistroDiario> findBySintomaContainingIgnoreCase(String sintoma);

    //Validar si ya existe un registro para un usuario en una fecha específica
    List<RegistroDiario> findByUsuarioIdAndDate(Integer usuarioId, LocalDate date);
}
