package digital.quintino.financeiroapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digital.quintino.financeiroapi.domain.PessoaDomain;
import digital.quintino.financeiroapi.domain.TipoPessoaDomain;
import digital.quintino.financeiroapi.dto.PessoaResponseDTO;
import digital.quintino.financeiroapi.repository.TipoPessoaInterfaceRepository;
import digital.quintino.financeiroapi.service.PessoaService;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private TipoPessoaInterfaceRepository tipoPessoaInterfaceRepository;
	
	@GetMapping("/tipo-pessoa")
	public ResponseEntity<List<TipoPessoaDomain>> recuperarTipoPessoa() {
		return ResponseEntity.ok(this.tipoPessoaInterfaceRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<PessoaResponseDTO> saveOne(@RequestBody @Valid PessoaDomain pessoaDomain) {
		return new ResponseEntity<>(this.pessoaService.saveOne(pessoaDomain), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaResponseDTO>> findAll() {
		return ResponseEntity.ok(this.pessoaService.findAll());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<PessoaResponseDTO> findOne(@PathVariable(value = "codigo") Long codigo) {
		PessoaResponseDTO pessoaResponseDTO = this.pessoaService.findOne(codigo);
		if(pessoaResponseDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(pessoaResponseDTO);
		}
	}
	
	@DeleteMapping("/{codigo}")
	public void deleteOne(@PathVariable(value = "codigo") Long codigo) {
		this.pessoaService.deleteOne(codigo);
	}
	
	@PutMapping
	public PessoaResponseDTO update(@RequestBody PessoaDomain pessoaDomain) {
		return this.pessoaService.updateOne(pessoaDomain);
	}
	
}
