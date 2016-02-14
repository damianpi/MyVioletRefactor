
import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.state.HistoryNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import com.horstmann.violet.product.diagram.abstracts.property.MultiLineString;
import com.horstmann.violet.product.diagram.state.ShallowHistoryNode;
import com.horstmann.violet.product.diagram.state.DeepHistoryNode;




public class TestDeepHistory{

	
	@Test
	public void testDeepHistoryHistoryType(){
		DeepHistoryNode deepHistoryNode = new DeepHistoryNode();
		assertEquals(deepHistoryNode.getHistoryType(), "H*");
	}
	
	
	@Test
	public void testDeepSize(){
		DeepHistoryNode deepHistoryNode = new DeepHistoryNode();
		Rectangle2D deepHistoryNodePosition = deepHistoryNode.getBounds();
		Rectangle2D assertedPositionAndSize = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(deepHistoryNodePosition, assertedPositionAndSize);
	}


	@Test
	public void testDeepCorrectSizeAndPosition(){
		DeepHistoryNode deepHistoryNode = new DeepHistoryNode();
		Rectangle2D cur = deepHistoryNode.getBounds();
		Rectangle2D pos = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(cur, pos);	
	}
	
	
}