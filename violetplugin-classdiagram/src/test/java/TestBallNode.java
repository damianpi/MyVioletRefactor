import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.classes.nodes.BallNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;


public class TestBallNode{
	

	@Test
	public void testGetBoundsOfCorrectType(){
		BallNode ballNode = new BallNode();
		Rectangle2D bounds = ballNode.getBounds();
		assertTrue(bounds instanceof Rectangle2D);
	}
	
	@Test
	public void testGetBoundsCorrectPosition(){
		BallNode ballNode = new BallNode();
		Point2D initialPoint = new Point2D.Double(0, 0);
		assertTrue(ballNode.contains(initialPoint));
	}

	
	
	
}