package cr.ac.ucr.ciclos_Patrones.services;

import cr.ac.ucr.ciclos_Patrones.modelo.Chat;
import cr.ac.ucr.ciclos_Patrones.repository.IChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private IChatRepository chatRepository;

    public List<Chat> listarTodos() {
        return chatRepository.findAll();
    }

    public Optional<Chat> obtenerPorId(Integer id) {
        return chatRepository.findById(id);
    }

    public List<Chat> listarPorUsuario(Integer usuarioId) {
        return chatRepository.findByUsuarioId(usuarioId);
    }

    public Chat guardar(Chat chat) {
        return chatRepository.save(chat);
    }

    public void eliminarPorId(Integer id) {
        chatRepository.deleteById(id);
    }
}
