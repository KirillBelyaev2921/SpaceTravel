package ua.kyrylo.bieliaiev.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "planets")
@Getter
@Setter
@NoArgsConstructor
public class Planet {

    @Id
    @Pattern(regexp = "[A-Z]+")
    private String id;
    @Column(length = 500)
    private String name;

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
