/*
 * @author umer-wn
 */
package org.group11.Patterns.serviceLocator;


import org.group11.Tools.Input;

//将这里的example改为你的服务对象类名
public class example implements Service{
    @Override
    //将这里的example改为你的服务名
    public String getName() {
        return "xxxx";
    }

    @Override
    //这里的参数即是在mainInterface中调用serviceLocator.execute(args)时传入的参数
    public void execute(String... args) {
        //这里实现你的服务逻辑
        //各设计模式的实现需要在pattern下的文件夹中实现
        //使用则直接通过import调用
        //任何的输入内容通过  String input= Input.getInput()读取
        //对数据库的操作可以参考DAO模式下的UserPasswordImpl和UserPasswordMapper文件
        //接下来转到上面两个文件中讲解数据库的操作
    }
}
