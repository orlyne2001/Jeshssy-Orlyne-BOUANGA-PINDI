package casestudy.Question2;

import java.util.*;

public class CommercialLand extends Land1 {

    public CommercialLand(String id, String owner, String loc,
                          double acres, Date regDate, String status) {
        super(id, owner, loc, acres, regDate, status);
    }

    @Override public boolean validateOwnership() { return !ownerName.isBlank(); }
    @Override public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("commercial");
    }
    @Override public double calculateTax() {
        return sizeInAcres * 10_000 * 0.025;
    }
    @Override public void generateLandReport() {
        printHeader("COMMERCIAL LAND REPORT");
        System.out.printf("""
        ID : %s   | Owner : %s
        Loc: %s
        Acres: %.2f
        Zoning OK : %b
        Tax ($)   : %.2f
        Status    : %s
        ================================
        """, landId, ownerName, location, sizeInAcres,
                checkZoningCompliance(), calculateTax(), landUseStatus);
    }
}

