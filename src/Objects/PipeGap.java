package Objects;

import Engine.Collidable;
import Engine.GameObject;
import Engine.Scene;
import Game.Config;

import java.awt.*;

public class PipeGap extends GameObject implements Collidable {

    private boolean passed;
    /**
     * Constructor base para un objeto de juego.
     *
     * @param x      Posición inicial en el eje X.
     * @param y      Posición inicial en el eje Y.
     * @param width  Ancho del objeto.
     * @param height Alto del objeto.
     * @param scene
     */
    public PipeGap(float x, float y, int width, int height, Scene scene) {
        super(x, y, width, height, scene);
        this.speedX = Config.PIPE_SPEED; // Movimiento constante
        this.gravity = 0;         // Los tubos no caen
        this.passed = false;
    }

    @Override
    public void onCollision(GameObject other) {
        if (!passed && other instanceof Bird) {
            scene.getGame().getGameState().addScore(1);
            passed = true;
            scene.removeObject(this);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, width, height);
    }

    @Override
    public void update(float delta) {
        super.update(delta); // Mueve el tubo según speedX

        // Auto-destrucción: Si sale completamente por la izquierda
        if (x + width < 0) {
            scene.removeObject(this);
        }
    }
}
