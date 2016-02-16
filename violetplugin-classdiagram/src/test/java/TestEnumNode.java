
import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.classes.nodes.EnumNode;
import java.awt.geom.Point2D;


public class TestEnumNode{

	@Test
	public void testGetBoundsCorrectPosition(){
		EnumNode enumNode = new EnumNode();
		Point2D initialPoint = new Point2D.Double(0, 0);
		assertTrue(enumNode.contains(initialPoint));
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testSetNullFields(){
		EnumNode enumNode = new EnumNode();
		enumNode.setFields(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNullName(){
		EnumNode enumNode = new EnumNode();
		enumNode.setName(null);
	}

}