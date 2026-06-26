package gymmanagementsystemcom.example.demo.controller;

import gymmanagementsystemcom.example.demo.model.GymClass;
import gymmanagementsystemcom.example.demo.service.GymClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins = "http://localhost:3000")
public class GymClassController {

    @Autowired
    private GymClassService gymClassService;

    @GetMapping
    public List<GymClass> getAllClasses() {
        return gymClassService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymClass> getClassById(
            @PathVariable Long id) {
        return gymClassService.getClassById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GymClass createClass(
            @RequestBody GymClass newClass) {
        return gymClassService.saveClass(newClass);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymClass> updateClass(
            @PathVariable Long id,
            @RequestBody GymClass updatedClass) {
        return gymClassService.getClassById(id)
                .map(existing -> {
                    existing.setName(
                            updatedClass.getName());
                    existing.setDescription(
                            updatedClass.getDescription());
                    existing.setTrainer(
                            updatedClass.getTrainer());
                    existing.setSchedule(
                            updatedClass.getSchedule());
                    existing.setDurationMin(
                            updatedClass.getDurationMin());
                    existing.setCapacity(
                            updatedClass.getCapacity());
                    return ResponseEntity.ok(
                            gymClassService.saveClass(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(
            @PathVariable Long id) {
        gymClassService.deleteClass(id);
        return ResponseEntity.ok().build();
    }
}