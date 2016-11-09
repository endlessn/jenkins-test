package asia.sonix.newsampleunittestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    public final static String EXTRA_RESULT = "RESULT";
    private final static int REQUEST_CD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CD:
                TextView textResult = (TextView) findViewById(R.id.text_result);
                if (resultCode == RESULT_OK) {
                    String result = data.getStringExtra(EXTRA_RESULT);
                    if (result != null) {
                        textResult.setText(result);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void sendMessage(View view) {
        ((TextView) findViewById(R.id.text_result)).setText("");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, REQUEST_CD);
    }

}
