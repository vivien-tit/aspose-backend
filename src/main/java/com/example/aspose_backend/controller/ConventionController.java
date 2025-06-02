package com.example.aspose_backend.controller;

import com.aspose.words.*;
import com.example.aspose_backend.dto.ConventionDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/convention")
@CrossOrigin(origins = "http://localhost:4200")

public class ConventionController {

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateDocument(@RequestBody ConventionDTO dto) throws Exception {
        Document doc = new Document("src/main/resources/templates/convention.docx");

        Map<String, String> variables = new HashMap<>();
        variables.put("reference", dto.reference);
        variables.put("villeconge", dto.villeconge);
        variables.put("villeperm", dto.villeperm);
        variables.put("dateSaisie", dto.dateSaisie);
        variables.put("nom", dto.nom);
        variables.put("fonction", dto.fonction);
        variables.put("unite", dto.unite);
        variables.put("matricule", dto.matricule);
        variables.put("NomClient", dto.NomClient);
        variables.put("Telephone", dto.Telephone);
        variables.put("Adresse", dto.Adresse);
        variables.put("Email", dto.Email);
        variables.put("Nomdel’organismeprêteurousociete", dto.NomOrganisme);
        variables.put("AdresseEmprunteur", dto.AdresseEmprunteur);
        variables.put("TelephoneEmprunteur", dto.TelephoneEmprunteur);
        variables.put("EmailEmprunteur", dto.EmailEmprunteur);
        variables.put("usageoumotifduprêtfacultatif", dto.usagePret);
        variables.put("Montantdupret", dto.montantPret);
        variables.put("Tauxd’interetannuel", dto.tauxInteret);
        variables.put("Duredupret", dto.dureePret);
        variables.put("Montantdechaqueecheance", dto.montantEcheance);
        variables.put("Nombretotald’echeance", dto.nombreEcheance);
        variables.put("ville", dto.ville);
        variables.put("date", dto.date);

        for (Map.Entry<String, String> entry : variables.entrySet()) {
            doc.getRange().replace(
                "{" + entry.getKey() + "}",
                entry.getValue(),
                new FindReplaceOptions()
            );
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        doc.save(out, SaveFormat.DOCX);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=convention.docx")
                .body(out.toByteArray());
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Bonjour depuis le backend !";
    }
}
