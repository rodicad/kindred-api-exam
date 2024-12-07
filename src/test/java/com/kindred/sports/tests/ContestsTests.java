package com.kindred.sports.tests;

import com.kindred.sports.base.BaseTest;
import com.kindred.sports.models.*;
import com.kindred.sports.services.CategoriesService;
import org.testng.annotations.Test;

import java.util.List;

public class ContestsTests extends BaseTest {
    private final CategoriesService matchesService = new CategoriesService();

    @Test
    public void testGetContestForCategory() {
        String category = "football:italy:serie_a";
        MatchResponse matchResponse = matchesService.getContestsForSportCategory(category);
        List<Match> matches= matchResponse.getMatches();
        for (Match match : matches) {
            System.out.println("match id: "+match.getIdentifier());
            System.out.println("match categories: "+match.getContestGroups().size());
            List<ContestGroup> contestGroups = match.getContestGroups();
            for (ContestGroup contestGroup : contestGroups) {
                System.out.println("contest group id: "+contestGroup.getIdentifier());
                System.out.println("contest group contests: "+contestGroup.getContests().size());
                List<Contest> contests = contestGroup.getContests();
                for (Contest contest : contests) {
                    System.out.println("contest name: "+contest.getName());
                    System.out.println("contest propositions: "+contest.getPropositions().size());
                    for (Proposition proposition : contest.getPropositions()) {
                        System.out.println("proposition type: "+proposition.getPropositionType());
                    }
                }
            }
        }
        //System.out.println("do we have contest groups: "+contestResponse.getContestGroups().size());

    }

}
