package Objects;

import Engine.GameObject;
import Engine.InputHandler;
import Engine.Scene;
import Game.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Bird extends GameObject {

    private InputHandler input;
    /**
     * Constructor base para un objeto de juego.
     *
     * @param x      Posición inicial en el eje X.
     * @param y      Posición inicial en el eje Y.
     * @param width  Ancho del objeto.
     * @param height Alto del objeto.
     * @param scene
     */
    public Bird(float x, float y, int width, int height, Scene scene) {
        super(x, y, width, height, scene);
        this.gravity = Config.GRAVITY;
        this.input = scene.getInput();
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.green);
        g.fillOval((int) x, (int) y, width, height);
        g.setColor(Color.black);
        // Pinto un ojo
        g.fillOval((int) (x+width*0.25), (int) y+height/3, 5,5);
        g.setColor(Color.yellow);
        g.fillPolygon(new int[]{(int) (x+width*0.75), (int) (x+1.5*width), (int) (x+width*0.75)}, new int[]{(int) y, (int) y+height/2, (int) y+height}, 3);

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (input.isKeyPressed(KeyEvent.VK_SPACE)) {
            this.speedY = Config.IMPULSE;
        }
    }
}
