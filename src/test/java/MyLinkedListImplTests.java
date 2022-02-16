import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListImplTests {
    
    MyLinkedListImpl<Integer> ml;
    MyLinkedListImpl<Integer> mlToSortNotNull;
    MyLinkedListImpl<Double> mld;
    MyLinkedListImpl<TestClass> mlt;
    
    
    @Before
    public void init() {
	
	ml = new MyLinkedListImpl<>();
	mlToSortNotNull = new MyLinkedListImpl<>();
	mld = new MyLinkedListImpl<>();
	mlt = new MyLinkedListImpl<>();
	
	ml.add(1);
	ml.add(null);
	ml.add(-2);
	ml.add(123);
	
	mlToSortNotNull.add(2);
	mlToSortNotNull.add(5);
	mlToSortNotNull.add(4);
	mlToSortNotNull.add(1);
	mlToSortNotNull.add(8);
	mlToSortNotNull.add(3);
	mlToSortNotNull.add(0);
	mlToSortNotNull.add(6);
	mlToSortNotNull.add(9);
	mlToSortNotNull.add(7);
	
	mld.add(2.1);
	mld.add(null);
	mld.add(2.2);
	mld.add(-1.5);
	
	mlt.add(new TestClass(1, 2, "One"));
	mlt.add(new TestClass(2, 1, "Two"));
	mlt.add(new TestClass(3, 3, "Three"));
	
//	m1 = [1, null, -2, 123]
//	ml_toSort_notNull = [2, 5, 4, 1, 8, 3, 0, 6, 9, 7]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
    }
    
    @Test    
    public void addTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertEquals("[1, null, -2, 123]", ml.toString());
	Assert.assertEquals(4, ml.size());
	Assert.assertEquals("[2.1, null, 2.2, -1.5]", mld.toString());
	Assert.assertEquals(4, mld.size());
	Assert.assertEquals("[1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]", mlt.toString());
	Assert.assertEquals(3, mlt.size());
    }
    
    
    @Test    
    public void getIntTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertNull(ml.get(1));
	Assert.assertEquals(new Integer(123), ml.get(3));
	ml.add(55);
	Assert.assertEquals(new Integer(55), ml.get(4));
	Assert.assertEquals(new Double(-1.5), mld.get(3));
	Assert.assertEquals("2 | 1 | Two", mlt.get(1).toString());
	
	TestClass tk = new TestClass(2, 2, "22T");
	mlt.add(tk);
	Assert.assertEquals(tk, mlt.get(3));
    }
    
