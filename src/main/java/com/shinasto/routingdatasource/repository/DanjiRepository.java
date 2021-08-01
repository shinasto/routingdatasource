package com.shinasto.routingdatasource.repository;

import com.shinasto.routingdatasource.entity.Danji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanjiRepository extends JpaRepository<Danji, Integer> {
}
