package main;

import java.io.IOException;

public final class Main {
    private Main() {
    }
    public static void main(final String[] args) throws IOException {
        // Se citeste inputul, incepe jocul, se scriu fisierele.
        GameInputLoader loader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = loader.load();
        GameMechanics m = new GameMechanics(gameInput, loader.getmOutputPath());
        m.launchGame();
    }


}
