package com.example.habitpulse;

// PUBLIC_INTERFACE
public class Habit {
    /** Represents a habit item with its properties. */
    private String name;
    private boolean isCompletedToday;
    private int currentStreak;
    private int recordStreak;

    public Habit(String name) {
        this.name = name;
        this.isCompletedToday = false;
        this.currentStreak = 0;
        this.recordStreak = 0;
    }

    // PUBLIC_INTERFACE
    public String getName() {
        return name;
    }

    // PUBLIC_INTERFACE
    public boolean isCompletedToday() {
        return isCompletedToday;
    }

    // PUBLIC_INTERFACE
    public void setCompletedToday(boolean completed) {
        this.isCompletedToday = completed;
    }

    // PUBLIC_INTERFACE
    public int getCurrentStreak() {
        return currentStreak;
    }

    // PUBLIC_INTERFACE
    public void setCurrentStreak(int streak) {
        this.currentStreak = streak;
    }

    // PUBLIC_INTERFACE
    public int getRecordStreak() {
        return recordStreak;
    }

    // PUBLIC_INTERFACE
    public void setRecordStreak(int recordStreak) {
        this.recordStreak = recordStreak;
    }
}
