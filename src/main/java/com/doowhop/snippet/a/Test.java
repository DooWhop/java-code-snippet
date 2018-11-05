package com.doowhop.snippet.a;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.doowhop.snippet.domain.Domain;


public class Test {
	
/*	public static void main(String[] args) {
//		BigDecimal bg = new BigDecimal("9200.00").multiply(new BigDecimal("0.012345"));
//		System.out.println(bg);
		BigDecimal bg1 =  new BigDecimal("9200.00").multiply(new BigDecimal("0.012345")).setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(bg1);
		
		MathContext mc = new MathContext(2,RoundingMode.HALF_UP);
		BigDecimal bg2 = new BigDecimal("9200.00").multiply(new BigDecimal("0.012345"), mc);
		System.out.println(bg2);
		
		BigDecimal decimal = new BigDecimal("1.12545");
        System.out.println(decimal);       
        BigDecimal setScale1 = decimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);
		
		String mm = "06M";
		Object oo = 1;
		
		System.out.println(Integer.parseInt(mm.substring(0, 2)));
	}*/

		 
	 /* public static void main(String [] args) {
		    String MESSAGE="taobao";
		    String a ="tao"+"bao"; 
		    String b="tao";
		    String c="bao";
		    final  String e =  "tao" ;
	        final  String f =  "bao" ;	
		    System.out.println(a==MESSAGE);
		    System.out.println((b+c)==MESSAGE);
		    System.out.println(a.intern()==MESSAGE);
		    System.out.println((b+c).intern()==MESSAGE);
		    System.out.println(a.equals(MESSAGE));
		    System.out.println((b+c).equals(MESSAGE));           
	        System. out .println((e+f)== MESSAGE );
		  Domain dom = new Domain();
		  dom.setId(123);
		  dom.setCode("mmmmmmmm");
		  try {
			method(dom);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }*/
	
	/*public static void method(Object obj) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	     Class<? extends Object> clazz = obj.getClass();
	     
	     Field[] fields = clazz.getDeclaredFields();//获得属性
	   for (Field field : fields) {
		   System.out.println(field.getName());
	   
	    PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
	      clazz);
	    Method getMethod = pd.getReadMethod();//获得get方法
	    Object o = getMethod.invoke(obj);//执行get方法返回一个Object
	    System.out.println("==="+o);
	    }
	}
	
	
	
	public static void decode(String base64, String name) throws IOException {
	
			byte[] fileBytes;	
			//1.1 解码文件base64
			fileBytes = Base64Utils.decodeFromString(base64);		
		    //1.2上传到云存储
			//InputStream is = new ByteArrayInputStream(fileBytes);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\liudp\\Desktop\\TEST\\"+name); 
			fos.write(fileBytes);
			fos.close();
	}
	
	public static void main(String[] args) throws IOException {
		String name = "p1.jpeg";	
		String base64 = "data:image/png;base64,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";
		Pattern pattern = Pattern.compile("data:image/(\\w+);base64,");
		Matcher matcher = pattern.matcher(base64);
		if(matcher.find()) {
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
		}
		BigDecimal a = new BigDecimal("-123.11");
		BigDecimal b = new BigDecimal("123.11");
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(a.toEngineeringString());
		System.out.println(b.toEngineeringString());
		System.out.println(a.toPlainString());
		System.out.println(b.toPlainString());
	}*/
	
