package com.horstmann.violet.product.diagram.classes.nodes;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * The bean info for the InterfaceNode type.
 */
public class EnumNodeBeanInfo extends SimpleBeanInfo
{

    @Override
    public PropertyDescriptor[] getPropertyDescriptors()
    {
        try
        {
            PropertyDescriptor nameDescriptor = new PropertyDescriptor("name", EnumNode.class);
            nameDescriptor.setValue("priority", new Integer(1));
            PropertyDescriptor methodsDescriptor = new PropertyDescriptor("fields", EnumNode.class);
            methodsDescriptor.setValue("priority", new Integer(2));
            return new PropertyDescriptor[]
            {
                    nameDescriptor,
                    methodsDescriptor
            };
        }
        catch (IntrospectionException exception)
        {
            return null;
        }
    }
}
