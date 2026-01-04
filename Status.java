//status enum for tasks

public enum Status{
    DONE("Complete"),
    NOT_DONE("Incomplete");

    private final String label;

    Status(String label){
        this.label = label;
    }

    @Override
    public String toString(){
        return label;
    }
}