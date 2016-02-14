import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.activity.SynchronizationBarVerticalNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

public class TestSynchronizationBarVerticalNode{
	@Test
	public void testObjectIsOfProperClass(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		assertTrue(bar instanceof SynchronizationBarVerticalNode);
	}
	
	@Test
	public void testGetBoundsOfCorrectType(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Rectangle2D initialBounds = bar.getBounds();
		assertTrue(initialBounds instanceof Rectangle2D);
	}
	
	@Test
	public void testGetBoundsCorrectPosition(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Point2D initialPosition = new Point2D.Double(0, 0);
		assertTrue(bar.contains(initialPosition));
	}

	//Robi to samo
//	@Test
//	public void testCheckCorrectPosition(){
//		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
//		Point2D point = new Point2D.Double(0, 0);
//		assertTrue(bar.contains(point));
//	}
	
	@Test
	public void testCheckDefaultSize(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Rectangle2D assertedInitialSize = new Rectangle2D.Double(0, 0, 4, 100);
		Rectangle2D testedBarSize = bar.getBounds();
		assertEquals(assertedInitialSize, testedBarSize);
	}
	
	
}