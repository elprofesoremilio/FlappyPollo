package Objects;

import Engine.Collidable;
import Engine.GameObject;
import Engine.Scene;

import java.awt.*;

public class Pipe extends GameObject implements Collidable {
    private static final float PIPE_SPEED = -100f; // Píxeles por segundo hacia la izquierda

    public Pipe(float x, float y, int width, int height, Scene scene) {
        super(x, y, width, height, scene);
        this.speedX = PIPE_SPEED; // Movimiento constante
        this.gravity = 0;         // Los tubos no caen
    }

    @Override
    public void update(float delta) {
        super.update(delta); // Mueve el tubo según speedX

        // Auto-destrucción: Si el tubo sale completamente por la izquierda
        if (x + width < 0) {
            scene.removeObject(this);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(new Color(34, 139, 34)); // Verde bosque
        g.fillRect((int)x, (int)y, width, height);

        // Borde para que se vea mejor
        g.setColor(Color.BLACK);
        g.drawRect((int)x, (int)y, width, height);
    }

    @Override
    public void onCollision(GameObject other) {

    }
}
