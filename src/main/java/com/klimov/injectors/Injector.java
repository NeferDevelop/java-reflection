package com.klimov.injectors;

import com.klimov.annotations.AutoInjectable;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * The Injector class is responsible for injecting dependencies into an object based on
 * the AutoInjectable annotation and a properties file.
 * @author s.a.klimov
 */
public class Injector {

    /**
     * Default constructor for the Injector class.
     */
    public Injector() {}

    /**
     * Injects dependencies into the given object using the configuration file specified by the path.
     *
     * @param object The object into which dependencies will be injected.
     * @param path   The path to the configuration file containing dependency mappings.
     * @param <T>    The type of the object.
     * @return The object with injected dependencies.
     * @throws IOException If an error occurs while loading the configuration file.
     */
    public <T> T inject(T object, String path) throws IOException {
        PropertyLoader propertyLoader = new PropertyLoader();
        propertyLoader.loadProperties(path);
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                String fieldClassName = field.getType().getName();
                String injectedClassName = propertyLoader.getProperty(fieldClassName);

                if (injectedClassName != null) {
                    field.setAccessible(true);

                    try {
                        Class<?> injectedClass = Class.forName(injectedClassName);
                        Object classObject = injectedClass.getDeclaredConstructor().newInstance();
                        field.set(object, classObject);
                    } catch (ClassNotFoundException | InstantiationException |
                             IllegalAccessException | NoSuchMethodException |
                             java.lang.reflect.InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return object;
    }
}
