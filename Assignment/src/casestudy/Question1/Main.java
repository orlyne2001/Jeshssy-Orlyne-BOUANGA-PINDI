package casestudy.Question1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Personnel medic = new Personnel("P001", "Alice", "Medic");
        Personnel soldier = new Personnel("P002", "Bob", "Soldier");
        Personnel logistics = new Personnel("P003", "Charlie", "Logistics Officer");

        List<Resource> resources = new ArrayList<>();
        resources.add(new Resource("R001", "Ambulance", 2, "Vehicle"));
        resources.add(new Resource("R002", "Medical Kit", 5, "Medical Supplies"));
        resources.add(new Resource("R003", "Rescue Equipment", 3, "Equipment"));

        Calendar cal = Calendar.getInstance();
        Date startDate = cal.getTime();
        cal.add(Calendar.DATE, 5);
        Date endDate = cal.getTime();

        Mission rescueMission = new RescueMission("M001", "Flood Zone Rescue", startDate, endDate, "PLANNED");

        rescueMission.addPersonnel(medic);
        rescueMission.addPersonnel(soldier);
        rescueMission.addPersonnel(logistics);

        rescueMission.assignTask();
        rescueMission.allocateResources(resources);
        rescueMission.trackMissionProgress();
        rescueMission.generateMissionReport();
    }
}

