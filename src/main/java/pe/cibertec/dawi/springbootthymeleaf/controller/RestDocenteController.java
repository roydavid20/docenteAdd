package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDocenteController {


    @GetMapping("/saludo")
    public String saludoCibertec(){
        return "Hola Cibertec";
    }

}
