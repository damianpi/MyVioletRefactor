
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.geom.Rectangle2D;
import com.horstmann.violet.product.diagram.state.ShallowHistoryNode;


public class TestShallowHistory{

	
	@Test
	public void testShallowHistoryHistoryType(){
		ShallowHistoryNode shallow = new ShallowHistoryNode();
		assertEquals(shallow.getHistoryType(), "H");
	}
	
	@Test
	public void testShallowSize(){
		ShallowHistoryNode shallowHistoryNode = new ShallowHistoryNode();
		Rectangle2D currentSize = shallowHistoryNode.getBounds();
		Rectangle2D assumedSize = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(currentSize, assumedSize);
	}

	@Test
	public void testCheckShallowHistoryDiameter(){
		ShallowHistoryNode shallowHistoryNode = new ShallowHistoryNode();
		Rectangle2D bounds = shallowHistoryNode.getBounds();
		assertTrue(bounds.getWidth() == bounds.getHeight());
	}

	
}