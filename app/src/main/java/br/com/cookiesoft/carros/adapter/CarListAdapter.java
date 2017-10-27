package br.com.cookiesoft.carros.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.cookiesoft.carros.R;
import br.com.cookiesoft.carros.entities.Car;
import br.com.cookiesoft.carros.listener.OnListClickInterationListener;
import br.com.cookiesoft.carros.viewholder.CarViewHolder;

/**
 * Created by Cookiesoft on 16/10/2017.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder>{

    private List<Car> mListCars;
    private OnListClickInterationListener mOnListClickInterationClick;

    public CarListAdapter(List<Car> listCars, OnListClickInterationListener listener){
        this.mListCars = listCars;
        this.mOnListClickInterationClick = listener;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View carView = inflater.inflate(R.layout.row_car_list, parent, false);
        return new CarViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car car = this.mListCars.get(position);

        holder.bindData(car, this.mOnListClickInterationClick);
    }

    @Override
    public int getItemCount() {
        return this.mListCars.size();
    }
}
