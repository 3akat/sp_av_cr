package com.bedulin.android.app.sp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: alexandr.bedulin
 * Date: 11/19/12
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SendTo extends Activity implements View.OnClickListener {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private TextView tvFB, tvTW, tvVK, tvMem, tvEM;

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
        setContentView(R.layout.send);
        tvFB = (TextView) findViewById(R.id.tvFB);
        tvFB.setOnClickListener(this);
        tvTW = (TextView) findViewById(R.id.tvTW);
        tvTW.setOnClickListener(this);
        tvVK = (TextView) findViewById(R.id.tvVK);
        tvVK.setOnClickListener(this);
        tvMem = (TextView) findViewById(R.id.tvMem);
        tvMem.setOnClickListener(this);
        tvEM = (TextView) findViewById(R.id.tvEM);
        tvEM.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvFB:
            case R.id.tvTW:
            case R.id.tvVK:
            case R.id.tvMem:
            case R.id.tvEM:
                Toast.makeText(this, "Not implemented yet", Toast.LENGTH_SHORT).show();
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
