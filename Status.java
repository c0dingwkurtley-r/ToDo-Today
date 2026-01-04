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

    public static Status parseStatus(String s){
        if (s.equals("Complete")){
            return Status.DONE;
        }
        return Status.NOT_DONE;
    }
}