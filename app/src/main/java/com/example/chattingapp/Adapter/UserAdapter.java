package com.example.chattingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chattingapp.MessageActivity;
import com.example.chattingapp.Model.User;
import com.example.chattingapp.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private List<User> mUser;
    private boolean ischat;

    public UserAdapter(Context mContext, List<User> mUser,boolean ischat) {
        this.mContext = mContext;
        this.mUser = mUser;
        this.ischat = ischat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final User user = mUser.get(i);
        viewHolder.username.setText(user.getUsername());
            if(user.getImageURL().equals("default")){
                viewHolder.profile_image.setImageResource(R.mipmap.ic_launcher);
            } else {
                Glide.with(mContext).load(user.getImageURL()).into(viewHolder.profile_image);
            }

            if(ischat){
                if(user.getStatus().equals("online")){
                    viewHolder.img_on.setVisibility(View.VISIBLE);
                    viewHolder.img_off.setVisibility(View.GONE);
                } else {
                    viewHolder.img_on.setVisibility(View.GONE);
                    viewHolder.img_off.setVisibility(View.VISIBLE);
                }
            } else {
                viewHolder.img_on.setVisibility(View.GONE);
                viewHolder.img_off.setVisibility(View.GONE);
            }

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MessageActivity.class);
                    intent.putExtra("userid",user.getId());
                    mContext.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public ImageView profile_image;
        private ImageView img_on;
        private ImageView img_off;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            profile_image = itemView.findViewById(R.id.profile_image);
            img_on = itemView.findViewById(R.id.img_on);
            img_off = itemView.findViewById(R.id.img_off);


        }
    }
}
