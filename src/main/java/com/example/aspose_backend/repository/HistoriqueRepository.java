package com.example.aspose_backend.repository;

import com.example.aspose_backend.model.Historique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueRepository extends JpaRepository<Historique, Integer> {
    List<Historique> findByDocumentId(Integer documentId);
}
