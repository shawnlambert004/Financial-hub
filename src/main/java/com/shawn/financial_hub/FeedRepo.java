package com.shawn.financial_hub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface FeedRepo
                extends JpaRepository<Feed, Long> {
        Feed findByUrl(String url);

        @Query("SELECT f.url FROM Feed f WHERE f.user.id = :user_id")
        List<String> findUrlsbyUserId(Long user_id);
}
// FeedRepo