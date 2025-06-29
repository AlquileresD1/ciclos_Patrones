package cr.ac.ucr.ciclos_Patrones.services;

import cr.ac.ucr.ciclos_Patrones.modelo.Mensaje;
import cr.ac.ucr.ciclos_Patrones.modelo.RegistroDiario;
import cr.ac.ucr.ciclos_Patrones.repository.IMensajeRepository;
import cr.ac.ucr.ciclos_Patrones.repository.IRegistroDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroDiarioService {

    @Autowired
    private IRegistroDiarioRepository registroRepository;

    public List<RegistroDiario> listarTodos() {
        return registroRepository.findAll();
    }

    public Optional<RegistroDiario> obtenerPorId(Integer id) {
        return registroRepository.findById(id);
    }

    public List<RegistroDiario> listarPorUsuario(Integer usuarioId) {
        return registroRepository.findByUsuarioId(usuarioId);
    }

    public List<RegistroDiario> listarPorFecha(LocalDate fecha) {
        return registroRepository.findByDate(fecha);
    }

    public List<RegistroDiario> listarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return registroRepository.findByDateBetween(inicio, fin);
    }

    public List<RegistroDiario> buscarPorEstadoAnimo(String estadoAnimo) {
        return registroRepository.findByEstadoAnimoContainingIgnoreCase(estadoAnimo);
    }

    public List<RegistroDiario> buscarPorSintoma(String sintoma) {
        return registroRepository.findBySintomaContainingIgnoreCase(sintoma);
    }

    public RegistroDiario guardar(RegistroDiario registro) {
        return registroRepository.save(registro);
    }

    public void eliminarPorId(Integer id) {
        registroRepository.deleteById(id);
    }

    // ✅ Validación de existencia de registro por usuario y fecha
    public boolean yaExisteRegistroEnFecha(Integer usuarioId, LocalDate fecha) {
        return !registroRepository.findByUsuarioIdAndDate(usuarioId, fecha).isEmpty();
    }
}
