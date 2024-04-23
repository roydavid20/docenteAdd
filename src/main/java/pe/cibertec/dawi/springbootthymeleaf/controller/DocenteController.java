package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.DocenteRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class DocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    @PostMapping("/delete")
    public String deleteDocente(@ModelAttribute("docenteId") int docenteId, Model model) {

//        System.out.println(docenteId);
        docenteRepository.deleteById(docenteId);
        List<DocenteEntity> docenteLst = docenteRepository.findAll();
        model.addAttribute("docente", new DocenteEntity());
        model.addAttribute("docentes", docenteLst);
        model.addAttribute("message", "Formulario para CRUD Docente");

        return "redirect:/inicio?success=Docente+eliminado+correctamente&action=delete";
    }

    @GetMapping({"/docentes", "/", "/inicio"})
    public String retornaSaludo(Model model) {

        List<DocenteEntity> docenteLst = docenteRepository.findAll();

        for (DocenteEntity docente : docenteLst) {
            System.out.println(docente.getName() + " " + docente.getLastName());
        }

        model.addAttribute("docentes", docenteLst);
        model.addAttribute("docente", new DocenteEntity());
        model.addAttribute("message", "Formulario para CRUD Docente");
        return "index";
    }


    @GetMapping("/home")
    public String home() {
        return "home";
    }



    @PostMapping("/guardar")
    public String guardarDocente(@ModelAttribute("docente") DocenteEntity docente, Model model) {
        docenteRepository.save(docente);


        List<DocenteEntity> docenteLst = docenteRepository.findAll();
        model.addAttribute("docentes", docenteLst);
        model.addAttribute("docente", new DocenteEntity());
        model.addAttribute("message", "Formulario para CRUD Docente");

        return "redirect:/inicio?success=Docente+agregado+correctamente&action=save";

    }

    @PostMapping("/edit")
    public String editDocente(@ModelAttribute("docenteId") int docenteId, Model model) {

//        System.out.println(docenteId);

       Optional<DocenteEntity> docenteEntity = docenteRepository.findById(docenteId);
        List<DocenteEntity> docenteLst = docenteRepository.findAll();
        model.addAttribute("docente", docenteEntity.isPresent() ? docenteEntity : new DocenteEntity());
        model.addAttribute("docentes", docenteLst);
        model.addAttribute("message", "Formulario para CRUD Docente");

        return "index";
    }


}
