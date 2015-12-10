# 使用jdk自带JWS发布webservice

## 服务器端:
- 对于最新的标准jws2.2，只需要在实现类上面加一个注解即可: @Webservice，老版本(jdk1.6.0_21前)需要写的很复杂。
- 发布webservice，很简单:
```java
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/test", new BusinessImpl());
	}
```
此时在浏览器输入http://localhost:8080/test?wsdl即可看到此服务的wsdl文件

## 客户端:
- 使用jdk自带的wsimport工具，即可生成客户端代码: 命令`wsimport -keep http://localhost:8080/test?wsdl`，选项keep的意思是
生成源码，你也可以选择直接生成class文件。注意生成的文件在包`webservice`下。
- 编写自己的客户端调用代码，比如建一个类，Client:
```java
	package webservice;
	public class Client {
		public static void main(String[] args) {
			BusinessImplService service = new BusinessImplService();
			BusinessImpl business = service.getBusinessImplPort();
			System.out.println(business.echo("I am client."));
		}
	}
```
里面用到的几个类都是wsimport自动生成的，运行即可看到效果了。
