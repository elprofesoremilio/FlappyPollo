package Game;

public class Config {
    public static final int GAME_WIDTH = 400;
    public static final int GAME_HEIGHT = 600;
    public static final String TITLE = "Flappy Pollo";
    public static final float GRAVITY = 300f;
    public static final float IMPULSE = -GRAVITY*0.8f;

    public static final int PIPE_WIDTH = 60;
    public static final int GAP_SIZE = 200; // El espacio por donde pasa el pájaro
    public static final int MIN_PIPE_HEIGHT = 50;
    public static final float PIPE_SPEED = -100f; // Píxeles por segundo hacia la izquierda

}
