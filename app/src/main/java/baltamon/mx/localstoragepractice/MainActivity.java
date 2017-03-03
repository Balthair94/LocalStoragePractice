package baltamon.mx.localstoragepractice;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import baltamon.mx.localstoragepractice.activities.LoginRegisterActivity;
import baltamon.mx.localstoragepractice.database.FriendsSQLiteHelper;
import baltamon.mx.localstoragepractice.persistence.UserSession;

public class MainActivity extends AppCompatActivity {

    private UserSession userSession;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpDataBase();

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

    private void setUpDataBase(){
        FriendsSQLiteHelper helper = new FriendsSQLiteHelper(this, "db_my_database", null, 1);
        database = helper.getWritableDatabase();

        if (database != null)
            Toast.makeText(this, "DataBase OPEN", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "DataBase NULL", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
    }
}
