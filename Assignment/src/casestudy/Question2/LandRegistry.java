package casestudy.Question2;

import java.util.*;
import java.util.stream.Collectors;

public class
LandRegistry {

    private final List<Land1> lands = new ArrayList<>();

    public void registerLand(Land1 land1) { lands.add(land1); }
    public boolean removeLand(String landId) {
        return lands.removeIf(l -> l.landId.equals(landId));
    }
    public Land1 findById(String landId) {
        return lands.stream()
                .filter(l -> l.landId.equals(landId))
                .findFirst().orElse(null);
    }

    public List<Land1> searchByOwner(String owner) {
        return lands.stream()
                .filter(l -> l.ownerName.equalsIgnoreCase(owner))
                .collect(Collectors.toList());
    }
    public List<Land1> filterByType(Class<? extends Land1> type) {
        return lands.stream()
                .filter(type::isInstance)
                .collect(Collectors.toList());
    }
    public List<Land1> searchByLocation(String keyword) {
        return lands.stream()
                .filter(l -> l.location.toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void generateAllReports() {
        lands.forEach(Land1::generateLandReport);
    }
}

