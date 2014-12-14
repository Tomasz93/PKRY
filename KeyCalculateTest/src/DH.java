import java.math.BigInteger;
import java.security.SecureRandom;

public class DH { 
	public SecureRandom rnd = new SecureRandom();
	public BigInteger publicP, publicG, publicR;
	public BigInteger myPublicKey, yourPublicKey;
	public int myPrivateKey;
	public byte[] secretKey = null;
	
	public void initialize(){
		publicP = BigInteger.probablePrime(1024, rnd);
		publicR = BigInteger.probablePrime(256, rnd);
		publicG = BigInteger.probablePrime(32, rnd);

		System.out.println(publicP.divide(publicR));
		
	}
	
	public void getInitializedValues(BigInteger p, BigInteger g){
		publicP = p;
		publicG = g;
	}
	
	public void calculateMyKeys(){
		myPrivateKey = rnd.nextInt(1500);
		myPublicKey = (publicG.pow(myPrivateKey)).mod(publicP);
	}
	
	public void getYourPublicKey(BigInteger b){
		yourPublicKey = b;
	}
	
	public void calculateSecretKey(){
		secretKey = (yourPublicKey.pow(myPrivateKey)).mod(publicP).toByteArray();
	}
	
	

}
