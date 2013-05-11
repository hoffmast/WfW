package edu.gvsu.cis.waterfortheworld;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ownfilter);

        Button btt = (Button) findViewById(R.id.button1);
        btt.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent editor = new Intent(MainActivity.this, PlasticBottleActivity.class);
                startActivityForResult(editor, 7);
            }
        });
    }
    
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }
    
}
