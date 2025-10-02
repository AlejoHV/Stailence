package co.edu.uceva.stailence1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.uceva.stailence1.model.entities.Pago;
import co.edu.uceva.stailence1.model.service.IPagoService;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoRestController {

    @Autowired
    private IPagoService pagoService;

    @GetMapping
    public List<Pago> listar() {
        return pagoService.findAll();
    }

    @PostMapping
    public Pago crear(@RequestBody Pago pago) {
        return pagoService.save(pago);
    }

    @GetMapping("/{id}")
    public Pago obtenerPorId(@PathVariable Long id) {
        return pagoService.findById(id);
    }

    @PutMapping("/{id}")
    public Pago actualizar(@RequestBody Pago pago, @PathVariable Long id) {
        Pago existente = pagoService.findById(id);
        if (existente != null) {
            existente.setValor(pago.getValor());
            existente.setFecha(pago.getFecha());
            existente.setMetodoPago(pago.getMetodoPago());
            existente.setCita(pago.getCita());
            return pagoService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pagoService.delete(id);
    }
}