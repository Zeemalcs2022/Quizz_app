package com.example.quiz_app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_app.R;
import com.example.quiz_app.models.Quiz;
import com.example.quiz_app.utils.colorPicker;
import com.example.quiz_app.utils.iconPicker;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder>{
    Context context;
    List<Quiz> quizzes;

    public QuizAdapter(Context context, List<Quiz> quizzes){
        this.context = context;
        this.quizzes = quizzes;
    }


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent,false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  QuizAdapter.QuizViewHolder holder, int position) {
        holder.textViewTitle.setText(quizzes.get(position).getTitle());
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(colorPicker.getInstance().getcolor()));
        holder.iconView.setImageResource(iconPicker.getInstance().getIcon());
        holder.itemview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,quizzes.get(position).getTitle() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return quizzes.size() ;
    }

    class QuizViewHolder extends RecyclerView.ViewHolder {
        View itemview;
        TextView textViewTitle;
        ImageView iconView;
        CardView cardContainer;
        public  QuizViewHolder(View itemview) {
            super(itemview);
            this.itemview = itemview;
            textViewTitle = itemview.findViewById(R.id.quizTitle);
            iconView = itemview.findViewById(R.id.quizIcon);
            cardContainer = itemview.findViewById(R.id.cardContainer);
        }


    }


}
