package com.bookify.bookify.repository;

import com.bookify.bookify.model.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EbookRepository extends JpaRepository<Ebook, Long> {
}
