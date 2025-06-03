package com.springboot.test.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.test.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {


    List<Document> findByTitleContainingIgnoreCase(String keyword);

    // Filtering by author and fileType example
    Page<Document> findByAuthorContainingIgnoreCaseAndFileTypeContainingIgnoreCase(String author, String fileType, Pageable pageable);
}
