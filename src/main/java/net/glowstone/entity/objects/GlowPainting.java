package net.glowstone.entity.objects;

import com.flowpowered.networking.Message;
import javafx.geometry.Pos;
import net.glowstone.entity.GlowEntity;
import net.glowstone.net.message.play.entity.SpawnPaintingMessage;
import net.glowstone.util.Position;
import org.bukkit.Art;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;

import java.util.Arrays;
import java.util.List;

public class GlowPainting extends GlowEntity implements Painting {
    
    Art motive;

    int tileX;
    int tileY;
    int tileZ;

    BlockFace facingDirection;

    public GlowPainting(Location location, Art art, BlockFace facingDirection) {
        super(location);
        setArt(art);
        tileX = location.getBlockX();
        tileY = location.getBlockY();
        tileZ = location.getBlockZ();
        this.facingDirection = facingDirection;
    }

    public GlowPainting(Location location, String name, BlockFace facingDirection) {
        this(location, Art.getByName(name), facingDirection);
    }

    @Override
    public List<Message> createSpawnMessage() {
        int x = Position.getIntX(location);
        int y = Position.getIntY(location);
        int z = Position.getIntZ(location);

        return Arrays.asList((Message)new SpawnPaintingMessage(id, "Sunset", x, y, z, 0));
    }

    @Override
    public EntityType getType() {
        return EntityType.PAINTING;
    }

    @Override
    public Art getArt() {
        return motive;
    }

    @Override
    public boolean setArt(Art motive) {
        return setArt(motive, false);
    }

    @Override
    public boolean setArt(Art motive, boolean force) {
        this.motive = motive;
        return true; // TODO: check the force flag, do nothing/pop it off the wall if the new motive doesn't fit
    }

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    public int getTileZ() {
        return tileZ;
    }

    public void setTileZ(int tileZ) {
        this.tileZ = tileZ;
    }

    public void setTilePosition(int tileX, int tileY, int tileZ) {
        this.tileX = tileX;
        this.tileY = tileY;
        this.tileZ = tileZ;
    }

    @Override
    public boolean setFacingDirection(BlockFace blockFace, boolean b) {
        this.facingDirection = blockFace;
        return true; // TODO: check the force flag, do nothing/pop it off if the wall and painting direction mismatch
    }

    @Override
    public BlockFace getAttachedFace() {
        return facingDirection.getOppositeFace();
    }

    @Override
    public void setFacingDirection(BlockFace blockFace) {
        setFacingDirection(blockFace, false);
    }

    @Override
    public BlockFace getFacing() {
        return facingDirection;
    }

}
