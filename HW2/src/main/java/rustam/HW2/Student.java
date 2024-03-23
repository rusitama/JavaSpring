package rustam.HW2;

public class Student {
    private int id;
    private String name;
    private String groupName;

    public Student(int id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }
}
