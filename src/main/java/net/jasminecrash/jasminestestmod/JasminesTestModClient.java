package net.jasminecrash.jasminestestmod;

import net.fabricmc.api.ClientModInitializer;

import java.util.Random;

public class JasminesTestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        logRandomMessage();
    }

    private void logRandomMessage() {
        String[] messages = {
            "Hello from the depths of heck!",
            "Client loaded successfully, and successfully loaded client!",
            "Be gay, do crime!",
            "Be crime, do gay~",
            "how many redstoners does it take to- IS THAT HATSUNE MIKU???!!"
        };
        Random random = new Random();
        String message = messages[random.nextInt(messages.length)];
        JasminesTestMod.LOGGER.info(message);
    }
}
