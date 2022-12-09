package com.melody.game.actor;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class HomeTopGroup extends BaseGroup {

    private Button starBtn;

    private Button volBtn;

    public HomeTopGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        /* init rate button */
        Button.ButtonStyle startStyle = new Button.ButtonStyle();
        TextureRegionDrawable star = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_STAR));
        startStyle.up = star;
        startStyle.down = star;
        starBtn = new Button(startStyle);
        starBtn.setPosition(0, 0);
        this.addActor(starBtn);

        /* init vol button */
        final Button.ButtonStyle volStyle = new Button.ButtonStyle();
        volStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_ON));
        volStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_OFF));
        volBtn = new Button(volStyle);
        volBtn.setPosition(getMelodyGame().getWorldWidth() - volBtn.getPrefWidth() - 40, starBtn.getY());
        this.addActor(volBtn);

        this.setSize(getMelodyGame().getWorldWidth() - 40, Math.max(starBtn.getHeight(), volBtn.getHeight()));

        volBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Music mc = getMelodyGame().getMusic();
                if(mc.isPlaying()) {
                    volStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_OFF));
                    volStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_ON));
                    volBtn.setStyle(volStyle);
                    mc.stop();
                } else {
                    volStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_ON));
                    volStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_OFF));
                    volBtn.setStyle(volStyle);
                    mc.play();
                }
            }
        });
    }

}
