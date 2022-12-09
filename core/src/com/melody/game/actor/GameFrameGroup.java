package com.melody.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.model.DataLogicModelImpl;
import com.melody.game.model.IDataLogicModel;
import com.melody.game.resource.Res;

import java.util.Arrays;


public class GameFrameGroup extends BaseGroup {

    private Image frame;

    private BgCardGroup[][] bgArray;

    private CardGroup[][] cardArray;

    private DataLogicModelImpl model;

    private ScoreCardGroup[] scoreCardArray;

    private final int ROW = 4;

    private final int COL = 4;

    public DataLogicModelImpl getModel() {
        return model;
    }

    public GameFrameGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    public void restart() {
        model.initData();

        /* set images of main cards */
        sync();
    }

    private void init() {

        frame = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.GAME_FRAME));
        this.addActor(frame);

        /* Group Size */
        this.setSize(frame.getWidth(), frame.getHeight());

        /* Background Card */
        bgArray = new BgCardGroup[ROW][COL];
        for(int i = 0; i < bgArray.length; i++) {
            for(int j = 0; j < bgArray[0].length; j ++) {
                bgArray[i][j] = new BgCardGroup(getMelodyGame());
                bgArray[i][j].setOrigin(Align.center);
                this.addActor(bgArray[i][j]);
            }
        }

        /* Gain the width and height of background card */
        float bgCardWidth = bgArray[0][0].getWidth();
        float bgCardHeight = bgArray[0][0].getHeight();

        /* calculate gaps */
        float bgGapsV = (this.getWidth() - COL * bgCardWidth) / (COL + 1);
        float bgGapsH = (this.getHeight() - ROW * bgCardHeight) / (ROW + 1);

        /* background card layout */
        for(int i = 0; i < ROW; i ++) {
            for(int j = 0; j < COL; j ++) {
                bgArray[i][j].setX(bgGapsV + j * (bgCardWidth + bgGapsV));
                bgArray[i][j].setY(bgGapsH + i * (bgCardHeight + bgGapsH));
            }
        }

        // -----------------------------------

        /* create main cards */
        cardArray = new CardGroup[ROW][COL];
        for(int i = 0; i < ROW; i ++) {
            for(int j = 0; j < COL; j ++) {
                cardArray[i][j] = new CardGroup(getMelodyGame());
                cardArray[i][j].setOrigin(Align.center);
                this.addActor(cardArray[i][j]);
            }
        }

        model = IDataLogicModel.Builder.build(ROW, COL, new GameFrameGroup.CurrentDataListener());

        model.initData();

        /* set images of main cards */
        sync();

        /* main cards layout */
        for(int i = 0; i < ROW; i ++) {
            for(int j = 0; j < COL; j ++) {
                cardArray[i][j].setX(bgGapsV + j * (bgCardWidth + bgGapsV));
                cardArray[i][j].setY(bgGapsH + i * (bgCardHeight + bgGapsH));
            }
        }

        /* score card */
        scoreSync();

        this.addListener(new InputListener() {
            private float touchDownX;
            private float touchDownY;
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touchDownX = x;
                touchDownY = y;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                float diffX = x - touchDownX;
                float diffY = y - touchDownY;

                if (Math.abs(diffX) >= Res.SWIPE_MIN_DISTANCE && Math.abs(diffX) * 0.5F > Math.abs(diffY)) {
                    // 左右滑动
                    if (diffX > 0) {
                        model.rightLogic();
                        sync();
                    } else {
                        model.leftLogic();
                        sync();
                    }
                } else if (Math.abs(diffY) >= Res.SWIPE_MIN_DISTANCE && Math.abs(diffY) * 0.5F > Math.abs(diffX)) {
                    // 上下滑动
                    if (diffY > 0) {
                        model.upLogic();
                        sync();
                    } else {
                        model.downLogic();
                        sync();
                    }
                }

                if(model.getIsOver()) {
                    Gdx.app.error("OVER", "OVER");
                }
            }
        });
    }

    private void sync() {
        ot();
        for(int i = 0; i < ROW; i ++) {
            for(int j = 0; j < COL; j ++) {
                cardArray[i][j].setNumStr(String.valueOf(model.getData()[i][j]));
            }
        }
    }

    public void scoreSync() {
        String str = String.valueOf(model.getCurrentScore());
        if(scoreCardArray != null) {
            for(int i = 0; i < scoreCardArray.length; i ++) {
                scoreCardArray[i].remove();
            }
        }
        scoreCardArray = new ScoreCardGroup[str.length()];
        for(int i = 0; i < str.length(); i ++) {
            scoreCardArray[i] = new ScoreCardGroup(getMelodyGame());
            scoreCardArray[i].setOrigin(Align.center);
            this.addActor(scoreCardArray[i]);
            scoreCardArray[i].setPosition(i * (scoreCardArray[i].getWidth() + 10)
                    + getWidth() / 2 - str.length() * (scoreCardArray[i].getWidth() + 10) / 2, getHeight() + 80);
        }
        for(int i = 0; i < scoreCardArray.length; i ++) {
            scoreCardArray[i].setNumStr(String.valueOf(str.charAt(i)));
        }
    }

    // test1
    private void ot() {
        for(int i = 0; i < ROW; i ++) {
            Gdx.app.error("OTCARD:", Arrays.toString(model.getData()[i]));
        }
    }


    private class CurrentDataListener implements IDataLogicModel.DataListener {


        @Override
        public void onGenerateNewCard(int row, int col) {
            cardArray[row][col].setScale(0.25f);
            ScaleToAction scaleTo = Actions.scaleTo(1.0f, 1.0f, 0.2f);
            cardArray[row][col].addAction(scaleTo);
        }

        @Override
        public void onOperateCard(int type) {
            switch (type) {
                case 1:model.swipeUp();sync();break;
                case 2:model.swipeDown();sync();break;
                case 3:model.swipeLeft();sync();break;
                case 4:model.swipeRight();sync();break;
            }
        }

        /**
         * ERROR ERROR
         * TODO: cards was hided
         * @param i origin i
         * @param j origin j
         * @param ni next i
         * @param nj next j
         */
        @Override
        public void onMoveCard(int i, int j, int ni, int nj) {
//            cardArray[i][j].remove();
//            addActor(cardArray[i][j]);
            float x = cardArray[i][j].getX();
            float y = cardArray[i][j].getY();

            float nx = cardArray[ni][nj].getX();
            float ny = cardArray[ni][nj].getY();

            MoveToAction moveBefore = Actions.moveTo(x, y);

            MoveToAction moveTo = Actions.moveTo(nx, ny, 0.6f);

//            MoveToAction moveBack = Actions.moveTo(x, y);

            DelayAction delay = Actions.delay(0.05f);

            SequenceAction sequenceAction = Actions.sequence(moveBefore, delay, moveTo);
//            moveArray[i][j].addAction(sequenceAction);
            cardArray[ni][nj].addAction(sequenceAction);

        }

        @Override
        public void onScoreChange() {
            scoreSync();
        }
    }
}
