import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.classes.nodes.BallNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;


public class TestBallNode{
	
	@Test
	public void testObjectIsOfProperClass(){
		BallNode bn = new BallNode();
		if(bn instanceof BallNode){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetBoundsOfCorrectType(){
		BallNode bn = new BallNode();
		Rectangle2D bounds = bn.getBounds();
		assertTrue(bounds instanceof Rectangle2D);
	}
	
	@Test
	public void testGetBoundsCorrectPosition(){
		BallNode bn = new BallNode();
		Point2D point = new Point2D.Double(0, 0);
		if(bn.contains(point)){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
//	
//	
//	
//	@Test
//	public void testGetBounds(){
//		
//	}
	
	
	
	
}