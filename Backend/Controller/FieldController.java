package com.pdm.farming.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pdm.farming.Service.FieldService;
import com.pdm.farming.Entities.Field;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fields")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping
    public ResponseEntity<List<Field>> getAllFields() {
    List<Field> fields =fieldService.getAllFields(); 
    return ResponseEntity.ok(fields);
    }

    @PostMapping
    public ResponseEntity<Field> createField(@RequestBody Field field) {
        Field savedField = fieldService.createField(field);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedField);
    }   

    // Get fields by location
    @GetMapping("/location/{location}")
    public Optional<Field> getFieldsByLocation(@PathVariable String location) {
        return fieldService.getFieldsByLocation(location);
    }

    // Delete a field by ID
    @DeleteMapping("/{id}")
    public void deleteField(@PathVariable Long id) {
        fieldService.deleteField(id);
    }

    // Get fields by name
    @GetMapping("/name/{fieldName}")
    public Optional<Field> getFieldsByName(@PathVariable String fieldName) {
        return fieldService.getFieldsByName(fieldName);
    }
 
    @PutMapping("/{fieldId}")
    public Field updateField(@PathVariable Long fieldId, @RequestBody Field updatedField) {
            return fieldService.updateField(fieldId, updatedField);
    }
}
