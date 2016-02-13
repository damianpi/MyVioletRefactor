
import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.state.HistoryNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import com.horstmann.violet.product.diagram.abstracts.property.MultiLineString;




public class TestHistoryNode{
	@Test
	public void testHistoryNodeCorrectType(){
		HistoryNode hist = new HistoryNode();
		assertTrue(hist instanceof HistoryNode);
	}
	
	@Test
	public void testCorrectSizeAndPosition(){
		HistoryNode hist = new HistoryNode();
		Rectangle2D cur = hist.getBounds();
		Rectangle2D pos = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(cur, pos);	
	}
	
}