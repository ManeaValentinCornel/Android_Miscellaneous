package vcmanea.example.android27_tablelayout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    TableLayout mTableLayout;
    ArrayList<ModelClass> mModelClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ADD VALUES
        mModelClasses = new ArrayList<>();
        mModelClasses.add(new ModelClass("1", "Random TItle", "L DS ads adLDS a dsad sa"));
        mModelClasses.add(new ModelClass("2", "Random TItle", "LDSadsad LDSadsads adsafsaf saLD Sads adsa f safsa LDSad ad sad safs f s aLDS a d a dsa d fs a"));

        mModelClasses.add(new ModelClass("3", "Another title","L DSadsa dsadLDS adsad sadsafsa fsaLDS adsad sadsafs afs aLDSa dsadsadsafsaf saLDS adsad sads afsaf saLDSad sad sads afsafsaL DS ads ads ad sa fsafsas afsafs a"));


        initViews();
    }


    private void initViews() {
        mTableLayout = findViewById(R.id.table_layout);
        mTableLayout.setStretchAllColumns(true);
        mTableLayout.setShrinkAllColumns(true);

        // Inflate your row "template" and fill out the fields.

        TableRow row = (TableRow) LayoutInflater.from(MainActivity.this).inflate(R.layout.attrib_row, null);
        ((TextView) row.findViewById(R.id.attrib_name)).setText("Sr.No");
        ((TextView) row.findViewById(R.id.attrib_value_title)).setVisibility(View.GONE);
        ((TextView) row.findViewById(R.id.attrib_value)).setTypeface(Typeface.DEFAULT_BOLD);
        ((TextView) row.findViewById(R.id.attrib_value)).setText("Something comes here");
        ((TextView) row.findViewById(R.id.attrib_value)).setGravity(Gravity.CENTER_HORIZONTAL);
        mTableLayout.addView(row);

        for (ModelClass modelClass : mModelClasses) {
            row = (TableRow) LayoutInflater.from(MainActivity.this).inflate(R.layout.attrib_row, null);
            ((TextView) row.findViewById(R.id.attrib_name)).setText(modelClass.getColumnA());
            ((TextView) row.findViewById(R.id.attrib_value_title)).setText(modelClass.getColumnB());
            ((TextView) row.findViewById(R.id.attrib_value)).setText(modelClass.getColumnC());
            mTableLayout.addView(row);
        }


    }


}