package com.desafio.forohub.domain.curso;

import com.desafio.forohub.domain.curso.dto.ActualizarCursoDTO;
import com.desafio.forohub.domain.curso.dto.CrearCursoDTO;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
@Entity(name = "Curso")
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;

    public Curso(CrearCursoDTO crearCursoDTO) {
        this.name = crearCursoDTO.name();
        this.categoria = crearCursoDTO.categoria();
        this.activo = true; //Automaticamente el curso estara activo.
    }

    public void actualizarCurso(ActualizarCursoDTO actualizarCursoDTO) {

        if(actualizarCursoDTO.name() != null){
            this.name = actualizarCursoDTO.name();
        }
        if (actualizarCursoDTO.categoria() != null){
            this.categoria = actualizarCursoDTO.categoria();
        }
        if (actualizarCursoDTO.activo() != null){
            this.activo = actualizarCursoDTO.activo();
        }
    }

    public void eliminarCurso(){
        this.activo = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
