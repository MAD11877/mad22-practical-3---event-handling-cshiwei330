package sg.edu.np.mad.exercise2;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    User user1 = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "on Create!");
        setContentView(R.layout.activity_main);

        user1.setFollowed(true);
        user1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis " +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        user1.setUsername("MAD");
        TextView desc = findViewById(R.id.desc);
        TextView name = findViewById(R.id.name);
        Button follow_but = findViewById(R.id.follow);
        desc.setText(user1.getDescription());

        Long ran = getIntent().getLongExtra("random", 0);
        name.setText(user1.getUsername() + " " + String.valueOf(ran));

        follow_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Button Pressed");
                if (user1.getFollowed()) {
                    user1.setFollowed(false);
                    follow_but.setText("unfollow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                } else {
                    user1.setFollowed(true);
                    follow_but.setText("follow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();

                }
            }
        });
        Intent myIntent = new Intent(MainActivity.this, ListActivity.class);

    }


}
