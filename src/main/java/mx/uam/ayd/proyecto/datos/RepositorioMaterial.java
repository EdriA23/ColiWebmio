package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Material;

/**
 * Repositorio para Materiales
 */
public interface RepositorioMaterial extends CrudRepository <Material, Long> {
    
    // Métodos necesarios para el repositorio de Material
    // ...
}
