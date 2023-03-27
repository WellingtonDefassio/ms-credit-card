package io.wdefassio.mscreditcard.service;

import io.wdefassio.mscreditcard.domain.CardsClient;
import io.wdefassio.mscreditcard.repository.CardsClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsClientService {

    private final CardsClientRepository cardsClientRepository;

    public List<CardsClient> clientCards(String cpf) {
       return cardsClientRepository.findByCpf(cpf);
    }


}
