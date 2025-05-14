package br.com.jrpbjr.arquivoposicional.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.jrpbjr.arquivoposicional.dtos.CnabResponseDto;
import br.com.jrpbjr.arquivoposicional.entities.CnabDat;
import br.com.jrpbjr.arquivoposicional.mapper.CnabMapper;
import br.com.jrpbjr.arquivoposicional.service.CnabFileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


@ExtendWith(MockitoExtension.class)
class CnabFileControllerTest {

    @Mock
    private CnabFileService cnabFileService;

    @Mock
    private CnabMapper cnabMapper;

    // Substituiremos o uso de @InjectMocks
    private CnabFileController cnabFileController;

    @Test
    void testUploadFile() {
        // Instância manual do controlador com os mocks
        cnabFileController = new CnabFileController(cnabFileService, cnabMapper);

        // Mock do arquivo MultipartFile
        MultipartFile mockFile = new MockMultipartFile("file", "test.txt", "text/plain",
                "Mock file content".getBytes());
        CnabDat mockCnabDat = new CnabDat();
        CnabResponseDto mockCnabResponseDto = new CnabResponseDto();

        when(cnabFileService.cnabFilePosicional(mockFile)).thenReturn(mockCnabDat);
        when(cnabMapper.toDto(mockCnabDat)).thenReturn(mockCnabResponseDto);

        ResponseEntity<CnabResponseDto> response = cnabFileController.uploadFile(mockFile);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCnabResponseDto, response.getBody());
    }
}
