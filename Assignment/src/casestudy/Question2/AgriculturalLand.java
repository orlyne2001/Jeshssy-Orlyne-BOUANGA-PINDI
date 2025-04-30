package casestudy.Question2;

import java.util.*;

public class AgriculturalLand extends Land1 {

    public AgriculturalLand(String id, String owner, String loc,
                            double acres, Date regDate, String status) {
        super(id, owner, loc, acres, regDate, status);
        if (acres < 1)
            throw new IllegalArgumentException("Agricultural land ≥1acre");
    }

    @Override public boolean validateOwnership() { return !ownerName.isBlank(); }
    @Override public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("farm");
    }
    @Override public double calculateTax() {
        return sizeInAcres * 5_000 * 0.01;
    }
    @Override public void generateLandReport() {
        printHeader("AGRICULTURAL LAND REPORT");
        System.out.printf("""
        ID             : %s
        Owner          : %s (valid: %b)
        Location       : %s
        Size (acres)   : %.2f
        Zoning OK      : %b
        Tax Due ($)    : %.2f
        Status         : %s
        ====================================
        """, landId, ownerName, validateOwnership(),
                location, sizeInAcres, checkZoningCompliance(),
                calculateTax(), landUseStatus);
    }
}

