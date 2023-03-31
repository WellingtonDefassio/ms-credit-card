package io.wdefassio.mscreditcard.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SolicitationCardData {

    private Long id;
    private String cpf;
    private String address;
    private BigDecimal approvedLimit;


}
