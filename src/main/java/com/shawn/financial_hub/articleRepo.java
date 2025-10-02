package com.shawn.financial_hub;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface articleRepo extends JpaRepository<SavedArticles, Long> {

    @Query(value = "SELECT* FROM application_articles WHERE user_id = :user_id", nativeQuery = true)
    List<SavedArticles> getArticles(Long user_id);
}
