
import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.state.HistoryNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import com.horstmann.violet.product.diagram.abstracts.property.MultiLineString;
import com.horstmann.violet.product.diagram.state.ShallowHistoryNode;
import com.horstmann.violet.product.diagram.state.DeepHistoryNode;




public class TestShallowHistory{
	
	@Test
	public void testCheckShallowHistoryCorrectType(){
		ShallowHistoryNode shallow = new ShallowHistoryNode();
		assertTrue(shallow instanceof ShallowHistoryNode);
	}
	
	
	@Test
	public void testShallowHistoryHistoryType(){
		ShallowHistoryNode shallow = new ShallowHistoryNode();
		assertEquals(shallow.getHistoryType(), "H");
	}
	
	@Test
	public void testShallowSize(){
		ShallowHistoryNode shallow = new ShallowHistoryNode();
		Rectangle2D cur = shallow.getBounds();
		Rectangle2D pos = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(cur, pos);
		
	}
	
	
	@Test
	public void testSetShallowHistoryType(){
		ShallowHistoryNode shallow = new ShallowHistoryNode();
		String def = shallow.getHistoryType();
		shallow.setHistoryType("changed");
		assertFalse(def.equals(shallow.getHistoryType()));
	}
	
	
	@Test
	public void testShallowCorrectSizeAndPosition(){
		ShallowHistoryNode shallow = new ShallowHistoryNode();
		Rectangle2D cur = shallow.getBounds();
		Rectangle2D pos = new Rectangle2D.Double(0, 0, 20, 20);
		assertEquals(cur, pos);	
	}

	
}