package net.glowstone.net.message.play.game;

import com.flowpowered.networking.Message;

public class UseBedMessage implements Message {

    private final int id;
    private final int x, y, z;

    public UseBedMessage(int id, int x, int y, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "UseBedMessage{" +
                "id=" + id +
                ",x=" + x +
                ",y=" + y +
                ",z=" + z +
                "}";
    }
}
