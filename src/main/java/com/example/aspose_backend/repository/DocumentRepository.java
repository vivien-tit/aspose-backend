package com.example.aspose_backend.repository;

import com.example.aspose_backend.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    List<Document> findByUtilisateurId(Integer utilisateurId);
    List<Document> findByType(Document.Type type);
}
