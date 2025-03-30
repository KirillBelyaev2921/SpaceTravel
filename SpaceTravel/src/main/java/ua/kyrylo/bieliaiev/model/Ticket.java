package ua.kyrylo.bieliaiev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate createdAt = LocalDate.now();

    private Long clientId;
    private Long fromPlanetId;
    private Long toPlanetId;
}
