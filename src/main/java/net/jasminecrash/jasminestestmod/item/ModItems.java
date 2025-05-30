package net.jasminecrash.jasminestestmod.item;

import net.jasminecrash.jasminestestmod.JasminesTestMod;
import net.jasminecrash.jasminestestmod.item.custom.weapons.ResonantBladeItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RESONATOR = registerItem("resonator", new Item(new Item.Settings()));
    public static final Item RESONANT_STONE = registerItem("resonant_stone", new Item(new Item.Settings()));

    public static final Item RESONANT_BLADE = registerItem("resonant_blade", new ResonantBladeItem(new Item.Settings().maxCount(1).maxDamage(4096)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(JasminesTestMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        JasminesTestMod.LOGGER.info("Beginning Item Registration...");

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
//            entries.add(RESONATOR);
//            entries.add(RESONANT_STONE);
//        });

        JasminesTestMod.LOGGER.info("Item Registration Complete!");
    }
}
