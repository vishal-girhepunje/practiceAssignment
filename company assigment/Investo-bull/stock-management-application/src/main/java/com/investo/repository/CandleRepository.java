package com.investo.repository;

import com.investo.model.Candle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandleRepository extends JpaRepository<Candle, Integer> {
}