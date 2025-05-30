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
        if (!world.isClient()) {
            BlockPos strikePos = context.getBlockPos();
            Block struckBlock = world.getBlockState(strikePos).getBlock();
            float pitch;
            float volume;
            switch (struckBlock.getTranslationKey().split("\\.")[2]) {
                case "iron_block", "netherite_block" -> {pitch = 5.0f; volume = 2.0f; world.removeBlock(strikePos,false);} //test cases work!
                case null, default -> {pitch = 1.0f; volume = 1.0f;}
            }
            world.playSound(strikePos.getX(), strikePos.getY(), strikePos.getZ(), SoundEvents.BLOCK_METAL_HIT, SoundCategory.MASTER, volume, pitch, true);
        }
        return ActionResult.PASS;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        attacker.playSound(SoundEvents.ENTITY_WARDEN_SONIC_BOOM);
    }
}
