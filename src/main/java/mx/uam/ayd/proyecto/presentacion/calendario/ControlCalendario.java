package mx.uam.ayd.proyecto.presentacion.calendario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import mx.uam.ayd.proyecto.negocio.ServicioEvento;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Evento;

/**
 * Módulo de control para la historia de usuario: 
 * @author JLCB
 */
@Component
public class ControlCalendario {

    private final ServicioEvento servicioEvento;
    private final VentanaCalendario ventana;

    @Autowired
    public ControlCalendario(ServicioEvento servicioEvento, VentanaCalendario ventana) {
        this.servicioEvento = servicioEvento;
        this.ventana = ventana;
    }

    /**
	 * Método que se ejecuta después de la construcción del bean
	 * y realiza la conexión bidireccional entre el control y la ventana
	 */
    @PostConstruct
    public void init() {
        ventana.setControlCalendario(this);
    }

    /**
	 * Inicia la historia de usuario
	 * 
	 */
	public void iniciaCalendario() {
        LocalDate diaActual = servicioEvento.obtenerDiaActual();
        LocalDate diaLimite = servicioEvento.obtenerDiaLimite();
		List<Evento> eventos = servicioEvento.recuperaEventosPorMes(diaActual);
        List<Evento> eventosTotales = servicioEvento.recupera();
        ventana.muestra(eventos, eventosTotales, diaActual, diaLimite);
	}

    public void anteriorMes(LocalDate fecha){
        LocalDate fechaNueva = servicioEvento.disminuirMes(fecha);
        LocalDate diaLimite = servicioEvento.obtenerDiaLimite();
        List<Evento> eventos = servicioEvento.recuperaEventosPorMes(fechaNueva);
        List<Evento> eventosTotales = servicioEvento.recupera();
        ventana.muestra(eventos, eventosTotales, fechaNueva, diaLimite);
    }

    public void siguienteMes(LocalDate fecha){
        LocalDate fechaNueva = servicioEvento.aumentarMes(fecha);
        LocalDate diaLimite = servicioEvento.obtenerDiaLimite();
        List<Evento> eventos = servicioEvento.recuperaEventosPorMes(fechaNueva);
        List<Evento> eventosTotales = servicioEvento.recupera();
        ventana.muestra(eventos, eventosTotales, fechaNueva, diaLimite);
    }

    public Cliente obtenerCliente(Evento evento){
        return servicioEvento.obtenerCliente(evento);
    }

    public void diaPresionado(Object dato){
        List<Object> datos = new ArrayList<>();
        datos = servicioEvento.diaPresionado(dato);
        if(datos.get(0).toString().equals("FINALIZADO")){
            ventana.muestraDetallesFinalizado(datos);
        }else{
            ventana.muestraDetallesEvento(datos);
        }
    }
}
