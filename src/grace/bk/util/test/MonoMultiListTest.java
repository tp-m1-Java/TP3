package grace.bk.util.test;

import org.junit.Before;
import org.junit.Test;

import grace.bk.util.MonoMultiList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MonoMultiListTest {

	private MonoMultiList<A> monol;
	private MonoMultiList<B> multil;
	
	@Before
	public void setUp() throws Exception {
		monol = new MonoMultiList<A>(new B()); // g�n�ricit� statique <A> (monomorphe sur B) 
		multil = new MonoMultiList<B>(); // g�n�ricit� statique <B> (polymorphisme)
	}

	@Test
	public void testAddMono_OK() {
		// TODO 
		// assertTrue("ajout d'un B dans une liste<A> monomorphe<B>", ??? );
        assertTrue(monol.add(new B()));
	}
	
	@Test
	public void testAddMono_NOK_up() {
//		 TODO 
		// assertFalse("ajout d'un A dans une liste<A> monomorphe<B>", ??? );
        assertFalse(monol.add(new A()));
	}
	
	@Test
	public void testAddMono_NOK_down() {
//		 TODO 
		// assertFalse("ajout d'un C dans une liste<A> monomorphe<B>", ??? );
        assertFalse(monol.add(new C()));
	}
	
	@Test
	public void testAddMulti_OK_eq() {
//		 TODO 
		// assertTrue("ajout d'un B dans une liste<B> polymorphe", ??? );
        assertTrue(multil.add(new B()));
	}

	@Test
	public void testAddMulti_NOK_up() {
//		 TODO 
		// assertFalse("ajout d'un A dans une liste<B> polymorphe", ??? );
        /*
        Le test ne passe pas car A est la classe mere
         */
        //assertFalse(multil.add(new A()));
	}
	
	@Test
	public void testAddMulti_OK_down() {
//		 TODO 
		//assertTrue("ajout d'un C dans une liste<B> polymorphe", ??? );
        assertTrue(multil.add(new C()));
	}

	class A {
	}
	
	class B extends A {
	}
	
	class C extends B {
	}

}
