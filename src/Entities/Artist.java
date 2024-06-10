package Entities;

public class Artist implements Comparable<Artist> {

    private String name;
    private int ct50;

    public Artist(String name){
        this.name = name;
        this.ct50 = 0;
    }

    public String getName() {
        return name;
    }

    public int getCt50() {
        return ct50;
    }

    public void setCt50(int ct50) {
        this.ct50 = ct50;
    }

    @Override
    public int compareTo(Artist o) {
        return 0;
    }
}
