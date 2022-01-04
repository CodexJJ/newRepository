package com.test;

import com.entity.Person;

import java.lang.reflect.*;

public class Test01 {

    public static void main(String[] args){
        //1.通过反射方式获取类型信息：
        System.out.println("\n========1.通过反射方式获取类型信息========\n");
        //Class作为Java反射机制的入口，先创建Class类的实例
        Class cla= Person.class;
        //获取Person类的全类名
        String fullName=cla.getName();
        System.out.println("以下是"+fullName+"类的基本信息");
        //获取Person类的简称类名
        String simpleName=cla.getSimpleName();
        //获取Person类所在的全包名
        String packageName=cla.getPackage().getName();
        System.out.println(simpleName+"类定义在"+packageName+"包");
        //获取person的父类的全类名
        String superclassName=cla.getSuperclass().getName();
        System.out.println("父类是："+superclassName);
        //获取person的实现接口，接口可以多实现，所以使用数组接收
        Class[] interfaces=cla.getInterfaces();
        System.out.println("实现的接口："+interfaces[0]);
        //获取person的所有访问修饰符，由public、protected、private、final、staic、abstract等对应的int常量组成，
        // 返回的整数应使用Modifier工具类来解码，才可以判断修饰符的构成
        int modifier=cla.getModifiers();
        if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC)
            System.out.println("访问修饰符是：public");
        else
            System.out.println("访问修饰符是：default(package)");

        if ((modifier & Modifier.FINAL) == Modifier.FINAL)
            System.out.println("这个类是 final 的");
        if ((modifier & Modifier.ABSTRACT) == Modifier.ABSTRACT)
            System.out.println("这是一个抽象类");
        if ((modifier & Modifier.INTERFACE) == Modifier.INTERFACE)
            System.out.println("这是一个接口");
        System.out.println("---------------------------------------------");

