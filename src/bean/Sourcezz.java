package bean;

 /**
  * 爬图网站支持对象
 *2018年2月1日 上午11:12:12
 *author coax only3bit@sina.cn
 *Description
 **/
public class Sourcezz {
	
	/**
	 * 顺序标识
	 */
	private int iden;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 网址
	 */
	private String url;
	
	/**
	 * ip地址 ipv4
	 */
	private String ipv4;
	
	/**
	 * ip地址 ipv6
	 */
	private String ipv6;
	
	public Sourcezz() {}
	
	public Sourcezz(int iden, String name, String url, String ipv4, String ipv6) {
		super();
		this.iden = iden;
		this.name = name;
		this.url = url;
		this.ipv4 = ipv4;
		this.ipv6 = ipv6;
	}

	public Sourcezz(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public int getIden() {
		return iden;
	}

	public void setIden(int iden) {
		this.iden = iden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public String getIpv6() {
		return ipv6;
	}

	public void setIpv6(String ipv6) {
		this.ipv6 = ipv6;
	}
	
	
}

