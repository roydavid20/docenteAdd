package pe.cibertec.dawi.springbootthymeleaf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "curso")
@Table(name = "curso")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String edicionCurso;

    private String nombre;

    private String anioCurso;
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private DocenteEntity docente;




}
