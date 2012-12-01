package com.bedulin.android.app.sp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCreator extends Activity implements AdapterView.OnItemClickListener {
    // ===========================================================
    // Constants
    // ===========================================================
    public static final String LOG = "CharacterCreatorLog";
    //  body parts id/GridView status
    public static final int START    = -1;
    public static final int PLACES   =  0;
    public static final int BODIES   =  1;
    public static final int EYES     =  2;
    public static final int EYEBROWS =  3;
    public static final int MOUTHS   =  4;
    public static final int HAIRS    =  5;
    public static final int HATS     =  6;
    public static final int SHIRTS   =  7;
    public static final int HANDS    =  8;
    public static final int LEGS     =  9;
    public static final int BOOTS    =  10;
    public static final int SHORT    =  11;
    public static final int LONG     =  12;
    public static final int SPECIAL  =  13;

    //  substrings for helping to find needed images in assets for grid view initialisation
    public static final String SUB_START         = "ic_";
    public static final String SUB_BODY          = "body";
    public static final String SUB_HAT           = "hat";
    public static final String SUB_HAIR          = "hair";
    public static final String SUB_HAIR_LONG     = "hr_long";
    public static final String SUB_HAIR_SHORT    = "hr_short";
    public static final String SUB_HAIR_SPECIAL  = "hr_special";
    public static final String SUB_EYE           = "eye";
    public static final String SUB_EYEBROW       = "ibrows";
    public static final String SUB_MOUTH         = "mouth";
    public static final String SUB_HANDS         = "hands";
    public static final String SUB_SHIRT         = "shirt";
    public static final String SUB_LEG           = "leg";
    public static final String SUB_BOOTS         = "boots";
    public static final String SUB_PLACE         = "place";

    //  hashCode for some icons
    public static final int ID_HAIR_SHORT   = 2145339829;   //"hair_short_ic.png".hashCode();
    public static final int ID_HAIR_LONG    =  -65201765;   //"hair_long_ic.png".hashCode();
    public static final int ID_HAIR_SPECIAL =  750441340;   //"hair_spec_ic.png".hashCode();
    public static final int ID_IC_BODIES    = -717170368;   //"hair_short_ic.png".hashCode();
    public static final int ID_IC_BOOTS     = -325786217;   //"hair_long_ic.png".hashCode();
    public static final int ID_IC_EYEBROWS  =  1179867882;  //"hair_spec_ic.png".hashCode();
    public static final int ID_IC_EYES      =  1057396770;  //"hair_short_ic.png".hashCode();
    public static final int ID_IC_HAIR      = -2015765598;  //"hair_long_ic.png".hashCode();
    public static final int ID_IC_HANDS     =  1739277882;  //"hair_spec_ic.png".hashCode();
    public static final int ID_IC_HATS      = -1699921416;  //"hair_short_ic.png".hashCode();
    public static final int ID_IC_LEGS      = -140778907;   //"hair_long_ic.png".hashCode();
    public static final int ID_IC_MOUTH     = -2008020067;  //"hair_spec_ic.png".hashCode();
    public static final int ID_IC_PLACES    = -9514548;     //"hair_short_ic.png".hashCode();
    public static final int ID_IC_SHIRT     = -1388901044;  //"hair_long_ic.png".hashCode();
    public static final int ID_IC_BACK      = -1424260691;  //"back_ic.png".hashCode();

    // ===========================================================
    // Fields
    // ===========================================================
    private static int mGridViewStatus;
    private static int mHairDeep;
    private GridView mElementsGV;
    private ImageView mCharacterIV;
    private Drawable[] mDrawableForLayer;
    private LayerDrawable mImageCombinationsLD;
    private ArrayList<Drawable> mBitmapAL;
    //  chose images
    private ArrayList<String> mNames;
    private Map<Integer, String> mHashForNamesHM;
    //  all images
    private String[] mImageNames;

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
        mCharacterIV = (ImageView) findViewById(R.id.ivCharacter);
        mElementsGV = (GridView) findViewById(R.id.gvElements);

//      get names of images
//      and creating associations of names with hash keys
        try {
            mImageNames = getAssets().list("imgs");
            mHashForNamesHM = new LinkedHashMap<Integer, String>();
            for (String s : mImageNames) {
                mHashForNamesHM.put(s.hashCode(), s);
            }
        } catch (IOException e) {
            Log.e(LOG, "getting list of images " + e.toString());
        }

//      layers array for creating avatar
//      filling all layers with blank image except first one(with white)
        mDrawableForLayer = new Drawable[11];
        try {
            for (int i = 1; i < 11; i++) {
                mDrawableForLayer[i] = Drawable.createFromStream(getAssets().open("imgs/pl_blank.png"), null);
            }
            mDrawableForLayer[0] = Drawable.createFromStream(getAssets().open("imgs/pl_default.jpg"), null);
            mImageCombinationsLD = new LayerDrawable(mDrawableForLayer);
            mCharacterIV.setImageDrawable(mImageCombinationsLD);
        } catch (IOException e) {
            Log.e(LOG, "layer init " + e.toString());
        }

//      gridView initialisation
        mElementsGV.setOnItemClickListener(this);
        mGridViewStatus = START;
        mElementsGV.setAdapter(initAdapter(mBitmapAL, mGridViewStatus));
        mElementsGV.setBackgroundColor(Color.CYAN);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//      reinitialise grid view on click, depending on its status
        if (mGridViewStatus == START) {
            switch (view.getId()) {
                case ID_IC_BODIES:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, BODIES));
                    break;
                case ID_IC_EYES:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, EYES));
                    break;
                case ID_IC_EYEBROWS:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, EYEBROWS));
                    break;
                case ID_IC_MOUTH:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, MOUTHS));
                    break;
                case ID_HAIR_LONG:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, LONG));
                    break;
                case ID_HAIR_SHORT:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, SHORT));
                    break;
                case ID_HAIR_SPECIAL:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, SPECIAL));
                    break;
                case ID_IC_HAIR:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, HAIRS));
                    break;
                case ID_IC_HATS:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, HATS));
                    break;
                case ID_IC_HANDS:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, HANDS));
                    break;
                case ID_IC_SHIRT:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, SHIRTS));
                    break;
                case ID_IC_LEGS:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, LEGS));
                    break;
                case ID_IC_BOOTS:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, BOOTS));
                    break;
                case ID_IC_PLACES:
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, PLACES));
                    break;
            }
        } else
