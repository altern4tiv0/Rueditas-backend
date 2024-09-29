package cibertec.edu.pe.ruedasBack.Service;

import cibertec.edu.pe.ruedasBack.DTO.AutoRequest;

import java.io.IOException;

public interface AutoService {
    String[] validarVehiculo(AutoRequest request) throws IOException;
}

