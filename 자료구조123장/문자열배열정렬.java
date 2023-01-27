package 자료구조123장;

//12장 입출력 작업하기 Test06_2를 수정하여 스트링 정렬하기, Test11/596페이지
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class 문자열배열정렬 {

public static void main(String[] args) {

  try {

    // 파일을 읽어서 string 객체를 정렬하는 프로그램 구성
    Path input = Paths.get("a.txt"); // 경로를 파악해서 읽어온다.

    byte[] bytes = Files.readAllBytes(input);
    System.out.println("== readAllBytes ==");
    System.out.println(new String(bytes));
    // ------------------- 추가한 코드
    // file 입출력 + String 처리 + 정렬 코딩(.sort)
    String s = new String(bytes);
    System.out.println("s = " + s);
    String [] sa = s.split(" |\n");
    // 대문자가 소문자보다 빠르다.
    for(int i = 0; i < sa.length; i++) {
    	for(int j = i + 1; j < sa.length; j++) {
    		if (sa[i].compareTo(sa[j]) > 0) {
    	    	String temp = sa[i];
    			sa[i] = sa[j];
    			sa[j] = temp;
    	    } 
    	}
    }    
    

    
    // ---------------------------

    int bufferSize = 10240;
    String b = " ";
    ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
    for (String sx : sa) {
  	  System.out.println(" " + sx);
  	  buffer.put(sx.getBytes());
  	  buffer.put(b.getBytes());  // 띄어쓰기 코드.
    }
	  buffer.flip();
    FileOutputStream file = new FileOutputStream("c.txt");
    FileChannel channel = file.getChannel();
    channel.write(buffer);
    file.close();

  } catch(IOException e) {
    e.printStackTrace();
  }
}
}