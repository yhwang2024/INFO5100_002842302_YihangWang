import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class Main {
    private static final String SYMMETRIC_CIPHER = "AES/GCM/NoPadding";
    private static final String ASYMMETRIC_CIPHER = "RSA/ECB/PKCS1Padding";
    private static final int AES_KEY_SIZE = 256;
    private static final int GCM_TAG_LENGTH = 128;
    private static final int RSA_KEY_SIZE = 2048;

    public static void main(String[] args) throws Exception {
        // Generate RSA key pairs for Alice and Bob
        KeyPair aliceKeyPair = generateRSAKeyPair();
        KeyPair bobKeyPair = generateRSAKeyPair();

        // Generate AES key
        SecretKey aesKey = generateAESKey();

        // Symmetric Encryption and Decryption
        String secretMessage = "Hello, this is a secret!";
        byte[] iv = new byte[12]; // NEVER reuse this IV with the same key
        new SecureRandom().nextBytes(iv);

        String encryptedMessage = encryptSymmetric(secretMessage, aesKey, iv);
        String decryptedMessage = decryptSymmetric(encryptedMessage, aesKey, iv);

        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);

        // Asymmetric Encryption and Decryption
        String publicMessage = "Hello, this is public!";
        String encryptedPublicMessage = encryptAsymmetric(publicMessage, bobKeyPair.getPublic());
        String decryptedPublicMessage = decryptAsymmetric(encryptedPublicMessage, bobKeyPair.getPrivate());

        System.out.println("Encrypted Public Message: " + encryptedPublicMessage);
        System.out.println("Decrypted Public Message: " + decryptedPublicMessage);

        // Signing and Verifying
        String signature = signMessage(decryptedMessage, aliceKeyPair.getPrivate());
        boolean isVerified = verifySignature(decryptedMessage, signature, aliceKeyPair.getPublic());

        System.out.println("Signature: " + signature);
        System.out.println("Is the signature verified? " + isVerified);
    }

    private static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    private static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(RSA_KEY_SIZE);
        return keyPairGenerator.generateKeyPair();
    }

    private static String encryptSymmetric(String plainText, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance(SYMMETRIC_CIPHER);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decryptSymmetric(String encryptedText, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance(SYMMETRIC_CIPHER);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    private static String encryptAsymmetric(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ASYMMETRIC_CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decryptAsymmetric(String encryptedText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ASYMMETRIC_CIPHER);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    private static String signMessage(String message, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    private static boolean verifySignature(String message, String signatureStr, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        return signature.verify(Base64.getDecoder().decode(signatureStr));
    }
}