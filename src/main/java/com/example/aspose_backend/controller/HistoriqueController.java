package com.example.aspose_backend.controller;

import com.example.aspose_backend.dto.HistoriqueDTO;
import com.example.aspose_backend.service.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historiques")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoriqueController {

    @Autowired
    private HistoriqueService historiqueService;

    @GetMapping
    public List<HistoriqueDTO> getAll() {
        return historiqueService.getAllHistorique();
    }

    @GetMapping("/document/{id}")
    public List<HistoriqueDTO> getByDocument(@PathVariable Long id) {
        return historiqueService.getHistoriqueByDocumentId(id);
    }
}

