import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/1/17.
 */
//@XStreamAlias("Root")
public class xmlTest {
    private String name;

//    @XStreamOmitField  //javabean转xml时不解析
    private String hidden;

    public xmlTest(String name, String hidden) {
        this.name = name;
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }
    public static void main(String[] args) {
        String url = "http://api.map.baidu.com/geocoder/v2/?"
                + "address=" + "上海" //起点名称
                + "&city=" + "北京"//终点名称
                + "&output=json&ak=" + "qpH6Mrl4pRTWqtMQ3GQjyYYI";
        StringBuilder json = new StringBuilder();
        BufferedReader in = null;
        try {
            URL qurl = new URL(url);
            URLConnection yc = qurl.openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
        } catch (MalformedURLException e) {

        } catch (IOException e) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignored) {
                }
            }
        }
    }
}


