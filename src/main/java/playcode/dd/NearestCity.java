package playcode.dd;

import java.util.*;

public class NearestCity {
    class CityDist {
        double dist;
        String city;

        public CityDist(double dist, String city) {
            this.dist = dist;
            this.city = city;
        }
    }

    private void updateCloserCity(Map.Entry<Integer, String> sameCoorCity, int queriedLocation, CityDist minCityDist) {
        if (sameCoorCity != null) {
            int location = sameCoorCity.getKey();
            String cityName = sameCoorCity.getValue();
            double currDist = Math.abs(location - queriedLocation);
            if (currDist < minCityDist.dist || (currDist == minCityDist.dist && cityName.compareTo(minCityDist.city) < 0)) {
                minCityDist.dist = currDist;
                minCityDist.city = cityName;
            }
        }
    }

    public List<String> getNearestCities(String[] names, int[] x, int[] y, String[] query) {
// 1) build a HashMap of TreeMap
// x --> TreeMap<y, String>
// build HashMap of name to x and y
        HashMap<Integer, TreeMap<Integer, String>> sameXCityMap = new HashMap<>();
        HashMap<Integer, TreeMap<Integer, String>> sameYCityMap = new HashMap<>();
        HashMap<String, int[]> nameToXYMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int xLocation = x[i];
            int yLocation = y[i];
            sameXCityMap.computeIfAbsent(xLocation, key -> new TreeMap<>()).put(yLocation, name);
            sameYCityMap.computeIfAbsent(yLocation, key -> new TreeMap<>()).put(xLocation, name);
            nameToXYMap.put(name, new int[]{xLocation, yLocation});
        }

// 2) use TreeMap to get closest city
        List<String> res = new ArrayList<>();
        for (String queriedCity : query) {
            CityDist minCityDist = new CityDist(Double.MAX_VALUE, "NONE");
            int[] queriedLocation = nameToXYMap.get(queriedCity);
            int queriedX = queriedLocation[0], queriedY = queriedLocation[1];
            TreeMap<Integer, String> sameXCities = sameXCityMap.get(queriedX);
            TreeMap<Integer, String> sameYCities = sameYCityMap.get(queriedY);
            Map.Entry<Integer, String> sameXLowerCity = sameXCities.lowerEntry(queriedY);
            updateCloserCity(sameXLowerCity, queriedY, minCityDist);
            Map.Entry<Integer, String> sameXHigherCity = sameXCities.higherEntry(queriedY);
            updateCloserCity(sameXHigherCity, queriedY, minCityDist);
            Map.Entry<Integer, String> sameYLowerCity = sameYCities.lowerEntry(queriedX);
            updateCloserCity(sameYLowerCity, queriedX, minCityDist);
            Map.Entry<Integer, String> sameYHigherCity;
            //sameYHigherCity = sameYCities.higherE‍‌‌‌‌‌‍‍‌‌‌‍‌‍‍‍‍‍ntry(queriedX);
            //updateCloserCity(sameYHigherCity, queriedX, minCityDist);

            res.add(minCityDist.city);
        }

        return res;
    }
}
