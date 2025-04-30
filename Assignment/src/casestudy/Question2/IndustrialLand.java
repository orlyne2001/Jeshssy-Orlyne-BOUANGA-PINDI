package casestudy.Question2;

import java.util.*;

public class IndustrialLand extends Land1 {

    private boolean envClearance;

    public IndustrialLand(String id, String owner, String loc,
                          double acres, boolean clearance,
                          Date regDate, String status) {
        super(id, owner, loc, acres, regDate, status);
        this.envClearance = clearance;
    }

    @Override
    public boolean validateOwnership() {
        return !ownerName.isBlank();
    }

    @Override
    public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("industrial") && envClearance;
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 12_000 * 0.03;
    }

    @Override
    public void generateLandReport() {
        System.out.println("===== INDUSTRIAL LAND REPORT =====");
        System.out.printf("""
        ID / Owner       : %s / %s
        Location         : %s
        Acres            : %.2f
        Env. Clearance   : %b
        Zoning Compliant : %b
        Tax ($)          : %.2f
        Status           : %s
        ================================
        """,
                landId, ownerName, location, sizeInAcres, envClearance,
                checkZoningCompliance(), calculateTax(), landUseStatus);
    }
}
