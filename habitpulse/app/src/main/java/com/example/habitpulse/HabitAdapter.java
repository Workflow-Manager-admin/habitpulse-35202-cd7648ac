package com.example.habitpulse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// PUBLIC_INTERFACE
public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {
    /** Adapter for displaying Habits in a RecyclerView. */

    private List<Habit> habitList;
    private OnHabitCheckedChangeListener listener;

    // PUBLIC_INTERFACE
    public interface OnHabitCheckedChangeListener {
        void onHabitCheckedChanged(Habit habit, boolean isChecked);
    }

    // PUBLIC_INTERFACE
    public HabitAdapter(List<Habit> habitList, OnHabitCheckedChangeListener listener) {
        this.habitList = habitList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_habit, parent, false);
        return new HabitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        Habit habit = habitList.get(position);
        holder.textHabitName.setText(habit.getName());
        holder.checkboxCompleted.setChecked(habit.isCompletedToday());
        holder.textStreak.setText("🔥 " + habit.getCurrentStreak());
        holder.checkboxCompleted.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (habit.isCompletedToday() != isChecked) {
                habit.setCompletedToday(isChecked);
                if (listener != null) {
                    listener.onHabitCheckedChanged(habit, isChecked);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    // PUBLIC_INTERFACE
    public void setHabits(List<Habit> newHabits) {
        this.habitList = newHabits;
        notifyDataSetChanged();
    }

    static class HabitViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkboxCompleted;
        TextView textHabitName, textStreak;

        HabitViewHolder(View itemView) {
            super(itemView);
            checkboxCompleted = itemView.findViewById(R.id.checkboxCompleted);
            textHabitName = itemView.findViewById(R.id.textHabitName);
            textStreak = itemView.findViewById(R.id.textStreak);
        }
    }
}
