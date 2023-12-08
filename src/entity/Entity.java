package entity;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity {
    Game game;
    public int mapX, mapY, screenX, screenY;
    public int speed;
    public BufferedImage up1, up2, upIdle, down1, down2, downIdle, left1, left2, leftIdle, right1, right2, rightIdle;
    public String direction;
    public int spriteCtr = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;

    public Entity(Game game) {
        this.game = game;
    }

    public void loadImage(String filepath) {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_up_2.png")));
            upIdle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_up_idle.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_down_2.png")));
            downIdle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_down_idle.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_left_2.png")));
            leftIdle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_left_idle.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_right_2.png")));
            rightIdle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(filepath + "_right_idle.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 0) image = upIdle;
                if (spriteNum == 1) image = up1;
                if (spriteNum == 2) image = up2;
                break;
            case "down":
                if (spriteNum == 0) image = downIdle;
                if (spriteNum == 1) image = down1;
                if (spriteNum == 2) image = down2;
                break;
            case "left":
                if (spriteNum == 0) image = leftIdle;
                if (spriteNum == 1) image = left1;
                if (spriteNum == 2) image = left2;
                break;
            case "right":
                if (spriteNum == 0) image = rightIdle;
                if (spriteNum == 1) image = right1;
                if (spriteNum == 2) image = right2;
                break;
        }
        graphics2D.drawImage(image, screenX, screenY, game.tileSize, game.tileSize, null);
    }
}
