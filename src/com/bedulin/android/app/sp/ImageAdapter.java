package com.bedulin.android.app.sp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created with IntelliJ IDEA.
 * User: alexandr.bedulin
 * Date: 11/15/12
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageAdapter extends BaseAdapter {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private Context mContext;
    private final int[] mImagesAL;

    // ===========================================================
    // Constructors
    // ===========================================================

    public ImageAdapter(Context context) {
        mContext = context;
        mImagesAL = new int[]{
                R.drawable.body_strong,R.drawable.body_skinny, R.drawable.body_fat, R.drawable.body_norm,
                R.drawable.shirt0, R.drawable.shirt1, R.drawable.shirt2, R.drawable.shirt3,
                R.drawable.legs0, R.drawable.legs1, R.drawable.legs2, R.drawable.legs3,
                R.drawable.place0, R.drawable.place1, R.drawable.place2, R.drawable.place3,
                R.drawable.mouth0, R.drawable.mouth1, R.drawable.mouth2, R.drawable.mouth3,
                R.drawable.hat0, R.drawable.hat1, R.drawable.hat2, R.drawable.hat3,
                R.drawable.hair0, R.drawable.hair1, R.drawable.hair2, R.drawable.hair3,
                R.drawable.eyes0, R.drawable.eyes1, R.drawable.eyes2, R.drawable.eyes3};
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public int getCount() {
        return mImagesAL.length;
    }

    @Override
    public Object getItem(int position) {
        return mImagesAL[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) { // if it's not recycled, initialize some
            // attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(mImagesAL[position]);
        return imageView;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
