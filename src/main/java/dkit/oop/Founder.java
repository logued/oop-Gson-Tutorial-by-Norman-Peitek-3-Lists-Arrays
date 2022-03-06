package dkit.oop;

public class Founder {
    String name;
    int flowerCount;

    public Founder(String name, int flowerCount) {
        this.name = name;
        this.flowerCount = flowerCount;
    }

    @Override
    public String toString() {
        return "Founder{" +
                "name='" + name + '\'' +
                ", flowerCount=" + flowerCount +
                '}';
    }
}