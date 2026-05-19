package org.serratec.TrabalhoIndividualAPI.Service;

import org.serratec.TrabalhoIndividualAPI.Domain.Paciente;
import org.serratec.TrabalhoIndividualAPI.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


}
