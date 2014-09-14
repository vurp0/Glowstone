package net.glowstone.entity;

import java.util.LinkedList;
import java.util.List;

import com.flowpowered.networking.Message;
import net.glowstone.net.message.play.entity.EntityHeadRotationMessage;
import net.glowstone.net.message.play.entity.SpawnMobMessage;
import net.glowstone.util.Position;

import org.bukkit.Location;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

/**
 * Represents a monster such as a creeper.
 * @author Graham Edgecombe
 */
public class GlowAgeable extends GlowCreature implements Ageable {

    private static final int AGE_BABY = -24000;
    private static final int AGE_ADULT = 0;
    protected float width, height;
    private int age = 0;
    private boolean ageLocked = false;

    /**
     * Creates a new ageable monster.
     * @param location The location of the monster.
     * @param type The type of monster.
     */
    public GlowAgeable(Location location, EntityType type) {
        super(location, type);
    }

    @Override
    public void pulse() {
        super.pulse();
        if (this.ageLocked) {
            setScaleForAge(!isAdult());
        } else {
            int currentAge = this.age;
            if (currentAge < AGE_ADULT) {
                currentAge++;
                setAge(currentAge);
            } else if (currentAge > AGE_ADULT) {
                currentAge--;
                setAge(currentAge);
            }
        }
    }

    @Override
    public final int getAge() {
        return this.age;
    }

    @Override
    public final void setAge(int age) {
        this.age = age;
        this.setScaleForAge(isAdult());
    }

    @Override
    public final void setAgeLock(boolean ageLocked) {
        this.ageLocked = ageLocked;
    }

    @Override
    public final boolean getAgeLock() {
        return this.ageLocked;
    }

    @Override
    public final void setBaby() {
        if (isAdult()) {
            setAge(AGE_BABY);
        }
    }

    @Override
    public final void setAdult() {
        if (!isAdult()) {
            setAge(AGE_ADULT);
        }
    }

    @Override
    public final boolean isAdult() {
        return this.age >= AGE_ADULT;
    }

    @Override
    public final boolean canBreed() {
        return this.age == AGE_ADULT;
    }

    @Override
    public void setBreed(boolean breed) {
        if (breed) {
            setAge(AGE_ADULT);
        } else if (isAdult()) {
            setAge(6000);
        }
    }

    public void setScaleForAge(boolean isAdult) {
        setScale(isAdult ? 1.0F : 0.5F);
    }

    protected final void setScale(float scale) {
        setSize(this.height * scale, this.width * scale);
    }
}
