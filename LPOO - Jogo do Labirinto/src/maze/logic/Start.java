package maze.logic;
import exceptions.TooManyDragonsException;
import maze.cli.CommandLine;

public class Start {
	/**
	 * @brief Funçao responsavel por pôr a interface logica a funcionar; Inicia o jogo.
	 * @param args
	 */
	public static void main(String[] args) {
		Jogo jogar = new Jogo();
		CommandLine cmd = new CommandLine(jogar);

		boolean firstTime = true;
		jogar.setGameMode(cmd.pede_modo_jogo());
		try {
			jogar.criaLabirintoAleatorio(cmd.pedeMazeAleatorio(), cmd.pedeNumDragoes());
		} catch (TooManyDragonsException e) {
			//Tem demasiados dragoes, e termina o programa
			cmd.demasiadosDragoesException();
			return;
		}
		
		cmd.instrucoes();

		while (!(jogar.isGameOver())) // Enquanto não for game_over
		{
			if (!firstTime)
				cmd.clearConsole();
			else
				firstTime = false;
			
			cmd.display(jogar.getLab().getBoard());

			jogar.turno(cmd.pede_movimentacao());

			for(int i = 0; i < jogar.getLab().getDragons().length; i++)
			if (!(jogar.getLab().getDragons()[i].isAlive()) && !(jogar.getLab().getDragons()[i].isUserWarned())){
				jogar.getLab().getDragons()[i].setUserWarned(true);
				cmd.clearConsole();
				cmd.heroi_matou_dragao();
				firstTime = true;
			}
				
		}

		cmd.display(jogar.getLab().getBoard());

		cmd.fim_jogo();

		return;
	}
}
