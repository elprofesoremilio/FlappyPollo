package Objects;

import Engine.Scene;
import Engine.Spawner;

public class PipeSpawner extends Spawner {
    private static final int PIPE_WIDTH = 60;
    private static final int GAP_SIZE = 200; // El espacio por donde pasa el pájaro
    private static final int MIN_PIPE_HEIGHT = 50;

    public PipeSpawner(Scene scene) {
        super(scene, 2f);
    }

    @Override
    public void spawn() {
        int screenHeight = scene.getGame().getHeight();
        int screenWidth = scene.getGame().getWidth();

        // Calculamos un punto de división aleatorio para el hueco
        // El hueco no puede estar ni muy arriba ni muy abajo
        int limit = screenHeight - GAP_SIZE - (MIN_PIPE_HEIGHT * 2);
        int randomY = (int)(Math.random() * limit) + MIN_PIPE_HEIGHT;

        // Tubo Superior (desde arriba hasta el inicio del hueco)
        Pipe topPipe = new Pipe(screenWidth, 0, PIPE_WIDTH, randomY, scene);

        // Tubo Inferior (desde el final del hueco hasta el suelo)
        int bottomPipeY = randomY + GAP_SIZE;
        int bottomPipeHeight = screenHeight - bottomPipeY;
        Pipe bottomPipe = new Pipe(screenWidth, bottomPipeY, PIPE_WIDTH, bottomPipeHeight, scene);

        scene.addObject(topPipe);
        scene.addObject(bottomPipe);
    }
}