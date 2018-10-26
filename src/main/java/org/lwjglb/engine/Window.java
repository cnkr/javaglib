package org.lwjglb.engine;

public abstract class Window {

    private final String TITLE;
    private int width;
    private int height;
    private long windowHandle;
    private boolean resized;
    private boolean vSync;

    public Window(String title, int width, int height, boolean vSync) {
        this.TITLE = title;
        this.width = width;
        this.height = height;
        this.vSync = vSync;
        this.resized = false;
    }

    abstract public void init();
    abstract public void setClearColor(float r, float g, float b, float alpha);
    abstract public boolean isKeyPressed(int keyCode);
    abstract public boolean windowShouldClose();
    abstract public String getTitle();
    abstract public int getWidth();
    abstract public int getHeight();
    abstract public boolean isResized();
    abstract public void setResized(boolean resized);
    abstract public boolean isvSync();
    abstract public void setvSync(boolean vSync);
    abstract public void update();
}
