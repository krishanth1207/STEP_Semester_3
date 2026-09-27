package session_7.assigment_problems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else if (color.equals("YELLOW")) {
            color = "RED";
        }
        System.out.println("t.next() -> " + color);
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Initial color: " + t.getColor());
        t.next();
        t.next();
        t.next();
    }
}
