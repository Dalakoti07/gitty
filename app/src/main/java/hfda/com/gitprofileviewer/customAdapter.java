package hfda.com.gitprofileviewer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder>{
    private ArrayList<users> gitUsers=new ArrayList<>();
    private Context context;

    // this ViewHolder internal class define each view in the itemView and populate the values in it when it is called by the recyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView url,userName,score;
        private ImageView avatarUrl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            url=(TextView) itemView.findViewById(R.id.tvUrl);
            userName=(TextView) itemView.findViewById(R.id.tvUserName);
            score=(TextView) itemView.findViewById(R.id.tvScore);
            avatarUrl=(ImageView) itemView.findViewById(R.id.profileImage);
        }
    }

    // declaring the constructor
    public customAdapter(ArrayList<users> users,Context context){
        this.gitUsers=users;
        this.context=context;
    }

    // this would create a viewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.each_user,parent,false);
        return new ViewHolder(v);
    }

    // this set value of each item in recyclerView
    @Override
    public void onBindViewHolder(@NonNull customAdapter.ViewHolder myViewHolder, int i) {
        users user=gitUsers.get(i);
        Picasso.with(context).load(user.getAvatarUrl()).into(myViewHolder.avatarUrl);
        myViewHolder.score.setText(user.getScore());
        myViewHolder.url.setText(user.getHtml_url());
        myViewHolder.userName.setText(user.getLogin());
        Log.d("mmm",user.getLogin());
    }

    // return the item count
    @Override
    public int getItemCount() {
        return gitUsers.size();
    }
}
