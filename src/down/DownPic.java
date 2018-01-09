package down;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


import cons.Constans;
import util.CxhUtil;
import view.ShowMessage;

/**
 * 图片下载类
 * @author 10864189 coax
 *
 */
public class DownPic {
	
	/**
	 * 网页源码获取
	 * @param uri 图片检索
	 * @return
	 * @throws IOException 
	 */
	public static String getHtml(String uri) throws IOException {
		
		URL url = new URL(uri);
		
		//打开输入流
		InputStream urlInStr = url.openStream();
		BufferedReader insBuRe = new BufferedReader(new InputStreamReader(urlInStr, "utf-8"));
		
		//读取源码存入StringBuilder
		StringBuilder buffereReaderStrBui = new StringBuilder();
		String str;
		
		while ((str = insBuRe.readLine()) != null) {
			buffereReaderStrBui.append(str);
		}
		urlInStr.close();
		return buffereReaderStrBui.toString();
		
	}
	
	/**
	 * 将HTML中的图片URL和标题存入返回Map
	 * @param html html源代码
	 * @return
	 * @throws Exception 
	 */
	public static Map<String,String> getUrl(String html) throws Exception{
		Matcher matcher = Pattern.compile(Constans.REGEX_HTMLIMG).matcher(html);
		Map<String,String> map = new HashMap<String,String>();
		while (matcher.find()) {
			String imgStr = matcher.group(0);
			String[] arr = CxhUtil.parseHtmlImgReturnAltAndSrc(imgStr);
			if(CxhUtil.isNotEmpty(arr) && arr.length>=2) {
				map.put(arr[0],arr[1]);
			}
		}
		return map;
	}
	
	/**
	 * 遍历Map 下载图片
	 * @param map
	 */
	public static void downLoad(Map<String, String> map) {
		Constans.downTotalCount = map.size();
		Thread[] threads = new Thread[map.size()];
		Set<Entry<String ,String>> set = map.entrySet();
		int i = 0;
		for (Entry<String,String> entry : set) {
			String alt = entry.getKey();
			String url = entry.getValue();
			threads[i] = new CopyThread(alt, url);
			threads[i].start();
			i++;
		}
		for (int j = 0; j < map.size(); j++ ) {
			try {
				threads[j].join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		ShowMessage ins = ShowMessage.getInstance();
		ins.showMessage("<html><body>发起请求："+Constans.downSuccessCount+"个<br/> 请求成功："+Constans.downSuccessCount+"个<br/> 请求失败："+Constans.downFailCount+"个</body></html>", "下载结果", JOptionPane.INFORMATION_MESSAGE);
		Constans.clearDownNum();
	}
	
	/**
	 * 单张图片下载
	 * @param alt 图片标题
	 * @param url 图片地址
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static void downOne(String alt ,String url) {
		
		
		//打开图片下载流
		InputStream inputS = null;
		OutputStream outputS = null;
		try {
			if(CxhUtil.isNotEmpty(url) && url.startsWith("http")) {
				inputS = new URL(url).openStream();
				//获取图片存储路径
				String fileOutPath = Constans.getMianView().textFilePath.getText();
				
				outputS = new FileOutputStream(fileOutPath + "/" +  alt + url.substring(url.length()-4));
				//复制图片
				int len;
				byte[] arr = new byte[1024];
				while ((len = inputS.read(arr)) != -1) {
					outputS.write(arr, 0, len);
				}
				Constans.downSuccessCount++;
			} else {
				Constans.downFailCount++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Constans.downFailCount++;
		} finally {
			try {
				if(inputS != null) {
					inputS.close();
				}
				if (outputS != null) {
					outputS.close();
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
