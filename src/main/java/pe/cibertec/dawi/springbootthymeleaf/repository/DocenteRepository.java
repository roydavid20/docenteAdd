package pe.cibertec.dawi.springbootthymeleaf.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {


}
