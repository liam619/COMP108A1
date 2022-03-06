
//
// Coded by Prudence Wong 2021-12-29
//
import java.util.*;
import java.io.*;

class COMP108A1PagingApp {

	private static final int MAX_CACHE_SIZE = 10;
	private static final int MAX_REQUEST_SIZE = 100;

	private static Scanner keyboardInput = new Scanner(System.in);

	// Do NOT change the main method!
	// main program
	public static void main(String[] args) throws Exception {

		int[] orgCache = new int[MAX_CACHE_SIZE];
		int[] cache = new int[MAX_CACHE_SIZE];
		int[] request = new int[MAX_REQUEST_SIZE];
		COMP108A1Output output = new COMP108A1Output();

		initArray(orgCache, MAX_CACHE_SIZE, -1);
		initArray(request, MAX_REQUEST_SIZE, 0);

		// get the cache size and the number of requests
		// then get the corresponding input in the respective arrays
		
//		int requestSize = 6;
//		int cacheSize = 3;
//		orgCache = new int[] { 20, 30, 10 };
//		request = new int[] { 20, 5, 30, 10, 5, 20 };

		int requestSize = 4;
		int cacheSize = 5;
		orgCache = new int[] { 10, 20, 30, 40, 50 };
		request = new int[] { 15, 50, 10, 20 };
		
//		int requestSize = 14;
//		int cacheSize = 4;
//		orgCache = new int[] {20, 30, 10, 40 };
//		request = new int[] { 40, 40, 30, 30, 20, 5, 5, 5, 15, 15, 15, 15, 10, 40 };

		System.out.println();
		System.out.println("Cache content: ");
		printArray(orgCache, cacheSize);
		System.out.println("Request sequence: ");
		printArray(request, requestSize);

		try {
			System.out.println();
			System.out.println("noEvict");
			copyArray(orgCache, cache, cacheSize);
			output = COMP108A1Paging.noEvict(cache, cacheSize, request, requestSize);
			output.print();
		} catch (Exception e) {
			errTraceMsg(e, "noEvict");
		}

		try {
			System.out.println();
			System.out.println("evictFIFO");
			copyArray(orgCache, cache, cacheSize);
			output = COMP108A1Paging.evictFIFO(cache, cacheSize, request, requestSize);
			output.print();
		} catch (Exception e) {
			errTraceMsg(e, "evictFIFO");
		}

		try {
			System.out.println();
			System.out.println("evictLFU");
			copyArray(orgCache, cache, cacheSize);
			output = COMP108A1PagingComplete.evictLFU(cache, cacheSize, request, requestSize);
			output.print();
		} catch (Exception e) {
			errTraceMsg(e, "evictLFU");
		}

		try {
			System.out.println();
			System.out.println("evictLRU");
			copyArray(orgCache, cache, cacheSize);
			output = COMP108A1PagingComplete.evictLRU(cache, cacheSize, request, requestSize);
			output.print();
		} catch (Exception e) {
			errTraceMsg(e, "evictLRU");
		}

	}

	static void errTraceMsg(Exception e, String errString) {
		System.err.println("Exception: " + errString);
		e.printStackTrace();
	}

	// Do NOT change this method!
	// set array[0]..array[size-1] to value
	static void initArray(int[] array, int size, int value) {
		for (int i = 0; i < size; i++)
			array[i] = value;
	}

	// Do NOT change this method!
	// print array[0]..array[size-1]
	static void printArray(int[] array, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
			if (i % 10 == 9)
				System.out.println();
		}
		System.out.println();
	}

	// Do NOT change this method!
	// copy numbers from array a1 to array a2, starting from a1[0] to a2[0], up to
	// a1[size-1] to a2[size-1]
	static void copyArray(int[] array1, int[] array2, int size) {
		for (int i = 0; i < size; i++) {
			array2[i] = array1[i];
		}
	}
}
