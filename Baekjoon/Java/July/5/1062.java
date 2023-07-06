import java.io.*;
import java.util.*;

class B1062 {
	static int N,K;
	static int flag;
	static int max=0;
	static String[] words;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		K=Integer.parseInt(s[1]);
		words=new String[N];
	
		
		if(K<5) {
			System.out.println(0);
			return;
		}else if(K==26) {
			System.out.println(N);
			return;
		}else {
			for(int i=0;i<N;i++) {
				String str=br.readLine();
				words[i]=str.substring(4,str.length()-4);
			}
			flag=0;
			max=0;
			// 초기 a n t i c 방문 체크.
			flag |=1 << ('a'-'a');
			flag |=1 << ('n'-'a');
			flag |=1 << ('t'-'a');
			flag |=1 << ('i'-'a');
			flag |=1 << ('c'-'a');
			combination(0,0,flag);
			System.out.println(max);
		}

	}
	private static void combination(int idx, int start,int flag) {
		// 기저조건  a n t i c 를 제외한 단어 조합.
		if(idx==K-5) {
			int count=0;
			for(int i=0;i<N;i++) {
				boolean isValid=true;
				for(int j=0;j<words[i].length();j++) {
					// 백트랙킹 (가지치기) 단어 하나라도 flag 방문처리가 되어있지 않다면 바로 종료.
					if((flag & 1 << (words[i].charAt(j)-'a')) ==0) {
						isValid=false;
						break;
					}
				}
				// 모든 단어가 있다면 단어 +1 
				if(isValid)
					count++;
			}
			//해당 조합으로 만들 수 있는 최대 단어 개수 비교.
			max=Math.max(max, count);
			return;
		}
	
		for(int i=start;i<26;i++) {
			if( (flag & 1 << i) !=0) continue;
			combination(idx+1,i+1,flag | 1 <<i);
		}
		
	}

}