package com.kindred.sports.tests;

import com.kindred.sports.base.BaseTest;
import com.kindred.sports.models.CategoryResponse;
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
            CategoryResponse matchResponse = matchesService.getCategoriesForSport(sport);
            Assert.assertNotNull(matchResponse.getMatches(), "Match categories should not be null");
            Assert.assertTrue(matchResponse.getMatches().size() > 0, "There should be matches for "+ sport);
            for (CategoryResponse.Match match : matchResponse.getMatches()) {
                Assert.assertTrue(match.getMatchCategories().size() > 0, "There should be matches for "+ sport);
                System.out.println("For sport: "+ sport + ", match with id:  "+match.getIdentifier()+" has: "+ match.getMatchCategories().size()+ " categories");
            }


        }
//
//        MatchResponse matchResponse = matchesService.getMatchesForSport("Football");
//        Assert.assertNotNull(matchResponse.getMatches(), "Match categories should not be null");
//        Assert.assertTrue(matchResponse.getMatches().size() > 0, "There should be matches for football");
//        System.out.println("how many matches: "+ matchResponse.getMatches().size());
//        System.out.println("first contest: "+ matchResponse.getMatches().get(0).getContestGroups());

    }

}
