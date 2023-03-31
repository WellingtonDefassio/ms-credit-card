package io.wdefassio.mscreditcard.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.wdefassio.mscreditcard.domain.Card;
import io.wdefassio.mscreditcard.domain.CardsClient;
import io.wdefassio.mscreditcard.domain.SolicitationCardData;
import io.wdefassio.mscreditcard.repository.CardRepository;
import io.wdefassio.mscreditcard.repository.CardsClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissionCardSubscriber {

    private final CardRepository cardRepository;
    private final CardsClientRepository cardsClientRepository;

    @RabbitListener(queues = "${mq.queues.emission-card}")
    public void receiveEmissionCardSolicitation(@Payload String payload) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            SolicitationCardData solicitationCardData = mapper.readValue(payload, SolicitationCardData.class);

            Card card = cardRepository.findById(solicitationCardData.getId()).get();
            CardsClient cardsClient = new CardsClient(null, solicitationCardData.getCpf(), card, solicitationCardData.getApprovedLimit());
            cardsClientRepository.save(cardsClient);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }


}
