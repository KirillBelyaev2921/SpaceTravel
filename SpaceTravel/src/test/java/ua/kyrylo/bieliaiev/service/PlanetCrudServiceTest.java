package ua.kyrylo.bieliaiev.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ua.kyrylo.bieliaiev.dao.DataProcessingException;
import ua.kyrylo.bieliaiev.db.HibernateUtil;
import ua.kyrylo.bieliaiev.model.Planet;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlanetCrudServiceTest {
    private final PlanetCrudService planetService = new PlanetCrudService();

    @Test
    @Transactional
    void savePlanetWhenCorrect() {
        Planet planet = new Planet("NEW", "NEW_PLANET");

        planetService.savePlanet(planet);

        assertNotNull(planet.getId());
    }
    @Test
    @Transactional
    void savePlanetWhenInCorrect() {
        Planet planet = new Planet("INC", "");

        assertThrows(DataProcessingException.class, () -> planetService.savePlanet(planet));
    }

    @Test
    @Transactional
    void findPlanetByIdWhenCorrect() {
        Planet planet = planetService.findPlanetById("MARS").orElseThrow();

        assertEquals("Mars", planet.getName());
    }
    @Test
    @Transactional
    void findPlanetByIdWhenNotFound() {
        Optional<Planet> planet = planetService.findPlanetById("");

        assertTrue(planet.isEmpty());
    }

    @Test
    @Transactional
    void updatePlanet() {
        Planet planet = new Planet("NEW2", "NEW_PLANET");

        planetService.savePlanet(planet);
        planet.setName("Kyrylo");

        planetService.updatePlanet(planet);

        Planet savedPlanet = planetService.findPlanetById("NEW2").orElseThrow();

        assertEquals("Kyrylo", savedPlanet.getName());
    }

    @Test
    @Transactional
    void deletePlanet() {
        Planet planet = new Planet("NEW3", "NEW_PLANET");

        planetService.savePlanet(planet);
        planetService.deletePlanet(planet);

        Optional<Planet> deletedPlanet = planetService.findPlanetById(planet.getId());

        assertTrue(deletedPlanet.isEmpty());

    }

    @AfterAll
    static void afterAll() {
        HibernateUtil.getInstance().close();
    }
}