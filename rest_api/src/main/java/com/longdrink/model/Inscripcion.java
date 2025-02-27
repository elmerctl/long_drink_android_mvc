package com.longdrink.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inscripcion")
@IdClass(Inscripcion.class)
public class Inscripcion {
    /*
    * IdClass ->> Debido a que es una Composite Key.
    * Cambio en nombre de campos: Debido a incompatibilidad de CrudRepository con nombres
    * de tipo id_alumno ->
    * Se pasa el campo a idalumno y nombre de columna id_alumno.
    * Getter y setter sin novedades.
    * Vease documentación de referencia: https://i.imgur.com/TKwO1r8.mp4
    *
    * */
    @Id
    @Column(name="id_alumno")
    private int idalumno;
    @Id
    @Column(name="id_curso")
    private int idcurso;
    @Column(name="fecha_inicio_curso")
    private Date fechainiciocurso;
    @Column(name="fecha_final_curso")
    private Date fechafinalcurso;
    @Column(name="fecha_inscripcion")
    private Date fechainscripcion;
    private int terminado;
    private int activo;

    public Inscripcion(){}

    public Inscripcion(int id_alumno, int id_curso, Date fecha_inicio_curso, Date fecha_final_curso, Date fecha_inscripcion, int terminado, int activo) {
        this.idalumno = id_alumno;
        this.idcurso = id_curso;
        this.fechainiciocurso = fecha_inicio_curso;
        this.fechafinalcurso = fecha_final_curso;
        this.fechainscripcion = fecha_inscripcion;
        this.terminado = terminado;
        this.activo = activo;
    }

    public boolean isEmpty(){
        return this.idalumno != 0 && this.idcurso != 0 && this.fechainiciocurso != null &&
                this.fechafinalcurso != null && this.fechainscripcion != null &&
                this.terminado == 0 || this.terminado == 1 && this.activo == 0 || this.activo == 1;
    }
    public int getId_alumno() {
        return idalumno;
    }

    public void setId_alumno(int id_alumno) {
        this.idalumno = id_alumno;
    }

    public int getId_curso() {
        return idcurso;
    }

    public void setId_curso(int id_curso) {
        this.idcurso = id_curso;
    }

    public Date getFecha_inicio_curso() {
        return fechainiciocurso;
    }

    public void setFecha_inicio_curso(Date fecha_inicio_curso) {
        this.fechainiciocurso = fecha_inicio_curso;
    }

    public Date getFecha_final_curso() {
        return fechafinalcurso;
    }

    public void setFecha_final_curso(Date fecha_final_curso) {
        this.fechafinalcurso = fecha_final_curso;
    }

    public Date getFecha_inscripcion() {
        return fechainscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fechainscripcion = fecha_inscripcion;
    }

    public int getTerminado() {
        return terminado;
    }

    public void setTerminado(int terminado) {
        this.terminado = terminado;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
