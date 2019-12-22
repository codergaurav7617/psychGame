package com.psych.game.controller;

import com.psych.game.model.Player;
import com.psych.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class playerController {
    @Autowired
    private PlayerRepository PlayerRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return PlayerRepository.findAll();
    }

    @PostMapping("/players")
    public Player createPlayer(@Valid @RequestBody Player player){
         return PlayerRepository.save(player);
    }
    @GetMapping("/players/{id}")
    public Player getAllPlayerById(@PathVariable(value = "id") Long id) throws Exception {
        return PlayerRepository.findById(id).orElseThrow(() -> new Exception("something went wrong"));
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable(value = "id") Long id, @Valid @RequestBody Player player) throws Exception {
        Player p = PlayerRepository.findById(id).orElseThrow(() -> new Exception("something went wrong"));
        p.setName(player.getName());
        return PlayerRepository.save(p);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(value = "id") Long id) throws Exception {
        Player p = PlayerRepository.findById(id).orElseThrow(() -> new Exception("something went wrong"));
        PlayerRepository.delete(p);
        return ResponseEntity.ok().build();
    }
}