	public static void main(String[] args) {
		
		String retDataStr = "{\"formContent\":\"<form id = \"sform\" action=\"https://gateway.95516.com/crfront/api/Verify.action\" method=\"post\"><input type='hidden' name='version' id='version' value='1.0.0'/><input type='hidden' name='charset' id='charset' value='GBK'/><input type='hidden' name='certorgcode' id='certorgcode' value='0000000001'/><input type='hidden' name='receiveorgcode' id='receiveorgcode' value='1000000001'/><input type='hidden' name='encrypmethod' id='encrypmethod' value='RSA'/><input type='hidden' name='encrypmessage' id='encrypmessage' value='6536ece4db364555f26935560122dfd3190e4abfddc388439ac6399f8066cc90dc66c34d8c1bed865045c8f16fb06b64de183154658df9fb6869a675c688eb0dab3f9a7bca3184aca891cebeb32701ac7410eb4e21e9d78c956c05c2a940868850de5270a9c33a4af7af65867e41eab71ece34974b58cea988f3235d414d441a10a18298a25f68c2e3ad241298aef623414d679405d641a3651608c5ed40d8d22645363ba3ea77195573319a5fa4c35ee5a7c97542e5bef2ff348c94e4343da2269d6476e53f36151925395c453e34d65cc9d186320c62fd988fd64170bce4bae9980d78444bb9cf06d3749f86eabee0527fe59ef1a62dc4165d4ab543c46981'/><input type='hidden' name='signmethod' id='signmethod' value='RSA'/><input type='hidden' name='signmessage' id='signmessage' value='f7f74d04c0d2c48c9ec7b1dced12a9ac2e57ea6a36043264ec0cb6a6f804a73f3bc82fe52fa8238ed6bfca86796657bf7cc37e7ec204db13516ff430d0c75ddae799d44a14693213fbc8a5fa255d656b3301d1c81159d1696319bd362d1762ab906348ee5b9af0874e8552f00713f7cb6b2ae379e3eac273e619d29ecc744cadd994af40eb1ee4a86083269f415e866ba1dd854b2899df315b20b5d6fc12847a4d0d54e52c06792e74a66afe3f6271938846126998c22c0298ff1fb4895522a5b040a7e785d8816c4b46301da49be941ab51fa10910e542a9072c42dbcf015a61df0c01d911802451f24df6c74703da2a721dd06554a3898065ef5f986277b40'/></form></body><script type=\"text/javascript\">document.all.sform.submit();</script>\"}";
		String ret = "{\"formContent\":\"<form id = \\\"sform\\\" action=\\\"https://gateway.95516.com/crfront/api/Verify.action\\\" method=\\\"post\\\"><input type='hidden' name='version' id='version' value='1.0.0'/><input type='hidden' name='charset' id='charset' value='GBK'/><input type='hidden' name='certorgcode' id='certorgcode' value='0000000001'/><input type='hidden' name='receiveorgcode' id='receiveorgcode' value='1000000001'/><input type='hidden' name='encrypmethod' id='encrypmethod' value='RSA'/><input type='hidden' name='encrypmessage' id='encrypmessage' value='6536ece4db364555f26935560122dfd3190e4abfddc388439ac6399f8066cc90dc66c34d8c1bed865045c8f16fb06b64de183154658df9fb6869a675c688eb0dab3f9a7bca3184aca891cebeb32701ac7410eb4e21e9d78c956c05c2a940868850de5270a9c33a4af7af65867e41eab71ece34974b58cea988f3235d414d441a10a18298a25f68c2e3ad241298aef623414d679405d641a3651608c5ed40d8d22645363ba3ea77195573319a5fa4c35ee5a7c97542e5bef2ff348c94e4343da2269d6476e53f36151925395c453e34d65cc9d186320c62fd988fd64170bce4bae9980d78444bb9cf06d3749f86eabee0527fe59ef1a62dc4165d4ab543c46981'/><input type='hidden' name='signmethod' id='signmethod' value='RSA'/><input type='hidden' name='signmessage' id='signmessage' value='f7f74d04c0d2c48c9ec7b1dced12a9ac2e57ea6a36043264ec0cb6a6f804a73f3bc82fe52fa8238ed6bfca86796657bf7cc37e7ec204db13516ff430d0c75ddae799d44a14693213fbc8a5fa255d656b3301d1c81159d1696319bd362d1762ab906348ee5b9af0874e8552f00713f7cb6b2ae379e3eac273e619d29ecc744cadd994af40eb1ee4a86083269f415e866ba1dd854b2899df315b20b5d6fc12847a4d0d54e52c06792e74a66afe3f6271938846126998c22c0298ff1fb4895522a5b040a7e785d8816c4b46301da49be941ab51fa10910e542a9072c42dbcf015a61df0c01d911802451f24df6c74703da2a721dd06554a3898065ef5f986277b40'/></form></body><script type=\\\"text/javascript\\\">document.all.sform.submit();</script>\\\"}";
/*		System.out.println(ret.replace("\\", ""));
		JSONObject retData = JSONObject.parseObject(ret.replace("\\", ""));
		System.out.println(retData);
		String formContent = retData.getJSONObject("RetData").getString("formContent");
		System.out.println(formContent);*/
		Pattern pattern = Pattern.compile("<form.*?<\\/form>");
		Matcher matcher = pattern.matcher(ret);
		if(matcher.find()) {
			System.out.println(matcher.group(0));
		}
	}

}
