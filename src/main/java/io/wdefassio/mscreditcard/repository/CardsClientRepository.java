package io.wdefassio.mscreditcard.repository;

import io.wdefassio.mscreditcard.domain.CardsClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsClientRepository extends JpaRepository<CardsClient,Long> {

    List<CardsClient> findByCpf(String cpf);

}
