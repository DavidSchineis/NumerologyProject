import java.io.*;


public class Driver {

	public static String RandomDateGen() {
		String s = "";
		
		int month = (int)(Math.random()*(12) + 1);
		
		int day = 0;
		
		int year = (int)(Math.random()*(2020-1500+1) + 1500);
		
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10|| month == 12) {
			day = (int)(Math.random()*(31) + 1);
		}
		else if(month == 2) {
			day = (int)(Math.random()*(28) + 1);
		}
		else {
			day = (int)(Math.random()*(30) + 1);
		}
		
		s = s + month + " " + day + " " + year;
		
		return s;
		
	}
	
	public static Numerology ReadDates(String[] s){
				
				int num[] = new int[1000];
				
				for(int j=0; j < s.length; j++) {
					num[j] = Integer.parseInt(s[j]);
					//System.out.println(num[j]);
				
				}
				int res = num[0] +num[1] + num[2];
				while(res > 9) {
					int res1 = res%10;
					int res2 = (res%100 - res1) / 10;
					int res3 = (res/100) % 10;
					int res4 = res/1000;
					
					res = res1 + res2 + res3 + res4;
					//System.out.println(res);
				}
				//System.out.println();
				Numerology n = new Numerology(num[0], num[1], num[2], res);
				return n;
	}
		

		
		
	
	
	public static void main(String[] args) {
		
		String dateString = "";
		
		try {
			
			File dates = new File("dates.txt");
			FileOutputStream fos = new FileOutputStream(dates);
			PrintWriter pw = new PrintWriter(fos);
			
			for(int i=0; i<100;i++) {
				
			dateString = RandomDateGen();
			pw.write(dateString);
			pw.println();
			
			}
			
			pw.flush();
			fos.close();
			pw.close();
			
			String[] s;
			Numerology n, m = new Numerology(0,0,0,0);
			SinglyLinkedList<Numerology> SSL = new SinglyLinkedList<Numerology>();
			DoublyLinkedList<Numerology> DLL = new DoublyLinkedList<Numerology>();
			
			BufferedReader br = new BufferedReader(new FileReader("dates.txt"));
			
			s = br.readLine().split(" ");
			n = ReadDates(s);
			SSL.addFirst(n);
			DLL.addFirst(n);
			
			for(int i=0; i<99; i++) {
					
				s = br.readLine().split(" ");
				n = ReadDates(s);
				SSL.addLast(n);
				DLL.addLast(n);
				
			}
			br.close();
			
			String sslStr, dllStr = "";
			
			
			File SSLs = new File("SSL.txt");
			FileOutputStream fos2 = new FileOutputStream(SSLs);
			PrintWriter pw2 = new PrintWriter(fos2);
			
			File DLLs = new File("DLL.txt");
			FileOutputStream fos3 = new FileOutputStream(DLLs);
			PrintWriter pw3 = new PrintWriter(fos3);
			
			for(int i=0;i<100;i++) {
				
				n = SSL.removeFirst();
				sslStr = n.makeString(n);
				pw2.write(sslStr);
				pw2.println();
				
				m = DLL.removeLast();
				dllStr = m.makeString(m);
				pw3.write(dllStr);
				pw3.println();
			}
			
			pw2.flush();
			fos2.close();
			pw2.close();
			
			pw3.flush();
			fos3.close();
			pw3.close();
			
		
		}
		catch(Exception exception) {
			
		}
	}

}
