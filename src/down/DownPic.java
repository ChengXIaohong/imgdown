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
 * ͼƬ������
 * @author 10864189 coax
 *
 */
public class DownPic {
	
	/**
	 * ��ҳԴ���ȡ
	 * @param uri ͼƬ����
	 * @return
	 * @throws IOException 
	 */
	public static String getHtml(String uri) throws IOException {
		
		URL url = new URL(uri);
		
		//��������
		InputStream urlInStr = url.openStream();
		BufferedReader insBuRe = new BufferedReader(new InputStreamReader(urlInStr, "utf-8"));
		
		//��ȡԴ�����StringBuilder
		StringBuilder buffereReaderStrBui = new StringBuilder();
		String str;
		
		while ((str = insBuRe.readLine()) != null) {
			buffereReaderStrBui.append(str);
		}
		urlInStr.close();
		return buffereReaderStrBui.toString();
		
	}
	
	/**
	 * ��HTML�е�ͼƬURL�ͱ�����뷵��Map
	 * @param html htmlԴ����
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
	 * ����Map ����ͼƬ
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
		ins.showMessage("<html><body>��������"+Constans.downSuccessCount+"��<br/> ����ɹ���"+Constans.downSuccessCount+"��<br/> ����ʧ�ܣ�"+Constans.downFailCount+"��</body></html>", "���ؽ��", JOptionPane.INFORMATION_MESSAGE);
		Constans.clearDownNum();
	}
	
	/**
	 * ����ͼƬ����
	 * @param alt ͼƬ����
	 * @param url ͼƬ��ַ
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static void downOne(String alt ,String url) {
		
		
		//��ͼƬ������
		InputStream inputS = null;
		OutputStream outputS = null;
		try {
			if(CxhUtil.isNotEmpty(url) && url.startsWith("http")) {
				inputS = new URL(url).openStream();
				//��ȡͼƬ�洢·��
				String fileOutPath = Constans.getMianView().textFilePath.getText();
				
				outputS = new FileOutputStream(fileOutPath + "/" +  alt + url.substring(url.length()-4));
				//����ͼƬ
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
