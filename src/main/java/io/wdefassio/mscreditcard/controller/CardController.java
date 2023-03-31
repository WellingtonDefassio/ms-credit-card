package io.wdefassio.mscreditcard.controller;

import io.wdefassio.mscreditcard.domain.Card;
import io.wdefassio.mscreditcard.dto.CardsByClientResponse;
import io.wdefassio.mscreditcard.dto.CardSaveRequest;
import io.wdefassio.mscreditcard.service.CardService;
import io.wdefassio.mscreditcard.service.CardsClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardsClientService cardsClientService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CardSaveRequest request) {
        return ResponseEntity.ok(cardService.save(request.toModel()));
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getAllCardsAvailableByIncome(@RequestParam("income") Long income) {
        return ResponseEntity.ok(cardService.getCardByIncome(income));
    }
    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientResponse>> clientCards(@RequestParam("cpf") String cpf) {
        return ResponseEntity.ok(cardsClientService.clientCards(cpf)
                .stream()
                .map(CardsByClientResponse::fromModel)
                .collect(Collectors.toList()));
    }


}
