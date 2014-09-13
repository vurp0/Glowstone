package net.glowstone.io.entity;

import net.glowstone.entity.objects.GlowItem;
import net.glowstone.entity.objects.GlowPainting;
import net.glowstone.io.nbt.NbtSerialization;
import net.glowstone.util.nbt.CompoundTag;
import org.bukkit.Art;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

class PaintingStore extends EntityStore<GlowPainting> {
    public PaintingStore() {
        super(GlowPainting.class, "Painting");
    }

    @Override
    public GlowPainting createEntity(Location location, CompoundTag compound) {
        return null;
    }

    @Override
    public void load(GlowPainting entity, CompoundTag tag) {
        super.load(entity, tag);

        if (tag.isString("Motive")) {
            entity.setArt(Art.getByName(tag.getString("Motive")));
        }
        if (tag.isInt("TileX") && tag.isInt("TileY") && tag.isInt("TileZ")) {
            entity.setTilePosition(tag.getInt("TileX"), tag.getInt("TileY"), tag.getInt("TileZ"));
        }
        if (tag.isByte("Facing")) {
            switch (tag.getByte("Facing")) {
                case 0:
                    entity.setFacingDirection(BlockFace.SOUTH);
                    break;
                case 1:
                    entity.setFacingDirection(BlockFace.WEST);
                    break;
                case 2:
                    entity.setFacingDirection(BlockFace.NORTH);
                    break;
                case 3:
                    entity.setFacingDirection(BlockFace.EAST);
                    break;
                default:
                    entity.setFacingDirection(BlockFace.SOUTH);
            }
        } else if (tag.isByte("Direction")) {
            switch (tag.getByte("Direction")) {
                case 0:
                    entity.setFacingDirection(BlockFace.SOUTH);
                    break;
                case 1:
                    entity.setFacingDirection(BlockFace.WEST);
                    break;
                case 2:
                    entity.setFacingDirection(BlockFace.NORTH);
                    break;
                case 3:
                    entity.setFacingDirection(BlockFace.EAST);
                    break;
                default:
                    entity.setFacingDirection(BlockFace.SOUTH);
            }
        } else if (tag.isByte("Dir")) {
            switch (tag.getByte("Dir")) {
                case 0:
                    entity.setFacingDirection(BlockFace.NORTH);
                    break;
                case 1:
                    entity.setFacingDirection(BlockFace.WEST);
                    break;
                case 2:
                    entity.setFacingDirection(BlockFace.SOUTH);
                    break;
                case 3:
                    entity.setFacingDirection(BlockFace.EAST);
                    break;
                default:
                    entity.setFacingDirection(BlockFace.SOUTH);
            }
        }
    }

    @Override
    public void save(GlowPainting entity, CompoundTag tag) {
        super.save(entity, tag);

        tag.putString("Motive", artToString(entity.getArt()));
        tag.putInt("TileX", entity.getTileX());
        tag.putInt("TileY", entity.getTileY());
        tag.putInt("TileZ", entity.getTileZ());
        switch (entity.getFacing()) {
            case SOUTH:
                tag.putByte("Facing", 0);
            case WEST:
                tag.putByte("Facing", 1);
            case NORTH:
                tag.putByte("Facing", 2);
            case EAST:
                tag.putByte("Facing", 3);
        }
    }

    private static String artToString(Art art) {
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
}
