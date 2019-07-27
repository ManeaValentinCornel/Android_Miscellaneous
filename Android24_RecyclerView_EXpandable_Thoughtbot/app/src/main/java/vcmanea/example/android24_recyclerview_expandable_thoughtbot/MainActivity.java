package vcmanea.example.android24_recyclerview_expandable_thoughtbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//////////////////////GOOGLE
        ArrayList<Company> companies=new ArrayList<>();

        ArrayList<Product> googleProduct = new ArrayList<>();
        googleProduct.add(new Product("Google AdSense"));
        googleProduct.add(new Product("Google Mail"));
        googleProduct.add(new Product("Google Android"));

        Company google=new Company("google",googleProduct);

        companies.add(google);

        //////////////////////GOOGLE

        ArrayList<Product> microsoftProduct=new ArrayList<>();
        microsoftProduct.add(new Product("Windows"));
        microsoftProduct.add(new Product("SkyDrive"));
        microsoftProduct.add(new Product("Miscrosoft Store"));
        microsoftProduct.add(new Product("Miscrosoft Office"));

        Company microsoft=new Company("Microsoft",microsoftProduct);

        companies.add(microsoft);

        ProductAdapter productAdapter=new ProductAdapter(companies);
        recyclerView.setAdapter(productAdapter);


    }
}
