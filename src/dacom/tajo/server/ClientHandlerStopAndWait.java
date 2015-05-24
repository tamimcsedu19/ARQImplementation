package dacom.tajo.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandlerStopAndWait implements ARQImplementation {

	Socket clientSocket;
	BufferedReader reader;
	PrintWriter writer;
	public ClientHandlerStopAndWait(Socket clientSocket) {
		try {
			this.clientSocket = clientSocket;
			InputStreamReader isReader = new InputStreamReader(
					clientSocket.getInputStream());
			reader = new BufferedReader(isReader);
			writer = new PrintWriter(clientSocket.getOutputStream());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void run() {
		/**
		 * Stop and wait frame = stwFrame
		 */
		Frame frame = new StopAndWaitFrame();
		/**
		 * Use of the static getFrames method of the frame Class
		 */
		List<Frame> frames = frame.getFrames(Server.getData()); frame = null;
		for(int i=0;i<frames.size();++i)
		{
			StopAndWaitFrame stwFrame =(StopAndWaitFrame)frames.get(i);
			writer.println(stwFrame);
			writer.flush();
		}

	}

}


