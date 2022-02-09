package org.example.services;

import org.example.data.model.TblPersona;

import java.util.List;

public interface IPersonaService {
    List<TblPersona> listarPersona();

    void eliminarPersona(TblPersona persona);

    void actualizarPersona(TblPersona persona);
}
