package vcmanea.example.android18_moreabouttoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=findViewById(R.id.toolbar);
        mToolbar.setTitle("ToolBar first");
        setSupportActionBar(mToolbar);

        mToolbar.setSubtitle("Toolbar app");
    }
}
