
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.geom.Rectangle2D;
import com.horstmann.violet.product.diagram.state.DeepHistoryNode;


public class TestDeepHistory{

	@Test
	public void testDeepHistoryHistoryType(){
		DeepHistoryNode deepHistoryNode = new DeepHistoryNode();
		assertEquals(deepHistoryNode.getHistoryType(), "H*");
	}
	
	@Test
	public void testDeepHistorySize(){
		DeepHistoryNode deepHistoryNode = new DeepHistoryNode();
		Rectangle2D deepHistoryNodePosition = deepHistoryNode.getBounds();
		Rectangle2D assertedPositionAndSize = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(deepHistoryNodePosition, assertedPositionAndSize);
	}

	@Test
	public void testCheckDeepHistoryDiameter(){
		DeepHistoryNode deepHistoryNode = new DeepHistoryNode();
		Rectangle2D bounds = deepHistoryNode.getBounds();
		assertTrue(bounds.getWidth() == bounds.getHeight());
	}
	
	
}