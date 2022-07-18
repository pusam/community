package com.community.domain.contents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContentsRepository extends JpaRepository<Contents, Long> {
    @Query("SELECT c FROM Contents c ORDER BY c.contentId DESC")
    Page<Contents> findAllDesc(Pageable pageable);
}