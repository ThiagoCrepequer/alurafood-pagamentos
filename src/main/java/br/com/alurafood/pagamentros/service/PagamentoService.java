package br.com.alurafood.pagamentros.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alurafood.pagamentros.dto.PagamentoDTO;
import br.com.alurafood.pagamentros.model.Pagamento;
import br.com.alurafood.pagamentros.model.Status;
import br.com.alurafood.pagamentros.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PagamentoDTO> listar(Pageable paginacao) {
        return repository
            .findAll(paginacao)
            .map(p -> modelMapper.map(p, PagamentoDTO.class));
    }

    public PagamentoDTO buscar(Long id) {
        var pagamento = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado"));

        return modelMapper.map(pagamento, PagamentoDTO.class);
    }

    public PagamentoDTO salvar(PagamentoDTO dto) {
        var pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        var pagamentoSalvo = repository.save(pagamento);

        return modelMapper.map(pagamentoSalvo, PagamentoDTO.class);
    }

    public PagamentoDTO atualizar(Long id, PagamentoDTO dto) {
        var pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDTO.class);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
