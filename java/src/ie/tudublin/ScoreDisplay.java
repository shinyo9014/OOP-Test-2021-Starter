package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	void loadScore() {
        for (int index = 0; index < score.length(); index++) {
            if (index == score.length() - 1) {
                notes.add(new Note(score.charAt(index), 1));
                continue;
            } else {
                if (Character.isDigit(score.charAt(index + 1))) {
                    notes.add(new Note(score.charAt(index), score.charAt(index + 1) - '0'));
                    index++;
                    continue;
                } else {
                    notes.add(new Note(score.charAt(index), 1));
                    continue;
                }
            }
        }
	}
	
	void printScores() {
        for (Note note : notes) {
            String type = "Quaver";
            if (note.getDuration() == 1) {
                type = "Crotchet";
            }
            System.out.println(note.getNote() + "\t" + note.getDuration() + "\t" + type);

        }
	}
	
	public void setup() 
	{
		loadScore();
        printScores();
	}

	public void draw()
	{
		background(255);
		strokeWeight(2);
        line(100, 200, 900, 200);
        line(100, 220, 900, 220);
        line(100, 240, 900, 240);
        line(100, 260, 900, 260);
        line(100, 280, 900, 280);
        int position = (mouseX - 100) / 40;
        drawNotes(position);
        textSize(25);
        fill(0);
	}


	
public void mouseMoved() {
	super.mouseMoved();
}

void drawNotes(int position) {
	int index = 0;
	textSize(32);

	for (Note note : notes) {
		fill(0, 0, 0);
		stroke(0, 0, 0);
		if (index == position) {
			fill(255, 0, 0);
			stroke(255, 0, 0);
		}
		text(note.getNote(), 100 + 40 * index, 150);
		int y = 240 - getScaleHeight(note.getNote()) * 10;
		drawSymbol(100 + 40 * index, y, note.getDuration() == 1);
		index++;
	}
}


int getScaleHeight(char note) {
	switch (note) {
		case 'A':
			return 4;
		case 'B':
			return 5;
		case 'c':
			return 6;
		case 'd':
			return 7;
		case 'E':
			return 1;
		case 'F':
			return 2;
		case 'G':
			return 3;
		default:
			return 0;
	}
}

void drawSymbol(int x, int y, boolean isQuaver) {
	line(x + 10, y, x + 10, y + 50);
	ellipse(x, y + 40 + 10, 20, 20);
	if (isQuaver) {
		line(x + 10, y, x + 10 + 10, y + 10);
	}
}

}