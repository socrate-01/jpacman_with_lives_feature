package nl.tudelft.jpacman.level;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.sprite.AnimatedSprite;
import nl.tudelft.jpacman.sprite.Sprite;

/**
 * A player operated unit in our game.
 */
public class Player extends Unit {

    private int score;
    private final Map<Direction, Sprite> sprites;
    private final AnimatedSprite deathSprite;
    private boolean alive;
    private int lives;
    private Unit killer;
    private boolean invulnerable;  // Added attribute for invulnerability.
    private static final long INVULNERABILITY_DURATION = 3000; // 3 seconds

    protected Player(Map<Direction, Sprite> spriteMap, AnimatedSprite deathAnimation) {
        this.score = 0;
        this.alive = true;
        this.lives = 3;
        this.sprites = spriteMap;
        this.deathSprite = deathAnimation;
        this.invulnerable = false;  // Initialization of invulnerability.
        deathSprite.setAnimating(false);
    }

    public boolean isAlive() {
        return alive && lives > 0;
    }

    public void setAlive(boolean isAlive) {
        if (!isAlive && lives > 0 && !invulnerable) {
            lives--;
            deathSprite.restart();
            if (lives > 0) {
                alive = true;
                setInvulnerableForDuration(INVULNERABILITY_DURATION);
            } else {
                alive = false;
            }
        } else if (isAlive) {
            deathSprite.setAnimating(false);
            killer = null;
            alive = true;
        }
    }

    public int getLives() {
        return lives;
    }

    public Unit getKiller() {
        return killer;
    }

    public void setKiller(Unit killer) {
        this.killer = killer;
    }

    public int getScore() {
        return score;
    }

    public void addPoints(int points) {
        score += points;
    }

    @Override
    public Sprite getSprite() {
        if (isAlive()) {
            return sprites.get(getDirection());
        }
        return deathSprite;
    }

    public boolean isInvulnerable() {
        return invulnerable;
    }

    /**
     * Sets the invulnerability and schedules a timer to reset it after a certain duration.
     */
    public void setInvulnerableForDuration(long duration) {
        invulnerable = true;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setInvulnerable(false);
            }
        }, duration);
    }

    public void setInvulnerable(boolean invulnerable) {
        this.invulnerable = invulnerable;
    }
}
