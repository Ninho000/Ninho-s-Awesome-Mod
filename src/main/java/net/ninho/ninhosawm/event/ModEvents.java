package net.ninho.ninhosawm.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.ninho.ninhosawm.NinhosAwesomeMod;
import net.ninho.ninhosawm.entity.ModEntities;
import net.ninho.ninhosawm.entity.dodo.DodoEntity;

@EventBusSubscriber(modid = NinhosAwesomeMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DODO.get(), DodoEntity.createAttributes().build());
    }
}