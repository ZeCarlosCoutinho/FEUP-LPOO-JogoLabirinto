import logic.Jogo;
import cli.CommandLine;

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

			if (!(jogar.getTab().getDragon().isAlive()) && !(jogar.getTab().getDragon().isUserWarned())){
				jogar.getTab().getDragon().setUserWarned(true);
				cmd.heroi_matou_dragao();
			}
				
		}

		cmd.display(jogar.getTab().getBoard());

		cmd.fim_jogo();

		return;
	}
}
