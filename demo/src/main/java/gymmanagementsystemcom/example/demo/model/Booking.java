package gymmanagementsystemcom.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

    @Data
    @Entity
    @Table(name = "bookings")
    public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "class_id")
        private GymClass gymClass;

        private LocalDateTime bookedAt = LocalDateTime.now();

        @Enumerated(EnumType.STRING)
        private Status status = Status.CONFIRMED;

        public enum Status { CONFIRMED, CANCELLED, ATTENDED }
    }