//          and putting chosen body part to main screen
                    iconPick(view);
    }

    /**
     * Creating menu for picking part
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Choosing with which parts to fill the grid view
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.send)
            startActivity(new Intent(this, SendTo.class));
        return super.onOptionsItemSelected(item);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * Reaction on icon click, depends on clicked item id(hash from image name)
     *
     * @param view - clicked element
     */
    private void iconPick(View view) {
        Log.e("sdvsdvsd",mHairDeep+"" );
        switch (view.getId()) {
            case ID_HAIR_SHORT:
                mHairDeep = 2;
                Log.e("2",mHairDeep+"" );
                mElementsGV.setAdapter(initAdapter(mBitmapAL, SHORT));
                break;
            case ID_HAIR_LONG:
                mHairDeep = 2;
                Log.e("3",mHairDeep+"" );
                mElementsGV.setAdapter(initAdapter(mBitmapAL, LONG));
                break;
            case ID_HAIR_SPECIAL:
                mHairDeep = 2;
                Log.e("4",mHairDeep+"" );
                mElementsGV.setAdapter(initAdapter(mBitmapAL, SPECIAL));
                break;
            case ID_IC_BACK:
                Log.e("5",mHairDeep+"" );
                if (mHairDeep == 2){
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, HAIRS));
                    mHairDeep = 1;
                }else{
                    mElementsGV.setAdapter(initAdapter(mBitmapAL, START));
                }
                break;
            default:
                Log.e("1",mHairDeep+"" );
                try {
                    if (mGridViewStatus == LONG || mGridViewStatus == SHORT || mGridViewStatus == SPECIAL) {
                        mGridViewStatus = HAIRS;
                    }
                    mDrawableForLayer[mGridViewStatus] = Drawable.createFromStream(
                            getAssets().open("imgs/" + mHashForNamesHM.get(view.getId())), null);
                } catch (IOException e) {
                    Log.e(LOG, "iconPick " + e.toString());
                }catch (ArrayIndexOutOfBoundsException e){
                    Log.e(LOG, "iconPick " + e.toString());
                }
                mImageCombinationsLD = new LayerDrawable(mDrawableForLayer);
                mCharacterIV.setImageDrawable(mImageCombinationsLD);
        }
    }

    /**
     * @param drawablesList list for body parts
     * @param parts         number of needed parts
     */
    public ImageAdapter initAdapter(ArrayList<Drawable> drawablesList, int parts) {
        if (drawablesList == null) {
            drawablesList = new ArrayList();
            mNames = new ArrayList();
        } else {
            drawablesList.clear();
            mNames.clear();
        }
        switch (parts) {
            case START:
                searchForImages(SUB_START, drawablesList, mNames);
                break;
            case BODIES:
                searchForImages(SUB_BODY, drawablesList, mNames);
                break;
            case EYES:
                searchForImages(SUB_EYE, drawablesList, mNames);
                break;
            case EYEBROWS:
                searchForImages(SUB_EYEBROW, drawablesList, mNames);
                break;
            case MOUTHS:
                searchForImages(SUB_MOUTH, drawablesList, mNames);
                break;
            case HAIRS:
                searchForImages(SUB_HAIR, drawablesList, mNames);
                mHairDeep = 1;
                break;
            case HANDS:
                searchForImages(SUB_HANDS, drawablesList, mNames);
                break;
            case LONG:
                searchForImages(SUB_HAIR_LONG, drawablesList, mNames);
                break;
            case SHORT:
                searchForImages(SUB_HAIR_SHORT, drawablesList, mNames);
                break;
            case SPECIAL:
                searchForImages(SUB_HAIR_SPECIAL, drawablesList, mNames);
                break;
            case HATS:
                searchForImages(SUB_HAT, drawablesList, mNames);
                break;
            case SHIRTS:
                searchForImages(SUB_SHIRT, drawablesList, mNames);
                break;
            case LEGS:
                searchForImages(SUB_LEG, drawablesList, mNames);
                break;
            case BOOTS:
                searchForImages(SUB_BOOTS, drawablesList, mNames);
                break;
            case PLACES:
                searchForImages(SUB_PLACE, drawablesList, mNames);
                break;
        }


            mGridViewStatus = parts;

        return new ImageAdapter(getApplicationContext(), drawablesList, mNames);
    }

    private void searchForImages(String imageNamePart, ArrayList<Drawable> images, ArrayList<String> names) {
        Drawable drawable;
//      checking for prevent loading excess images(example: if searching for SUB_EYE will be added and eye.png and ic_eye.png<--excess)
        if (SUB_START.equals(imageNamePart)) {
            for (String fileName : mImageNames) {
                if (fileName.contains(imageNamePart))
                    try {
                        drawable = Drawable.createFromStream(getAssets().open("imgs/" + fileName), null);
                        names.add(fileName);
                        images.add(drawable);
                    } catch (IOException e) {
                        Log.e(LOG, "Opening images " + e.toString());
                    }
            }
        } else {
            for (String fileName : mImageNames) {
                if (fileName.contains(imageNamePart) && !fileName.contains(SUB_START))
                    try {
                        drawable = Drawable.createFromStream(getAssets().open("imgs/" + fileName), null);
                        names.add(fileName);
                        images.add(drawable);
                    } catch (IOException e) {
                        Log.e(LOG, "Opening images " + e.toString());
                    }
            }
            try {
                drawable = Drawable.createFromStream(getAssets().open("imgs/back_ic.png"), null);
                names.add("back_ic.png");
                images.add(drawable);
            } catch (IOException e) {
                Log.e(LOG, "Opening images " + e.toString());
            }
        }
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
//Toast.makeText(this,"Not implemented yet",Toast.LENGTH_SHORT).show();
//Log.e("","");