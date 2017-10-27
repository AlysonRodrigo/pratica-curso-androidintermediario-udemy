package br.com.cookiesoft.carros.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.cookiesoft.carros.R;
import br.com.cookiesoft.carros.adapter.CarListAdapter;
import br.com.cookiesoft.carros.constants.CarrosConstants;
import br.com.cookiesoft.carros.data.CarMock;
import br.com.cookiesoft.carros.entities.Car;
import br.com.cookiesoft.carros.listener.OnListClickInterationListener;

public class MainActivity extends AppCompatActivity {

    public ViewHolder viewHolder = new ViewHolder();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.context = this;

        CarMock carMock = new CarMock(this);
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        // 1 - Obter o recyclerView
        this.viewHolder.recyclerView = (RecyclerView) findViewById(R.id.recyclerview_cars);


        OnListClickInterationListener listener = new OnListClickInterationListener() {
            @Override
            public void OnClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstants.CARRO_ID,id);

                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        // Definir adapter
        CarListAdapter carListAdapter = new CarListAdapter(carList, listener);
        this.viewHolder.recyclerView.setAdapter(carListAdapter);

        // Definir layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.viewHolder.recyclerView.setLayoutManager(linearLayoutManager);

    }

    public static class ViewHolder{
        RecyclerView recyclerView;
    }
}
