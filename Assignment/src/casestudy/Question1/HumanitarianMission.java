package casestudy.Question1;

import java.util.*;

public class HumanitarianMission extends Mission {

    public HumanitarianMission(String id, String name, Date start, Date end, String status) {
        super(id, name, start, end, status);
    }

    @Override
    public void assignTask() {
        boolean hasLogisticsOrMedical = assignedPersonnel.stream().anyMatch(p ->
                p.getPersonnelRole().equalsIgnoreCase("Logistics Officer") ||
                        p.getPersonnelRole().equalsIgnoreCase("Medic"));

        if (!hasLogisticsOrMedical) {
            System.out.println("HumanitarianMission requires at least a logistics officer or medic.");
            return;
        }

        System.out.println("Tasks assigned: logistics, distribution, medical aid.");
    }

    @Override
    public void allocateResources(List<Resource> resources) {
        boolean essentialsAvailable = false;

        for (Resource r : resources) {
            if ((r.getResourceName().equalsIgnoreCase("Food Supplies") ||
                    r.getResourceName().equalsIgnoreCase("Medical Kit") ||
                    r.getResourceName().equalsIgnoreCase("Transport Vehicle"))
                    && r.isAvailable()) {
                allocatedResources.add(r);
                r.reduceQuantity(1);
                essentialsAvailable = true;
                System.out.println(r.getResourceName() + " allocated.");
            }
        }

        if (!essentialsAvailable) {
            System.out.println("Essential humanitarian resources not available.");
        }
    }

    @Override
    public void trackMissionProgress() {
        status = "IN_PROGRESS";
        System.out.println("Monitoring humanitarian aid progress...");
    }

    @Override
    public void generateMissionReport() {
        System.out.println("HumanitarianMission Report:");
        System.out.println("Mission: " + missionName);
        System.out.println("Status: " + status);
        System.out.println("Personnel: " + assignedPersonnel.size());
        System.out.println("Resources used:");
        for (Resource r : allocatedResources) {
            System.out.println("- " + r.getResourceName());
        }
    }
}

