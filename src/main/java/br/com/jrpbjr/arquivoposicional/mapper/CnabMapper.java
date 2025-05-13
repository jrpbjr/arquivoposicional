package br.com.jrpbjr.arquivoposicional.mapper;

import br.com.jrpbjr.arquivoposicional.dtos.CnabResponseDto;
import br.com.jrpbjr.arquivoposicional.entities.CnabDat;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface CnabMapper {
    default CnabResponseDto toDto(CnabDat cnabDat) {
        return new CnabResponseDto(cnabDat);
    }
}