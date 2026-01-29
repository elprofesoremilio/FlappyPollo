package Scenes;

import Engine.Game;
import Engine.Scene;
import Objects.Bird;
import Objects.PipeSpawner;

public class FlappyScene extends Scene {
    private PipeSpawner spawner;

    public FlappyScene(Game game) {
        super(game);
        this.spawner = new PipeSpawner(this);
        this.addObject(new Bird((game.getWidth()-30) / 2f, (game.getHeight()-30) / 2f, 30, 30, this));
    }

    @Override
    public void update(float delta) {
        spawner.update(delta); // El spawner decide cuándo crear tubos
        super.update(delta);    // La escena actualiza y mueve todos los objetos
    }
}
