/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themaze;

import java.awt.*;
import java.util.Random;

/**
 *
 * @author 073787251
 */
public class Square {

    public int x, y;
    public int state; //Whether or not the block is a wall or a path
    public int hiddenState;

    public Square(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
        Random rnd = new Random();
        if (rnd.nextInt(10) < 6) {
            hiddenState = 1;
        } else {
            hiddenState = 0;
        }
    }

    public String rowCount(int index) {
        String ret = "";
        int c = 0;
        for (int i = index; i < 225; i += 15) {
            if (MainFrame.board.get(i).hiddenState == 1) {
                c++;
            } else {
                if (c != 0) {
                    ret += c + " ";
                }
                c = 0;
            }
        }
        if (c != 0) {
            ret += c + " ";
        }
        return ret;
    }

    public String colCount(int index) {
        String ret = "";
        int c = 0;
        for (int i = index; i < index + 15; i++) {
            if (MainFrame.board.get(i).hiddenState == 1) {
                c++;
            } else {
                if (c != 0) {
                    ret += c + " ";
                }
                c = 0;
            }
        }
        if (c != 0) {
            ret += c + " ";
        }
        return ret;
    }

    public void display(Graphics g) {
        if (state == 0) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, 50, 50);
        } else if (state == 1) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(x, y, 50, 50);
        } else {
            g.setColor(Color.white);
            g.fillRect(x, y, 50, 50);
        }
    }
}
