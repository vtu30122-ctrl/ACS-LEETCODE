
import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores customer ID -> check-in information
    private Map<Integer, CheckInInfo> checkIns;

    // Stores route -> [total travel time, number of trips]
    private Map<String, double[]> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.get(id);

        int travelTime = t - info.time;

        String route = info.station + "->" + stationName;

        if (!routes.containsKey(route)) {
            routes.put(route, new double[]{0.0, 0.0});
        }

        double[] data = routes.get(route);

        data[0] += travelTime; // total time
        data[1]++;             // number of trips

        // Customer is no longer checked in
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;

        double[] data = routes.get(route);

        return data[0] / data[1];
    }

    // Helper class for check-in information
    private static class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}

