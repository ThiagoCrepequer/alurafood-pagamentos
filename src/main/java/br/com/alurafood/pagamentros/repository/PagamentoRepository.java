package br.com.alurafood.pagamentros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alurafood.pagamentros.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    
}
