package dacom.tajo.server;

import java.util.List;

public class StopAndWaitFrame implements Frame {

	
	@Override
	public List<Frame> getFrames(String message) {
		
		return null;
	}
	boolean matchFrame(StopAndWaitFrame cur,String ack)
	{
		return true;
	}

}
