/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.lang.reflect.Field;

/**
 *
 * @author DELL
 */
public class ObjectCheck {

    public boolean isNullObject(Object obj) {
        boolean flag = false;

        Class<?> clazz = obj.getClass();

        // Print the class name
        System.out.println("Class: " + clazz.getSimpleName());

        // Get all fields of the class
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // Make private fields accessible
            try {
                // Get field name and value
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);
                // Check for null value
                if (fieldValue == null || fieldValue.toString().isEmpty()) {

                    flag = true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
