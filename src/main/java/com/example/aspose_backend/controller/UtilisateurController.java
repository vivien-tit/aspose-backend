package com.example.aspose_backend.controller;

import com.example.aspose_backend.model.Utilisateur;
import com.example.aspose_backend.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getById(@PathVariable Integer id) {
        return utilisateurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Création classique
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Utilisateur utilisateur) {
        if (utilisateurService.emailExiste(utilisateur.getEmail())) {
            return ResponseEntity.badRequest().body("Cet e-mail est déjà utilisé.");
        }
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return ResponseEntity.ok(utilisateurService.save(utilisateur));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.findById(id)
                .map(existing -> {
                    existing.setNom(utilisateur.getNom());
                    existing.setEmail(utilisateur.getEmail());
                    existing.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
                    return ResponseEntity.ok(utilisateurService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (utilisateurService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        utilisateurService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //  Méthode d'inscription (register)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur utilisateur) {
        if (utilisateurService.emailExiste(utilisateur.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("message", "Cet e-mail est déjà utilisé."));
        }
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        Utilisateur saved = utilisateurService.save(utilisateur);
        return ResponseEntity.ok(saved);
    }

    //  Méthode de connexion (login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        Utilisateur user = utilisateurService.findByEmail(dto.getEmail());
        if (user != null && passwordEncoder.matches(dto.getMotDePasse(), user.getMotDePasse())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Email ou mot de passe incorrect."));
    }
}
