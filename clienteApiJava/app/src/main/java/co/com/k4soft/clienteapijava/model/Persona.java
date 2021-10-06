package co.com.k4soft.clienteapijava.model;

import lombok.Data;

@Data
public class Persona {

    private Integer idPersona;
    private String numeroDocumento;
    private TipoDocumento tipoDocumento;
    private String nombre;
    private String apellido;
    private boolean activo;
}
