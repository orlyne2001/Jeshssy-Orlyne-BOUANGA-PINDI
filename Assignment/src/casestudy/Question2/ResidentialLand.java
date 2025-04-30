package casestudy.Question2;

import java.util.*;

public class ResidentialLand extends Land1{

    private int residentialUnits;

    public ResidentialLand(String id, String owner, String loc,
                           double acres, int units,
                           Date regDate, String status) {
        super(id, owner, loc, acres, regDate, status);
        if (units > acres * 2)
            throw new IllegalArgumentException("Max2 units/acre");
        this.residentialUnits = units;
    }

    @Override public boolean validateOwnership() { return !ownerName.isBlank(); }
    @Override public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("residential");
    }
    @Override public double calculateTax() {
        return sizeInAcres * 8_000 * 0.015;
    }
    @Override public void generateLandReport() {
        printHeader("RESIDENTIAL LAND REPORT");
        System.out.printf("""
        ID / Owner     : %s / %s
        Location       : %s
        Size / Units   : %.2fac / %d units
        Zoning OK      : %b
        Tax Due ($)    : %.2f
        Status         : %s
        ===================================
        """, landId, ownerName, location, sizeInAcres,
                residentialUnits, checkZoningCompliance(),
                calculateTax(), landUseStatus);
    }
}

