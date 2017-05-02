import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TheOffice {

    private Employee[] workers;

    //Constructor
    TheOffice(){}

    TheOffice(String fileLoc) throws TaskLevelException{

        //This is used to read a file, do NOT edit!!!
        Scanner fs = null;
        File f = null;

        //Try Catch on file
        try{
            f = new File(fileLoc);
            fs = new Scanner(f);
        }
        catch(FileNotFoundException e){
            System.out.println("FileNotFoundException: The file \""+ fileLoc + "\" could not be found.");
        }


        //First Line is number of employees
        int size = Integer.parseInt(fs.nextLine());
        System.out.println("size: " + size);

        workers = new Employee[size];

        //This might be useful, feel free to delete, or not use these
        RegionalManager manager = null;
        int supremum = 0;
        AssistantRegionalManager assistantManager = null;
        int ATRM = 0;
        //create subordinate array for regional manager
        Employee[] subs = new Employee[size];



        //Loops through file
        for(int i = 0; i < size; i++){
            //Sets temp variables for all possible member variables
            int IDNumber = -1;
            String name = null;
            Task[] taskList = null;
            int regionNum = -1;
            int minimumTask = -1;
            int numClients = -1;
            String[] products = null;
            int maxTaskComplexityLevel = -1;

            System.out.println("Main for loop times ran: " + i);
            //Check which type of employee
            String type = fs.nextLine().trim();

            //Get Standard information (id, name)
            IDNumber = Integer.parseInt(fs.nextLine().trim());
            name =  fs.nextLine();

            //Gets number of tasks and makes a task array based on the size
            int tasks = Integer.parseInt(fs.nextLine().trim());
            taskList = new Task[tasks];

            //Fills up Task List
            for(int j = 0; j < tasks; j++){
                //Gets information for task
                String work = fs.nextLine();
                int num = Integer.parseInt(fs.nextLine().trim());

                //Sets task at array spot
                taskList[j] = new Task(work, num);
            }

            //Scanner read for Regional Manager. Use this as an example to do the other 3 types
            if(type.equals("RegionalManager")){
                //Gets Region Number and Minimum Task Level
                regionNum = Integer.parseInt(fs.nextLine().trim());
                minimumTask = Integer.parseInt(fs.nextLine().trim());

                //Loop through the Task list
                for(int j = 0; j < taskList.length; j++ ){
                    //If a task is below the minimum task level, throw exception
                    if(taskList[j].getLevel() < minimumTask){
                        throw new TaskLevelException(taskList[j].getLevel());
                    }
                }

                //set manager to new regional manager
                manager = new RegionalManager(IDNumber, name, taskList, regionNum,  minimumTask);

                //set workers[i] to regional manager
                workers[i] = manager;

                //Set supremum (Might be useful)
                supremum = minimumTask;
            }
            else if(type.equals("AssistantRegionalManager")){
                //Gets minimum task level
                minimumTask = Integer.parseInt(fs.nextLine().trim());

                //loop through taskList, throws exception if task[k] < minimumTask
                for (int j = 0; j < taskList.length; j++) {
                    //if any task is below minimumTask, exception is thrown
                    if (taskList[j].getLevel() < minimumTask) {
                        throw new TaskLevelException(taskList[j].getLevel());
                    }
                }

                //set assistantManager to new assistant regional manager Object
                assistantManager = new AssistantRegionalManager(IDNumber, name, taskList, manager, minimumTask);
                ATRM++;

                //set workers[i] to assistantManager
                workers[i] = assistantManager;

            }
            else if(type.equals("SalesAssociate")){
                //Gets number of clients
                numClients = Integer.parseInt(fs.nextLine().trim());

                //Sets products[] to size of nextLine
                products = new String[Integer.parseInt(fs.nextLine().trim())];

                //fills products array with nextLine statement
                for (int j = 0; j < products.length; j++) {
                    products[j] = fs.nextLine().trim();
                }

                //sets workers[i] to a new SalesAssociate Object
                workers[i] = new SalesAssociate(IDNumber, name, taskList, numClients, products, manager);

            }
            else if(type.equals("Receptionist")){
                //reads the max task complexity level with newLine statement
                maxTaskComplexityLevel = Integer.parseInt(fs.nextLine().trim());
                
              
                //sets workers[i] to a new Receptionist Object
                workers[i] = new Receptionist(IDNumber, name, taskList, assistantManager, maxTaskComplexityLevel);

            }
        }

        //Set up Employee Arrays for regional manager
        Employee[] a = new Employee[size -1];
        for(int i = 0, j = 0; i < workers.length; i++){
            if(!(workers[i] instanceof RegionalManager)){
                a[j++] = workers[i];
            }
        }

        //If there is a manager, set the subordinate array
        if(manager != null){
            manager.setSubordinates(a);
        }
    }

    //getter and setter for Employee workers array
    public Employee[] getWorkers() {
        return workers;
    }

    public void setWorkers(Employee[] a) {
        workers = new Employee[a.length];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = a[i];
        }
    }


    //calls the toString method on any RegionalManager objects found in the workers array and returns it as a string
    public String toString() {
        String result = new String();
        for(int i = 0; i < workers.length; i++) {
            if (workers[i] instanceof RegionalManager) {
                result += workers[i].toString();
            }
        }
        return result;
    }

    //levelDisplay method
    public String levelDisplay() {
        //creates new string to be returned
        String result = new String();
        int temp = 0;

        //iterates over all of the workers in the office
        for(int i = 0; i < workers.length; i++) {

            //template for Name and Level
            result += "Name: " + workers[i].getName() + "\tLevel: ";

            //if workers[i] is an instance of RegionalManager, set temp to value returned from RegionalManager's getMinimumTask method
            if (workers[i] instanceof RegionalManager) {
                temp = ((RegionalManager) workers[i]).getMinimumTask();
            }

            //if workers[i] is an instance of AssistantRegionalManager, set temp to value returned from AssistantRegionalManager's getMinimumTask method
            else if (workers[i] instanceof AssistantRegionalManager) {
                temp = ((AssistantRegionalManager) workers[i]).getMinimumTask();
            }

            /* if workers[i] is an instance of anything other than RegionalManager or AssistantRegionalManager, a minimum task level of 1 is assumed.
            temp is set to 1*/
            else {
                temp = 1;
            }

            //if worker at index i is the final array index, newLine is not appended to temp
            if (workers[i] == workers[workers.length - 1]) {
                result += temp;
                }

                else {
                result += temp + "\n";
            }
        }

        //return formatted String result
        return result;
    }



    public static void main(String[] args) throws TaskLevelException{
        
        //Gets location for file
        TheOffice o = new TheOffice((args[0]+".txt"));

        //Prints office, then the current level display
        System.out.println(o + "\n\n\n" + o.levelDisplay());

        //Sorts(by name) the employee array
        Sorter.sort(o.getWorkers());

        //Prints the sorted(by name) level display
        System.out.println("\n\n\n" + o.levelDisplay());

}

}
