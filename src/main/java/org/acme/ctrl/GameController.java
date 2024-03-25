package org.acme.ctrl;


import org.acme.Player;
import org.acme.Game;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private Game gameService;

    @PostMapping("/start")
    public ResponseEntity<Game> startGame() {
        Game game = gameService.startGame();
        return ResponseEntity.ok(game);
    }

    @PutMapping("/refuel")
    public ResponseEntity<Player> refuel(@RequestParam int playerId) {
        Player player = gameService.refuel(playerId);
        return ResponseEntity.ok(player);
    }

    @PutMapping("/buy-vehicle")
    public ResponseEntity<Player> buyVehicle(@RequestParam int playerId, @RequestParam int vehicleId) {
        Player player = gameService.buyVehicle(playerId, vehicleId);
        return ResponseEntity.ok(player);
    }

    @PutMapping("/move/right")
    public ResponseEntity<Player> moveRight(@RequestParam int playerId) {
        Player player = gameService.moveRight(playerId);
        return ResponseEntity.ok(player);
    }

    @PutMapping("/move/left")
    public ResponseEntity<Player> moveLeft(@RequestParam int playerId) {
        Player player = gameService.moveLeft(playerId);
        return ResponseEntity.ok(player);
    }

    @PutMapping("/move/up")
    public ResponseEntity<Player> moveUp(@RequestParam int playerId) {
        Player player = gameService.moveUp(playerId);
        return ResponseEntity.ok(player);
    }

    @PutMapping("/move/down")
    public ResponseEntity<Player> moveDown(@RequestParam int playerId) {
        Player player = gameService.moveDown(playerId);
        return ResponseEntity.ok(player);
    }
}
