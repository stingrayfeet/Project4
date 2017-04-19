public class SalesAssociate extends Employee{

    //member variables--
    private int numClients;
    private String[] products;
    private RegionalManager supervisor;

    //constructor--
    public SalesAssociate(int IDNumber, String name, Task[] taskList, int numClients, String[] products, RegionalManager supervisor) {
        super(IDNumber, name, taskList);
        this.numClients = numClients;
        this.products = products;
        this.supervisor = supervisor;
    }

    //behaviors (getters and setters for member variables)--
    public int getNumClients() {
        return numClients;
    }

    public void setNumClients(int numClients) {
        this.numClients = numClients;
    }

    public String[] getProducts() {
        return products;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }

    public RegionalManager getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(RegionalManager supervisor) {
        this.supervisor = supervisor;
    }

    //returns a string formatted with the superclass (Employee) toString method, along with the SalesAssociate object's supervisor and numClients member variables
    public String toString() {
        String temp = null;
        String result = "Sales Associate\n" + super.toString() + "\nRegional Manager: " + supervisor.getName() + "\nNumber of Clients: " + numClients + "\nProducts to sell: ";

        /* iterates over products array and assigns the product at index i to temp
        appends temp onto result */
        for (int i = 0; i < products.length; i++) {
            temp = "\n\t" + products[i].toString();
            result += temp;
        }

        return result;
    }

    //equals method. Do not edit!
    public boolean equals(SalesAssociate s){
        boolean equal = super.equals(s);
        equal = equal && (s.getNumClients() == numClients);
        equal = equal && (s.getSupervisor().equals(supervisor));

        for(int i = 0; i < products.length; i++){
            equal = equal && (products[i].equals(s.getProducts()[i]));
        }
        return equal;
    }

}