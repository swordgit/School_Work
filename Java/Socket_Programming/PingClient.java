import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PingClient
{
	private static final int delay = 1000; // 1000 millisecond seperation

	public static void main(String[] args) throws Exception
	{
		final int PING_COUNT = 9;

		// Get command line argument.
		if (args.length != 1)
		{
			System.out.println("Required arguments: port");
			return;
		}

		// create port number for outgoing packet
		int port = Integer.parseInt(args[0]);

		// interface instruction
		System.out
				.println("Command Syntax: ping <destination addr> <destination port>");
		System.out.println("Use CTRL^C to quit");
		System.out.print(">");

		// read input from user and retrieve address and port string and execute
		// ping
		Scanner input = new Scanner(System.in);
		// split the input so the address and port can be retrieved
		String[] command = input.nextLine().split(" ");
		while (true)
		{
			if (!command[0].equalsIgnoreCase("ping"))
			{
				System.out
						.println("Command Syntax: ping <destination addr> <destination port>");
				System.out.println("Use CTRL^C to quit");
				System.out.print(">");
				command = input.nextLine().split(" ");
			}
			else
			{
				String serverAddress = command[1];
				int serverPort = Integer.parseInt(command[2]);
				byte[] sendData = new byte[1024];
				byte[] receiveData = new byte[1024];
				DatagramSocket socket = new DatagramSocket(port);
				InetAddress IP = InetAddress.getByName(serverAddress);
				Date date = new Date();
				for (int i = 0; i <= PING_COUNT; i++)
				{
					date = Calendar.getInstance().getTime();
					SimpleDateFormat sdf = new SimpleDateFormat(
							"EEE MMM HH:mm:ss:SSS z yyyy");
					String message = "PING " + i + " " + sdf.format(date)
							+ "\r\n";
					sendData = message.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData,
							sendData.length, IP, serverPort);
					// System.out.println(message);
					socket.send(sendPacket);
					DatagramPacket reply = new DatagramPacket(new byte[1024],
							1024);
					socket.setSoTimeout(delay);
					try
					{
						socket.receive(reply);
						printData(reply);
					}
					catch (SocketTimeoutException e)
					{
						System.out.println("PING " + i + " "
								+ "Request timed out.");
					}
					Thread.sleep(delay);
				}
				socket.close();
				System.out.print(">");
				try
				{
					command = input.nextLine().split(" ");
				}
				catch (Exception e)
				{
				}
			}

		}

	}

	private static void printData(DatagramPacket request) throws Exception
	{
		// Obtain references to the packet's array of bytes.
		byte[] buf = request.getData();
		// Wrap the bytes in a byte array input stream,
		// so that you can read the data as a stream of bytes.
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		// Wrap the byte array output stream in an input stream reader,
		// so you can read the data as a stream of characters.
		InputStreamReader isr = new InputStreamReader(bais);
		// Wrap the input stream reader in a bufferred reader,
		// so you can read the character data a line at a time.
		// (A line is a sequence of chars terminated by any combination of \r
		// and \n.)
		BufferedReader br = new BufferedReader(isr);
		// The message data is contained in a single line, so read this line.
		String line = br.readLine();
		// Print host address and data received from it.
		System.out.println("Received from "
				+ request.getAddress().getHostAddress() + ": "
				+ new String(line));
	}

}
