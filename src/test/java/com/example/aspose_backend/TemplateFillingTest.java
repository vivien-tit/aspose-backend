package com.example.aspose_backend;

import com.aspose.words.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemplateFillingTest {

    @Test
    public void testRemplissageTemplate() throws Exception {
        // Charger le template
        String templatePath = "src/main/resources/templates/template.docx";
        Document doc = new Document(templatePath);

        // Préparer les données à injecter
        Map<String, String> data = new HashMap<>();
        data.put("nom", "Jean Dupont");
        data.put("date", "15 mai 2025");

        // Remplacer les balises {{nom}}, {{date}}, etc.
        for (Map.Entry<String, String> entry : data.entrySet()) {
            doc.getRange().replace(
                "{{" + entry.getKey() + "}}",
                entry.getValue(),
                new FindReplaceOptions()
            );
        }

        // Enregistrer le résultat
        String outputPath = "generated/resultat.docx";
        File outFile = new File(outputPath);
        outFile.getParentFile().mkdirs(); // crée le dossier si besoin
        doc.save(outputPath);

        // Vérifier que le fichier a été généré
        assertTrue(outFile.exists(), "Le fichier généré est introuvable.");
    }
}
