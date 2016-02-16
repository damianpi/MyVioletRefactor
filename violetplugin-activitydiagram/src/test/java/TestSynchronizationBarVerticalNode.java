import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.activity.SynchronizationBarVerticalNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

public class TestSynchronizationBarVerticalNode{

	@Test
	public void testGetBoundsCorrectPosition(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Point2D initialPosition = new Point2D.Double(0, 0);
		assertTrue(bar.contains(initialPosition));
	}

	@Test
	public void testCheckDefaultSize(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Rectangle2D assertedInitialSize = new Rectangle2D.Double(0, 0, 4, 100);
		Rectangle2D testedBarSize = bar.getBounds();
		assertEquals(assertedInitialSize, testedBarSize);
	}
	
	@Test
	public void testBarIsVertical(){
		SynchronizationBarVerticalNode bar = new SynchronizationBarVerticalNode();
		Rectangle2D bounds = bar.getBounds();
		assertTrue(bounds.getWidth() < bounds.getHeight());
	}
}