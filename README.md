#Get Started Struts2 using xml configuration#

##Configuration##
1.register StrutsPrepareAndExecuteFilter in [web.xml](src/main/webapp/WEB-INF/web.xml)
```xml
<filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

2.create [struts.xml ](src/main/resources/struts.xml) in classpath root and config action mappings.
```xml
<package name="struts2" extends="struts-default,json-default"  >
    <action name="">
        <result type="dispatcher">/index.jsp</result>
    </action>
    <action name="echo" class="com.selonj.actions.EchoAction">
        <result name="*" type="json"/>
    </action>
</package>
```

3.add json capabilities by add struts-json-plugin-xx.jar in [build.gradle](build.gradle)
```groovy
compile 'org.apache.struts:struts2-json-plugin:2.2.3'
```

##Problems##
- You can't put *struts.xml* into WEB-INF because org.apache.struts2.config.StrutsXmlConfigurationProvider load configuration files from classpath.
- You can add &lt;action name=""&gt; to mapping home page,but you must set *struts.action.extension*=",". 