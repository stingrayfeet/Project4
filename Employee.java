public abstract class Employee {
    //member variables
    private int IDNumber;
    private String name;
    private Task[] taskList;

    //constructor--
    public Employee(int IDNumber, String name, Task[] taskList) {
        this.IDNumber = IDNumber;
        this.name = name;
        this.taskList = taskList;
    }

    //behaviors (getters and setters for member variables)--
    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaskList(Task[] taskList) {
        this.taskList = taskList;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public String getName() {
        return name;
    }

    public Task[] getTaskList() {
        return taskList;
    }

    //returns a string formatted with name, ID, and task list
    public String toString() {
        String result = String.format("Name: %s\nID: %d\nTask List: ", getName(), getIDNumber());
        for (int i = 0; i < taskList.length; i++) {
            String temp = "\n" + taskList[i].toString();
            result += temp;
        }
        return result;

    }

    //equals method. Do not edit!
    public boolean equals(Employee e){
        boolean equal = true;
        equal = equal && (e.getIDNumber() == IDNumber);
        equal = equal && (e.getName().equals(name));
        for(int i = 0; i < taskList.length; i++){
            equal = equal && (taskList[i].equals(e.getTaskList()[i]));
        }
        return equal;
    }


}