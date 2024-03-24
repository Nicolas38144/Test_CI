package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Game;

import java.util.List;
import javax.inject.Inject;

@ApplicationScoped
public class Coin {
    private final Game game;

    private int id;
    private int xCoordinate;
    private int yCoordinate;
    private int value;

    @Inject
    public Coin(Game game) {
        this.game = game;
    }

    public Coin(Game game, int id, int xCoordinate, int yCoordinate, int value) {
        this.game = game;
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.value = value;
    }

    public List<Coin> getCoins() {
        // Vous devrez peut-être ajuster ce retour en fonction de la façon dont vous stockez les pièces dans le jeu
        return game.getCoins();
    }

    public Coin getCoinById(int coinId) {
        return getCoins().stream().filter(coin -> coin.getId() == coinId).findFirst().orElse(null);
    }

    public void collectCoin(int coinId) {
        Coin coinToCollect = getCoinById(coinId);

        if (coinToCollect != null) {
            game.getPlayer().setMoney(game.getPlayer().getMoney() + coinToCollect.getValue());
            game.getCoins().remove(coinToCollect);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
