package cr.ac.ucr.cicloVital.repository;

import cr.ac.ucr.cicloVital.modelo.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRegistroDiarioRepository extends JpaRepository<RegistroDiario, Integer> {

    List<RegistroDiario> findByUsuarioId(Integer usuarioId);

    List<RegistroDiario> findByDate(LocalDate date);

    List<RegistroDiario> findByDateBetween(LocalDate start, LocalDate end);

    List<RegistroDiario> findByEstadoAnimoContainingIgnoreCase(String estadoAnimo);

    List<RegistroDiario> findBySintomaContainingIgnoreCase(String sintoma);

    //Para validar si ya hay un registro en una fecha para un usuario
    List<RegistroDiario> findByUsuarioIdAndDate(Integer usuarioId, LocalDate date);
}
