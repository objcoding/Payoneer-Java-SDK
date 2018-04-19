package com.objcoding.payoneer.utils;

import java.util.Map;

/**
 * URL表达式处理器
 *
 * @author: egan
 * <pre>
 * email egzosn@gmail.com
 * date 2017/3/5 10:07
 * </pre>
 */
public class UriVariables {

   /**
    * 依次匹配
    * @param uri 匹配的uri，带代表式
    * @param uriVariables 匹配表达式的值
    * @return 匹配完的url
    * <code>
    *     System.out.println(getUri(&quot;http://egan.in/{a}/ba/{a1}?{bb}={a1}&quot;, &quot;no1&quot;, &quot;no2&quot;, &quot;no3&quot;, &quot;no4&quot;));
    *    结果 http://egan.in/no1/ba/no2?no3=no4
    * </code>
    *
    */
   public static String getUri(String uri, Object... uriVariables) {

       if (null == uriVariables){
           return uri;
       }
       for (Object variable : uriVariables){
           if (null == variable){
               continue;
           }
           uri = uri.replaceFirst("\\{\\w+\\}", variable.toString());
       }
       return uri;
   }

   /**
    * 匹配Map.key
    * @param uri 匹配的uri，带代表式
    * @param uriVariables 匹配表达式的值
    * @return 匹配完的url
    * <code>
    *      Map&lt;String, Object&gt;  uriVariable = new HashMap&lt;String, Object&gt;();
    *      uriVariable.put(&quot;a&quot;, &quot;no1&quot;);
    *      uriVariable.put(&quot;a1&quot;, &quot;no2&quot;);
    *      uriVariable.put(&quot;bb&quot;, &quot;no3&quot;);
    *      System.out.println(getUri(&quot;http://egan.in/{a}/ba/{a1}?{bb}={a1}&quot;, uriVariable));
    *      结果 http://egan.in/no1/ba/no2?no3=no2
    * </code>
    */
   public static String getUri(String uri, Map<String, Object> uriVariables) {

       if (null == uriVariables){
           return uri;
       }
       for (String key : uriVariables.keySet()){
           Object uriVariable = uriVariables.get(key);
           if (null == uriVariable){
               continue;
           }

           uri = uri.replace("{" + key + "}", uriVariable.toString());
       }
       return uri;
   }

}
