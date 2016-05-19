import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
  
public class JSONReadFromFile {
	public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException {
		String site="www.futurepowerpc.com";
		String key="5792-\u0095\u00a0IP Cameras";
		System.out.println(urlList(PropertiesFile.getFile(),site,key));
	}
    public static List<String> urlList(String file, String siteurl, String key){
    	JSONParser parser = new JSONParser();
    	List<String> sites=new ArrayList<String>();
        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject site = (JSONObject)jsonObject.get(siteurl);     
//            key = key.replaceAll(" ", "\\u00a0");
            JSONArray links = (JSONArray)site.get(key);
			Iterator<String> iterator = links.iterator();
            while (iterator.hasNext()) {
                //System.out.println(iterator.next());
                sites.add(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return sites;
    }
}