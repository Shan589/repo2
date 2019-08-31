package com.hhit.springmvc.handlers;

import com.hhit.springmvc.entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.SimpleLog;
import org.springframework.http.HttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;
//@SessionAttributes
@RequestMapping("/springock")
@Controller
public class HelloWorld {
    private static final String SUCCESS = "success";

    //重定向。redrect重定向到根目录下的index.jsp
    //直接请求转发(Forward)和间接请求转发(Redirect)
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("TestRedirect");
        // return "redirect:/index.jsp";
        return "forward:/index.jsp";
    }
    @RequestMapping("/testView")
    public String testView(){
        System.out.println("--------->testView");
        return "helloView";
    }
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id, Map<String,Object> map){
        if (id!=null){
            //模拟从数据库获取对象
            User user = new User(1001,"TOM","a123456","2056@qq.com",46);
            System.out.println("从数据库中获取一个对象 " + user);
            map.put("user",user);
        }
    }
    /*运行流程：
     * 1.执行@ModelAttribute注解修饰的方法：·从数据库中取出对象，把对象放入到Map中。键为user
     * 2.SpringMVC从Map中取出User对象，并把表单的请求参数赋给该User对象的对应属性
     * 3 SpringMVC把上述对象传入到目标方法的参数中
     */
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改：" + ">>>" + user);
        return SUCCESS;
    }
    @RequestMapping("/testmodelandview")
    public ModelAndView testModelView(){
        String ViewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(ViewName);
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }
    //使用原生的ServletAPI
    @RequestMapping("/testservletapi")
    public void testServeletAPI(HttpServletRequest request, HttpServletResponse response, Writer writer) throws IOException {
        System.out.println("testServletAPI: " + request + "," + response + writer);
        writer.write("hello , spring");
    }

    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println(user);
        return SUCCESS;
    }
    @RequestMapping("/testCookieparam")
    public String testCookieparam(@CookieValue(value = "JSESSIONID") String sessionid){
        System.out.println("SessionId为： " + sessionid);
        return SUCCESS;
    }

    @RequestMapping("/requestparam")
    //required = false可以设置该项可为空
    public String RequestParamTest(@RequestParam("username") String un,
                                   @RequestParam(value = "age", required = false) Integer age){
        System.out.println("username:" + un + ",age: " + age);
        return SUCCESS;
    }
    /*
    /1.使用 @RequestMapping注解来映射请求的URL
     2. 返回值会通过视图解析器解析为实际物理视图，对于InternalResourceViewResolver视图
        通过prefix + resultVal + 后缀 这样的方式的得到物理视图，然后跳转发操作
     tip:  @RequestMapping注解不仅能够修饰方法，也能够修饰类
          ①类定义处:提供初步的请求映射信息。相当于WEB-INF的根目录..error:根目录的前面是不需要加“/”的
          ②方法定义处:提供进一步的细分映射信息，相当于类定义处的URL。
             若类定义处未使用@RequestMapping注解，则该方法定义处相当于根目录

     */
    @RequestMapping("/helloworld")
    public String HelloWorld(){
        System.out.println("Hello World>>>>>>");
        new SimpleLog("comming");
        return SUCCESS;
    }

    //使用Method指定请求方式 ;
    @RequestMapping(value = "/testmethod",method = RequestMethod.POST)
    public String testMethod(){
        new SimpleLog("postTest");
        return SUCCESS;
    }
    //使用@PathVariable可以映射URL中的占位符到目标方法的参数中。进而支持rest风格的URL
    @RequestMapping(value = "pathvariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("PathVariable : " + id);
        return SUCCESS;
    }
    /*
    * Rest风格的URL
    * 以CRUD为例：           Ant风格：
    * 新增: /order POST
    * 修改: /order/1 PUT     update?id=1
    * 获取: /order/1 GET     get?id=1
    * 删除: /order/1 DELETE   delete?id=1
    *
    * 如何发送PUT跟DELETE请求：
    * 1.需要配置HiddenHttpMethodFilter
    * 2.需要发送POST请求
    * 3.需要在发送POST请求时携带一个name="_method"的隐藏域，值为DELETE或是PUT
    * */
    @RequestMapping(value = "hmethodpost",method = RequestMethod.POST)
    public String HiddengMethodPost(){
        System.out.println("HiddengMethodPost: >>>>");
        return SUCCESS;
    }

    @RequestMapping(value = "hmethodget/{id}",method = RequestMethod.GET)
    public String HiddengMethodGet(@PathVariable("id") Integer id){
        System.out.println("HiddengMethodGet: >>>>" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "hmethodput",method = RequestMethod.PUT)
    public String HiddengMethodPut(){
        System.out.println("HiddengMethodPut: >>>>");
        return SUCCESS;
    }

    @RequestMapping(value = "hmethoddelete",method = RequestMethod.DELETE)
    public String HiddengMethodDelete(){
        System.out.println("HiddengMethodDelete: >>>>");
        return SUCCESS;
    }

}
