package io.wdefassio.mscreditcard.dto;

import io.wdefassio.mscreditcard.domain.Card;
import io.wdefassio.mscreditcard.domain.FlagCard;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class CardSaveRequest {
    private String name;
    @Enumerated(EnumType.STRING)
    private String flag;
    private BigDecimal income;
    private BigDecimal baseLimit;
    public Card toModel() {
        return Card.builder()
                .name(name)
                .flag(FlagCard.valueOf(flag))
                .income(income)
                .baseLimit(baseLimit)
                .build();
    }

}
