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
        return weatherRepository.findByRecordAt(date);
    }

    public List<Weather> getWeatherByDateRange(LocalDate startDate, LocalDate endDate) {
        return weatherRepository.findByRecordAtBetween(startDate, endDate);
    }

    public Weather updateWeather(Long id, Weather weather) {
        Weather existingWeather = weatherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Weather record not found"));
        existingWeather.setTemperature(weather.getTemperature());
        existingWeather.setHumidity(weather.getHumidity());
        existingWeather.setPressure(weather.getPressure());
        existingWeather.setWindSpeed(weather.getWindSpeed());
        existingWeather.setRecordAt(weather.getRecordAt());
        existingWeather.setFarmer(weather.getFarmer());
        return weatherRepository.save(existingWeather);
    }

    public void deleteWeather(Long id) {
        weatherRepository.deleteById(id);
    }
}
