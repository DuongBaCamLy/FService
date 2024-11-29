package com.pdm.farming.Service;

import com.pdm.farming.Entities.Weather;
import com.pdm.farming.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public Weather createWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    public List<Weather> getWeatherByFarmerId(Long farmerId) {
        return weatherRepository.findByFarmer_FarmerId(farmerId);
    }

    public List<Weather> getWeatherByDate(LocalDate date) {
        return weatherRepository.findByDate(date);
    }

    public List<Weather> getWeatherByDateRange(LocalDate startDate, LocalDate endDate) {
        return weatherRepository.findByDateBetween(startDate, endDate);
    }

    public Weather updateWeather(Long id, Weather weather) {
        Weather existingWeather = weatherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Weather not found"));
        existingWeather.setDate(weather.getDate());
        existingWeather.setTemperature(weather.getTemperature());
        existingWeather.setHumidity(weather.getHumidity());
        existingWeather.setFarmer(weather.getFarmer());
        return weatherRepository.save(existingWeather);
    }

    public void deleteWeather(Long id) {
        weatherRepository.deleteById(id);
    }
}
