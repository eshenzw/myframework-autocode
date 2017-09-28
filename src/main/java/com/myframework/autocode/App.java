package com.myframework.autocode;

import com.myframework.autocode.config.XmlConfig;
import com.myframework.autocode.generator.GeneratorJava;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    /**
     * 说明：
     * 配置  resources 下  autocode.xml文件
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
        for(int i=0;i<args.length;i++){
            if("--configfile".equals(args[i])){
                if(i<args.length-1 && args[i+1] != null && args[i+1] != ""){
                    System.out.println("加载配置文件："+args[1]);
                    XmlConfig.loadXml(args[1]);
                    GeneratorJava.autocode();
                }else{
                    System.out.println("加载配置文件失败. try with --help");
                }
            }else if("--help".equals(args[i])){
                System.out.println("usage with --configfile autocode.xml");
            }
        }
    }
}
