package gymmanagementsystemcom.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gym_classes")
public class GymClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String trainer;
    private LocalDateTime schedule;
    private Integer durationMin = 60;
    private Integer capacity = 20;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description; }

    public String getTrainer() { return trainer; }
    public void setTrainer(String trainer) {
        this.trainer = trainer; }

    public LocalDateTime getSchedule() { return schedule; }
    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule; }

    public Integer getDurationMin() { return durationMin; }
    public void setDurationMin(Integer durationMin) {
        this.durationMin = durationMin; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity; }
}