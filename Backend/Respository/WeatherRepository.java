package com.pdm.farming.Repository;

import com.pdm.farming.Entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    // Tìm theo ID nông dân
    List<Weather> findByFarmer_FarmerId(Long farmerId);

    // Tìm theo ngày cụ thể
    List<Weather> findByRecordAt(LocalDate recordAt);

    // Tìm theo khoảng thời gian
    List<Weather> findByRecordAtBetween(LocalDate startDate, LocalDate endDate);
}
