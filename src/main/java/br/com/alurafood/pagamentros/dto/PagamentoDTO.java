package br.com.alurafood.pagamentros.dto;

import java.math.BigDecimal;

import br.com.alurafood.pagamentros.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDTO {
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long formaDePagamentoId;
    private Long pedidoId;
}
