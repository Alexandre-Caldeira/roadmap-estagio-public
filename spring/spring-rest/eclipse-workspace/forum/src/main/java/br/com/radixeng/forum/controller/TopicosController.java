package br.com.radixeng.forum.controller;

import br.com.radixeng.forum.controller.dto.DetalhesTopicoDTO;
import br.com.radixeng.forum.controller.dto.TopicoDTO;
import br.com.radixeng.forum.controller.form.AtualizacaoTopicoForm;
import br.com.radixeng.forum.controller.form.TopicoForm;
import br.com.radixeng.forum.modelo.Topico;
import br.com.radixeng.forum.repository.CursoRepository;
import br.com.radixeng.forum.repository.TopicoRepository;
import java.net.URI;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDTO> lista(String query) {
		if (query == null) {
		  return TopicoDTO.converter(topicoRepository.findAll());
		} else {
		  //			return TopicoDTO.converter(topicoRepository.findByCurso_Nome(query));
		  return TopicoDTO.converter(topicoRepository.buscarPorCategoria(query));
		}
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> cadastrar(
		@RequestBody @Valid TopicoForm form,
		UriComponentsBuilder uriBuilder
	) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		// passa apenas caminho do recurso, para Spring abstrair acesso em diferentes ambientes (prod, dev)
		URI uriNovoTopico = uriBuilder
		  .path("/topicos/{id}")
		  .buildAndExpand(topico.getId())
		  .toUri();
		
		return ResponseEntity.created(uriNovoTopico).body(new TopicoDTO(topico));
	}
	
	@GetMapping("/{id}")
	public DetalhesTopicoDTO detalhar(@PathVariable("id") Long idTopico) {
		Topico topico = topicoRepository.getById(idTopico);
		
		return new DetalhesTopicoDTO(topico);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDTO> atualizar(@PathVariable("id") Long idTopico,
			@RequestBody @Valid AtualizacaoTopicoForm form,
			UriComponentsBuilder uriBuilder) {
		Topico topico = form.atualizar(idTopico, topicoRepository);
		
		return ResponseEntity.ok(new TopicoDTO(topico));
	}
}
