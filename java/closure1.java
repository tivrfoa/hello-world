

class closure1 {

	public static void main(String[] args) {
		
		/*
		 *  time("someString") {
		 * 		new closure1().m1();
		 *  }
		 */
		 
		 closure1 c1 = new closure1();
		 time("m1", () -> c1.m1());
		 time("m2", () -> c1.m2(32));
		 
		 System.out.println("finished main");
	}
	
	void m1() {
		System.out.println("I'm m1");
	}
	
	void m2(int x) {
		System.out.println("I'm m2 and my age is " + x);
		throw new RuntimeException("bad argument");
	}
	
	static void time(String methodName, Runnable function) {
		long t0 = System.nanoTime();
		boolean success = false;
		
		try {
			function.run();
			success = true;
		} finally {
			long nano = System.nanoTime() - t0;
			System.out.printf("%s executed with %s in %d nanoseconds.\n",
					methodName,
					(success) ? "success" : "error",
					nano);
		}
	}
}



