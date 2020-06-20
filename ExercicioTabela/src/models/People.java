package models;

import java.util.Arrays;

public class People {
    private String name;
    private int age;
    private String[] preferences;

    public People(String name, int age, String[] preferences) {
        this.name = name;
        this.age = age;
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", preferences=" + Arrays.toString(preferences) +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String[] getPreferences() {
        return preferences;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
