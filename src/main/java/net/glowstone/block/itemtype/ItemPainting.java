package net.glowstone.block.itemtype;

import net.glowstone.GlowWorld;
import net.glowstone.block.GlowBlock;
import net.glowstone.entity.GlowEntity;
import net.glowstone.entity.GlowPlayer;
import net.glowstone.entity.objects.GlowPainting;
import net.glowstone.net.message.play.entity.SpawnPaintingMessage;
import org.bukkit.Art;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class ItemPainting extends ItemType {

    @Override
    public void rightClickBlock(GlowPlayer player, GlowBlock target, BlockFace face, ItemStack holding, Vector clickedLoc) {
        GlowWorld world = player.getWorld();
        GlowEntity paintingEntity = new GlowPainting(target.getRelative(face).getLocation(), Art.SUNSET, face);
        //player.getSession().send(new SpawnPaintingMessage(paintingEntity.getEntityId(), "Sunset", paintingEntity.getLocation().getBlockX(), paintingEntity.getLocation().getBlockY(), paintingEntity.getLocation().getBlockZ(), 0));
        /*BlockType placeAs;
        if (face == BlockFace.UP) {
            placeAs = ItemTable.instance().getBlock(Material.SIGN_POST);
        } else if (face == BlockFace.DOWN) {
            return;
        } else {
            placeAs = ItemTable.instance().getBlock(Material.WALL_SIGN);
        }
        placeAs.rightClickBlock(player, target, face, holding, clickedLoc);*/
    }

}
