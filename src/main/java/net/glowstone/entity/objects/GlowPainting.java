package net.glowstone.entity.objects;

import com.flowpowered.networking.Message;
import javafx.geometry.Pos;
import net.glowstone.entity.GlowEntity;
import net.glowstone.entity.meta.MetadataMap;
import net.glowstone.net.message.play.entity.*;
import net.glowstone.util.Position;
import org.bukkit.Art;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.LinkedList;
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
        int x = getTileX();
        int y = getTileY();
        int z = getTileZ();

        return Arrays.asList((Message)new SpawnPaintingMessage(id, artToString(motive), x, y, z, getFacingInt(facingDirection)),
                (Message) new EntityMetadataMessage(id, metadata.getEntryList()));
    }

    @Override
    public List<Message> createUpdateMessage() {
        boolean moved = hasMoved();
        boolean rotated = hasRotated();

        int x = getTileX();
        int y = getTileY();
        int z = getTileZ();

        int dx = x - getTileX();
        int dy = y - getTileY();
        int dz = z - getTileZ();

        boolean teleport = dx > Byte.MAX_VALUE || dy > Byte.MAX_VALUE || dz > Byte.MAX_VALUE || dx < Byte.MIN_VALUE || dy < Byte.MIN_VALUE || dz < Byte.MIN_VALUE;

        int yaw = Position.getIntYaw(location);
        int pitch = Position.getIntPitch(location);

        List<Message> result = new LinkedList<>();
        //if (teleported || (moved && teleport)) {
            //result.add(new EntityTeleportMessage(id, x, y, z, yaw, pitch));
        ///*} else*/ if (moved) {
            //result.add(new RelativeEntityPositionMessage(id, dx, dy, dz));
        //}

        // todo: handle head rotation as a separate value

        // send changed metadata
        List<MetadataMap.Entry> changes = metadata.getEntryList();
        result.add(new EntityMetadataMessage(id, changes));

        // send velocity if needed
        /*if (velocityChanged) {
            result.add(new EntityVelocityMessage(id, velocity));
        }*/


        return result;
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
    public boolean hasMoved() {
        return false;
    }

    @Override
    public boolean hasRotated() {
        return false;
    }

    @Override
    public Vector getVelocity() {
        return new Vector(0,0,0);
    }

    @Override
    public void setVelocity(Vector velocity) {
        return;
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

    public static String artToString(Art art) {
        switch (art) {
            case KEBAB:
                return "Kebab";
            case AZTEC:
                return "Aztec";
            case ALBAN:
                return "Alban";
            case AZTEC2:
                return "Aztec2";
            case BOMB:
                return "Bomb";
            case PLANT:
                return "Plant";
            case WASTELAND:
                return "Wasteland";
            case WANDERER:
                return "Wanderer";
            case GRAHAM:
                return "Graham";
            case POOL:
                return "Pool";
            case COURBET:
                return "Courbet";
            case SUNSET:
                return "Sunset";
            case SEA:
                return "Sea";
            case CREEBET:
                return "Creebet";
            case MATCH:
                return "Match";
            case BUST:
                return "Bust";
            case STAGE:
                return "Stage";
            case VOID:
                return "Void";
            case SKULL_AND_ROSES:
                return "SkullAndRoses";
            case WITHER:
                return "Wither";
            case FIGHTERS:
                return "Fighters";
            case SKELETON:
                return "Skeleton";
            case DONKEYKONG:
                return "DonkeyKong";
            case POINTER:
                return "Pointer";
            case PIGSCENE:
                return "Pigscene";
            case BURNINGSKULL:
                return "BurningSkull";
            default:
                return "Kebab";
        }
    }

    public static int getFacingInt(BlockFace facing) {
        switch(facing) {
            case SOUTH:
                return 0;
            case WEST:
                return 1;
            case NORTH:
                return 2;
            case EAST:
                return 3;
            default:
                return 2;
        }
    }

}
