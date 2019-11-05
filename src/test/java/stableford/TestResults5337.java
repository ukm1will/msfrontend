package stableford;

import data.StableFordData5337;
import data.StableFordData5361;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import models.Competition;
import models.Golfer;
import org.junit.Test;
import services.StringHelper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import static enums.ScoringSystem.STABLEFORD;
import static org.junit.Assert.assertEquals;

public class TestResults5337 {

    private final String currentDataFile = StableFordData5337.JSON;
    private Competition competition = new Competition(currentDataFile);

    @Test
    public void CompetitionShouldBeStableford() {
        String json = currentDataFile;
        competition.setScoringSystem(json);
        assertEquals(STABLEFORD, competition.getScoringSystem());
    }

    @Test
    public void ShouldAddGolfersToCompetition() {
        String json = currentDataFile;
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Golfer>>() {
        }.getType();
        competition.golfers = gson.fromJson(json, listType);
        assertEquals(22, competition.golfers.size());
    }

    @Test
    public void ShouldHaveCorrectDataForGuydonCerasuolo() {

        String json = currentDataFile;
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Golfer>>() {
        }.getType();
        competition.golfers = gson.fromJson(json, listType);

        Golfer guydonCerasuolo = competition.find("Guydon Cerasuolo");
        assertEquals("Guydon Cerasuolo", guydonCerasuolo.getFullName());
        assertEquals(101, guydonCerasuolo.getGross());
        assertEquals(80, guydonCerasuolo.getNett());
        assertEquals(21, guydonCerasuolo.getHandicap());
        assertEquals(28, guydonCerasuolo.getPts());
    }

    @Test
    public void ShouldShowEdnyfedBeforeSort() {

        String json = currentDataFile;
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Golfer>>() {
        }.getType();
        competition.golfers = gson.fromJson(json, listType);

        Golfer edMorgan = competition.find("Ednyfed O. Morgan");
        assertEquals("Ednyfed O. Morgan", edMorgan.getFullName());
        assertEquals(5, edMorgan.getPosition());
        assertEquals(86, edMorgan.getGross());
        assertEquals(76, edMorgan.getNett());
        assertEquals(10, edMorgan.getHandicap());
        assertEquals(32, edMorgan.getPts());

    }

    @Test
    public void ShouldShowEdnyfedAfterSort() {

        String json = currentDataFile;
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Golfer>>() {
        }.getType();
        competition.golfers = gson.fromJson(json, listType);

        Collections.sort(competition.golfers);
        competition.updateRankings();

        Golfer edMorgan = competition.find("Ednyfed O. Morgan");
        assertEquals("Ednyfed O. Morgan", edMorgan.getFullName());
        assertEquals(3, edMorgan.getPosition());
        assertEquals(86, edMorgan.getGross());
        assertEquals(76, edMorgan.getNett());
        assertEquals(10, edMorgan.getHandicap());
        assertEquals(32, edMorgan.getPts());
    }

//    @Test
//    public void BeforeSortingCheckNames() {
//        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
//        competition.addResultsToCompetition(activeData);
//        competition.addGolfersToCompetition();
//        Golfer posOne = competition.golfers.get(0);
//        Golfer posTwo = competition.golfers.get(1);
//        assertEquals("B. M. Dobson", posOne.getFullName());
//        assertEquals(1, posOne.getPosition());
//        assertEquals("Neil L. Lahif", posTwo.getFullName());
//        assertEquals(2, posTwo.getPosition());
//    }
//
//    @Test
//    public void AfterSortingCheckNames() {
//        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
//        competition.addResultsToCompetition(activeData);
//        competition.addGolfersToCompetition();
//        Collections.sort(competition.golfers);
//        competition.updateRankings();
//        Golfer posOne = competition.golfers.get(0);
//        Golfer posTwo = competition.golfers.get(1);
//        assertEquals("B. M. Dobson", posOne.getFullName());
//        assertEquals(1, posOne.getPosition());
//        assertEquals("Colin Harris", posTwo.getFullName());
//        assertEquals(2, posTwo.getPosition());
//    }
}
