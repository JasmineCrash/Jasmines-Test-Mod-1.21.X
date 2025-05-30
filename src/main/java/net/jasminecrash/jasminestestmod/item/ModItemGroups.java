package net.jasminecrash.jasminestestmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jasminecrash.jasminestestmod.JasminesTestMod;
import net.jasminecrash.jasminestestmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup JASMINES_TEST_MOD_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(JasminesTestMod.MOD_ID, "jasmines_test_mod_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.RESONATOR))
                    .displayName(Text.translatable("itemgroup.jasminestestmod.jasmines_test_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RESONATOR);
                        entries.add(ModItems.RESONANT_STONE);
                        entries.add(ModItems.RESONANT_BLADE);
                    })
            .build()
    );

    public static final ItemGroup JASMINES_TEST_MOD_BLOCKS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(JasminesTestMod.MOD_ID, "jasmines_test_mod_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.RESONANT_STONE_BLOCK))
                    .displayName(Text.translatable("itemgroup.jasminestestmod.jasmines_test_mod_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RESONANT_STONE_BLOCK);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        JasminesTestMod.LOGGER.info("Beginning Item Group Registration...");

        JasminesTestMod.LOGGER.info("Item Group Registration Complete!");
    }
}
