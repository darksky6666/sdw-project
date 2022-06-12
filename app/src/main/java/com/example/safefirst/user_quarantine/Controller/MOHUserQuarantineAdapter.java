package com.example.safefirst.user_quarantine.Controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safefirst.R;

import java.util.ArrayList;

public class MOHUserQuarantineAdapter extends RecyclerView.Adapter<MOHUserQuarantineAdapter.viewHolder> {

    private Context context;
    Activity activity;
    private ArrayList<String> UserQ_ID, UserQ_Type, UserQ_Location, UserQ_startDate, UserQ_endDate, User_phoneNum;

    Animation translate_anim;

    public MOHUserQuarantineAdapter(Activity activity,
                              Context context,
                              ArrayList UserQ_ID,
                              ArrayList UserQ_Type,
                              ArrayList UserQ_Location,
                              ArrayList UserQ_startDate,
                              ArrayList UserQ_endDate,
                              ArrayList User_phoneNum) {
        this.activity = activity;
        this.context = context;
        this.UserQ_ID = UserQ_ID;
        this.UserQ_Type = UserQ_Type;
        this.UserQ_Location = UserQ_Location;
        this.UserQ_startDate = UserQ_startDate;
        this.UserQ_endDate = UserQ_endDate;
        this.User_phoneNum = User_phoneNum;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_quarantine_row, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.viewUQ_ID.setText(String.valueOf(UserQ_ID.get(position)));
        holder.viewUQType2.setText(String.valueOf(UserQ_Type.get(position)));
        holder.viewUQLocation2.setText(String.valueOf(UserQ_Location.get(position)));
        holder.viewUQstartDate2.setText(String.valueOf(UserQ_startDate.get(position)));
        holder.viewUQendDate2.setText(String.valueOf(UserQ_endDate.get(position)));
        holder.viewUser2.setText(String.valueOf(User_phoneNum.get(position)));
        holder.updateUQLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MOHUpdateUserQuarantine.class);
                intent.putExtra("id", String.valueOf(UserQ_ID.get(position)));
                intent.putExtra("type", String.valueOf(UserQ_Type.get(position)));
                intent.putExtra("location", String.valueOf(UserQ_Location.get(position)));
                intent.putExtra("startDate", String.valueOf(UserQ_startDate.get(position)));
                intent.putExtra("endDate", String.valueOf(UserQ_endDate.get(position)));
                intent.putExtra("user", String.valueOf(User_phoneNum.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return UserQ_ID.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView viewUQ_ID, viewUQType2, viewUQLocation2, viewUQstartDate2, viewUQendDate2, viewUser2;
        LinearLayout updateUQLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            viewUQ_ID = itemView.findViewById(R.id.viewUQ_ID);
            viewUQType2 = itemView.findViewById(R.id.viewUQType2);
            viewUQLocation2 = itemView.findViewById(R.id.viewUQLocation2);
            viewUQstartDate2 = itemView.findViewById(R.id.viewUQstartDate2);
            viewUQendDate2 = itemView.findViewById(R.id.viewUQendDate2);
            viewUser2 = itemView.findViewById(R.id.viewUser2);
            updateUQLayout = itemView.findViewById(R.id.updateUQLayout);
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            updateUQLayout.setAnimation(translate_anim);
        }
    }
}
