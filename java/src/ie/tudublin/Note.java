package ie.tudublin;

/**
 * @author Xinyu
 * @className Note
 * @descriptioz TODO
 * @date 2021/4/21 
 */
public class Note {
    private char note;
    private int duration;

    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
    }

    public char getNote() {
        return note;
    }

    public void setNote(char note) {
        this.note = note;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }    
}
