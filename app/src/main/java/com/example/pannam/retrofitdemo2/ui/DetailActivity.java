package com.example.pannam.retrofitdemo2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pannam.retrofitdemo2.R;
import com.example.pannam.retrofitdemo2.helper.Constants;
import com.example.pannam.retrofitdemo2.model.Flower;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by pannam on 2/20/2016.
 */
public class DetailActivity extends AppCompatActivity {
    private TextView mName, mId, mCategory, mPrice,mInstruction;
    private ImageView mPhoto;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Flower flower = (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);
        configViews();
        mId.setText("" + flower.getProductId());
        mName.setText(flower.getName());
        mCategory.setText(flower.getCategory());
        mInstruction.setText(flower.getInstruction());
        Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/" + flower.getPhoto()).into(mPhoto);





    }

    private void configViews() {

        mPhoto = (ImageView)findViewById(R.id.flowerPhoto);
        mName =(TextView)findViewById(R.id.flowerName);
        mId = (TextView)findViewById(R.id.flowerId);
        mCategory= (TextView)findViewById(R.id.flowerCategory);
        mInstruction= (TextView)findViewById(R.id.flowerInstruction);
        mPrice = (TextView)findViewById(R.id.flowerPrice);








    }
}
