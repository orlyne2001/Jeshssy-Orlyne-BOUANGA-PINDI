package casestudy.Question1;

import java.util.*;

public class CombatMission extends Mission {

    public CombatMission(String id, String name, Date start, Date end, String status) {
        super(id, name, start, end, status);
    }

    @Override
    public void assignTask() {
        if (assignedPersonnel.size() < 3) {
            System.out.println("CombatMission requires at least 3 personnel.");
            return;
        }

        System.out.println("Combat-specific tasks (defense, attack, strategy) assigned to personnel.");
    }

    @Override
    public void allocateResources(List<Resource> resources) {
        boolean resourcesAllocated = false;

        for (Resource r : resources) {
            if ((r.getResourceName().equalsIgnoreCase("Ammunition") ||
                    r.getResourceName().equalsIgnoreCase("Vehicle") ||
                    r.getResourceName().equalsIgnoreCase("Weapon"))
                    && r.isAvailable()) {
                allocatedResources.add(r);
                r.reduceQuantity(1);
                resourcesAllocated = true;
                System.out.println(r.getResourceName() + " allocated.");
            }
        }

        if (!resourcesAllocated) {
            System.out.println("Required combat resources not available.");
        }
    }

    @Override
    public void trackMissionProgress() {
        status = "IN_PROGRESS";
        System.out.println("Tracking combat operation progress...");
    }

    @Override
    public void generateMissionReport() {
        System.out.println("CombatMission Report:");
        System.out.println("Name: " + missionName + ", Status: " + status);
        System.out.println("Personnel involved: " + assignedPersonnel.size());
        System.out.println("Resources used:");
        for (Resource r : allocatedResources) {
            System.out.println("- " + r.getResourceName());
        }
    }
}

