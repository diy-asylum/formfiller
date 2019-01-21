package com.diyasylum.encryption.serializers;

import com.diyasylum.encryption.models.EncryptedMessage;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class EncryptedMessageSerializer {

  private static Base64 base64 = new Base64();

  public static class EncryptedMessageJsonSerializer extends JsonSerializer<EncryptedMessage> {

    @Override
    public void serialize(
        EncryptedMessage message,
        JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider)
        throws IOException, JsonProcessingException {

      jsonGenerator.writeStartObject();
      jsonGenerator.writeStringField(
          "encryptedMessage", base64.encodeBase64String(message.getEncryptedMessage()));
      jsonGenerator.writeStringField("salt", base64.encodeBase64String(message.getSalt()));
      jsonGenerator.writeStringField("nonce", base64.encodeBase64String(message.getNonce()));
      jsonGenerator.writeEndObject();
    }
  }

  public static class EncryptedMessageJsonDeserializer extends JsonDeserializer<EncryptedMessage> {

    @Override
    public EncryptedMessage deserialize(
        JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {
      TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
      byte[] encryptedMessage =
          base64.decodeBase64(((TextNode) treeNode.get("encryptedMessage")).asText());
      byte[] salt = base64.decodeBase64(((TextNode) treeNode.get("salt")).asText());
      byte[] nonce = base64.decodeBase64(((TextNode) treeNode.get("nonce")).asText());
      return new EncryptedMessage(encryptedMessage, salt, nonce);
    }
  }
}
