package br.com.radixeng.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.radixeng.forum.dto.CursoDTO;
import br.com.radixeng.forum.repository.CursoRepository;

@RestController
public class CursosController {
	
	@Autowired
	CursoRepository cursoRepository;
	
	@RequestMapping("/cursos")
	public List<CursoDTO> listaTodos(){
		return CursoDTO.converter(cursoRepository.findAll());
	}
}
