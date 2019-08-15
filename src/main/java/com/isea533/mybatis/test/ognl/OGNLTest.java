package com.isea533.mybatis.test.ognl;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.apache.ibatis.scripting.xmltags.OgnlClassResolver;

import java.util.Arrays;

public class OGNLTest {

    public static void main(String[] args) throws OgnlException {

        Dog dog = new Dog("二少爷", "柴犬");
        Person rose = new Person("rose", "123456", dog);

        OgnlContext context = new OgnlContext();
        context.put("rose", rose);
        context.setRoot(rose);

        Cat cat = new Cat("布偶");
        rose.setCats(Arrays.asList(cat));

        Dog haqi = new Dog("哈奇", "秋田");
        context.put("dog", haqi);

        Object value = Ognl.getValue(Ognl.parseExpression("dog"), context, context.getRoot());
        System.out.println(value.toString());

        Object dogName = Ognl.getValue(Ognl.parseExpression("#dog.name"), context, context.getRoot());
        System.out.println(dogName);

        dogName = Ognl.getValue("#rose.dog.name", context, context.getRoot());
        System.out.println(dogName);

        Ognl.getValue(Ognl.parseExpression("@com.isea533.mybatis.test.ognl.Person@staticMethod()"), context, context.getRoot());

        value = Ognl.getValue("getUsername()", context, context.getRoot());
        System.out.println(value);

        value = Ognl.getValue("dog.getName()", context, context.getRoot());
        System.out.println(value);

        value = Ognl.getValue("cats[0]", context, context.getRoot());
        System.out.println(value.toString());

        String a = "rose";
//        System.out.println(Ognl.getValue(Ognl.parseExpression("a != null and a != ''"), ognl.Ognl.createDefaultContext(a, new OgnlClassResolver()), context.getRoot()));

    }
}
