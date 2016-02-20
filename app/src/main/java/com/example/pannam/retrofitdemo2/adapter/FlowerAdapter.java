package com.example.pannam.retrofitdemo2.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pannam.retrofitdemo2.R;
import com.example.pannam.retrofitdemo2.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pannam on 2/17/2016.
 */

//This is for recyclerView
public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {
    private final FlowerClickListener mListener;
    private static final String TAG = FlowerAdapter.class.getSimpleName();
    private List<Flower> mFlowers;


    public FlowerAdapter(FlowerClickListener listener) {
        mFlowers = new ArrayList<>();
        mListener = listener;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        //loading the recycler view
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);


        //create new holder object
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Flower currFlower = mFlowers.get(position);

        holder.mName.setText(currFlower.getName());
        holder.mPrice.setText("£ " + Double.toString(currFlower.getPrice()));

        Picasso.with(holder.itemView.getContext())
                .load("http://services.hanselandpetal.com/photos/" + currFlower.getPhoto()).into(holder.mPhoto);


    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public void addFlower(Flower flower) {
        Log.d(TAG, flower.getPhoto());
        mFlowers.add(flower);
        notifyDataSetChanged();


    }

    /**
     * @param position
     * @return
     */
    public Flower getSelectedFlower(int position) {

        return mFlowers.get(position);


    }

    //viewholder shows the place in recycle view for the item
    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mPhoto;
        private TextView mName, mPrice;


        public Holder(View itemView) {
            super(itemView);
            mPhoto = (ImageView) itemView.findViewById(R.id.flowerPhoto);
            mName = (TextView) itemView.findViewById(R.id.flowerName);
            mPrice = (TextView) itemView.findViewById(R.id.flowerPrice);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            mListener.onClick(getLayoutPosition());
        }
    }

    public interface FlowerClickListener {

        void onClick(int position);
    }
}
