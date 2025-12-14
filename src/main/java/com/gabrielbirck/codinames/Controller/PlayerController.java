package com.gabrielbirck.codinames.Controller;

import com.gabrielbirck.codinames.Class.DTOs.PlayerDTO;
import com.gabrielbirck.codinames.Class.Player;
import com.gabrielbirck.codinames.Service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    public ResponseEntity<Player> create(@RequestBody @Valid PlayerDTO dto) {
        Player newPlayer = service.createPlayer(dto);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return service.getAllPlayers();
    }
}
