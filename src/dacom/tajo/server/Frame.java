package dacom.tajo.server;

import java.util.List;

public interface Frame {
		public List<Frame> getFrames(String message);
		public String toString();
}
