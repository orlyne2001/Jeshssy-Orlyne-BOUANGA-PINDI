package casestudy.Question1;

import java.util.*;

public abstract class Mission {
    protected String missionId;
    protected String missionName;
    protected Date missionStartDate;
    protected Date missionEndDate;
    protected String status;
    protected List<Personnel> assignedPersonnel = new ArrayList<>();
    protected List<Resource> allocatedResources = new ArrayList<>();

    public Mission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, String status) {
        if (missionStartDate.after(missionEndDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionStartDate = missionStartDate;
        this.missionEndDate = missionEndDate;
        this.status = status;
    }

    public void addPersonnel(Personnel person) {
        if (!assignedPersonnel.contains(person)) {
            assignedPersonnel.add(person);
            person.setAssignedMission(this);
        }
    }

    public abstract void assignTask();
    public abstract void allocateResources(List<Resource> resources);
    public abstract void trackMissionProgress();
    public abstract void generateMissionReport();
}

