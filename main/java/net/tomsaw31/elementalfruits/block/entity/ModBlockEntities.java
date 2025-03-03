package net.tomsaw31.elementalfruits.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.elementalfruits.ElementalFruitsMod;
import net.tomsaw31.elementalfruits.block.ModBlocks;
import net.tomsaw31.elementalfruits.block.entity.custom.FruitSynthesizerBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ElementalFruitsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<FruitSynthesizerBlockEntity>> FRUIT_SYNTHESIZER =
            BLOCK_ENTITIES.register("fruit_synthesizer", () ->
                    BlockEntityType.Builder.of(FruitSynthesizerBlockEntity::new,
                            ModBlocks.FRUIT_SYNTHESIZER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

