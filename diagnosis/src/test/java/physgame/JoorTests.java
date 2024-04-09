package physgame;

import org.joor.Reflect;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class JoorTests {

    @Test
    public void test() {

        final String script = """
                package com.example;

                class HelloWorld implements java.util.function.Supplier<String> {
                    public String get() {
                        return "Hello World!";
                    }
                }
                """;

        // todo 编译时name添加version, 这样从数据库获取的脚本如果发生过变更这里可以使用最新的脚本.
        final Supplier<String> supplier = Reflect.compile(
                "com.example.HelloWorld",
                script).create().get();

        // Prints "Hello World!"
        System.out.println(supplier.get());
    }
}
