package com.bedulin.android.app.sp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CharacterCreator extends Activity {
    // ===========================================================
    // Constants
    // ===========================================================
    public static final String MYLOG = "SP-log";

    public static final int HEIGHT = 385;
    public static final int WIDTH = 385;

    // ===========================================================
    // Fields
    // ===========================================================
    private RelativeLayout layoutItem;
    private GridView gvElements;
    private ImageView ivCharacter;
    private Bitmap bitmap;
    private ArrayAdapter<Color> adapter;
    private Color[] colors;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character);

//      Creating a mutable bitmap. Necessary to monitor the memory.
        try {
            bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            Log.e(MYLOG, "bitmap out of memory");
            bitmap = null;
        }
        ivCharacter = (ImageView) findViewById(R.id.ivCharacter);
        ivCharacter.setImageResource(R.drawable.push_menu);


        gvElements = (GridView) findViewById(R.id.gvElements);
        gvElements.setAdapter(new ImageAdapter(getApplicationContext()));
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================


}
