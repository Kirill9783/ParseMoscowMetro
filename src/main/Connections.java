import java.util.TreeSet;

public class Connections implements Comparable<Connections> {
    private final TreeSet<Station> connectionStations;

    public Connections() {
        connectionStations = new TreeSet<>();
    }

    public void addStation(Station station) {
        connectionStations.add(station);
    }

    public TreeSet<Station> getConnectionStations() {
        return connectionStations;
    }

    @Override
    public int compareTo(Connections stationsConnection) {
        if (connectionStations.size() == stationsConnection.getConnectionStations().size()) {
            if (connectionStations.containsAll(stationsConnection.getConnectionStations())) {
                return 0;
            } else {
                return -1;
            }
        }
        if (connectionStations.size() < stationsConnection.getConnectionStations().size()) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return compareTo((Connections) obj) == 0;
    }
}

