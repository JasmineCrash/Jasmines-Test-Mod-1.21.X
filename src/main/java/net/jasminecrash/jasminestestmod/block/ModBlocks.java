package net.jasminecrash.jasminestestmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jasminecrash.jasminestestmod.JasminesTestMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RESONANT_STONE_BLOCK = registerBlock("resonant_stone_block", new Block(
            AbstractBlock.Settings.create()
                    .strength(0.6f)
                    .solid()
                    .slipperiness(1.0f)
                    .requiresTool()
                    .luminance(blockState -> 15)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
    ));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(JasminesTestMod.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block, Item.Settings blockItemSettings) {
        registerBlockItem(name, block, blockItemSettings);
        return Registry.register(Registries.BLOCK, Identifier.of(JasminesTestMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block, Item.Settings settings) {
        Registry.register(Registries.ITEM, Identifier.of(JasminesTestMod.MOD_ID, name), new BlockItem(block, settings));
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(JasminesTestMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        JasminesTestMod.LOGGER.info("Beginning Block Registration...");

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//            entries.add(ModBlocks.RESONANT_STONE_BLOCK);
//        });

        JasminesTestMod.LOGGER.info("Block Registration Complete!");
    }
}
