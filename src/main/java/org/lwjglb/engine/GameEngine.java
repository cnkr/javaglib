package org.lwjglb.engine;

abstract public class GameEngine implements Runnable {

    public static final int TARGET_FPS = 75;
    public static final int TARGET_UPS = 30;

    private final Window window;
    private final Thread gameLoopThread;
    private final Timer timer;
    private final IGameLogic gameLogic;

    abstract public GameEngine(
            String windowTitle, int width, int height, boolean vSync, IGameLogic gameLogic
    ) throws Exception;

    abstract public void start();
    abstract public void run();
    abstract protected void init();
    abstract private void sync();
    abstract protected void input();
    abstract protected void update(float interval);
    abstract protected void render();
}
