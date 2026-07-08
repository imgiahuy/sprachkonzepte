package aufgabe6;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Aufgabe6 {

    public static class MethodModel {
        private final String returnType;
        private final String name;
        private final List<String> paramTypes;

        public MethodModel(Method m) {
            this.name = m.getName();
            this.returnType = m.getReturnType().getCanonicalName();
            this.paramTypes = new ArrayList<>();
            for (Class<?> p : m.getParameterTypes()) {
                paramTypes.add(p.getCanonicalName());
            }
        }

        public String getReturnType() { return returnType; }
        public String getName() { return name; }
        public List<String> getParamTypes() { return paramTypes; }
    }

    public static class InterfaceModel {
        private final String name;
        private final List<MethodModel> methods;

        public InterfaceModel(Class<?> iface) {
            this.name = iface.getCanonicalName();
            this.methods = new ArrayList<>();
            for (Method m : iface.getMethods()) {
                methods.add(new MethodModel(m));
            }
        }

        public String getName() { return name; }
        public List<MethodModel> getMethods() { return methods; }
    }

    public static class ClassModel {
        private final String name;
        private final boolean isInterface;
        private final List<InterfaceModel> interfaces;
        private final List<MethodModel> methods;

        public ClassModel(Class<?> clazz) {
            this.name = clazz.getCanonicalName();
            this.isInterface = clazz.isInterface();
            this.interfaces = new ArrayList<>();
            this.methods = new ArrayList<>();

            if (isInterface) {
                for (Method m : clazz.getMethods()) {
                    methods.add(new MethodModel(m));
                }
            } else {
                for (Class<?> iface : clazz.getInterfaces()) {
                    interfaces.add(new InterfaceModel(iface));
                }
            }
        }

        public String getName() { return name; }
        public boolean isInterface() { return isInterface; }
        public List<InterfaceModel> getInterfaces() { return interfaces; }
        public List<MethodModel> getMethods() { return methods; }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.println("Usage: Aufgabe6 <fully.qualified.ClassName> ...");
            System.exit(1);
        }

        List<ClassModel> models = new ArrayList<>();
        for (String arg : args) {
            Class<?> clazz = Class.forName(arg);
            models.add(new ClassModel(clazz));
        }

        java.net.URL stgUrl = Aufgabe6.class.getResource("aufgabe6.stg");
        STGroupFile group = new STGroupFile(stgUrl, "UTF-8", '$', '$');
        ST template = group.getInstanceOf("page");
        template.add("classes", models);
        System.out.println(template.render());
    }
}
