import static org.junit.Assert.*;
import org.junit.Test;
import com.horstmann.violet.product.diagram.classes.nodes.SocketNode;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;


public class TestSocketNode{
	
	@Test
	public void testObjectIsOfProperClass(){
		SocketNode sn = new SocketNode();
		if(sn instanceof SocketNode){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetBoundsOfCorrectType(){
		SocketNode sn = new SocketNode();
		Rectangle2D bounds = sn.getBounds();
		assertTrue(bounds instanceof Rectangle2D);
	}
	
	@Test
	public void testGetBoundsCorrectPosition(){
		SocketNode sn = new SocketNode();
		Point2D point = new Point2D.Double(0, 0);
		if(sn.contains(point)){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
	
}