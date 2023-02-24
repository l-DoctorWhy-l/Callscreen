package com.example.callscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import com.example.callscreen.databinding.ActivityMainBinding;

import jp.wasabeef.blurry.Blurry;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private boolean cameraToggle = false;
    private boolean standard_widget_position = true;
    private boolean micToggle = false;
    String user_name = "RODIPIT", interlocutor_name = "adfaafsafafaefadwdfsawfqafsdfAADFAFAFAFWFWAEFAW AFDAS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.userName.setText(StringCutter.cutter(user_name,28));
        binding.interlocutorName.setText(StringCutter.cutter(interlocutor_name,28));

        Blurry.with(this).capture(binding.userLogo).into(binding.userLogo);

        binding.closeButton.setOnClickListener(view -> finish());

        binding.messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                startActivity(intent);
            }
        });

        binding.cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(cameraToggle){
                cameraToggle = false;
                binding.cameraButton.setBackgroundResource(R.drawable.white_circle_bg);
                binding.cameraButton.setImageResource(R.drawable.baseline_videocam_off);
            }else{
                cameraToggle = true;
                binding.cameraButton.setBackgroundResource(R.drawable.grey_circle_bg);
                binding.cameraButton.setImageResource(R.drawable.baseline_videocam);

            }

            }
        });

        binding.microButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(micToggle){
                    micToggle = false;
                    binding.microButton.setBackgroundResource(R.drawable.white_circle_bg);
                    binding.microButton.setImageResource(R.drawable.baseline_mic_off);
                    binding.userName.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.baseline_mic_mini_off),null);
                }else{
                    micToggle = true;
                    binding.microButton.setBackgroundResource(R.drawable.grey_circle_bg);
                    binding.microButton.setImageResource(R.drawable.baseline_mic);
                    binding.userName.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.baseline_mic),null);


                }

            }
        });

        binding.rectanglesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(standard_widget_position){
                    standard_widget_position = false;
                    ConstraintSet buf = new ConstraintSet();
                    buf.clone((ConstraintLayout) binding.root);
                    buf.clear(R.id.user_widget,ConstraintSet.BOTTOM);
                    buf.clear(R.id.user_widget,ConstraintSet.TOP);
                    buf.clear(R.id.user_widget,ConstraintSet.BOTTOM);
                    buf.clear(R.id.interlocutor_widget,ConstraintSet.BOTTOM);
                    buf.clear(R.id.interlocutor_widget,ConstraintSet.TOP);
                    buf.connect(R.id.user_widget,ConstraintSet.TOP,R.id.interlocutor_widget,ConstraintSet.BOTTOM, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15,  getResources().getDisplayMetrics()));
                    buf.connect(R.id.interlocutor_widget,ConstraintSet.BOTTOM,R.id.user_widget,ConstraintSet.TOP);
                    buf.connect(R.id.interlocutor_widget,ConstraintSet.TOP,R.id.top_buttons,ConstraintSet.BOTTOM,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15,  getResources().getDisplayMetrics()));
                    buf.applyTo(binding.root);
                }else{
                    standard_widget_position = true;
                    ConstraintSet buf = new ConstraintSet();
                    buf.clone((ConstraintLayout) binding.root);
                    buf.clear(R.id.user_widget,ConstraintSet.BOTTOM);
                    buf.clear(R.id.user_widget,ConstraintSet.TOP);
                    buf.clear(R.id.user_widget,ConstraintSet.BOTTOM);
                    buf.clear(R.id.interlocutor_widget,ConstraintSet.BOTTOM);
                    buf.clear(R.id.interlocutor_widget,ConstraintSet.TOP);
                    buf.connect(R.id.interlocutor_widget,ConstraintSet.TOP,R.id.user_widget,ConstraintSet.BOTTOM,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15,  getResources().getDisplayMetrics()));
                    buf.connect(R.id.user_widget,ConstraintSet.BOTTOM,R.id.interlocutor_widget,ConstraintSet.TOP);
                    buf.connect(R.id.user_widget,ConstraintSet.TOP,R.id.top_buttons,ConstraintSet.BOTTOM,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15,  getResources().getDisplayMetrics()));
                    buf.applyTo(binding.root);
                }
            }
        });

        binding.hiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertHiDialog();
            }
        });

        binding.interlocutorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ContactsActivity.class);
                startActivity(intent);
            }
        });

    }

    public void showAlertHiDialog(){
        AlertDialog.Builder hiAlertDialog = new AlertDialog.Builder(MainActivity.this);

        hiAlertDialog.setMessage(R.string.hi);

        hiAlertDialog.setPositiveButton(R.string.hi, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        hiAlertDialog.show();

    }


}