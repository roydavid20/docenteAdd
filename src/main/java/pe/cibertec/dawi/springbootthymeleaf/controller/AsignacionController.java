package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.dawi.springbootthymeleaf.model.CursoEntity;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.CursoRepository;
import pe.cibertec.dawi.springbootthymeleaf.repository.DocenteRepository;

import java.util.List;

@Controller

public class AsignacionController {


    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DocenteRepository docenteRepository;


    @GetMapping({"/asignacion", "/" })
    public String retornaSludo(Model model){
        List<CursoEntity> cursolist = cursoRepository.findAll();
        for (CursoEntity curso: cursolist){

            System.out.println(curso.getNombre() + "" + curso.getEdicionCurso());
        }
        model.addAttribute("cursos", cursolist);
        model.addAttribute("curso", new CursoEntity());
        model.addAttribute("message", "Formulario para CRUD Cursos");
        return "asignacion";
    }

    @GetMapping({"/addCursDocente"})
    public String comboDocente(@ModelAttribute("cursoId") int cursoId, Model model){
        CursoEntity cursoAsignacion = cursoRepository.findById(cursoId).orElse(null);
        List<DocenteEntity> comboDocente = docenteRepository.findAll();
        model.addAttribute("cursoA", cursoAsignacion);
        model.addAttribute("docentes", comboDocente);
        model.addAttribute("message", "Asignar Docente a Curso");
        return "AddCurso";
    }
    @PostMapping("/addCursDocente") // Agregué esta anotación para manejar la solicitud POST
    public String asignarDocente(@ModelAttribute("cursoId") CursoEntity curso,
                                 Model model) {
        cursoRepository.save(curso);
        model.addAttribute("message" , "Formulario Para Asignar");
        return "redirect:/addCursDocente?cursoId=";
}
}