//    @Test (expected = IndexOutOfBoundsException.class)
//    public void getIntExceptionTest() {
//		m1 = [1, null, -2, 123]Assert.assertNull(ml.get(5));
//    }
    
    @Test    
    public void getLastTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	Assert.assertEquals("123", ml.getLast().toString());
	Assert.assertEquals("-1.5", mld.getLast().toString());
	Assert.assertEquals("3 | 3 | Three", mlt.getLast().toString());
	mld.add(1.1);
	Assert.assertEquals("1.1", mld.getLast().toString());
    }
    
    @Test    
    public void containsObjectTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertTrue(ml.contains(-2));
	Assert.assertTrue(ml.contains(null));
	Assert.assertFalse(ml.contains(11));
    }
    
    @Test    
    public void deleteObjectTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertFalse(ml.delete(new Integer(2)));
	Assert.assertFalse(mld.delete(3.3));
	Assert.assertFalse(mld.delete("Other class"));
	
	Assert.assertTrue(ml.delete(null));
	Assert.assertEquals("[1, -2, 123]", ml.toString());
	Assert.assertEquals(3, ml.size());
	
	Assert.assertTrue(ml.delete(new Integer(-2)));
	Assert.assertEquals("[1, 123]", ml.toString());
	Assert.assertEquals(2, ml.size());
	
	Assert.assertTrue(mld.delete(2.1));
	Assert.assertEquals("[null, 2.2, -1.5]", mld.toString());
	Assert.assertEquals(3, mld.size());
    }
    
    
    @Test    
    public void indexOfTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertEquals(0, ml.indexOf(1));
	Assert.assertEquals(1, ml.indexOf(null));
	ml.delete(null);
	ml.add(null);
	Assert.assertEquals(3, ml.indexOf(null));
	
	Assert.assertEquals(1, mld.indexOf(null));
	Assert.assertEquals(3, mld.indexOf(-1.5));
    }
    
    
    @Test    
    public void extractAndDeleteTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertEquals("1", ml.extractAndDelete().toString());
	Assert.assertEquals("[null, -2, 123]", ml.toString());
	Assert.assertEquals(3, ml.size());
	Assert.assertNull(ml.extractAndDelete());
	Assert.assertEquals("[-2, 123]", ml.toString());
	Assert.assertEquals(2, ml.size());
	
	Assert.assertEquals("2.1", mld.extractAndDelete().toString());
	Assert.assertEquals("[null, 2.2, -1.5]", mld.toString());
	Assert.assertEquals(3, mld.size());
	
	Assert.assertEquals("1 | 2 | One", mlt.extractAndDelete().toString());
	Assert.assertEquals("[2 | 1 | Two, 3 | 3 | Three]", mlt.toString());
	Assert.assertEquals(2, mlt.size());
    }
    
    
    @Test    
    public void subListTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertEquals("[-2, 123]", ml.subList(2, 4).toString());
	Assert.assertEquals(2, ml.subList(2, 4).size());
	Assert.assertEquals("[null, -2, 123]", ml.subList(1, 4).toString());
	Assert.assertEquals(3, ml.subList(1, 4).size());
	
	Assert.assertEquals("[2.1, null, 2.2, -1.5]", mld.subList(0, mld.size()).toString());
	Assert.assertEquals(4, ml.subList(0, mld.size()).size());
	Assert.assertEquals("[]", mld.subList(3, 3).toString());
	Assert.assertEquals(0, ml.subList(3, 3).size());
	
	Assert.assertEquals("[2 | 1 | Two]", mlt.subList(1, 2).toString());
	Assert.assertEquals(1, mlt.subList(1, 2).size());
    }
    
    
    @Test    
    public void reverseTest() {
//	m1 = [1, null, -2, 123]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertEquals("[123, -2, null, 1]", ml.reverse().toString());
	Assert.assertEquals("[123, -2, null, 1]", ml.toString());
	Assert.assertEquals("[1, null, -2, 123]", ml.reverse().toString());
	
	mld.add(5.7);
	Assert.assertEquals("[5.7, -1.5, 2.2, null, 2.1]", mld.reverse().toString());
	
	mlt.extractAndDelete();
	Assert.assertEquals("[3 | 3 | Three, 2 | 1 | Two]", mlt.reverse().toString());
	mlt.extractAndDelete();
	Assert.assertEquals("[2 | 1 | Two]", mlt.reverse().toString());
	mlt.extractAndDelete();
	Assert.assertEquals("[]", mlt.reverse().toString());
    }
    
    
    @Test    
    public void sortTest() {
//	m1 = [1, null, -2, 123]
//	ml_toSort_notNull = [2, 5, 4, 1, 8, 3, 0, 6, 9, 7]
//	mld = [2.1, null, 2.2, -1.5]
//	mlt = [1 | 2 | One, 2 | 1 | Two, 3 | 3 | Three]
	
	Assert.assertEquals("[2, 5, 4, 1, 8, 3, 0, 6, 9, 7]", mlToSortNotNull.toString());
	mlToSortNotNull.sort();
	Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", mlToSortNotNull.toString());
	
	ml.sort(new Comparator<Integer>() {

	    @Override
	    public int compare(Integer o1, Integer o2) {
		if(o1 == null) return -1;
		if(o2 == null) return 1;
		return o1 - o2;
	    }
	});
	Assert.assertEquals("[null, -2, 1, 123]", ml.toString());
	
	mld.sort(new Comparator<Double>() {
	    
	    @Override
	    public int compare(Double o1, Double o2) {
		if(o1 == null) return -1;
		if(o2 == null) return 1;
		return (o1 - o2) > 0 ? 1 : -1;
	    }
	});
	Assert.assertEquals("[null, -1.5, 2.1, 2.2]", mld.toString());
    }
}
