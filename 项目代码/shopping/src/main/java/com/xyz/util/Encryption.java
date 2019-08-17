package com.xyz.util;

import java.security.MessageDigest;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;

import com.xyz.domain.UserBase;


public class Encryption {
	 private static final MessageDigest md;  
	 private static final Base64  b64Encoder;  
	 private static final Integer saltLen = 15; 
	    
	    
	 static{  
	      try {  
	          md = MessageDigest.getInstance("MD5", "SUN");  
	          b64Encoder = new Base64();  
	      } catch (Exception e) {  
	          throw new RuntimeException(e);  
	      }  
	  } 

	  public static void  encryptPasswd(UserBase user){  
		  String salt = "";
	      Random rand = new Random();
	      String base = "abcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*()_+";
	    	
		  for (int i = 0; i < saltLen; i++) {
			  String target = String.valueOf(base.charAt(rand.nextInt(base.length())));
			  salt+=target;
		  }
	    	
	      try{              
	          md.reset(); 
	          String passwordSalt = user.getPassword()+salt;
	          md.update(passwordSalt.getBytes("UTF-8"));  
	          byte[] bys = md.digest();
	          byte[] lastPassword = b64Encoder.encode(bys);           
	          user.setPassword(new String(lastPassword));
	          user.setSalt(salt); 
	      }catch(Exception ex){  
	          ex.printStackTrace();   
	      }  
	  }    
	    
	  public static boolean  checkPassword(UserBase user, String submitPassword){      	
		  try{              
	          md.reset(); 
	          String passwordSalt = submitPassword+user.getSalt();
	          //调用update方法来完成 向MessageDigest对象提供要计算的数据。
	          md.update(passwordSalt.getBytes("UTF-8"));  
	          //调用 digest（）方法来计算摘要（即生成散列码）：
	          byte[] bys = md.digest();
	          //b64Encoder编码 为可见字符
	          byte[] lastPassword = b64Encoder.encode(bys);    
	          //将byte数组转换为字符串
	          submitPassword = new String(lastPassword);
	          //比较两个摘要的相等性
	          System.out.println(submitPassword);
	          if(submitPassword.equals(user.getPassword()))
	          	  return true;
	          else 
	        	  return false;  
	        }catch(Exception ex){  
	            ex.printStackTrace(); 
	            return false;
	        }                 
	  }
}
