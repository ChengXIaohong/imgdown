package down;


/**
 * 图片下载线程类
 * @author 10864189 coax
 *
 */
public class CopyThread extends Thread{
	
	String alt;
	String url;
	
	public CopyThread(String alt, String url) {
		super();
		this.alt = alt;
		this.url = url;
	}

	@Override
	public void run() {
		DownPic.downOne(alt, url);
	}

}
