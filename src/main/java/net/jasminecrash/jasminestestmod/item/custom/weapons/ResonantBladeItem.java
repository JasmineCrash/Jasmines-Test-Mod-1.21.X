package net.jasminecrash.jasminestestmod.item.custom.weapons;


import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ResonantBladeItem extends Item {
    public ResonantBladeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (world.isClient()) { return ActionResult.PASS; }
        BlockPos strikePos = context.getBlockPos();
        Block struckBlock = world.getBlockState(strikePos).getBlock();
        float pitch;
        float volume;
        ActionResult result = ActionResult.PASS;
        switch (struckBlock.getTranslationKey().split("\\.")[2]) {
            case "iron_block", "netherite_block" -> {
                pitch = 5.0f;
                volume = 2.0f;
                world.removeBlock(strikePos,false);
                result = ActionResult.SUCCESS;
            } //test cases work!
            default -> {
                pitch = 1.0f;
                volume = 1.0f;
            }
        }
        world.playSound(
                null,
                strikePos,
                SoundEvents.BLOCK_METAL_BREAK, SoundCategory.PLAYERS,
                volume, pitch
        );
        return result;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        attacker.getWorld().playSound(
                null,
                attacker.getBlockPos(),
                SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.PLAYERS,
                1.0f, 1.0f
        );
        return true;
    }
}
