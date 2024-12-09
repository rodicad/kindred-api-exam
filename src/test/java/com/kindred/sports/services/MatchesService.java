package com.kindred.sports.services;

import com.kindred.sports.api.ApiClient;
import com.kindred.sports.models.*;
import io.restassured.response.Response;

import java.util.List;

public class MatchesService extends ApiClient {

    public MatchResponse parseMatchResponse(Response response) {
        return response.as(MatchResponse.class);
    }

    /**
     * This method processes the sport's matches in API response!.
     *
     */
    public void processMatches(List<Match> matches) {
        if (matches == null || matches.isEmpty()) {
            System.out.println("No matches available for category: ");
            return;
        }
        System.out.println("Matches available: "+matches.size());
        matches.forEach(this::processMatch);
    }


    /**
     * This method processes a single match in API response!.
     */
    private void processMatch(Match match) {

        List<Category> categories = match.getMatchCategories();
        if (categories != null && !categories.isEmpty()) {
            System.out.println("Match with ID:  "+match.getIdentifier()+", has " + categories.size()+"categories.");
            return;
        }
        List<ContestGroup> contestGroups = match.getContestGroups();
        if (contestGroups != null &&  !contestGroups.isEmpty()) {
            System.out.println("Match with ID: "+match.getIdentifier()+", has " + contestGroups.size()+" contest groups.");
            contestGroups.forEach(this::processContestGroup);
        }

    }

    /**
     * This method processes a match's contest group in API response!.
     */
    private void processContestGroup(ContestGroup contestGroup) {
        List<Contest> contests = contestGroup.getContests();
        if (contests != null && !contests.isEmpty()) {
            System.out.println("Contest Group with ID: "+contestGroup.getIdentifier()+", has " + contests.size()+" contests.");
        }
    }
}
