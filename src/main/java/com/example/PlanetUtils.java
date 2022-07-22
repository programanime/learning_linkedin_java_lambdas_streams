package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class PlanetUtils {

  public List<Planet> getPlanetsBeginningWithM(List<Planet> planets) {
    return planets.stream().
      filter(s -> s.getName() != null && s.getName().toLowerCase().startsWith("m")).
      collect(Collectors.toList());
  }

  public List<Planet> getPlanetsWithRings(List<Planet> planets) {
    return planets.stream().
      filter(s -> s.getHasRings()).
      collect(Collectors.toList());
  }

  public List<Planet> getPlanetsWithMoreThanThreeMoons(List<Planet> planets) {
    return planets.stream().
      filter(s -> s.getNumberOfMoons() > 3).
      collect(Collectors.toList());
  }

  public List<Planet> getPlanetsWithDensityGreaterThanFive(List<Planet> planets) {
    return planets.
      stream().
      filter(p -> p.getDensity() > 5).
      collect(Collectors.toList());
  }
}
