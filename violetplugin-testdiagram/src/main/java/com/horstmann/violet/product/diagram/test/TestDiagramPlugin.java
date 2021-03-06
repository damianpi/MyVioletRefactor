package com.horstmann.violet.product.diagram.test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.horstmann.violet.framework.plugin.IDiagramPlugin;
import com.horstmann.violet.framework.plugin.extensionpoint.Violet016FileFilterExtensionPoint;
import com.horstmann.violet.product.diagram.abstracts.IGraph;

/**
 * Describes use case diagram graph type
 * 
 * @author Alexandre de Pellegrin
 * 
 */
public class TestDiagramPlugin implements IDiagramPlugin, Violet016FileFilterExtensionPoint
{

    @Override
    public String getDescription()
    {
        return "Test UML diagram";
    }

    @Override
    public String getProvider()
    {
        return "Alexandre de Pellegrin / Cays S. Horstmann";
    }

    @Override
    public String getVersion()
    {
        return "1.0.0";
    }

    @Override
    public String getName()
    {
        return this.rs.getString("menu.test_diagram.name");
    }

    @Override
    public String getCategory()
    {
        return this.rs.getString("menu.test_diagram.category");
    }

    @Override
    public String getFileExtension()
    {
        return this.rs.getString("files.test.extension");
    }

    @Override
    public String getFileExtensionName()
    {
        return this.rs.getString("files.test.name");
    }

    @Override
    public String getSampleFilePath()
    {
        return this.rs.getString("sample.file.path");
    }

    @Override
    public Class<? extends IGraph> getGraphClass()
    {
        return TestDiagramGraph.class;
    }

    public Map<String, String> getMappingToKeepViolet016Compatibility()
    {
        Map<String, String> replaceMap = new HashMap<String, String>();
//        replaceMap.put("com.horstmann.violet.ActorNode", ActorNode.class.getName());
//        replaceMap.put("com.horstmann.violet.UseCaseDiagramGraph", UseCaseDiagramGraph.class.getName());
//        replaceMap.put("com.horstmann.violet.UseCaseNode", UseCaseNode.class.getName());
//        replaceMap.put("com.horstmann.violet.UseCaseRelationshipEdge", UseCaseRelationshipEdge.class.getName());
        return replaceMap;
    }

    private ResourceBundle rs = ResourceBundle.getBundle(TestDiagramConstant.TEST_DIAGRAM_STRINGS, Locale.getDefault());

}