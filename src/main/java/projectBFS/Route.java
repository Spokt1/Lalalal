package projectBFS;

/**
 * Created by slava on 21.05.2017.
 */
public class Route {
    private String route;
    private Integer weight;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Route{" +
                "route='" + route + '\'' +
                ", weight=" + weight +
                '}';
    }
}
