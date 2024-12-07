package com.kindred.sports.tests;

import com.kindred.sports.base.BaseTest;
import com.kindred.sports.models.Category;
import com.kindred.sports.models.Match;
import com.kindred.sports.models.MatchResponse;
import com.kindred.sports.services.CategoriesService;
import com.kindred.sports.utils.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MatchTests extends BaseTest {
    private final CategoriesService matchesService = new CategoriesService();

    @Test
    public void testGetCategoriesForAllSports() throws IOException {
        List<String> sports = FileUtils.readSportsFromFile("src/test/resources/sports.txt");

        for (String sport : sports) {
            MatchResponse matchResponse = matchesService.getCategoriesForSport(sport);
            Assert.assertNotNull(matchResponse.getMatches(), "Match categories should not be null");
            Assert.assertTrue(matchResponse.getMatches().size() > 0, "There should be matches for " + sport);
            for (Match match : matchResponse.getMatches()) {
                Assert.assertTrue(match.getMatchCategories().size() > 0, "There should be matches for " + sport);
                System.out.println("For sport: " + sport + ", match with id:  " + match.getIdentifier() + " has: " + match.getMatchCategories().size() + " categories");
            }


        }
    }

    @Test
    public void testGetCategoriesForFootball() throws IOException {
        MatchResponse matchResponse = matchesService.getCategoriesForSport("football");
        Assert.assertNotNull(matchResponse.getMatches(), "Match categories should not be null");
              Assert.assertTrue(matchResponse.getMatches().size() > 0, "There should be matches for Football ");
                for (Match match : matchResponse.getMatches()) {
                    for (Category category : match.getCategories()) {
                        System.out.println("category id:  : "+category.getCategoryRn());
                }


            }
    }


}
