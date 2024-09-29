package cibertec.edu.pe.ruedasBack.Controller;

import cibertec.edu.pe.ruedasBack.DTO.AutoRequest;
import cibertec.edu.pe.ruedasBack.DTO.AutoResponse;
import cibertec.edu.pe.ruedasBack.Service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/autenticar")
public class AutoController {

    @Autowired
    private AutoService AutoService;

    @PostMapping
    public AutoResponse validarVehiculo(@RequestBody AutoRequest request) {
        System.out.println("request = " + request);

        try {
            String[] datosVehiculos = AutoService.validarVehiculo(request);
            if (datosVehiculos == null) {
                return new AutoResponse(

                        "01",
                        "Error: Auto no Encontrado",
                        "",
                        "",
                        "",
                        "",
                        "");
            }
            return new AutoResponse(

                    "00",
                    "",
                    datosVehiculos[0],
                    datosVehiculos[1],
                    datosVehiculos[2],
                    datosVehiculos[3],
                    datosVehiculos[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new AutoResponse(

                    "99",
                    "Error: Ocurrió un Problema",
                    "",
                    "",
                    "",
                    "",
                    "");
        }
    }
}