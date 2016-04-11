package cn.psvmc.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import cn.psvmc.okhttpdemo.utils.OkHttpUtils;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView showText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.getTextButton);
        showText = (TextView)findViewById(R.id.showText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> params = new HashMap<String, String>();
                params.put("userPhone","15225178360");
                params.put("userLoginPswd","123456");
                OkHttpUtils.postAsyn("http://t.yidaisong.com/login!in.do", new OkHttpUtils.ResultCallback<JsonObject>() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(JsonObject response) {
                        Log.i("RESULT", "" + response.get("msg"));
                        showText.setText(""+response.toString());
                    }
                }, params);

            }
        });
    }

}
