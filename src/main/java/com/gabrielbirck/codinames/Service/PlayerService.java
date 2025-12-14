package com.gabrielbirck.codinames.Service;

import com.gabrielbirck.codinames.Class.DTOs.PlayerDTO;
import com.gabrielbirck.codinames.Class.Enum.GroupType;
import com.gabrielbirck.codinames.Class.Infra.CodinameHandler;
import com.gabrielbirck.codinames.Class.Player;
import com.gabrielbirck.codinames.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodinameHandler handler;

    public Player createPlayer(PlayerDTO dto) {
        Player newPlayer = new Player(dto);
        String codiname = getCodiname(dto.groupType());
        newPlayer.setCodiname(codiname);
        return repository.save(newPlayer);
    }

    private String getCodiname(GroupType group) {
        return handler.findCodiname(group);
    }
}
