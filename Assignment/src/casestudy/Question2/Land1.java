package casestudy.Question2;

import java.util.*;

public abstract class Land1 {
    protected String landId;
    protected String ownerName;
    protected String location;
    protected double sizeInAcres;
    protected Date   registrationDate;
    protected String landUseStatus;

    protected Land1(String landId, String ownerName, String location,
                    double acres, Date regDate, String status) {

        if (ownerName == null || ownerName.isBlank())
            throw new IllegalArgumentException("Owner name required");

        this.landId = landId;
        this.ownerName = ownerName;
        this.location  = location;
        this.sizeInAcres = acres;
        this.registrationDate = regDate;
        this.landUseStatus = status;
    }

    public abstract boolean validateOwnership();
    public abstract boolean checkZoningCompliance();
    public abstract double  calculateTax();
    public abstract void    generateLandReport();

    protected void printHeader(String title) {
        System.out.println("===== " + title + " =====");
    }
}

