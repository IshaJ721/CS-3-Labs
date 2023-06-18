import java.util.*;

public class Melody {
	Queue<Note> notes;

	public Melody(Queue<Note> song) {
		notes = new LinkedList<Note>();
		while(!song.isEmpty())
		{
		notes.offer(song.poll());
		}
	}

	public double getTotalDuration() {
		double duration = 0;
		for(int i = 0; i<notes.size();i++)
		{
			Note note = notes.poll();
			duration += note.getDuration();
			notes.offer(note);
		}
		return duration;
	}

	public String toString() {
		String string = "";
		for (int i = 0; i < notes.size(); i++) {
			Note note = notes.poll();
			string += note + " \n";
			notes.offer(note);
		}
		return string;
	}

	public void changeTempo(double tempo) {
		for (int i = 0; i < notes.size(); i++) {
			Note note = notes.poll();
			note.setDuration(tempo*note.getDuration());
			notes.offer(note);
		}
	}

	public void reverse() {
		Stack<Note> stack = new Stack<Note>();
		while(!notes.isEmpty())
		{
			stack.push(notes.poll());
		}
		for(int i = 0; i<stack.size();i++)
		{
			notes.offer(stack.pop());
		}

	}

	public void append(Melody other) {
		for(int i =0; i<other.notes.size();i++)
		{
			Note note = other.notes.poll();
			this.notes.offer(note);
			other.notes.offer(note);
		}

	}

	public void play() {
		Queue<Note> queue = new LinkedList<Note>();
		boolean repeat = false;
		int x=0;
		for (int i = 0; i < notes.size(); i++) {
			Note note = notes.poll();
			note.play();
			if(note.isRepeat()&&repeat==false)
			{
				repeat = true;
			}
			if(repeat)
				queue.offer(note);
			if(note.isRepeat()&&repeat==true&&x>0)
			{
				repeat = false;
				while(!queue.isEmpty())
				{
					queue.poll().play();
				}
			}	
			if(note.isRepeat()&&repeat)
			{
				x++;
			}
			notes.offer(note);
		}
	}

	public Queue<Note> getNotes() {
		return notes;
	}

}