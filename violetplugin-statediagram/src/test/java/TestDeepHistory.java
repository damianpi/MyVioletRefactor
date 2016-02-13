
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
	public void testCheckDeepHistoryCorrectType(){
		DeepHistoryNode deep = new DeepHistoryNode();
		assertTrue(deep instanceof DeepHistoryNode);
	}
	
	@Test
	public void testDeepHistoryHistoryType(){
		DeepHistoryNode deep = new DeepHistoryNode();
		assertEquals(deep.getHistoryType(), "H*");
	}
	
	
	@Test
	public void testDeepSize(){
		DeepHistoryNode deep = new DeepHistoryNode();
		Rectangle2D cur = deep.getBounds();
		Rectangle2D pos = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(cur, pos);
	}
	
	
	@Test
	public void testSetDeepHistoryType(){
		DeepHistoryNode deep = new DeepHistoryNode();
		String def = deep.getHistoryType();
		deep.setHistoryType("changed");
		assertFalse(def.equals(deep.getHistoryType()));
	}
	

	@Test
	public void testDeepCorrectSizeAndPosition(){
		DeepHistoryNode deep = new DeepHistoryNode();
		Rectangle2D cur = deep.getBounds();
		Rectangle2D pos = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(cur, pos);	
	}
	
	
}