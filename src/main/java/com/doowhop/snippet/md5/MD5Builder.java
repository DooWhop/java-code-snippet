package com.doowhop.snippet.md5;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
 
 
public class MD5Builder {
 
	public static String build(String origin ,String charsetName){
		if(origin == null )
			return null ;
		
		StringBuilder sb = new StringBuilder() ;
		MessageDigest digest = null ;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null ;
		}
		
		//生成一组length=16的byte数组
		byte[] bs = digest.digest(origin.getBytes(Charset.forName(charsetName))) ;
		
		for (int i = 0; i < bs.length; i++) {
			int c = bs[i] & 0xFF ; //byte转int为了不丢失符号位， 所以&0xFF
			if(c < 16){ //如果c小于16，就说明，可以只用1位16进制来表示， 那么在前面补一个0
				sb.append("0");
			}
			sb.append(Integer.toHexString(c)) ;
		}
		return sb.toString() ;
	}
	
	public static String uuid() {
			UUID uuid=UUID.randomUUID();
		    String str = uuid.toString();
		    return str.replace("-", ""); 
	}
	
	public static void main(String[] args) {
		
		//String str = MD5Builder.build("1", "UTF-8") ;
		
		//System.out.println(str);//结果：  3cb95cfbe1035bce8c448fcaf80fe7d9
		System.out.println(uuid());
		  
	}
 
}









