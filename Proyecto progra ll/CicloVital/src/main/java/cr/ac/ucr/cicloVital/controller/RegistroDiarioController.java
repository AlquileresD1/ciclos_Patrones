package cr.ac.ucr.cicloVital.controller;

import cr.ac.ucr.cicloVital.modelo.RegistroDiario;
import cr.ac.ucr.cicloVital.services.RegistroDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/registros")
public class RegistroDiarioController {

    @Autowired
    private RegistroDiarioService registroService;

    // GET: Listar todos los registros
    @GetMapping
    public ResponseEntity<?> listarRegistros() {
        List<RegistroDiario> registros = registroService.listarTodos();
        if (registros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No existen registros diarios aún.");
        }
        return ResponseEntity.ok(registros);
    }

    // POST: Agregar registro (con validación de fecha única)
    @PostMapping
    public ResponseEntity<?> agregarRegistro(@Validated @RequestBody RegistroDiario registro, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }

        Integer usuarioId = registro.getUsuario().getId();
        LocalDate fecha = registro.getDate();

        if (registroService.yaExisteRegistroEnFecha(usuarioId, fecha)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un registro diario para el usuario en la fecha " + fecha);
        }

        RegistroDiario guardado = registroService.guardar(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Optional<RegistroDiario> registro = registroService.obtenerPorId(id);
        if (!registro.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un registro con ID " + id);
        }
        return ResponseEntity.ok(registro);
    }

    // DELETE: Eliminar por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        Optional<RegistroDiario> registro = registroService.obtenerPorId(id);
        if (!registro.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El registro con ID " + id + " no existe.");
        }
        registroService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    // PUT: Actualizar registro
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@Validated @PathVariable Integer id,
                                        @RequestBody RegistroDiario registro, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }

        Optional<RegistroDiario> existente = registroService.obtenerPorId(id);
        if (!existente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un registro con ID " + id);
        }

        registro.setId(id);
        RegistroDiario actualizado = registroService.guardar(registro);
        return ResponseEntity.ok(actualizado);
    }
}