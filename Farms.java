import java.util.HashMap;
import java.util.Map;

public class Farms {
    private Map<Integer, String> farmData; //farm ID and color of the farm
    private Map<Integer, Integer> cowCount; //farm ID and number of cows
    private Map<Integer, Cow> cows; // store existing cows by using cowID as the key

    public Farms() {
        farmData = new HashMap<>();
        cowCount = new HashMap<>();
        cows = new HashMap<>();
    }

    //check if farm already has a cow of another color
    public boolean canAddCow(int farmID, String color) {
        return !farmData.containsKey(farmID) || farmData.get(farmID).equals(color);
    }

    //check if the cow ID already exists
    public boolean isCowIDUnique(int cowID) {
        return !cows.containsKey(cowID);
    }

    //add data to all the maps
    public void addCow(int cowID, int farmID, String color, Cow cow) {
        if (isCowIDUnique(cowID)) {
            farmData.put(farmID, color);
            cowCount.put(farmID, cowCount.getOrDefault(farmID, 0) + 1);
            cows.put(cowID, cow);
        } else {
            throw new IllegalArgumentException("Cow ID already exists.");
        }
    }

    public Map<Integer, String> getFarmData() {
        return farmData;
    }

    public Map<Integer, Integer> getCowCount() {
        return cowCount;
    }

    public Map<Integer, Cow> getCows() {
        return cows;
    }
}
