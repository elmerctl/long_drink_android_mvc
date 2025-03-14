package com.longdrink.controller;

import com.longdrink.model.Alumno;
import com.longdrink.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService servAlum;

    //FRONT: Listar TODOS los alumnos.
    @GetMapping()
    public List<Alumno> listarAlumnos(){
        return servAlum.listarAlumnos();
    }

    //FRONT: Listar activos.
    @GetMapping("activos")
    public List<Alumno> listarAlumnosActivos(){
        return servAlum.listarAlumnosActivos();
    }

    //FRONT: Guardar alumno.
    @PostMapping("nuevo")
    public boolean guardarAlumno(@RequestBody Alumno a){
        Alumno alum = servAlum.guardarAlumno(a);
        if(alum != null){
            return true;
        }
        else{ return false; }
    }

    //FRONT: Actualizar alumno.
    //Nota: No debe actualizar campo activo, para eso esta el eliminar.
    @PutMapping("editar")
    public String editarAlumno(@RequestBody Alumno a){
        boolean respuesta = servAlum.buscarPorID(a.getId_alumno());
        if(respuesta){
            Alumno alum = servAlum.obtenerAlumno(a.getId_alumno());
            if(a.getAp_materno() == null) a.setAp_materno(alum.getAp_materno());
            if(a.getAp_paterno() == null) a.setAp_paterno(alum.getAp_paterno());
            if(a.getNombre() == null) a.setNombre(alum.getNombre());
            if(a.getDni() == null) a.setDni(alum.getDni());
            if(a.getEmail() == null) a.setEmail(alum.getEmail());
            a.setActivo(alum.getActivo());
            servAlum.actualizarAlumno(a);
            return "Success";

        }
        else{
            return "Failed";
        }
    }

    //FRONT: Obtener alumno por DNI.
    @GetMapping("dni")
    public Alumno obtenerPorDNI(@RequestParam String dni){
        return servAlum.obtenerAlumDNI(dni);
    }

    //FRONT: Eliminar alumno por ID.
    @DeleteMapping("eliminar/id")
    public boolean eliminarAlumID(@RequestParam int id){
        return servAlum.eliminarAlumnoID(id);
    }


}
