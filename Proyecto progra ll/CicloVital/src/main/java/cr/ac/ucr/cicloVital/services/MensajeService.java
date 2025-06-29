package cr.ac.ucr.cicloVital.services;

import cr.ac.ucr.cicloVital.modelo.Mensaje;
import cr.ac.ucr.cicloVital.repository.IMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    @Autowired
    private IMensajeRepository mensajeRepository;

    public List<Mensaje> listarTodos() {
        return mensajeRepository.findAll();
    }

    public Optional<Mensaje> obtenerPorId(Integer id) {
        return mensajeRepository.findById(id);
    }

    public List<Mensaje> listarPorChat(Integer chatId) {
        return mensajeRepository.findByChatIdOrderByFechaHoraAsc(chatId);
    }

    public List<Mensaje> buscarPorTexto(String texto) {
        return mensajeRepository.findByContenidoContainingIgnoreCase(texto);
    }

    public List<Mensaje> filtrarPorUsuario(boolean esUsuario) {
        return mensajeRepository.findByEsUsuario(esUsuario);
    }

    public List<Mensaje> filtrarPorRangoFecha(LocalDateTime desde, LocalDateTime hasta) {
        return mensajeRepository.findByFechaHoraBetween(desde, hasta);
    }

    public Mensaje guardar(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    public void eliminarPorId(Integer id) {
        mensajeRepository.deleteById(id);
    }
}
