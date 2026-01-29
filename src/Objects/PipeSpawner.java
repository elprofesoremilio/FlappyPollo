package Objects;

import Engine.Scene;
import Engine.Spawner;
import Game.Config;


public class PipeSpawner extends Spawner {

    public PipeSpawner(Scene scene) {
        super(scene, 2f);
    }

    @Override
    public void spawn() {
        int screenHeight = scene.getGame().getHeight();
        int screenWidth = scene.getGame().getWidth();

        // Calculamos un punto de división aleatorio para el hueco
        // El hueco no puede estar ni muy arriba ni muy abajo
        int limit = screenHeight - Config.GAP_SIZE - (Config.MIN_PIPE_HEIGHT * 2);
        int randomY = (int)(Math.random() * limit) + Config.MIN_PIPE_HEIGHT;

        // Tubo Superior (desde arriba hasta el inicio del hueco)
        Pipe topPipe = new Pipe(screenWidth, 0, Config.PIPE_WIDTH, randomY, scene);

        // Tubo Inferior (desde el final del hueco hasta el suelo)
        int bottomPipeY = randomY + Config.GAP_SIZE;
        int bottomPipeHeight = screenHeight - bottomPipeY;
        Pipe bottomPipe = new Pipe(screenWidth, bottomPipeY, Config.PIPE_WIDTH, bottomPipeHeight, scene);

        // Creamos el hueco para contar la puntuación
        PipeGap gap = new PipeGap(screenWidth+Config.PIPE_WIDTH/2f-1, randomY, 1, Config.GAP_SIZE, scene);

        scene.addObject(topPipe);
        scene.addObject(bottomPipe);
        scene.addObject(gap);
    }
}