package itamio.seedshow;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("seedshow")
public class SeedShowMod {
    public SeedShowMod() {
        MinecraftForge.EVENT_BUS.addListener(this::onRegisterCommands);
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("seedshow").requires(s -> s.hasPermission(0))
            .executes(ctx -> {
                long seed = ctx.getSource().getLevel().getSeed(); ctx.getSource().sendSuccess(() -> Component.literal("World seed: " + seed), false);
                return 1;
            }));
    }
}
