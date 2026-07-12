package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Pago;

/**
 * Repositorio para Pagos
 */
public interface RepositorioPago extends CrudRepository <Pago, Long> {
    
    // Métodos para el repositorio
    // ...
}
