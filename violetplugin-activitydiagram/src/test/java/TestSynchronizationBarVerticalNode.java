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
		Rectangle2D bounds = bar.getBounds();
		assertTrue(bounds instanceof Rectangle2D);
	}
	
	@Test
	public void testGetBoundsCorrectPosition(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Point2D point = new Point2D.Double(0, 0);
		assertTrue(bar.contains(point));
	}
	
	@Test
	public void testCheckCorrectPosition(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Point2D point = new Point2D.Double(0, 0);
		assertTrue(bar.contains(point));
	}
	
	@Test
	public void testCheckDefaultSize(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Rectangle2D defined = new Rectangle2D.Double(0, 0, 4, 100);
		Rectangle2D current = bar.getBounds();
		assertEquals(defined, current);

	}
	
	
}