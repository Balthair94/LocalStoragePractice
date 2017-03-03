package baltamon.mx.localstoragepractice;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import baltamon.mx.localstoragepractice.activities.LoginRegisterActivity;
import baltamon.mx.localstoragepractice.persistence.UserSession;

public class MainActivity extends AppCompatActivity {

    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        userSession = new UserSession(this);

        TextView textView =  (TextView) findViewById(R.id.tvUserName);
        textView.setText(userSession.getUserName());

        onLogoutClick();
    }

    public void setUpToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("My friends");
        }
    }

    public void onLogoutClick(){
        Button button = (Button) findViewById(R.id.btnLogout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSession.logout();
                startActivity(new Intent(MainActivity.this, LoginRegisterActivity.class));
                finish();
            }
        });
    }

}
