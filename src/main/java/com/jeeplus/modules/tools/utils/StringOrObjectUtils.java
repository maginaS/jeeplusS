/**
 * 
 */
package com.jeeplus.modules.tools.utils;


import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author MikeSun
 *
 */
public class StringOrObjectUtils {
	/**
     * 验证实体对象是否为空
     * 
     * @param bean
     * @param attributeName
     *            自定义验证的
     */
    public static boolean isEmpty(Object bean, String... attributeName) {
        List<String> list = Arrays.asList(attributeName);
        PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(bean);
        for (PropertyDescriptor origDescriptor : origDescriptors) {
            String name = origDescriptor.getName();
            if (list.contains(name)) {
                if ("class".equals(name)) {
                    continue;
                }
                if (PropertyUtils.isReadable(bean, name)) {
                    try {
                        Object value = PropertyUtils.getSimpleProperty(bean, name);
                        if (value == null) {
                            continue;
                        } else {
                            return false;
                        }
                    } catch (java.lang.IllegalArgumentException ie) {
                        ;
                    } catch (Exception e) {
                        ;
                    }
                }
            } else {
                continue;
            }
        }
        return true;
    }


    /**
     * 验证实体对象是否为空
     * 如果对象属性为空，则判断该对象为空。
     * 
     * @param bean
     * @return
     */
    public static boolean isEmpty(Object bean) {
        PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(bean);
        for (PropertyDescriptor origDescriptor : origDescriptors) {
            String name = origDescriptor.getName();
            if ("class".equals(name)) {
                continue;
            }
            if (PropertyUtils.isReadable(bean, name)) {
                try {
                    Object value = PropertyUtils.getSimpleProperty(bean, name);
                    if (value == null) {
                        continue;
                    } else {
                        return false;
                    }
                } catch (java.lang.IllegalArgumentException ie) {
                    ;
                } catch (Exception e) {
                    ;
                }
            }
        }
        return true;
    }

}
