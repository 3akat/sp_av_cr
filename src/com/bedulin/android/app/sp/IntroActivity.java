package com.bedulin.android.app.sp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created with IntelliJ IDEA.
 * User: alexandr.bedulin
 * Date: 11/15/12
 * Time: 7:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntroActivity extends Activity implements Animation.AnimationListener {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private ImageView ivIntro;
    private Animation anim;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        ivIntro = (ImageView) findViewById(R.id.ivIntro);
        anim = AnimationUtils.loadAnimation(this,R.anim.anim_intro);
        anim.setAnimationListener(this);
        ivIntro.setAnimation(anim);
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        ivIntro.setImageResource(Color.BLACK);
        finish();
        Intent intent = new Intent(this,CharacterCreator.class);
        startActivity(intent);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
