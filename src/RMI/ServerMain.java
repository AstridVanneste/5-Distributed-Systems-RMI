package RMI;
/**
 * Created by Astrid on 11-Oct-17.
 */
public class ServerMain
{
	public static void main(String[] args)
	{
		Server server = new Server();

		server.init();

		BankComponent bank = new BankComponent(200);

		server.addComponent(ComponentKeys.BANK_KEY,bank);
	}
}
