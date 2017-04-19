public class Receptionist extends Employee{

    //member variables--
    private AssistantRegionalManager supervisor;
    private int maxTaskComplexityLevel;

    //constructor--
    public Receptionist(int IDNumber, String name, Task[] taskList, AssistantRegionalManager supervisor, int maxTaskComplexityLevel) {
        super(IDNumber, name, taskList);
        this.supervisor = supervisor;
        this.maxTaskComplexityLevel = maxTaskComplexityLevel;
    }

    //behaviors (getters and setters for all member variables)--
    public AssistantRegionalManager getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(AssistantRegionalManager supervisor) {
        this.supervisor = supervisor;
    }

    public int getMaxTaskComplexityLevel() {
        return maxTaskComplexityLevel;
    }

    public void setMaxTaskComplexityLevel(int maxTaskComplexityLevel) {
        this.maxTaskComplexityLevel = maxTaskComplexityLevel;
    }

    //returns a string formatted with the superclass (Employee) toString method, along with the Receptionist object's supervisor and maxTaskComplexityLevel member variables
    public String toString() {
        String result = "Receptionist\n" + super.toString() + "\nAssistant Regional Manager: " + supervisor.getName() + "\nMax Task Level: " + maxTaskComplexityLevel;
        return result;
    }


    //equals method. Do not edit!
    public boolean equals(Receptionist r){
        boolean equal = super.equals(r);
        equal = equal && (r.getSupervisor().equals(supervisor));
        equal = equal && (r.getMaxTaskComplexityLevel() == maxTaskComplexityLevel);
        return equal;
    }
}