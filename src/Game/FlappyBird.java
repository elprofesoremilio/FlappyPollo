package Game;

import Engine.Game;
import Scenes.FlappyScene;

public class FlappyBird {
    void main() {
        Game game = new Game(Config.GAME_WIDTH, Config.GAME_HEIGHT, Config.TITLE);
        game.setScene(new FlappyScene(game));
        game.start();
    }
}
