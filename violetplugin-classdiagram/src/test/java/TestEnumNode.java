
import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.classes.nodes.EnumNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import com.horstmann.violet.product.diagram.abstracts.property.MultiLineString;




public class TestEnumNode{
	
	@Test
	public void testObjectIsOfProperClass(){
		EnumNode en = new EnumNode();
		if(en instanceof EnumNode){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetBoundsOfCorrectType(){
		EnumNode en = new EnumNode();
		Rectangle2D bounds = en.getBounds();
		assertTrue(bounds instanceof Rectangle2D);
	}
	
	@Test
	public void testGetBoundsCorrectPosition(){
		EnumNode en = new EnumNode();
		Point2D point = new Point2D.Double(0, 0);
		if(en.contains(point)){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
	
	@Test
	public void testCorrectName(){
		EnumNode en = new EnumNode();
		MultiLineString ms = en.getName();
		assertEquals(ms.getText(), "\u00ABenum\u00BB");
		
		
	}
	
	

	
}