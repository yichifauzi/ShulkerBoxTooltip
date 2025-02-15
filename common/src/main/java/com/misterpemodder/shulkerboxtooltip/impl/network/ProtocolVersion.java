package com.misterpemodder.shulkerboxtooltip.impl.network;

import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.Nullable;

/**
 * ShulkerBoxTooltip's network protocol versioning.
 *
 * @param major The major revision of the protocol, different major versions are always incompatible.
 * @param minor The minor version number, different minor version should be compatible.
 */
public record ProtocolVersion(int major, int minor) {
  /**
   * The current network protocol version.
   */
  public static final ProtocolVersion CURRENT = new ProtocolVersion(2, 0);

  /**
   * Attempts to read a version from the given buffer.
   *
   * @param buf The byte buffer.
   * @return The remote version, or null if an error occurred.
   */
  @Nullable
  public static ProtocolVersion readFromPacketBuf(FriendlyByteBuf buf) {
    try {
      return new ProtocolVersion(buf.readInt(), buf.readInt());
    } catch (RuntimeException e) {
      return null;
    }
  }

  /**
   * Writes a version to the given packet buffer.
   *
   * @param buf The byte buffer.
   */
  public void writeToPacketBuf(FriendlyByteBuf buf) {
    buf.writeInt(this.major);
    buf.writeInt(this.minor);
  }

  public String toString() {
    return this.major + "." + this.minor;
  }
}
