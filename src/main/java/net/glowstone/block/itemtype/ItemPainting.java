package net.glowstone.block.itemtype;

import net.glowstone.GlowWorld;
import net.glowstone.block.GlowBlock;
import net.glowstone.entity.GlowPlayer;
import org.bukkit.Art;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class ItemPainting extends ItemType {

    @Override
    public void rightClickBlock(GlowPlayer player, GlowBlock target, BlockFace face, ItemStack holding, Vector clickedLoc) {
        GlowWorld world = player.getWorld();
        Painting painting = (Painting) world.spawnEntity(target.getRelative(face).getLocation(), EntityType.PAINTING);
        painting.setFacingDirection(face);
        painting.setArt(Art.BURNINGSKULL);
    }
}
