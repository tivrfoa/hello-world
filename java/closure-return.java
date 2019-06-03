// https://www.oracle.com/technetwork/server-storage/ts-5579-1-158845.pdf

interface Block<R, X extends Exception> {
	R execute() throws X;
}

class closure {

	public static void main(String[] args) {
		
		closure obj = new closure();
		
		// obj.time("test 1", () -> System.out.println("I'm Block"));
		System.out.println(obj.f());
	}
	
	int f() {
		return time("f", () -> { return 32; });
	}
	
	public <R, X extends Exception> R time(String opName,
			Block<R, X> block) throws X {
		long startTime = System.nanoTime();
		boolean success = true;
		try {
			return block.execute();
		} catch(final Throwable ex) {
			success = false;
			throw ex;
		} finally {
			System.out.printf("%s runned in %d nanoseconds %b\n",
					opName,
					System.nanoTime() - startTime,
					success);
		}
	}
}



