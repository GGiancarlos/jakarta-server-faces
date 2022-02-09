package org.example.services;

import org.example.data.model.TblPersona;
import org.example.data.repository.TblPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    TblPersonaRepository tblPersonaRepository;

    @Override
    public List<TblPersona> listarPersona() {
        return tblPersonaRepository.findAll();
    }

    @Override
    public void eliminarPersona(TblPersona persona) {
        tblPersonaRepository.delete(persona);
    }

    @Override
    public void actualizarPersona(TblPersona persona) {
        tblPersonaRepository.save(persona);
    }

}
