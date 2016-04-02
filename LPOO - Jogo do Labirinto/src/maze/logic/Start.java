package maze.logic;
import maze.cli.CommandLine;

public class Start {
	public static void main(String[] args) {
		Jogo jogar = new Jogo();
		CommandLine cmd = new CommandLine(jogar);

		boolean firstTime = true;
		jogar.setGameMode(cmd.pede_modo_jogo());
		
		cmd.instrucoes();

		while (!(jogar.isGameOver())) // Enquanto não for game_over
		{
			if (!firstTime)
				cmd.clearConsole();
			else
				firstTime = false;
			
			cmd.display(jogar.getTab().getBoard());

			jogar.turno(cmd.pede_movimentacao());

			for(int i = 0; i < jogar.getTab().getDragons().length; i++)
			if (!(jogar.getTab().getDragons()[i].isAlive()) && !(jogar.getTab().getDragons()[i].isUserWarned())){
				jogar.getTab().getDragons()[i].setUserWarned(true);
				cmd.clearConsole();
				cmd.heroi_matou_dragao();
				firstTime = true;
			}
				
		}

		cmd.display(jogar.getTab().getBoard());

		cmd.fim_jogo();

		return;
	}
}
