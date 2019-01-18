package com.diyasylum.encryption;

import picocli.CommandLine;
import com.diyasylum.encryption.models.EncryptedMessage;
import com.diyasylum.encryption.SecretBox;

@CommandLine.Command(name = "Encrypt string", mixinStandardHelpOptions = true)
public class EncryptCli implements Runnable {

  public void run() {
    SecretBox box = new SecretBox("password");
    EncryptedMessage secret = box.encrypt("don't tell");
    String message = box.decrypt(secret);
    System.out.println(message);
    SecretBox box2 = new SecretBox("WRONG");
    String fail = box2.decrypt(secret);
    System.out.println(fail);
    System.out.println("Success");
  }

  public static void main(String[] args) {
    CommandLine.run(new EncryptCli(), args);
  }
}