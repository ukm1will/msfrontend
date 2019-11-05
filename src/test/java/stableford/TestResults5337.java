package stableford;

import data.StableFordData5337;
import models.Competition;
import models.Golfer;
import org.junit.Test;
import services.StringHelper;

import java.util.Collections;

import static enums.ScoringSystem.STABLEFORD;
import static org.junit.Assert.assertEquals;

public class TestResults5337 {

    private final String currentDataFile = StableFordData5337.WHOLE_PAGE;
    private Competition competition = new Competition(currentDataFile);
    private String beforePart;


    public TestResults5337() throws Exception {
        beforePart = StringHelper.getBeforePart(competition.getMasterScoreboardFormat());
    }

    @Test
    public void CompetitionShouldBeStableford() {
        assertEquals(STABLEFORD, competition.getScoringSystem());
    }

    @Test
    public void ShouldAddResultsToCompetition() {
        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
        competition.addResultsToCompetition(activeData);
        assertEquals(22, competition.results.size());
    }

    @Test
    public void ShouldAddGolfersToCompetition() {
        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
        competition.addResultsToCompetition(activeData);
        competition.addGolfersToCompetition();
        assertEquals(22, competition.golfers.size());
    }

    @Test
    public void GuydonShouldHaveCorrectData() {
        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
        competition.addResultsToCompetition(activeData);
        competition.addGolfersToCompetition();
        Golfer guydonCerasuolo = competition.find("Guydon Cerasuolo");
        assertEquals("Guydon Cerasuolo", guydonCerasuolo.getFullName());
        assertEquals(101, guydonCerasuolo.getGross());
        assertEquals(80, guydonCerasuolo.getNett());
        assertEquals(21, guydonCerasuolo.getHandicap());
        assertEquals(28, guydonCerasuolo.getPts());
    }

    @Test
    public void ShouldShowEdnyfedBeforeSort() {
        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
        competition.addResultsToCompetition(activeData);
        competition.addGolfersToCompetition();
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
        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
        competition.addResultsToCompetition(activeData);
        competition.addGolfersToCompetition();
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

    @Test
    public void BeforeSortingCheckNames() {
        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
        competition.addResultsToCompetition(activeData);
        competition.addGolfersToCompetition();
        Golfer posOne = competition.golfers.get(0);
        Golfer posTwo = competition.golfers.get(1);
        assertEquals("B. M. Dobson", posOne.getFullName());
        assertEquals(1, posOne.getPosition());
        assertEquals("Neil L. Lahif", posTwo.getFullName());
        assertEquals(2, posTwo.getPosition());
    }

    @Test
    public void AfterSortingCheckNames() {
        String activeData = StringHelper.splitBeforeAndAfter(currentDataFile, beforePart, "Number of Cards Processed");
        competition.addResultsToCompetition(activeData);
        competition.addGolfersToCompetition();
        Collections.sort(competition.golfers);
        competition.updateRankings();
        Golfer posOne = competition.golfers.get(0);
        Golfer posTwo = competition.golfers.get(1);
        assertEquals("B. M. Dobson", posOne.getFullName());
        assertEquals(1, posOne.getPosition());
        assertEquals("Colin Harris", posTwo.getFullName());
        assertEquals(2, posTwo.getPosition());
    }
}
