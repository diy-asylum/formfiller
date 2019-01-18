package com.diyasylum.encryption;

import com.diyasylum.encryption.models.EncryptedMessage;
import com.muquit.libsodiumjna.SodiumLibrary;
import com.muquit.libsodiumjna.exceptions.SodiumLibraryException;

public class SecretBox {
    private String password; 

    public SecretBox(String password) 
    { 
        LibsodiumLibrary.initialize();
        this.password = password; 
    } 

    public EncryptedMessage encrypt(String message) {
    	try {
    		byte[] salt = SodiumLibrary.randomBytes(SodiumLibrary.cryptoPwhashSaltBytes());
    		byte[] key = SodiumLibrary.cryptoPwhashArgon2i(password.getBytes(), salt);
    		byte[] nonce = SodiumLibrary.randomBytes(SodiumLibrary.cryptoBoxNonceBytes().intValue());
    		byte[] encryptedMessage = SodiumLibrary.cryptoSecretBoxEasy(message.getBytes(), nonce, key);
    		return new EncryptedMessage(encryptedMessage, salt, nonce);
    	} catch (SodiumLibraryException e){
    		System.out.println("Sodium failure");
      		e.printStackTrace();
      		return null;
    	}
    }

    public String decrypt(EncryptedMessage encryptedMessage) {
    	try{
    		byte[] key = SodiumLibrary.cryptoPwhashArgon2i(password.getBytes(), encryptedMessage.getSalt());
    		byte[] message = SodiumLibrary.cryptoSecretBoxOpenEasy(encryptedMessage.getEncryptedMessage(), encryptedMessage.getNonce(), key);
    		return new String(message);
    	} catch (SodiumLibraryException e) {
    		System.out.println("Sodium failure");
      		e.printStackTrace();
      		return null;
    	}
    }
}

class LibsodiumLibrary 
{ 
    private static boolean isInitialized = false; 
  
    private static void loadLibrary() 
    { 
    	String libraryPath = "/usr/local/lib/libsodium.so";
    	System.out.println("Loading libsodium");
    	System.out.println("Library path: " + libraryPath);
		SodiumLibrary.setLibraryPath(libraryPath);
		// To check the native library is actually loaded, print the version of 
		// native sodium library
		String v = SodiumLibrary.libsodiumVersionString();
		System.out.println("libsodium version: " + v); 
    } 
  
    public static void initialize() 
    { 
        if (!isInitialized) {
        	loadLibrary(); 
        	isInitialized = true;
        }
    } 
} 