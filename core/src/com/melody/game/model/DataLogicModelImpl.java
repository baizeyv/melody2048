package com.melody.game.model;

import com.badlogic.gdx.Gdx;

import java.util.Arrays;
import java.util.Random;

public class DataLogicModelImpl implements IDataLogicModel {

    private int[][] data;

    private DataListener dataListener;

    private boolean isOver = false;

    private int currentScore;

    public int[][] getData() {
        return data;
    }

    public DataLogicModelImpl(int rowNum, int colNum, DataListener dataListener) {
        this.dataListener = dataListener;
        data = new int[rowNum][colNum];
        initData();
    }

    public void initData() {
        for(int i = 0; i < data.length; i ++) {
            for(int j = 0; j < data[0].length; j++) {
                data[i][j] = 0;
            }
        }
        currentScore = 0;
        generateCardNumber();
        generateCardNumber();
    }

    /**
     * Get The Quantity Of Empty Frame
     * @return
     */
    public int getEmptyNum() {
        int res = 0;
        for(int i = 0; i < data.length; i ++) {
            for(int j = 0; j < data[0].length; j ++) {
                if(data[i][j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public void leftLogic() {
        if(isOver) {
            Gdx.app.error("arst", "arsetin");
            return;
        }
        if(dataListener != null) {
            dataListener.onOperateCard(3);
        }
    }

    public boolean getIsOver() {
        return isOver;
    }

    public void rightLogic() {
        if(isOver) {
            Gdx.app.error("arst", "arsetin");
            return;
        }
        if(dataListener != null) {
            dataListener.onOperateCard(4);
        }
    }

    public void downLogic() {
        if(isOver) {
            Gdx.app.error("arst", "arsetin");
            return;
        }
        if(dataListener != null) {
            dataListener.onOperateCard(2);
        }
    }

    public void upLogic() {
        if(isOver) {
            Gdx.app.error("arst", "arsetin");
            return;
        }
        if(dataListener != null) {
            dataListener.onOperateCard(1);
        }
    }

    /*public void swipeLeft() {
        boolean flag = false;

        for(int i = 0; i < data.length; i ++) { // iterate over each line
            int x = 0, y = 1;
            while (x < data[i].length && y <data[i].length) {
                if(data[x][i] == data[y][i]) {
                    data[x][i] *= 2;
                    data[y][i] = 0;
                    currentScore += data[x][i];
                    flag = true;
                    if(dataListener != null) {
                        dataListener.onMoveCard(x, i,y , i);
                        dataListener.onScoreChange();
                    }
                    y++;
                } else if (data[x][i] == 0 || data[y][i] != 0) {
                    x = y;
                    y++;
                }
            }
            int ptr = 0;
            for(int j = 0; j < data[i].length; j ++) {
                if(data[j][i] == 0) {
                    ptr++;
                } else if(ptr != 0) {
                    data[j - ptr][i] = data[j][i];
                    data[j][i] = 0;
                    flag = true;
                }
            }
        }

        if(flag) {
            generateCardNumber();
            if(!checkMovable()) {
                isOver = true;
            }
        }
    }*/

    public void swipeLeft() {
        boolean flag = false;
        for(int i = 0; i < data.length; i ++) { // iterate over each line

            for(int j = 0; j < data[i].length; j ++) { // iterate ech grid of the current line
                if(data[i][j] == 0) {
                    continue;
                }
                for(int k = j + 1; k < data[i].length; k ++) {
                    if(data[i][k] == 0) {
                        continue;
                    }
                    if(data[i][k] == data[i][j]) {
                        data[i][j] *= 2;
                        data[i][k] = 0;
                        currentScore += data[i][j];
                        flag = true;
                        if(dataListener != null) {
                            dataListener.onMoveCard(i, k, i, j, true);
                            dataListener.onScoreChange();
                        }
                    }
                    break;
                }
            }
            ot("before");
            // move card
            for(int j = 0; j < data[i].length; j ++) {
                if(data[i][j] == 0) {
                    for(int k = j + 1; k < data[i].length; k++) {
                        if(data[i][k] == 0) {
                            continue;
                        }
                        data[i][j] = data[i][k];
                        data[i][k] = 0;
                        flag = true;
                        if(dataListener != null) {
                            dataListener.onMoveCard(i, k, i, j, false);
                        }
                        break;
                    }
                }
            }
            ot("after");
        }
        if(flag) {
            generateCardNumber();
            if(!checkMovable()) {
                isOver = true;
            }
        }

    }

    public void swipeDown() {
        boolean flag = false;
        for(int i = 0; i < data.length; i ++) { // iterate over each line

            for(int j = 0; j < data[i].length; j ++) { // iterate ech grid of the current line
                if(data[j][i] == 0) {
                    continue;
                }
                for(int k = j + 1; k < data[i].length; k ++) {
                    if(data[k][i] == 0) {
                        continue;
                    }
                    if(data[k][i] == data[j][i]) {
                        data[j][i] *= 2;
                        data[k][i] = 0;
                        currentScore += data[j][i];
                        flag = true;if(dataListener != null) {
                            dataListener.onMoveCard(k, i, j, i, true);
                            dataListener.onScoreChange();
                        }
                    }
                    break;
                }
            }
            ot("before");

            // move card
            for(int j = 0; j < data[i].length; j ++) {
                if(data[j][i] == 0) {
                    for(int k = j + 1; k < data[i].length; k++) {
                        if(data[k][i] == 0) {
                            continue;
                        }
                        data[j][i] = data[k][i];
                        data[k][i] = 0;
                        flag = true;
                        if(dataListener != null) {
                            dataListener.onMoveCard(k, i, j, i, false);
                        }
                        break;
                    }
                }
            }
            ot("after");
        }
        if(flag) {
            generateCardNumber();
            if(!checkMovable()) {
                isOver = true;
            }
        }
    }

    private void ot(String str) {
        for(int i = 0; i < 4; i ++) {
            Gdx.app.error(str, Arrays.toString(data[i]));
        }
    }

    public void swipeRight() {
        boolean flag = false;
        for(int i = 0; i < data.length; i ++) { // iterate over each line

            for(int j = data[i].length - 1; j >= 0; j --) { // iterate ech grid of the current line
                if(data[i][j] == 0) {
                    continue;
                }
                for(int k = j - 1; k >= 0; k --) {
                    if(data[i][k] == 0) {
                        continue;
                    }
                    if(data[i][k] == data[i][j]) {
                        data[i][j] *= 2;
                        data[i][k] = 0;
                        currentScore += data[i][j];
                        flag = true;
                        if(dataListener != null) {
                            dataListener.onMoveCard(i, k, i, j, true);
                            dataListener.onScoreChange();
                        }
                    }
                    break;
                }
            }
            ot("before:");

            // move card
            for(int j = data[i].length - 1; j >= 0; j --) {
                if(data[i][j] == 0) {
                    for(int k = j - 1; k >= 0; k--) {
                        if(data[i][k] == 0) {
                            continue;
                        }
                        data[i][j] = data[i][k];
                        data[i][k] = 0;
                        flag = true;
                        if(dataListener != null) {
                            dataListener.onMoveCard(i, k, i, j, false);
                        }
                        break;
                    }
                }
            }
            ot("after:");
        }
        if(flag) {
            generateCardNumber();
            if(!checkMovable()) {
                isOver = true;
            }
        }
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void swipeUp() {
        boolean flag = false;
        for(int i = 0; i < data.length; i ++) { // iterate over each line

            for(int j = data[i].length - 1; j >= 0; j --) { // iterate ech grid of the current line
                if(data[j][i] == 0) {
                    continue;
                }
                for(int k = j - 1; k >= 0; k --) {
                    if(data[k][i] == 0) {
                        continue;
                    }
                    if(data[k][i] == data[j][i]) {
                        data[j][i] *= 2;
                        data[k][i] = 0;
                        currentScore += data[j][i];
                        flag = true;
                        if(dataListener != null) {
                            dataListener.onMoveCard(k, i, j, i, true);
                            dataListener.onScoreChange();
                        }
                    }
                    break;
                }
            }
            ot("befroe");
            // move card
            for(int j = data[i].length - 1; j >= 0; j --) {
                if(data[j][i] == 0) {
                    for(int k = j - 1; k >= 0; k--) {
                        if(data[k][i] == 0) {
                            continue;
                        }
                        data[j][i] = data[k][i];
                        data[k][i] = 0;
                        flag = true;
                        if(dataListener != null) {
                            dataListener.onMoveCard(k, i, j, i, false);
                        }
                        break;
                    }
                }
            }
            ot("aft");
        }
        if(flag) {
            generateCardNumber();
            if(!checkMovable()) {
                isOver = true;
            }
        }
    }

    private boolean checkMovable() {
        boolean res = false;
        if(getEmptyNum() > 0) {
            return !res;
        }
        for(int i = 0; i < data.length; i ++) {
            for(int j = 0; j < data[0].length - 1; j ++) {
                if (data[i][j] == data[i][j + 1]) {
                    return !res;
                }
            }
        }
        for(int i = 0; i < data.length; i ++) {
            for(int j = 0; j < data[0].length - 1; j ++) {
                if (data[j][i] == data[j + 1][i]) {
                    return !res;
                }
            }
        }
        return res;
    }



    /**
     * 右下角开始横数，1-16
     * @return
     */
    private int generateRandom() {
        Random random = new Random();
        int rd = random.nextInt(16) + 1; // 1 - 16
        return rd;
    }

    private void generateCardNumber() {

        int pos = generateRandom();
        while (data[(pos - 1) / data.length][data.length - 1 - (pos - 1) % data.length] != 0) {
            pos = generateRandom();
        }
        Double rd = Math.random();
        if(rd < 0.2) {
            data[(pos - 1) / data.length][data.length - 1 - (pos - 1) % data.length] = 4;
        } else {
            data[(pos - 1) / data.length][data.length - 1 - (pos - 1) % data.length] = 2;
        }
        Gdx.app.error("POS", "" + pos);
        if(dataListener != null) {
            dataListener.onGenerateNewCard((pos - 1) / data.length,data.length - 1 - (pos - 1) % data.length);
        }
    }

}
