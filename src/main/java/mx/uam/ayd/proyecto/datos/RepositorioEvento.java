package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Evento;

/**
 * Repositorio para Eventos
 */
public interface RepositorioEvento extends CrudRepository <Evento, Long> {
    
    // Métodos necesarios para el repositorio
    // ...
}
