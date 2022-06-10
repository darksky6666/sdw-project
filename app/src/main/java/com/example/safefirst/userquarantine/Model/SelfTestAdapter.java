package com.example.safefirst.userquarantine.Model;

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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safefirst.R;
import com.example.safefirst.userquarantine.Controller.MOHUpdateSelfTestResult;

import java.util.ArrayList;

public class SelfTestAdapter extends RecyclerView.Adapter<SelfTestAdapter.viewHolder> {

    private Context context;
    Activity activity;
    private ArrayList<String> Test_ID, Test_Place, Test_Type, Test_Date, Test_Result, User_phoneNum;

    Animation translate_anim;

    public SelfTestAdapter(Activity activity,
                           Context context,
                           ArrayList Test_ID,
                           ArrayList Test_Place,
                           ArrayList Test_Type,
                           ArrayList Test_Date,
                           ArrayList Test_Result,
                           ArrayList User_phoneNum) {
        this.activity = activity;
        this.context = context;
        this.Test_ID = Test_ID;
        this.Test_Place = Test_Place;
        this.Test_Type = Test_Type;
        this.Test_Date = Test_Date;
        this.Test_Result = Test_Result;
        this.User_phoneNum = User_phoneNum;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.self_test_row, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.viewTest_ID.setText(String.valueOf(Test_ID.get(position)));
        holder.viewTest_Place.setText(String.valueOf(Test_Place.get(position)));
        holder.viewTest_Type.setText(String.valueOf(Test_Type.get(position)));
        holder.viewTest_Date.setText(String.valueOf(Test_Date.get(position)));
        holder.viewTest_Result.setText(String.valueOf(Test_Result.get(position)));
        holder.viewUser_phoneNum.setText(String.valueOf(User_phoneNum.get(position)));
        holder.updateSelfTestLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MOHUpdateSelfTestResult.class);
                intent.putExtra("id", String.valueOf(Test_ID.get(position)));
                intent.putExtra("place", String.valueOf(Test_Place.get(position)));
                intent.putExtra("type", String.valueOf(Test_Type.get(position)));
                intent.putExtra("date", String.valueOf(Test_Date.get(position)));
                intent.putExtra("result", String.valueOf(Test_Result.get(position)));
                intent.putExtra("user", String.valueOf(User_phoneNum.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Test_ID.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView viewTest_ID, viewTest_Place, viewTest_Type, viewTest_Date, viewTest_Result, viewUser_phoneNum;
        LinearLayout updateSelfTestLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            viewTest_ID = itemView.findViewById(R.id.viewTest_ID);
            viewTest_Place = itemView.findViewById(R.id.viewTestPlace);
            viewTest_Type = itemView.findViewById(R.id.viewTestType);
            viewTest_Date = itemView.findViewById(R.id.viewTestDate);
            viewTest_Result = itemView.findViewById(R.id.viewTestResult);
            viewUser_phoneNum = itemView.findViewById(R.id.viewUser);
            updateSelfTestLayout = itemView.findViewById(R.id.updateSelfTestLayout);
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            updateSelfTestLayout.setAnimation(translate_anim);
        }
    }
}
