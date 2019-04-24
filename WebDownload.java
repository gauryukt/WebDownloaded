import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

//Yukti Gaur
//CSAS 3111
//This program will download an arbitary webpage
public class WebDownload {
	
	public static void main(String[] args) {
		System.out.println("The program will download an arbitary webpage");
		// TODO Auto-generated method stub 
		//the host to connect to:
				String host = "sciris.shu.edu";
				// the port to use for the connection
				int port = 80;
				// the file to retrieve
				String file = "/";

				if (args.length == 2) {
				file = args[1]; }
				
				if (args.length >= 1) {
				host = args[0]; }
				else
				{
				System.out.println("Usage: java WebDownload host [file]");
				     	System.exit(-1);
				}
				
				try
				{
				    //connecting....
				
				Socket s = new Socket(host, port);
				System.out.println("Connection established: " + s);
				BufferedReader in = new BufferedReader(new InputStreamReader(
               			s.getInputStream()));
				PrintWriter out = new PrintWriter(
	                    new OutputStreamWriter(
	     	                  		s.getOutputStream()));
				// here I can send and receive characters using 
				// in.readLine() and out.println()

				in.close();
				out.close();
				s.close();
				System.out.println("Disconneted");

			    }
				catch(Exception e)
				{
					System.err.println("Error: " + e);
				}
				System.out.println("Setting up input and output streams of characters");
				private static void sendHTTPCode(PrintWriter out, String file, String host)
				{
				     out.println("GET " + file + " HTTP/1.1");
				     out.println("HOST: " + host);
				     out.println();
				            out.flush();
				}
				
				private static void receiveHTTPData(BufferedReader out) throws Exception
				{
				     String line = out.readLine();
				     while (line != null)
				     {
				          System.out.println("Got: " + line);
				line = out.readLine();
					}
				}
           								

	}

}
		



