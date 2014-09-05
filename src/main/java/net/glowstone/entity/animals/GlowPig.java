package net.glowstone.entity.animals;

import net.glowstone.entity.GlowAnimal;

import org.bukkit.Location;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;

/**
 * Represents a monster such as a creeper.
 * @author Graham Edgecombe
 */
public class GlowPig extends GlowAnimal implements Pig {

    private boolean hasSaddle;

    /**
     * Creates a new ageable animal.
     * @param location The location of the monster.
     */
    public GlowPig(Location location) {
        super(location, EntityType.PIG);
    }

    @Override
    public boolean hasSaddle() {
        return hasSaddle;
    }

    @Override
    public void setSaddle(boolean hasSaddle) {
        this.hasSaddle = hasSaddle;
    }
}
