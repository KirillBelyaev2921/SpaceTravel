package ua.kyrylo.bieliaiev.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "planets")
@Data
@NoArgsConstructor
public class Planet {

    @Id
    private String id;

    @Column(length = 500)
    private String name;

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
