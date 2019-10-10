package hfda.com.gitprofileviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class profiledetail extends AppCompatActivity {

    String userName,url,stars;
    private TextView tv_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //get the intent
        Intent intent=getIntent();
        tv_data=(TextView) findViewById(R.id.data);
        // get the object and typecast it
        users user=(users)intent.getSerializableExtra("profile");
        renderStuff(user);
    }

    private void renderStuff(users user) {
        tv_data.setText(user.getLogin()+"\n\n"+user.getAvatarUrl()+"\n\n"+user.getScore());
    }
}
