package casestudy.Question2;



import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Date today = new Date();
        LandRegistry registry = new LandRegistry();

        registry.registerLand(new AgriculturalLand("L001", "Alice",
                "Green Farm Zone5", 10, today, "In Use"));
        registry.registerLand(new ResidentialLand("L002", "Bob",
                "Residential BlockB", 1.5, 3, today, "Vacant"));
        registry.registerLand(new CommercialLand("L003", "Chad",
                "CommercialStreet9", 0.8, today, "Under Dev"));
        registry.registerLand(new IndustrialLand("L004", "Dana",
                "Industrial Park3", 5, true, today, "In Use"));

        registry.generateAllReports();

        System.out.println("\n--- Lands owned by Bob ---");
        registry.searchByOwner("Bob").forEach(Land1::generateLandReport);
    }
}

