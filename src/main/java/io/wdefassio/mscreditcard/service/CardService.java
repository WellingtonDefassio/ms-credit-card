package io.wdefassio.mscreditcard.service;

import io.wdefassio.mscreditcard.domain.Card;
import io.wdefassio.mscreditcard.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card) {
        return  cardRepository.save(card);
    }

    public List<Card> getCardByIncome(Long income) {
        BigDecimal incomeBigDecimal = BigDecimal.valueOf(income);
        return cardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }


}
