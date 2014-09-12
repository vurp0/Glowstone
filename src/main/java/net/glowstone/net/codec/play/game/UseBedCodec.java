package net.glowstone.net.codec.play.game;

import com.flowpowered.networking.Codec;
import io.netty.buffer.ByteBuf;
import net.glowstone.net.GlowBufUtils;
import net.glowstone.net.message.play.game.UseBedMessage;
import org.bukkit.util.BlockVector;

import java.io.IOException;

public class UseBedCodec implements Codec<UseBedMessage> {
    @Override
    public UseBedMessage decode(ByteBuf buf) throws IOException {
        int id = buf.readByte();
        BlockVector pos = GlowBufUtils.readBlockPosition(buf);
        return new UseBedMessage(id, pos.getBlockX(), pos.getBlockY(), pos.getBlockZ());
    }

    @Override
    public ByteBuf encode(ByteBuf buf, UseBedMessage message) throws IOException {
        buf.writeByte(message.getId());
        GlowBufUtils.writeBlockPosition(buf, message.getX(), message.getY(), message.getZ());
        return buf;
    }
}