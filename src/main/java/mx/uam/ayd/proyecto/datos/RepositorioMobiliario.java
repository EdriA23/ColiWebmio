package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Mobiliario;

/**
 * Repositorio para Mobiliarios
 */
public interface RepositorioMobiliario extends CrudRepository <Mobiliario, Long> {
    
    // Métodos para el repositorio de Mobiliario
    // ...
}
