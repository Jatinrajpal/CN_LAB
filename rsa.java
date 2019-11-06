import java.util.*; 
import java.math.BigInteger; 
import java.lang.*; 

class rsa
{ 
public static void main(String[] args) 
{ 
Random rand1=new Random(System.currentTimeMillis());
 Random rand2=new Random(System.currentTimeMillis()*10); 
int pubkey=Integer.parseInt(args[0]); 
BigInteger p=BigInteger.probablePrime(32, rand1);
BigInteger q=BigInteger.probablePrime(32, rand2); 
BigInteger n=p.multiply(q); // n
BigInteger p_1=p.subtract(new BigInteger("1"));
BigInteger q_1=q.subtract(new BigInteger("1")); 

BigInteger p_1_q_1=p_1.multiply(q_1);  // z
while(true) 
{ 
BigInteger GCD=p_1_q_1.gcd(new BigInteger(""+pubkey)); if(GCD.equals(BigInteger.ONE)) 
{ 
break; 
} 
pubkey++; 
} 
BigInteger bigB_pubkey=new BigInteger(""+pubkey); // e
BigInteger bigB_prvkey=bigB_pubkey.modInverse(p_1_q_1);   System.out.println("public key : "+bigB_pubkey+","+n); System.out.println("private key : "+bigB_prvkey+","+n); 
} 
} 
