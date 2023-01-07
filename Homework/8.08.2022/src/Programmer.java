import java.util.List;

public class Programmer {
    String name;
    String city;
    List<String> skills;

    public Programmer(String name, String city, List<String> skills) {
        this.name = name;
        this.city = city;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return name + "(" + city + ") skills = " + skills;
    }
}
