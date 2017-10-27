package br.com.cookiesoft.carros.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.cookiesoft.carros.R;
import br.com.cookiesoft.carros.constants.CarrosConstants;
import br.com.cookiesoft.carros.data.CarMock;
import br.com.cookiesoft.carros.entities.Car;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private CarMock carMock;
    private Car mCar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.carMock = new CarMock(this);

        this.mViewHolder.textModel = (TextView) this.findViewById(R.id.text_model);
        this.mViewHolder.imageViewCar = (ImageView) this.findViewById(R.id.img_car_photo);
        this.mViewHolder.textFabricante = (TextView) this.findViewById(R.id.textFabricante);
        this.mViewHolder.textCavalos = (TextView) this.findViewById(R.id.text_cavalos);
        this.mViewHolder.textPrice = (TextView) this.findViewById(R.id.text_price);

        this.getDataFromActivity();

        this.setData();

    }

    private void setData(){

        this.mViewHolder.imageViewCar.setImageDrawable(this.mCar.getPicture());
        this.mViewHolder.textModel.setText(this.mCar.getModel());
        this.mViewHolder.textFabricante.setText(this.mCar.getFabricante());
        this.mViewHolder.textCavalos.setText(String.valueOf(this.mCar.getCavalos()));
        this.mViewHolder.textPrice.setText(String.valueOf("R$ "+this.mCar.getPrice()));
    }

    private void getDataFromActivity(){

        Bundle extras = getIntent().getExtras();

        if(extras != null){
           this.mCar = this.carMock.getCar(extras.getInt(CarrosConstants.CARRO_ID));
        }

    }

    private static class ViewHolder{

        ImageView imageViewCar;
        TextView textModel;
        TextView textFabricante;
        TextView textCavalos;
        TextView textPrice;

    }
}