        //2.通过反射方式获取构造方法信息：
        System.out.println("\n=======2.通过反射方式获取构造方法信息========\n");
        //使用getDeclaredConstructors()获取该类型的所有构造方法，访问级别不限
        Constructor[] cos=cla.getDeclaredConstructors();
        for(int j=0;j<cos.length;j++){
            System.out.println("\n第"+(j+1)+"个构造方法");
            Constructor c=cos[j];
            //获取构造方法的访问修饰符
            int mod=c.getModifiers();
            // 判断该构造方法的访问修饰符
            if ((mod & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println("public");
            else if ((mod & Modifier.PROTECTED) == Modifier.PROTECTED)
                System.out.println("protected");
            else if ((mod & Modifier.PRIVATE) == Modifier.PRIVATE)
                System.out.println("private");
            else
                System.out.println("default(package)");
            // 使用getParameterTypes()获取构造方法的参数列表
            Class[] params = c.getParameterTypes();
            if (params.length == 0) {
                System.out.println("该构造方法没有参数");
            } else {
                System.out.print("该构造方法的参数列表为：[");
                for (int i = 0; i < params.length; i++) {
                    if (i != 0)
                        System.out.print(", ");
                    System.out.print(params[i].getName());
                }
                System.out.println("]");
            }
        }
        System.out.println("----------------------------------------");

        //3.通过反射方式获取属性信息：
        System.out.println("\n=======3.通过反射方式获取属性信息=======\n");
        //使用getDeclaredFields()获取该类型中的全部属性，与属性的访问级别无关
        Field[] fields = cla.getDeclaredFields();
        for(int a=0;a<fields.length;a++){
            Field field=fields[a];
            System.out.println("\n第"+(a+1)+"个属性");
            System.out.println("属性名："+field.getName());
            System.out.println("类型："+field.getType().getName());
            int mod=field.getModifiers();
            System.out.print("访问修饰符：");
            // 判断该属性的访问修饰符
            if ((mod & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println("public");
            else if ((mod & Modifier.PROTECTED) == Modifier.PROTECTED)
                System.out.println("protected");
            else if ((mod & Modifier.PRIVATE) == Modifier.PRIVATE)
                System.out.println("private");
            else
                System.out.println("default(package)");
            // 判断该属性是否有static修饰符
            if ((mod & Modifier.STATIC) == Modifier.STATIC)
                System.out.println("这是一个静态属性");
            // 判断该属性是否有final修饰符
            if ((mod & Modifier.FINAL) == Modifier.FINAL)
                System.out.println("这是一个final属性");
        }
        System.out.println("----------------------------------");

        //4.通过反射方式获取方法信息：
        System.out.println("\n=========4.通过反射方式获取方法信息=========\n");
        //使用getDeclaredMethods()获取该实例中的全部方法，与方法的访问级别无关
        Method[] methods = Person.class.getDeclaredMethods();
        for(int b=0;b<methods.length;b++) {
            System.out.println("\n第" + (b + 1) + "个方法");
            Method m = methods[b];
            System.out.println("方法名：" + m.getName());
            //使用getReturnType()获取方法的返回值
            System.out.println("返回值：" + m.getReturnType().getName());
            System.out.println("参数列表：");
            Class[] params = m.getParameterTypes();
            if (params.length == 0) {
                System.out.println("该方法没有参数");
            } else {
                System.out.print("该方法的参数列表为：[");
                for (int i = 0; i < params.length; i++) {
                    if (i != 0)
                        System.out.print(", ");
                    System.out.print(params[i].getName());
                }
                System.out.println("]");
            }
            System.out.print("访问修饰符：");
            int mod = m.getModifiers();
            if ((mod & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println("public");
            else if ((mod & Modifier.PROTECTED) == Modifier.PROTECTED)
                System.out.println("protected");
            else if ((mod & Modifier.PRIVATE) == Modifier.PRIVATE)
                System.out.println("private");
            else
                System.out.println("default(package)");
            // 判断该方法是否有static修饰符
            if ((mod & Modifier.STATIC) == Modifier.STATIC)
                System.out.println("这是一个静态方法");
            // 判断该方法是否有final修饰符
            if ((mod & Modifier.FINAL) == Modifier.FINAL)
                System.out.println("这是一个final方法");
            // 判断该方法是否有abstract修饰符
            if ((mod & Modifier.ABSTRACT) == Modifier.ABSTRACT)
                System.out.println("这是一个抽象方法");
            // 判断该方法是否有synchronized修饰符
            if ((mod & Modifier.SYNCHRONIZED) == Modifier.SYNCHRONIZED)
                System.out.println("这是一个同步方法");

            // 获取方法所属的类或接口的Class实例
            Class declaringClass = m.getDeclaringClass();
            System.out.println("方法声明在：" + declaringClass.getName() + " 中");

            // 获取方法抛出的异常类型，即throws子句中声明的异常
            Class[] exceptions = m.getExceptionTypes();
            if (exceptions.length > 0) {
                System.out.print("该方法抛出的异常有：[");
                for (int i = 0; i < exceptions.length; i++) {
                    if (i != 0)
                        System.out.print(", ");
                    System.out.print(exceptions[i].getName());
                }
                System.out.println("]");

            }
        }
        System.out.println("-------------------------------------");
        //5.通过反射方式创建实例：
        System.out.println("\n======5.通过反射方式创建实例======\n");
        try {
            Class clz=Class.forName("com.entity.Person");
            //使用newInstance()方法获取对象实例，默认使用无参构造
            Object obj=clz.newInstance();
            System.out.println(obj);

            //通过无参构造实例化对象
            Constructor c1=clz.getDeclaredConstructor();
            obj=c1.newInstance();
            System.out.println(obj);

            // 通过一个参数的构造实例化
            Constructor c2 = clz.getDeclaredConstructor(String.class);
            // Person的单参构造为private，这里已超出其访问范围，不能直接访问
            // 通过setAccessable方法，设定为可以访问
            c2.setAccessible(true);
            obj = c2.newInstance("New Person");
            System.out.println(obj);

            // 通过三个参数的构造实例化
            Constructor c3 = clz.getDeclaredConstructor(String.class,String.class, String.class);
            // Person的三参构造为protected，这里已超出其访问范围，不能直接访问
            // 通过setAccessable方法，设定为可以访问
            c3.setAccessible(true);
            obj = c3.newInstance("New Person", "beijing", "Hello!");
            System.out.println(obj);
            System.out.println("----------------------------------------------");
            System.out.println("\n========6.通过反射方式访问属性=========\n");
            //6.通过反射方式访问属性：
            // 使用getDeclaredField(属性名)获取name属性
            Class person=Class.forName("com.entity.Person");
            Field name = person.getDeclaredField("name");
            obj=person.newInstance();
            // name属性为private，这里已超出其访问范围，不能直接访问
            // 通过setAccessable方法，设定为可以访问
            name.setAccessible(true);
            // 先取值看一下
            System.out.println("赋值前的name：" + name.get(obj));
            // 为name属性赋值
            name.set(obj, "New Person");
            // 展示一下赋值效果
            System.out.println("赋值后的name：" + name.get(obj));

            System.out.println("--------------------------------------");
            System.out.println("\n========7.通过反射方式调用方法=========\n");
            //7.通过反射方式调用方法：
            Class cls = Class.forName("com.entity.Person");
            // 根据方法名和参数列表获取static final int getAge()方法，没有参数可以不写或用null表示
            Method getAge = cls.getDeclaredMethod("getAge", null);
            //使用invoke(执行方法的对象，执行方法传入的参数)调用实例的方法
            Object returnAge = getAge.invoke(null, null);
            System.out.println("年龄是：" + returnAge);

            // 根据方法名和参数列表获取public void setName(String)方法
            Method setName = cls.getDeclaredMethod("setName", String.class);
            // setName方法为public，这里可以直接访问
            // 调用setName方法并传参
            setName.invoke(obj, "New Person");
            // 验证一下结果，调用public String getName()方法得到name的值
            Object returnName = cls.getDeclaredMethod("getName").invoke(obj);
            System.out.println("刚才设定的name是：" + returnName);
            System.out.println("---------------------------------------------");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
