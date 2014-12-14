import java.math.BigInteger;

public class Main {

	static public DH Alice = new DH();
	static public DH Bob = new DH();
	
	public static void main(String[] args) {
		long t1,t2;
		float time;
		t1=System.currentTimeMillis();
		Alice.initialize();
		System.out.println("Alice");
		System.out.println("P: "+Alice.publicP+"; G: "+Alice.publicG);
		Bob.getInitializedValues(Alice.publicP, Alice.publicG);
		System.out.println("Bob");
		System.out.println("P: "+Bob.publicP+"; G: "+Bob.publicG);
		Alice.calculateMyKeys();
		System.out.println("Alice");
		System.out.println("Private: "+Alice.myPrivateKey+"; Public: "+Alice.myPublicKey);
		Bob.calculateMyKeys();
		System.out.println("Bob");
		System.out.println("Private: "+Bob.myPrivateKey+"; Public: "+Bob.myPublicKey);
		Alice.getYourPublicKey(Bob.myPublicKey);
		Bob.getYourPublicKey(Alice.myPublicKey);
		Alice.calculateSecretKey();
		System.out.println("Alice");
		System.out.println("Key: "+new BigInteger(Alice.secretKey));
		Bob.calculateSecretKey();
		System.out.println("Bob");
		System.out.println("Key: "+new BigInteger(Bob.secretKey));
		t2=System.currentTimeMillis();
		time = (t2-t1);		
		System.out.println("Czas obliczenia kluczy: "+time/1000+" s");
		//System.out.println("Key: "+Bob.secretKey.length*8);
	}
}
