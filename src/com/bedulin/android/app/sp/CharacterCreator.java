package com.bedulin.android.app.sp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class CharacterCreator extends Activity implements AdapterView.OnItemClickListener {
    // ===========================================================
    // Constants
    // ===========================================================
    /**
     * Parts id/GridView status
     */
    public static final int START = -1;
    public static final int BODIES = 1;
    public static final int HATS = 6;
    public static final int HAIRS = 5;
    public static final int EYEBROWS = 3;
    public static final int EYES = 2;
    public static final int MOUTHS = 4;
    public static final int HANDS = 8;
    public static final int SHIRTS = 7;
    public static final int LEGS = 9;
    public static final int BOOTS = 10;
    public static final int PLACES = 0;
    public static final int SHORT = 11;
    public static final int LONG = 12;
    public static final int SPECIAL = 13;

    public static final int HEIGHT = 385;
    public static final int WIDTH = 385;

    // ===========================================================
    // Fields
    // ===========================================================
    private static int gvStatus;

    private GridView gvElements;
    private ImageView ivCharacter;
    private Drawable[] drawableArray;
    private LayerDrawable layerDrawable;
    private ImageAdapter adapter;

    private String[] imageList;
    private ArrayList<Integer> arrayList;


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
        ivCharacter = (ImageView) findViewById(R.id.ivCharacter);

//      layers array for combining images
        drawableArray = new Drawable[11];
        for (int i = 1; i < 11; i++) {
            drawableArray[i] = getResources().getDrawable(R.drawable.place_blank);
        }
        drawableArray[0] = getResources().getDrawable(R.drawable.place_default);

//      gridView initialisation
        gvElements = (GridView) findViewById(R.id.gvElements);
        gvElements.setOnItemClickListener(this);
        gvStatus = START;
        gvElements.setAdapter(initAdapter(adapter, arrayList, gvStatus));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (gvStatus == START) {
            switch (view.getId()) {
                case R.drawable.ic_bodys:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, BODIES));
                    break;
                case R.drawable.ic_eyes:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, EYES));
                    break;
                case R.drawable.ic_eyebrows:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, EYEBROWS));
                    break;
                case R.drawable.ic_mouth:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, MOUTHS));
                    break;
                case R.drawable.ic_hair:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, HAIRS));
                    break;
                case R.drawable.ic_hats:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, HATS));
                    break;
                case R.drawable.ic_hands:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, HANDS));
                    break;
                case R.drawable.ic_shirt:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, SHIRTS));
                    break;
                case R.drawable.ic_legs:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, LEGS));
                    break;
                case R.drawable.ic_boots:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, BOOTS));
                    break;
                case R.drawable.ic_places:
                    gvElements.setAdapter(initAdapter(adapter, arrayList, PLACES));
                    break;
            }
        } else
            switch (gvStatus) {
                case BODIES:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case EYES:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case EYEBROWS:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case MOUTHS:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case HAIRS:
                    switch (view.getId()) {
                        case R.drawable.ic_back:
                            gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                            break;
                        case R.drawable.ic_short:
                            gvElements.setAdapter(initAdapter(adapter, arrayList, SHORT));
                            break;
                        case R.drawable.ic_long:
                            gvElements.setAdapter(initAdapter(adapter, arrayList, LONG));
                            break;
                        case R.drawable.ic_spec:
                            gvElements.setAdapter(initAdapter(adapter, arrayList, SPECIAL));
                            break;
                    }
                    break;
                case SHORT:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, HAIRS));
                    else {
                        drawableArray[HAIRS] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case LONG:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, HAIRS));
                    else {
                        drawableArray[HAIRS] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case SPECIAL:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, HAIRS));
                    else {
                        drawableArray[HAIRS] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case HATS:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case HANDS:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case SHIRTS:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case LEGS:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case BOOTS:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
                case PLACES:
                    if (view.getId() == R.drawable.ic_back)
                        gvElements.setAdapter(initAdapter(adapter, arrayList, START));
                    else {
                        drawableArray[gvStatus] = getResources().getDrawable(view.getId());
                        layerDrawable = new LayerDrawable(drawableArray);
                        ivCharacter.setImageDrawable(layerDrawable);
                    }
                    break;
            }
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
        if (item.getItemId() == R.id.send) {
            startActivity(new Intent(this, SendTo.class));
        }
        return super.onOptionsItemSelected(item);
    }
    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * @param imageAdapter ImageView adapter for gridView
     * @param arrayList    list for body parts
     * @param parts        number of needed parts
     * @return adapter filled by body parts
     */
    public ImageAdapter initAdapter(ImageAdapter imageAdapter, ArrayList<Integer> arrayList, int parts) {
        if (arrayList == null) {
            arrayList = new ArrayList();
        } else {
            arrayList.clear();
        }
        switch (parts) {
            case START:
                arrayList.add(R.drawable.ic_bodys);
                arrayList.add(R.drawable.ic_eyes);
                arrayList.add(R.drawable.ic_eyebrows);
                arrayList.add(R.drawable.ic_mouth);
                arrayList.add(R.drawable.ic_hair);
                arrayList.add(R.drawable.ic_hats);
                arrayList.add(R.drawable.ic_hands);
                arrayList.add(R.drawable.ic_shirt);
                arrayList.add(R.drawable.ic_legs);
                arrayList.add(R.drawable.ic_boots);
                arrayList.add(R.drawable.ic_places);
                break;
            case BODIES:
                arrayList.add(R.drawable.body4_fat);
                arrayList.add(R.drawable.body4_skinny);
                arrayList.add(R.drawable.body4_strong);
                arrayList.add(R.drawable.ic_back);
                break;
            case EYES:
                arrayList.add(R.drawable.eye3);
                arrayList.add(R.drawable.eye5);
                arrayList.add(R.drawable.eye7);
                arrayList.add(R.drawable.ic_back);
                break;
            case EYEBROWS:
                arrayList.add(R.drawable.eyebrows13);
                arrayList.add(R.drawable.eyebrows5);
                arrayList.add(R.drawable.eyebrows1);
                arrayList.add(R.drawable.ic_back);
                break;
            case MOUTHS:
                arrayList.add(R.drawable.mouth3);
                arrayList.add(R.drawable.mouth11);
                arrayList.add(R.drawable.mouth6);
                arrayList.add(R.drawable.ic_back);
                break;
            case HAIRS:
                arrayList.add(R.drawable.ic_short);
                arrayList.add(R.drawable.ic_long);
                arrayList.add(R.drawable.ic_spec);
                arrayList.add(R.drawable.ic_back);
                break;
            case HANDS:
                arrayList.add(R.drawable.hands1_4);
                arrayList.add(R.drawable.hands2_4);
                arrayList.add(R.drawable.hands3_4);
                arrayList.add(R.drawable.ic_back);
                break;
            case LONG:
                arrayList.add(R.drawable.long2);
                arrayList.add(R.drawable.long7);
                arrayList.add(R.drawable.long9);
                arrayList.add(R.drawable.ic_back);
                break;
            case SHORT:
                arrayList.add(R.drawable.short11);
                arrayList.add(R.drawable.short13);
                arrayList.add(R.drawable.short6);
                arrayList.add(R.drawable.ic_back);
                break;
            case SPECIAL:
                arrayList.add(R.drawable.spec34);
                arrayList.add(R.drawable.spec35);
                arrayList.add(R.drawable.spec36);
                arrayList.add(R.drawable.ic_back);
                break;
            case HATS:
                arrayList.add(R.drawable.hat14);
                arrayList.add(R.drawable.hat28);
                arrayList.add(R.drawable.hat4);
                arrayList.add(R.drawable.ic_back);
                break;
            case SHIRTS:
                arrayList.add(R.drawable.shirt16);
                arrayList.add(R.drawable.shirt4);
                arrayList.add(R.drawable.shirt43);
                arrayList.add(R.drawable.ic_back);
                break;
            case LEGS:
                arrayList.add(R.drawable.leg16);
                arrayList.add(R.drawable.leg17);
                arrayList.add(R.drawable.leg9);
                arrayList.add(R.drawable.ic_back);
                break;
            case BOOTS:
                arrayList.add(R.drawable.boots1);
                arrayList.add(R.drawable.boots2);
                arrayList.add(R.drawable.boots3);
                arrayList.add(R.drawable.ic_back);
                break;
            case PLACES:
                arrayList.add(R.drawable.place2);
                arrayList.add(R.drawable.place6);
                arrayList.add(R.drawable.place8);
                arrayList.add(R.drawable.ic_back);
                break;
        }
        imageAdapter = new ImageAdapter(this.getApplicationContext(), arrayList);
        gvStatus = parts;
        return imageAdapter;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================


}
//Toast.makeText(this,"Not implemented yet",Toast.LENGTH_SHORT).show();
//Log.e("","");