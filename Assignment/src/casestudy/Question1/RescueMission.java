package casestudy.Question1;

import java.util.*;

public class RescueMission extends Mission {

    public RescueMission(String id, String name, Date start, Date end, String status) {
        super(id, name, start, end, status);
    }

    @Override
    public void assignTask() {
        boolean hasMedic = assignedPersonnel.stream()
                .anyMatch(p -> p.getPersonnelRole().equalsIgnoreCase("Medic"));

        if (!hasMedic) {
            System.out.println("RescueMission requires at least one Medic.");
            return;
        }

        System.out.println("Rescue, medical, and logistics tasks assigned to personnel.");
    }

    @Override
    public void allocateResources(List<Resource> resources) {
        boolean allocated = false;

        for (Resource r : resources) {
            if ((r.getResourceName().equalsIgnoreCase("Ambulance") ||
                    r.getResourceName().equalsIgnoreCase("Medical Kit") ||
                    r.getResourceName().equalsIgnoreCase("Rescue Equipment"))
                    && r.isAvailable()) {
                allocatedResources.add(r);
                r.reduceQuantity(1);
                allocated = true;
                System.out.println(r.getResourceName() + " allocated.");
            }
        }

        if (!allocated) {
            System.out.println("No necessary rescue resources available.");
        }
    }

    @Override
    public void trackMissionProgress() {
        status = "IN_PROGRESS";
        System.out.println("Monitoring rescue operations...");
    }

    @Override
    public void generateMissionReport() {
        System.out.println("RescueMission Report:");
        System.out.println("Name: " + missionName + ", Status: " + status);
        System.out.println("Personnel assigned: " + assignedPersonnel.size());
        System.out.println("Resources used:");
        for (Resource r : allocatedResources) {
            System.out.println("- " + r.getResourceName());
        }
    }
}

