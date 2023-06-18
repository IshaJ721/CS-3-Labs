import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	public void reset()
	{	              
		myView.color = false;
		int r, c;
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
			myView.updateView(grid);
	}
	private void oneGeneration()
	{
		for(int i = 0; i<grid.length;i++)
		{
			for(int j = 0; j<grid[0].length; j++)
			{
				if(i==0||i==(grid.length-1)||j==0||j==(grid[0].length-1))
				{
					int neighbors = 0;
					if(i==0&&j==0)
					{
						if(grid[i+1][j].isAliveNow())
							neighbors++;
						if(grid[i+1][j+1].isAliveNow())
							neighbors++;
						if(grid[i][j+1].isAliveNow())
							neighbors++;
					}
					else if(i==0&&j!=0&&j!=(grid[0].length-1))
					{
						if(grid[i+1][j].isAliveNow())
							neighbors++;
						if(grid[i+1][j+1].isAliveNow())
							neighbors++;
						if(grid[i][j-1].isAliveNow())
							neighbors++;
						if(grid[i][j+1].isAliveNow())
							neighbors++;
						if(grid[i+1][j-1].isAliveNow())
							neighbors++;
					}
					else if(j==0&&i!=0&&i!=(grid.length-1))
					{
						if(grid[i-1][j].isAliveNow())
							neighbors++;
						if(grid[i+1][j].isAliveNow())
							neighbors++;
						if(grid[i+1][j+1].isAliveNow())
							neighbors++;
						if(grid[i][j+1].isAliveNow())
							neighbors++;
						if(grid[i-1][j+1].isAliveNow())
							neighbors++;
					}
					else if(i==0&&j==(grid[0].length-1))
					{
						if(grid[i+1][j].isAliveNow())
							neighbors++;
						if(grid[i][j-1].isAliveNow())
							neighbors++;
						if(grid[i+1][j-1].isAliveNow())
							neighbors++;
					}
					else if(j==(grid[0].length-1)&&i!=0&&i!=(grid.length-1))
					{
						if(grid[i-1][j].isAliveNow())
							neighbors++;
						if(grid[i+1][j].isAliveNow())
							neighbors++;
						if(grid[i-1][j-1].isAliveNow())
							neighbors++;
						if(grid[i][j-1].isAliveNow())
							neighbors++;
						if(grid[i+1][j-1].isAliveNow())
							neighbors++;
					}
					else if(i==(grid.length-1)&&j==(grid[0].length-1))
					{
						if(grid[i-1][j].isAliveNow())
							neighbors++;
						if(grid[i-1][j-1].isAliveNow())
							neighbors++;
						if(grid[i][j-1].isAliveNow())
							neighbors++;
					}
					else if(i==(grid.length-1)&&j!=0&&j!=(grid[0].length-1))
					{
						if(grid[i-1][j].isAliveNow())
							neighbors++;
						if(grid[i-1][j-1].isAliveNow())
							neighbors++;
						if(grid[i][j-1].isAliveNow())
							neighbors++;
						if(grid[i][j+1].isAliveNow())
							neighbors++;
						if(grid[i-1][j+1].isAliveNow())
							neighbors++;
					}
					else if(i==(grid.length-1)&&j==0)
					{
						if(grid[i-1][j].isAliveNow())
							neighbors++;
						if(grid[i][j+1].isAliveNow())
							neighbors++;
						if(grid[i-1][j+1].isAliveNow())
							neighbors++;
					}
					if(grid[i][j].isAliveNow()&&neighbors==0||neighbors==1||(neighbors>4&&neighbors<8))
						grid[i][j].setAliveNext(false);
					if(grid[i][j].isAliveNow()&&neighbors==2||neighbors==3)
						grid[i][j].setAliveNext(true);
					if(!grid[i][j].isAliveNow()&&neighbors==3)
						grid[i][j].setAliveNext(true);
				}
				else
				{
					int neighbors = 0;
					if(grid[i-1][j].isAliveNow())
						neighbors++;
					if(grid[i+1][j].isAliveNow())
						neighbors++;
					if(grid[i-1][j-1].isAliveNow())
						neighbors++;
					if(grid[i+1][j+1].isAliveNow())
						neighbors++;
					if(grid[i][j-1].isAliveNow())
						neighbors++;
					if(grid[i][j+1].isAliveNow())
						neighbors++;
					if(grid[i-1][j+1].isAliveNow())
						neighbors++;
					if(grid[i+1][j-1].isAliveNow())
						neighbors++;
					if(grid[i][j].isAliveNow()&&neighbors==0||neighbors==1||(neighbors>=4&&neighbors<=8))
						grid[i][j].setAliveNext(false);
					if(grid[i][j].isAliveNow()&&neighbors==2||neighbors==3)
						grid[i][j].setAliveNext(true);
					if(!grid[i][j].isAliveNow()&&neighbors==3)
						grid[i][j].setAliveNext(true);
				}
			}
		}
		for(int i = 0; i<grid.length;i++)
		{
			for(int j=0; j<grid[0].length;j++)
			{
				grid[i][j].setAliveNow(grid[i][j].isAliveNext());
			}
		}
	}
}

