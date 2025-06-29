package cr.ac.ucr.ciclos_Patrones.repository;

import cr.ac.ucr.ciclos_Patrones.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Buscar usuario por correo (ideal para login)
    Optional<Usuario> findByCorreo(String correo);

    // Buscar usuario por correo y contraseña (inicio de sesión básico)
    Optional<Usuario> findByCorreoAndPassword(String correo, String password);

    // Buscar todos los usuarios por edad
    List<Usuario> findByEdad(Integer edad);

    // Buscar usuarios por nombre exacto
    List<Usuario> findByNombre(String nombre);

    // Buscar usuarios cuyo nombre contenga parte del texto (ignorando mayúsculas/minúsculas)
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}
