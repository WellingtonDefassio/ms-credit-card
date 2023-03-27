package io.wdefassio.mscreditcard.dto;

import io.wdefassio.mscreditcard.domain.CardsClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CardsByClientResponse {

    private String nome;
    private String flag;
    private BigDecimal approvedLimit;


    public static CardsByClientResponse fromModel(CardsClient model) {
        return CardsByClientResponse.builder()
                .nome(model.getCard().getName())
                .flag(model.getCard().getFlag().name())
                .approvedLimit(model.getApprovedLimit()).build();
    }


}
