import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTest {

	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("ABC"));
		assertFalse(CryptoManager.isStringInBounds("abc"));
		assertFalse(CryptoManager.isStringInBounds("abc--"));
		assertFalse(CryptoManager.isStringInBounds("fail"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("wxyx", 3));
		assertEquals("GHI", CryptoManager.caesarEncryption("DEF", 3));
		assertEquals("IJK", CryptoManager.caesarEncryption("DEF", 5));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("DEF", CryptoManager.caesarDecryption("GHI", 3));
		assertEquals("DEF", CryptoManager.caesarDecryption("IJK", 5));
		
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("GSPVH", CryptoManager.bellasoEncryption("WORLD", "KEY"));
		assertEquals("EGIH", CryptoManager.bellasoEncryption("ABCD", "EFG"));
		
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("WORLD", CryptoManager.bellasoDecryption("GSPVH", "KEY"));
		assertEquals("ABCD", CryptoManager.bellasoDecryption("EGIH", "EFG"));
		

	}
}
