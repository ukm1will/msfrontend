package models;

import java.util.ArrayList;
import java.util.List;

public class Competition {

    public List<Golfer> golfers = new ArrayList<>();

    public Competition() {
    }

    public void updateRankings() {
        // After sorting, the position will no longer be accurate, therefore they need to be re-adjusted
        for (int i = 0; i < golfers.size(); i++) {
            golfers.get(i).setPosition(i + 1);
        }
    }
}