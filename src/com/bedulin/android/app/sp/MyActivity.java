package com.bedulin.android.app.sp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MyActivity extends Activity {
    // ===========================================================
    // Constants
    // ===========================================================
    public static final String MYLOG = "SP-log";

    public static final int HEIGHT = 385;
    public static final int WIDTH = 385;

    // ===========================================================
    // Fields
    // ===========================================================
    private ImageView imageView;
    private Bitmap bitmap;

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
        setContentView(R.layout.main);
//      Creating a mutable bitmap. Necessary to monitor the memory.
        try{
        bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888);
        }catch (OutOfMemoryError e){
            Log.e(MYLOG,"bitmap out of memory");
            bitmap = null;
        }
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================



}
