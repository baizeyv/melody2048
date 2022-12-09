package com.melody.game.resource;

public class Res {

    public static final float WORLD_WIDTH_FIXED = 480;
    public static final String ATLAS_PATH = "img/melody.atlas";
    public static final float SWIPE_MIN_DISTANCE = 20;

    public interface ATLAS_RES {
        String BACKGROUND = "roll1";
        String HOME_TOP_STAR = "button/rate";
        String HOME_TOP_VOL_ON = "button/sound";
        String HOME_TOP_VOL_OFF = "button/soundoff";
        String HOME_TITLE_NEW = "titlenew";
        String HOME_BTN_CLASSIC_UP = "newmenu/classic";
        String HOME_BTN_CLASSIC_DOWN = "classic";
        String HOME_BTN_TIME_UP = "newmenu/timetrial";
        String HOME_BTN_TIME_DOWN = "time";
        String HOME_BTN_MORE_UP = "newmenu/moregames";
        String HOME_BTN_MORE_DOWN = "moregames";
        String GAME_BTN_MENU = "button/menu";
        String GAME_FRAME = "frame";
        String GAME_SCORE_TITLE = "score";
        String GAME_CARD_EMPTY = "frame1";
        String GAME_CARD_DOUBLE = "x2";
        String MENU_MENU = "menunew";
        String MENU_RESUME = "resume";
        String MENU_RETRY = "retrynew";
        String MENU_BACKGROUND = "background";
        String MENU_TITLE = "pausetitle";
        String SCORE_EMPTY = "scorenumber/empty";
        String SCORE_NUMBER_PREFIX = "scorenumber/s";
        String GAME_OVER = "gameover";
    }

    public static interface AUDIO_RES {
        String BGM = "audio/BGM.ogg";
        String BUTTON_SOUND = "audio/buttonsound.ogg";
        String COLLISION_1 = "audio/coll1.ogg";
        String COLLISION_2 = "audio/coll2.ogg";
        String HIGHER_NUM = "audio/highernum.ogg";
    }

}
