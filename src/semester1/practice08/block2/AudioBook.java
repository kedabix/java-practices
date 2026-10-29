package semester1.practice08.block2;

public class AudioBook extends Publication {
    private int durationMinutes;
    private String narrator;

    public AudioBook(String title, String author, int releaseYear, int durationMinutes, String narrator) {
        super(title, author, releaseYear);
        this.durationMinutes = durationMinutes;
        this.narrator = narrator;
    }

    // Наприклад, 135 хвилин -> "2 год 15 хв"
    public String formatDuration() {
        return (durationMinutes / 60) + " год " + (durationMinutes % 60) + " хв";
    }

    @Override
    public String toString() {
        return "AudioBook{" + super.toString() + ", тривалість: " + formatDuration() + ", читає: " + narrator + "}";
    }
}
