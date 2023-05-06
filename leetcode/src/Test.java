public class Test {

    public static void main(String[] args) {
        Lift l = new Lift(-1000);
        l.call(-50);
        System.out.println(l.getCurrentFloor());
    }
//    @Test(timeout = 4000)
//    public void test() throws Throwable {
//        assertEquals(Integer.MAX_VALUE, l.getTopFloor()); Lift l = new Lift(Integer.MAX_VALUE);
//
//    }
}
