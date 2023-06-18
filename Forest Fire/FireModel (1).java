import java.util.*;

public class FireModel {
	public static int SIZE = 47;
	private FireCell[][] myGrid;
	private FireView myView;

	public FireModel(FireView view) {
		myGrid = new FireCell[SIZE][SIZE];
		int setNum = 0;
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				myGrid[r][c] = new FireCell();
			}
		}
		myView = view;
		myView.updateView(myGrid);
	}

	public void recursiveFire(int r, int c) {
		if (r < 0 || c < 0 || r > SIZE - 1 || c > SIZE - 1)
			return;
		if (r==SIZE-1||c==SIZE-1) {
			if(myGrid[r][c].getStatus() !=0)
				myGrid[r][c].setStatus(2);
				recursiveFire(r, c-1);
				recursiveFire(r - 1, c);
				
			}
		if(myGrid[r][c].getStatus() == 0)
			return;
				if(myGrid[r][c].getStatus()==1)
				{
					myGrid[r][c].setStatus(2);
			recursiveFire(r - 1, c);
			recursiveFire(r, c - 1);
			recursiveFire(r + 1, c);
			recursiveFire(r, c + 1);
				}
				}
	

	public void solve() {
		List<FireCell> list = new ArrayList<FireCell>();
		for (int i = 0; i < SIZE; i++) {
			if (myGrid[SIZE - 1][i].getStatus() == 1)
				myGrid[SIZE - 1][i].setStatus(2);
			list.add(myGrid[SIZE - 1][i]);
			recursiveFire(i, SIZE - 1);
		}
		boolean trouble = false;
		myView.updateView(myGrid);
		for(int i = 0; i < SIZE; i++)
		{
			trouble = (myGrid[0][i].getStatus()==2);
			if(trouble)
				break;
		}
		if(trouble)
			System.out.println("Onett is in trouble!");
		else
			System.out.println("Onett is safe");
	}

}

