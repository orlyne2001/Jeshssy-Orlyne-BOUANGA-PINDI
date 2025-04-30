package casestudy.Question1;
import java.util.*;

public class ReconMission extends Mission {
    public ReconMission(String id, String name, Date start, Date end, String status) {
        super(id, name, start, end, status);
    }

    @Override
    public void assignTask() {
        if (assignedPersonnel.size() < 2) {
            System.out.println("ReconMission requires at least 2 personnel.");
            return;
        }
        System.out.println("Recon tasks assigned to personnel.");
    }

    @Override
    public void allocateResources(List<Resource> resources) {
        for (Resource r : resources) {
            if (r.getResourceName().equalsIgnoreCase("Drone") && r.isAvailable()) {
                allocatedResources.add(r);
                r.reduceQuantity(1);
                System.out.println("Drone allocated.");
                return;
            }
        }
        System.out.println("No drones available. Cannot allocate resources.");
    }

    @Override
    public void trackMissionProgress() {
        status = "IN_PROGRESS";
        System.out.println("Tracking Recon progress...");
    }

    @Override
    public void generateMissionReport() {
        System.out.println("ReconMission Report:");
        System.out.println("Name: " + missionName + ", Status: " + status);
        System.out.println("Personnel: " + assignedPersonnel.size());
        System.out.println("Resources used: " + allocatedResources.size());
    }
}

