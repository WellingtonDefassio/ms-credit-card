package io.wdefassio.mscreditcard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CardsClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    @ManyToOne()
    @JoinColumn(name = "id_card")
    private Card card;
    private BigDecimal approvedLimit;

}
