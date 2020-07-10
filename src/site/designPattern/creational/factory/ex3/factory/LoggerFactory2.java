package site.designPattern.creational.factory.ex3.factory;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
//https://medium.com/@kousiknath/design-patterns-different-approaches-to-use-factory-pattern-to-choose-objects-dynamically-at-run-71449bceecef
public class LoggerFactory2 {

    private static final Map<String, LoggingOperation> instances = new HashMap<>();

    static {
        try {
            loadClasses(LoggerFactory.class.getClassLoader(), "package_where_storage_classes_reside");
        } catch (Exception e) {
            // log or throw exception.
        }
    }

    public static void register(String loggerMedium, LoggingOperation instance) {
        if (loggerMedium != null && instance != null) {
            instances.put(loggerMedium, instance);
        }
    }

    public static LoggingOperation getInstance(String loggerMedium) {
        if (instances.containsKey(loggerMedium)) {
            return instances.get(loggerMedium);
        }
        return null;
    }

    private static void loadClasses(ClassLoader cl, String packagePath) throws Exception {

        String dottedPackage = packagePath.replaceAll("[/]", ".");

        URL upackage = cl.getResource(packagePath);
        URLConnection conn = upackage.openConnection();

//        String rr = IOUtils.toString(conn.getInputStream(), "UTF-8");//add that dependency through maven or gradle.
        String rr = "";
        if (rr != null) {
            String[] paths = rr.split("\n");

            for (String p : paths) {
                if (p.endsWith(".class")) {
                    Class.forName(dottedPackage + "." + p.substring(0, p.lastIndexOf('.')));
                }

            }
        }
    }
}
//Now Any new logger medium comes up like FLASH_DRIVE, then they will register themselves by calling register method, so
//no chnages will be done in the factory class.
