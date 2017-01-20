import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;


public class webServiceClient {
//    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-client.xml");
//        HelloWorld helloWorld = ctx.getBean("hello", HelloWorld.class);
//        System.out.println("#############Client getUserByName##############");
//        User user = helloWorld.getUserInfo(1);
//        if (user != null) {
//            System.out.println(user.getAge() + "  " + user.getName());
//        } else {
//            System.out.println("无返回结果");
//        }
//    }
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        HelloWorldImplService hw = new HelloWorldImplService();
//        HelloWorld hi = hw.getHelloWorldImplPort();
//        User user = hi.getUserInfo(1);
//        if (user != null) {
//            System.out.println(user.getAge() + "  " + user.getName());
//        } else {
//            System.out.println("无返回结果");
//        }
//    }
    public static void main(String[] args) throws Exception {
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient("http://localhost:8080/helloService?wsdl");
        Object[] result = client.invoke("getUserInfo", 1);
        System.out.println(result[0]);
    }

}
