package co.edu.uceva.stailence1.controller;

import co.edu.uceva.stailence1.model.entities.Negocio;
import co.edu.uceva.stailence1.model.service.INegocioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/negocios")  // Prefijo para la ruta
public class NegocioRestController {

    private final INegocioService negocioService;

    public NegocioRestController(INegocioService negocioService) {
        this.negocioService = negocioService;
    }

    // Crear negocio
    @PostMapping
    public ResponseEntity<Negocio> crearNegocio(@RequestBody Negocio negocio) {
        Negocio creado = negocioService.save(negocio);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // Listar todos los Negocios
    @GetMapping
    public ResponseEntity<List<Negocio>> listarNegocios() {
        List<Negocio> Negocios = negocioService.findAll();
        return ResponseEntity.ok(Negocios);
    }

    // Buscar un negocio por id
    @GetMapping("/{id}")
    public ResponseEntity<Negocio> obtenerNegocio(@PathVariable Long id) {
        Negocio negocio = negocioService.findById(id);
        if (negocio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(negocio);
    }

    // Actualizar un negocio
    @PutMapping("/{id}")
    public ResponseEntity<Negocio> actualizarNegocio(@PathVariable Long id, @RequestBody Negocio negocio) {
        Negocio negocioExistente = negocioService.findById(id);
        if (negocioExistente != null) {
            negocio.setId_Negocios(id);
            Negocio actualizado = negocioService.save(negocio);
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un negocio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNegocio(@PathVariable Long id) {
        negocioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}