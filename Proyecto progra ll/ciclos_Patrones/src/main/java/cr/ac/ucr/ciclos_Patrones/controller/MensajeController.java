package cr.ac.ucr.ciclos_Patrones.controller;

import cr.ac.ucr.ciclos_Patrones.modelo.Mensaje;
import cr.ac.ucr.ciclos_Patrones.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    // GET: Listar todos los mensajes
    @GetMapping
    public ResponseEntity<?> listarMensajes() {
        List<Mensaje> mensajes = mensajeService.listarTodos();
        if (mensajes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No existen mensajes registrados");
        }
        return ResponseEntity.ok(mensajes);
    }

    // POST: Agregar nuevo mensaje
    @PostMapping
    public ResponseEntity<?> agregarMensaje(@Validated @RequestBody Mensaje mensaje, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }

        Mensaje mensajeGuardado = mensajeService.guardar(mensaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensajeGuardado);
    }

    // GET: Buscar mensaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMensaje(@PathVariable Integer id) {
        Optional<Mensaje> mensaje = mensajeService.obtenerPorId(id);
        if (!mensaje.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El mensaje con ID " + id + " no se encuentra registrado");
        }
        return ResponseEntity.ok(mensaje);
    }

    // DELETE: Eliminar mensaje por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        Optional<Mensaje> mensaje = mensajeService.obtenerPorId(id);
        if (!mensaje.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El mensaje con ID " + id + " no se encuentra registrado");
        }
        mensajeService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    // PUT: Actualizar mensaje por ID
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@Validated @PathVariable Integer id,
                                        @RequestBody Mensaje mensaje, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }

        Optional<Mensaje> mensajeExistente = mensajeService.obtenerPorId(id);
        if (!mensajeExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El mensaje con ID " + id + " no se encuentra registrado");
        }

        mensaje.setId(id);
        Mensaje actualizado = mensajeService.guardar(mensaje);
        return ResponseEntity.ok(actualizado);
    }

    // GET: Listar todos los mensajes de un chat específico
    @GetMapping("/porChat/{chatId}")
    public ResponseEntity<?> listarPorChat(@PathVariable Integer chatId) {
        List<Mensaje> mensajes = mensajeService.listarPorChat(chatId);
        if (mensajes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No hay mensajes registrados para el chat con ID " + chatId);
        }
        return ResponseEntity.ok(mensajes);
    }


}
