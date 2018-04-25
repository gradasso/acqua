package com.acqua.constants;



/**
 * Centralized constants only for security configurations
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class SecurityConstants {
	
	
	
	/**
	 * The secret key for generate jwt token
	 */
	public static final String SECRET = "SecretKeyToGenJWTs";
	
	
	
	/**
	 * The expiration time of token
	 */
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	
	
	
	/**
	 * Token prefix in the header
	 */
	public static final String TOKEN_PREFIX = "Bearer ";
	
	
	
	/**
	 * Header key for retrieve token
	 */
	public static final String HEADER_STRING = "Authorization";
	
	
	
	/**
	 * URL to do a login requests
	 */
	public static final String SIGN_UP_URL = ApiConstants.API_V1_USER+PathConstants.CREATE;

}
