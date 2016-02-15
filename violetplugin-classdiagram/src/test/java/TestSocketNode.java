import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.classes.nodes.SocketNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;


public class TestSocketNode{

	@Test
	public void testGetBoundsCorrectPosition(){
		SocketNode socketNode = new SocketNode();
		Point2D initialPosition = new Point2D.Double(0, 0);
		assertTrue(socketNode.contains(initialPosition));
	}

	@Test
	public void testSocketNodeSize(){
		SocketNode socketNode = new SocketNode();
		Rectangle2D bounds = socketNode.getBounds();
		assertTrue(bounds.getWidth() < bounds.getHeight());
	}


}