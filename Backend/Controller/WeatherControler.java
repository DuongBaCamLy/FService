package com.pdm.farming.Controller;

import com.pdm.farming.Entities.Weather;
import com.pdm.farming.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Create a new weather record
    @PostMapping
    public ResponseEntity<Weather> createWeather(@RequestBody Weather weather) {
        Weather savedWeather = weatherService.createWeather(weather);
        return ResponseEntity.ok(savedWeather);
    }

    // Get all weather records
    @GetMapping
    public ResponseEntity<List<Weather>> getAllWeather() {
        return ResponseEntity.ok(weatherService.getAllWeather());
    }

    // Get weather records by farmer ID
    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<Weather>> getWeatherByFarmerId(@PathVariable Long farmerId) {
        return ResponseEntity.ok(weatherService.getWeatherByFarmerId(farmerId));
    }

    // Get weather records by date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<Weather>> getWeatherByDate(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return ResponseEntity.ok(weatherService.getWeatherByDate(parsedDate));
    }

    // Get weather records by date range
    @GetMapping("/date-range")
    public ResponseEntity<List<Weather>> getWeatherByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ResponseEntity.ok(weatherService.getWeatherByDateRange(start, end));
    }

    // Update a weather record
    @PutMapping("/{id}")
    public ResponseEntity<Weather> updateWeather(@PathVariable Long id, @RequestBody Weather weather) {
        Weather updatedWeather = weatherService.updateWeather(id, weather);
        return ResponseEntity.ok(updatedWeather);
    }

    // Delete a weather record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeather(@PathVariable Long id) {
        weatherService.deleteWeather(id);
        return ResponseEntity.noContent().build();
    }
}
