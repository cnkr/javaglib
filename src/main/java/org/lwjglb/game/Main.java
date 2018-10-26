package org.lwjglb.game;

// import glfw and opengl libraries

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.glfw.Callbacks.*;


public class Main {

    private long window; // window handle

    public void run() {
        try {
            init();
            loop();

            glfwFreeCallbacks(window); // Free CB
            glfwDestroyWindow(window); //
        } finally {
            glfwTerminate();
            glfwSetErrorCallback(null).free();
        }
    }

    public void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Cannot init GLFW.");
        }

        int WIDTH = 800;
        int HEIGHT = 600;

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

        window = glfwCreateWindow(WIDTH, HEIGHT, "HELLO LWJGL", NULL, NULL);

        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW Window");
        }

        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true);
            }
        });

        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(window,
                (vidMode.width() - WIDTH) / 2,
                (vidMode.height() - HEIGHT) / 2);
        glfwMakeContextCurrent(window);

        glfwSwapInterval(1);
        glfwShowWindow(window);
    }

    public void loop() {
        GL.createCapabilities();

        glClearColor(0.0f, 0.0f, 1.0f, 0.0f);

        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }


    }


    public static void main(String[] args) {
        new Main().run();
    }
}