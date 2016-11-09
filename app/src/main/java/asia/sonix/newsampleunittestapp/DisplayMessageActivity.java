package asia.sonix.newsampleunittestapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            TextView textView = (TextView) findViewById(R.id.text_message);
            textView.setText(message);
        }
    }

    public void clickOK(View view) {
        Intent result = new Intent();
        result.putExtra(MainActivity.EXTRA_RESULT, "OK!");
        setResult(Activity.RESULT_OK, result);
        finish();
    }

    public void clickCansel(View view) {
        setResult(Activity.RESULT_CANCELED, new Intent());
        finish();
    }
}
