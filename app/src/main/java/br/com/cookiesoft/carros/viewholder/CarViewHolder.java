package br.com.cookiesoft.carros.viewholder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.cookiesoft.carros.R;
import br.com.cookiesoft.carros.entities.Car;
import br.com.cookiesoft.carros.listener.OnListClickInterationListener;

/**
 * Created by Cookiesoft on 16/10/2017.
 */

public class CarViewHolder extends ViewHolder {

    private ImageView mImageViewPicture;
    private TextView mTextCarModel;
    private TextView textview_details;

    public CarViewHolder(View itemView) {
        super(itemView);

        mImageViewPicture = (ImageView) itemView.findViewById(R.id.img_car_pic);
        this.mTextCarModel = (TextView) itemView.findViewById(R.id.text_car_model);
        this.textview_details = (TextView) itemView.findViewById(R.id.textview_details);
    }

    public void bindData(final Car car, final OnListClickInterationListener listener){

        this.mImageViewPicture.setImageDrawable(car.getPicture());
        this.mTextCarModel.setText(car.getModel());
        this.textview_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(car.getId());
            }
        });

    }
}
