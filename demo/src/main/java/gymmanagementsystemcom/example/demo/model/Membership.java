package gymmanagementsystemcom.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

    @Data
    @Entity
    @Table(name = "memberships")
    public class Membership {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @Enumerated(EnumType.STRING)
        private Plan plan;

        private Double price;
        private LocalDate startDate;
        private LocalDate endDate;

        @Enumerated(EnumType.STRING)
        private Status status = Status.ACTIVE;

        public enum Plan { BASIC, STANDARD, PREMIUM }
        public enum Status { ACTIVE, EXPIRED, CANCELLED }
    }
