package com.kindred.sports.services;

import com.kindred.sports.base.ApiClient;
import com.kindred.sports.models.*;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class MatchesService extends ApiClient {
    public Response getMatchesForSport(String url, Map<String,String> headers, Map<String, String> queryParams) {
        return get(url,headers,queryParams );
    }

    public Response getContestsForSportCategory(String url, Map<String,String> headers, Map<String, String> queryParams) {
        return get(url,headers,queryParams );
    }

    public MatchResponse parseMatchResponse(Response response) {
        return response.as(MatchResponse.class);
    }

    /**
     * This method processes the matches for a sport, not a category!.
     * @param matches
     */
    public void processMatches(List<Match> matches) {
        if (matches == null || matches.isEmpty()) {
            System.out.println("No matches available for category: ");
            return;
        }
        matches.forEach(this::processMatch);
    }


    private void processMatch(Match match) {
        System.out.println("Match ID: " + match.getIdentifier());

        List<Category> categories = match.getCategories();
        if (categories == null || categories.isEmpty()) {
            System.out.println("No categories found for match: " + match.getIdentifier());
        } else {
            System.out.println("Categories count: " + categories.size());
            return;
        }
        List<ContestGroup> contestGroups = match.getContestGroups();
        if (contestGroups == null || contestGroups.isEmpty()) {
            System.out.println("No contest groups found for match: " + match.getIdentifier());
        } else {
            System.out.println("Contest groups count: " + contestGroups.size());
            contestGroups.forEach(this::processContestGroup);

        }

    }



    private void processContestGroup(ContestGroup contestGroup) {
        List<Contest> contests = contestGroup.getContests();
        if (contests == null || contests.isEmpty()) {
            System.out.println("No contests found in contest group.");
            return;
        }
        System.out.println("Contests count: "+contests.size());
        contests.forEach(this::processContest);
    }

    private void processContest(Contest contest) {
        List<Proposition> propositions = contest.getPropositions();
        if (propositions == null || propositions.isEmpty()) {
            System.out.println("No propositions found for contest.");
            return;
        }
        System.out.println("Propositions count: "+propositions.size());
        propositions.forEach(this::processProposition);
    }

    private void processProposition(Proposition proposition) {
        System.out.println("Proposition type: " + proposition.getPropositionType());
    }

}
