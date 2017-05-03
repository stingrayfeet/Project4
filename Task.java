public class Task {

    //member variables--
    private String name;
    private int level;

    //constructor--
    public Task(String name, int level) {
        this.name = name;
        this.level = level;
    }

    //behaviors(getters only, member variable values are immutable)--
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    //returns a string formatted with task and level
    public String toString() {
        String ans = String.format("\tTask: %s\tLevel: %d",getName(), getLevel());
        return ans;
    }

    //equals method. Do not edit!
    public boolean equals(Task t){
        return ((t.getLevel() == level) && (t.getName().equals(name)));
    }

}

