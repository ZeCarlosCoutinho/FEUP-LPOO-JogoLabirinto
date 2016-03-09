import logic.Jogo;
import cli.CommandLine;

public class Start {
	public static void main(String[] args) {
		Jogo jogar = new Jogo();
		CommandLine cmd = new CommandLine(jogar);

		jogar.setGameMode(cmd.pede_modo_jogo());

		while (!(jogar.isGameOver())) // Enquanto não for game_over
		{
			cmd.display(jogar.getTab().getBoard());

			jogar.turno(cmd.pede_movimentacao());

			if (!(jogar.getTab().getDragon().isAlive()))
				cmd.heroi_matou_dragao();
		}

		cmd.display(jogar.getTab().getBoard());

		cmd.fim_jogo();

		return;
	}

}
