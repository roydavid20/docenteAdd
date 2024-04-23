package pe.cibertec.dawi.springbootthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.dawi.springbootthymeleaf.model.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
}
