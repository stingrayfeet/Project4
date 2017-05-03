public class RegionalManager extends Employee {

    //member variables--
    private int RegionNum;
    private Employee[] subordinates;
    private int minimumTask;

    //constructor 1 (includes Employee[] subordinates as a parameter)--
    public RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, Employee[] subordinates, int minimumTask) {
        super(IDNumber, name, taskList);
        this.RegionNum = RegionNum;
        this.subordinates = subordinates;
        this.minimumTask = minimumTask;
    }

    //constructor 2 (excludes Employee[] subordinates as a parameter)--
    public RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, int minimumTask) {
        super(IDNumber, name, taskList);
        this.RegionNum = RegionNum;
        this.minimumTask = minimumTask;
    }

    //behaviors (getters and setters for member variables)--
    public int getRegionNum() {
        return RegionNum;
    }

    public void setRegionNum(int RegionNum) {
        this.RegionNum = RegionNum;
    }

    public Employee[] getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Employee[] subordinates) {
        this.subordinates = subordinates;
    }

    public int getMinimumTask() {
        return minimumTask;
    }

    public void setMinimumTask(int minimumTask) {
        this.minimumTask = minimumTask;
    }

    //returns a string formatted with the superclass (Employee) toString method, along with the RegionalManager object's regionNum and minimumTask member variables
    public String toString() {
        String result = "Regional Manager\n" + super.toString() + "\nRegion Number: " + RegionNum + "\nMinimum Task Level: " + minimumTask+ "\nEmployees: ";
        for (int i = 0; i < subordinates.length; i++) {
            String temp = "\n" + subordinates[i].toString();
            result += temp;
        }

        return result;
    }




    //equals method. Do not edit!
    public boolean equals(RegionalManager r){
        boolean equal = super.equals(r);
        equal = equal && (r.getRegionNum() == RegionNum);
        equal = equal && (r.getMinimumTask() == minimumTask);
        for(int i = 0; i < subordinates.length; i++){
            equal = equal && (subordinates[i].equals(r.getSubordinates()[i]));
        }
        return equal;
    }
}
