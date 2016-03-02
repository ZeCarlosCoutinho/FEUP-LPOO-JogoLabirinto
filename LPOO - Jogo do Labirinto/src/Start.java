import logic.Jogo;
import cli.CommandLine;

public class Start {
	public static void main(String[] args)
	{
		Jogo jogar = new Jogo();
		CommandLine cmd = new CommandLine();
		
		while(!(jogar.isGame_over()))	//Enquanto não for game_over
		{
			cmd.display(jogar.getTab().getBoard());
			
			jogar.turno(cmd.pede_movimentacao());
		}
		
		cmd.display(jogar.getTab().getBoard());

		if(jogar.isWin())
			System.out.println("GANHASTE!!!!");
		else
			System.out.println("PERDESTE. NOOB");
		
		return;
	}
	
}
