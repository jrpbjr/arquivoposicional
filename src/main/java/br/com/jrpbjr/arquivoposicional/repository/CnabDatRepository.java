package br.com.jrpbjr.arquivoposicional.repository;

import java.util.Optional;

import br.com.jrpbjr.arquivoposicional.entities.CnabDat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CnabDatRepository extends MongoRepository<CnabDat, String> {
    Optional<CnabDat> findByHeaderCompanyId(String companyId);
}
