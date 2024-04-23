package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.cibertec.dawi.springbootthymeleaf.model.CursoEntity;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.CursoRepository;

import java.util.List;

@Controller
public class CursoController {


    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/deleteCurso")
    public String deleteCurso(@ModelAttribute("cursoId") int cursoId, Model model){
        cursoRepository.deleteById(cursoId);
        List<CursoEntity> cursolist = cursoRepository.findAll();
        model.addAttribute("curso" , new CursoEntity());
        model.addAttribute("cursos", cursolist);
        model.addAttribute("message", "Formulario para CRUD Cursos");

        return  "redirect:/inicioC?success=Curso+Eliminado+Correctamente&action=delete";
    }

    @GetMapping({"/cursos", "/", "inicioC", })
    public String retornaSludo(Model model){
        List<CursoEntity> cursolist = cursoRepository.findAll();
        for (CursoEntity curso: cursolist){

            System.out.println(curso.getNombre() + "" + curso.getEdicionCurso());
        }
        model.addAttribute("cursos", cursolist);
        model.addAttribute("curso", new CursoEntity());
        model.addAttribute("message", "Formulario para CRUD Cursos");
        return "cursos";
    }

    @PostMapping("/guardarCurso")
    public String guardarCurso(@ModelAttribute("curso") CursoEntity curso, Model model) {
        cursoRepository.save(curso);


        List<CursoEntity> cursolist = cursoRepository.findAll();
        model.addAttribute("cursos", cursolist);
        model.addAttribute("curso", new CursoEntity());
        model.addAttribute("message", "Formulario para CRUD Cursos");

        return "redirect:/inicioC?success=Curso+agregado+correctamente&action=save";

    }
}
