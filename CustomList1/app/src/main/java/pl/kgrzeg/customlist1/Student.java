package pl.kgrzeg.customlist1;

/**
 * Created by course on 03/11/2017.
 */

public class Student {
    private String name;
    private String training;
    private String shool;
    private String urlPhoot;
    private int age;

    public Student() {
    }

    public Student(String name, String training, String shool, String urlPhoot, int age) {
        this.name = name;
        this.training = training;
        this.shool = shool;
        this.urlPhoot = urlPhoot;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getShool() {
        return shool;
    }

    public void setShool(String shool) {
        this.shool = shool;
    }

    public String getUrlPhoot() {
        return urlPhoot;
    }

    public void setUrlPhoot(String urlPhoot) {
        this.urlPhoot = urlPhoot;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
