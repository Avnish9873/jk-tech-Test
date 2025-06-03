package com.springboot.test.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.test.entity.Document;
import com.springboot.test.repository.DocumentRepository;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document saveDocument(Document doc) {
        doc.setUploadDate(LocalDateTime.now());
        return documentRepository.save(doc);
    }

    public List<Document> searchByKeyword(String keyword) {
        return documentRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public Page<Document> filterDocuments(String author, String fileType, Pageable pageable) {
        return documentRepository.findByAuthorContainingIgnoreCaseAndFileTypeContainingIgnoreCase(author, fileType, pageable);
    }
}
