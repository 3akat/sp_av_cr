package com.bedulin.android.app.sp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

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
    private ArrayList<Drawable> mImagesAL;
    private ArrayList<String> mNamesAL;

    // ===========================================================
    // Constructors
    // ===========================================================
    public ImageAdapter(Context context, ArrayList images, ArrayList<String> names) {
        mContext = context;
        mImagesAL = images;
        mNamesAL = names;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public int getCount() {
        return mImagesAL.size();
    }

    @Override
    public Drawable getItem(int position) {
        return mImagesAL.get(position);
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
            imageView.setLayoutParams(new GridView.LayoutParams(50, 50));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageDrawable(getItem(position));
        imageView.setId(mNamesAL.get(position).hashCode());
        return imageView;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
