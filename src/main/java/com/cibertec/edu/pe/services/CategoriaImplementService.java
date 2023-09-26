package com.cibertec.edu.pe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.Categoria;
import com.cibertec.edu.pe.repository.CategoriaRepository;

@Service
public class CategoriaImplementService implements ICategoriaSevice{
	@Autowired
	private CategoriaRepository catRepository;
	@Override
	public Categoria registarCategoria(Categoria categoria) {		
		return catRepository.save(categoria);
	}

}
