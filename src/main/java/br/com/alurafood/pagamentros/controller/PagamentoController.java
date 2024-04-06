package br.com.alurafood.pagamentros.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alurafood.pagamentros.dto.PagamentoDTO;
import br.com.alurafood.pagamentros.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    
    @Autowired
    private PagamentoService service;

    @GetMapping
    public Page<PagamentoDTO> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.listar(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> buscar(@PathVariable Long id) {
        PagamentoDTO pagamento = service.buscar(id);
        return ResponseEntity.ok(pagamento);
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> salvar(@RequestBody @Valid PagamentoDTO pagamento, UriComponentsBuilder uriBuildar) {
        PagamentoDTO pagamentoSalvo = service.salvar(pagamento);
        URI endereco = uriBuildar.path("/pagamento/{id}").buildAndExpand(pagamento.getId()).toUri();
        
        return ResponseEntity.created(endereco).body(pagamentoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDTO> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDTO pagamento) {
        PagamentoDTO atualizado = service.atualizar(id, pagamento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagamentoDTO> deletar(@PathVariable @NotNull Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping("/{id}/confirmar")
    public void confirmarPagamento(@PathVariable @NotNull Long id){
        service.confirmarPagamento(id);
    }
}
