package com.example.aspose_backend;

import com.aspose.words.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConventionTemplateTest {

    @Test
    public void testGenererConventionRemplie() throws Exception {
        // Charger le modèle
        String cheminTemplate = "src/main/resources/templates/convention.docx";
        Document doc = new Document(cheminTemplate);

        // Variables à injecter
        Map<String, String> variables = new HashMap<>();
        variables.put("reference", "REF-2025-001");
        variables.put("villeconge", "Yaoundé");
        variables.put("villeperm", "Douala");
        variables.put("dateSaisie", "12 mai 2025");
        variables.put("nom", "Jean Dupont");
        variables.put("fonction", "Responsable Financier");
        variables.put("unite", "Département Crédit");
        variables.put("matricule", "001245");
        variables.put("NomClient", "vivien");
        variables.put("Telephone", "651493949");
        variables.put("Adresse", "Yaoundé");
        variables.put("Email", "vtitsop4@gmail.com");
        variables.put("Nomdel’organismeprêteurousociete", "Afriland First Bank");
        variables.put("AdresseEmprunteur", "Douala");
        variables.put("TelephoneEmprunteur", "651493949");
        variables.put("EmailEmprunteur", "vtitsop4@gmail.com");
        variables.put("usageoumotifduprêtfacultatif", "l'investissement dans l'immobilier");
        variables.put("Montantdupret", "100.000.000");
        variables.put("Tauxd’interetannuel", "8");
        variables.put("Duredupret", "12");
        variables.put("Montantdechaqueecheance", "9.000.000");
        variables.put("Nombretotald’echeance", "12");
        variables.put("ville", "yaoundé");
        variables.put("date", "15 mai 2025");

        // Remplacement dans le document
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            doc.getRange().replace(
                "{" + entry.getKey() + "}", // regex pour capturer toute la forme
                entry.getValue(),
                new FindReplaceOptions()
        );
        }

        // Sauvegarder le document généré
        String cheminSortie = "generated/Convention_generee.docx";
        File fichier = new File(cheminSortie);
        fichier.getParentFile().mkdirs(); // Créer dossier si besoin
        doc.save(cheminSortie);

        // Vérification
        assertTrue(fichier.exists(), "Le fichier n’a pas été généré !");
    }
}
