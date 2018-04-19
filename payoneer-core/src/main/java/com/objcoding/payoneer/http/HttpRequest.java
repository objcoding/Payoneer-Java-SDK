package com.objcoding.payoneer.http;

import com.objcoding.payoneer.model.enums.CharsetType;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http 请求
 * <p>
 * Auth: zch
 * Email: zhangchenghui.dev@gmail.com
 * Date: 2018/4/20.
 */
public class HttpRequest {

    /**
     * get 请求
     */
    public static String getRequest(String strUrl, String basicAuthCode) {
        InputStream in = null;
        BufferedReader br = null;
        try {
            URL url = new URL(strUrl.trim());
            //打开连接
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 设置 basic auth 请求头
            httpURLConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Basic " + basicAuthCode);
            httpURLConnection.setRequestMethod(HttpMethod.GET.name());

            if (200 == httpURLConnection.getResponseCode()) {
                //得到输入流
                in = httpURLConnection.getInputStream();
                // 装饰成缓冲流
                br = new BufferedReader(new InputStreamReader(in, CharsetType.UTF8.getName()));
                final StringBuilder sb = new StringBuilder();
                // 读取
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * post 请求
     */
    public static String postRequest(String strUrl, String basicAuthCode, String reqBody) {
        InputStream in = null;
        OutputStream out = null;
        BufferedReader br = null;
        try {
            URL httpUrl = new URL(strUrl.trim());
            HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(HttpMethod.POST.name());
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            // 设置 basic auth 请求头
            httpURLConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Basic " + basicAuthCode);
            httpURLConnection.setRequestMethod(HttpMethod.POST.name());

            httpURLConnection.connect();
            out = httpURLConnection.getOutputStream();
            out.write(reqBody.getBytes(CharsetType.UTF8.getName()));
            // flush输出流的缓冲
            out.flush();

            // 开始获取内容
            in = httpURLConnection.getInputStream();
            br = new BufferedReader(new InputStreamReader(in, CharsetType.UTF8.getName()));
            final StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
