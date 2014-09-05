package net.glowstone.entity.animals;

import net.glowstone.entity.GlowAnimal;

import org.bukkit.Location;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;

/**
 * Represents a monster such as a creeper.
 * @author Graham Edgecombe
 */
public class GlowCow extends GlowAnimal implements Cow {

    /**
     * Creates a new ageable animal.
     * @param location The location of the monster.
     */
    public GlowCow(Location location) {
        super(location, EntityType.COW);
    }
}
