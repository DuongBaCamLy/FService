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

    @PostMapping
    public ResponseEntity<Weather> createWeather(@RequestBody Weather weather) {
        Weather createdWeather = weatherService.createWeather(weather);
        return ResponseEntity.ok(createdWeather);
    }

    @GetMapping
    public ResponseEntity<List<Weather>> getAllWeather() {
        return ResponseEntity.ok(weatherService.getAllWeather());
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<Weather>> getWeatherByFarmerId(@PathVariable Long farmerId) {
        return ResponseEntity.ok(weatherService.getWeatherByFarmerId(farmerId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Weather>> getWeatherByDate(@PathVariable String date) {
        LocalDate recordDate = LocalDate.parse(date);
        return ResponseEntity.ok(weatherService.getWeatherByDate(recordDate));
    }

    @GetMapping("/range")
    public ResponseEntity<List<Weather>> getWeatherByDateRange(
            @RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ResponseEntity.ok(weatherService.getWeatherByDateRange(start, end));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weather> updateWeather(@PathVariable Long id, @RequestBody Weather weather) {
        return ResponseEntity.ok(weatherService.updateWeather(id, weather));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeather(@PathVariable Long id) {
        weatherService.deleteWeather(id);
        return ResponseEntity.noContent().build();
    }
}
