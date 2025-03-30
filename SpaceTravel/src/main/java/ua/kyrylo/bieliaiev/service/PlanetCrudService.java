
package ua.kyrylo.bieliaiev.service;

import ua.kyrylo.bieliaiev.dao.PlanetDao;
import ua.kyrylo.bieliaiev.model.Planet;

import java.util.Optional;

public class PlanetCrudService {

    private final PlanetDao planetDao = new PlanetDao();

    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }

    public Optional<Planet> findPlanetById(String id) {
        return planetDao.getById(id);
    }

    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }

    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }
}
