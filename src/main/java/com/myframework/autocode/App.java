package com.myframework.autocode;

import com.myframework.autocode.generator.GeneratorJava;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    /**
     * 说明：
     * 配置  com.myframework.autocode.config.Config类   修改 DB_TABLES
     * OUTPUT_PACKAGE
     * MODULE_NAME
     * 然后运行  com.myframework.autocode.generator.GeneratorJava
     * 的main方法 就可以生成 mybatis相关的类文件
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, TemplateException {
        System.out.println("////////////////////////////////////////////////////////////////////  \n" +
                "//                          _ooOoo_                               //  \n" +
                "//                         o8888888o                              //      \n" +
                "//                         88\" . \"88                              //      \n" +
                "//                         (| ^_^ |)                              //      \n" +
                "//                         O\\  =  /O                              //  \n" +
                "//                      ____/`---'\\____                           //                          \n" +
                "//                    .'  \\\\|     |//  `.                         //  \n" +
                "//                   /  \\\\|||  :  |||//  \\                        //      \n" +
                "//                  /  _||||| -:- |||||-  \\                       //  \n" +
                "//                  |   | \\\\\\  -  /// |   |                       //  \n" +
                "//                  | \\_|  ''\\---/''  |   |                       //          \n" +
                "//                  \\  .-\\__  `-`  ___/-. /                       //          \n" +
                "//                ___`. .'  /--.--\\  `. . ___                     //      \n" +
                "//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //  \n" +
                "//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //      \n" +
                "//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //  \n" +
                "//      ========`-.____`-.___\\_____/___.-`____.-'========         //      \n" +
                "//                           `=---='                              //  \n" +
                "//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //  \n" +
                "//         佛祖保佑       永无BUG     永不修改                  //  \n" +
                "////////////////////////////////////////////////////////////////////");
        GeneratorJava.autocode();
    }
}
