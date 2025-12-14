package com.gabrielbirck.codinames.Class.Infra;

import com.gabrielbirck.codinames.Class.Enum.GroupType;
import com.gabrielbirck.codinames.Service.CodinameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodinameHandler {

    @Autowired
    private CodinameService service;

    public String findCodiname(GroupType groupType) {
        if (groupType == GroupType.AVENGERS) {
            String firstMatch = service.getAvengersCodinameList().stream().findFirst().orElseThrow(
                    () -> new IllegalStateException("Nenhum codinome disponivel"));
            this.service.getAvengersCodinameList().remove(firstMatch);
            return firstMatch;
        } else {
            String firstMatch = service.getJusticeLeagueCodinameList().stream().findFirst().orElseThrow(
                    () -> new IllegalStateException("Nenhum codinome disponivel")
            );
            this.service.getJusticeLeagueCodinameList().remove(firstMatch);
            return firstMatch;
        }
    }
}
