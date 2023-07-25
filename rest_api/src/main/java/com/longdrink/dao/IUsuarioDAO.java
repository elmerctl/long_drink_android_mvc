package com.longdrink.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.longdrink.model.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Integer> {

	List<Usuario> findAllByactivo(int activo);

	Optional<Usuario> findByid(Integer id);

	Optional<Usuario> findByNombre_usuario(String nombre_usuario);
}
