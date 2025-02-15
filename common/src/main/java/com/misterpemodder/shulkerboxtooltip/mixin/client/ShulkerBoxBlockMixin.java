package com.misterpemodder.shulkerboxtooltip.mixin.client;

import com.misterpemodder.shulkerboxtooltip.ShulkerBoxTooltip;
import com.misterpemodder.shulkerboxtooltip.impl.config.Configuration.ShulkerBoxTooltipType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin {
  @Inject(at = @At("HEAD"), method =
      "appendHoverText(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/Item$TooltipContext;"
          + "Ljava/util/List;Lnet/minecraft/world/item/TooltipFlag;)V", cancellable = true)
  private void onAppendTooltip(ItemStack stack, Item.TooltipContext context, List<Component> tooltip,
      TooltipFlag options, CallbackInfo ci) {
    if (ShulkerBoxTooltip.config != null && ShulkerBoxTooltip.config.tooltip.type != ShulkerBoxTooltipType.VANILLA)
      ci.cancel();
  }
}
