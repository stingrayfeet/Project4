public class AssistantRegionalManager extends Employee{

    //member variables--
    private RegionalManager manager;
    private int minimumTask;

    //constructor--
    public AssistantRegionalManager(int IDNumber, String name, Task[] taskList, RegionalManager manager, int minimumTask) {
        super(IDNumber, name, taskList);
        this.manager = manager;
        this.minimumTask = minimumTask;
    }

    //behaviors (getters and setters for all member variables)--
    public RegionalManager getManager() {
        return manager;
    }

    public void setManager(RegionalManager manager) {
        this.manager = manager;
    }

    public int getMinimumTask() {
        return minimumTask;
    }

    public void setMinimumTask(int minimumTask) {
        this.minimumTask = minimumTask;
    }

    //returns a string formatted with the superclass (Employee) toString method, along with the AssistantRegionalManager object's manager and minimumTask member variables
    public String toString() {
        String result = "Assistant Regional Manager\n" + super.toString() + "\nRegional Manager: " + manager.getName() + "\nMinimum task level: " + minimumTask;
        return result;
    }

    //equals method. Do not edit!
    public boolean equals(AssistantRegionalManager r){
        boolean equal = super.equals(r);
        equal = equal && (r.getMinimumTask() == minimumTask);
        equal = equal && (r.getManager().equals(manager));
        return equal;
    }
}