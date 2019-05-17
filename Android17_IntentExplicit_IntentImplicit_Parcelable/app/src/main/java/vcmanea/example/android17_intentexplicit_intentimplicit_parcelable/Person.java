package vcmanea.example.android17_intentexplicit_intentimplicit_parcelable;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
