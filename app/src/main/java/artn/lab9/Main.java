package artn.lab9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    EditText et1, et2, et3;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(getString(R.string.string_el1), et1.getText().toString());
        editor.putString(getString(R.string.string_el2), et2.getText().toString());
        editor.putInt(getString(R.string.int_el), Integer.parseInt(et3.getText().toString()));
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String strElKey = getString(R.string.string_el1);
        String strEl = preferences.getString(strElKey, "");
        et1.setText(strEl);
        strElKey = getString(R.string.string_el2);
        strEl = preferences.getString(strElKey, "");
        et2.setText(strEl);
        String intElKey = getString(R.string.int_el);
        Integer intEl = preferences.getInt(intElKey, -1);
        //Log.d("OnResume ebatt", intEl.toString());
        et3.setText(intEl.toString());
    }


}
