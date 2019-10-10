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
    private onIemClickListener mOnItemClickListener;

    // this ViewHolder internal class define each view in the itemView and populate the values in it when it is called by the recyclerView
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView url,userName,score;
        onIemClickListener mOnItemClickListener;
        private ImageView avatarUrl;
        public ViewHolder(@NonNull View itemView,onIemClickListener listener) {
            super(itemView);
            url=(TextView) itemView.findViewById(R.id.tvUrl);
            userName=(TextView) itemView.findViewById(R.id.tvUserName);
            score=(TextView) itemView.findViewById(R.id.tvScore);
            avatarUrl=(ImageView) itemView.findViewById(R.id.profileImage);
            this.mOnItemClickListener=listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnItemClickListener.onItemClicked(getAdapterPosition());
        }
    }

    // declaring the constructor
    public customAdapter(ArrayList<users> users,Context context,onIemClickListener listener){
        this.gitUsers=users;
        this.context=context;
        this.mOnItemClickListener=listener;
    }

    //this would inflate the viewHolder and return it
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.each_user,parent,false);
        return new ViewHolder(v,mOnItemClickListener);
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

    // now this is the onItemClick Listener, this clickListenet need to be implemented by mainActivity which would click the item
    public interface onIemClickListener{
        void onItemClicked(int position);
    }
}
