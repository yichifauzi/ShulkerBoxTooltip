package com.misterpemodder.shulkerboxtooltip.impl.network.context;

import com.misterpemodder.shulkerboxtooltip.impl.network.channel.Channel;
import net.minecraft.world.entity.player.Player;

public sealed interface MessageContext<T> permits C2SMessageContext, S2CMessageContext {
  /**
   * Executes the given task in the server/client's main thread.
   *
   * @param task The function to execute.
   */
  void execute(Runnable task);

  Player getPlayer();

  Channel<T> getChannel();

  Side getReceivingSide();

  enum Side {
    CLIENT, SERVER
  }
}
