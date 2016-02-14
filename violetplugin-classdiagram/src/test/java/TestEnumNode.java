
import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.classes.nodes.EnumNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import com.horstmann.violet.product.diagram.abstracts.property.MultiLineString;




public class TestEnumNode{
	


	
	@Test
	public void testGetBoundsCorrectPosition(){
		EnumNode enumNode = new EnumNode();
		Point2D initialPoint = new Point2D.Double(0, 0);
		assertTrue(enumNode.contains(initialPoint));
	}
	
//	@Test
//	public void testCorrectName(){
//		EnumNode enumNode = new EnumNode();
//		MultiLineString enumName = enumNode.getName();
//		assertEquals(enumName.getText(), "\u00ABenum\u00BB");
//	}
	
	

	
}