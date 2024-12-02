package com.pdm.farming.Repository;

import com.pdm.farming.Entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    // Find by Farmer ID
    List<Weather> findByFarmer_FarmerId(Long farmerId);

    // Find by specific date
    List<Weather> findByDate(LocalDate date);

    // Find records within a date range
    List<Weather> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
