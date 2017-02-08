package baltamon.mx.localstoragepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        userSession = new UserSession(this);

        TextView textView =  (TextView) findViewById(R.id.tvUserName);
        textView.setText(userSession.getUserName());

        onLogoutClick();
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
