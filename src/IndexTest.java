import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.*;   // instead of  import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class IndexTest {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	
		File testFile = new File("testFile.txt");
		PrintWriter writer = new PrintWriter("testFile.txt");
		writer.write("This is the test");
		writer.close();
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		File deleteFile = new File("testFile.txt");
		deleteFile.delete();
	}

	@Test
	public void testIndex() throws IOException {
		Index the = new Index();
		File test = new File("index");
		assertTrue(test.exists());
		
	}
	
	

	@Test
	public void testAddBlob() throws Exception {
		setUpBeforeClass();
		boolean checker = false;
		//fail("Not yet implemented");
		String fileName = "testFile.txt";
		Blob23 blobby = new Blob23(fileName);
		Index test = new Index();
		test.addBlob(fileName);
		String str = "";
		BufferedReader br = new BufferedReader(new FileReader("index"));
		while(br.ready()) {
			if(br.readLine().equals(fileName + " : " + blobby.getShawedString())) {
				checker = true;
				assertTrue(checker);

			}
			
		}
		tearDownAfterClass();
		
		
	}

	@Test
	public void testRemoveBlob() throws Exception {
		//fail("Not yet implemented");
		setUpBeforeClass();
		boolean test = true;
		Index in = new Index();
		
		String fileName = "testFile.txt";
		Blob23 blobby = new Blob23("testFile.txt");
		blobby.shaTheFile();
		BufferedReader br = new BufferedReader(new FileReader("index"));
		while(br.ready()) {
			br.readLine();
			if(br.readLine().equals(fileName + " : " + blobby.getShawedString())) {
				test = false;
				

			}
		}
		assertTrue(test);
		tearDownAfterClass();
	}

	@Test
	public void testClearIndexFile() throws IOException {
		//fail("Not yet implemented");
		boolean check = false;
		BufferedReader br = new BufferedReader(new FileReader("index"));
		if(!br.ready()) {
			check = true;
			assertTrue(check);
		}
		
	}	

}
