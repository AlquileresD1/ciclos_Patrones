package cr.ac.ucr.ciclos_Patrones.services;

import cr.ac.ucr.ciclos_Patrones.modelo.Usuario;
import cr.ac.ucr.ciclos_Patrones.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Optional<Usuario> login(String correo, String password) {
        return usuarioRepository.findByCorreoAndPassword(correo, password);
    }

    public List<Usuario> buscarPorEdad(Integer edad) {
        return usuarioRepository.findByEdad(edad);
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
