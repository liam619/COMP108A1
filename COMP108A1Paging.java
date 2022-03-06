//
// Coded by Prudence Wong 2021-12-29
//
// NOTE: You are allowed to add additional methods if you need.
//
// Name:
// Student ID:
//
// Time Complexity and explanation: You can use the following variables for easier reference.
// n denotes the number of requests, p denotes the size of the cache
// n and p can be different and there is no assumption which one is larger
//
// noEvict():
//
// evictFIFO():
//
// evictLFU():
//
// evictLRU():
//

class COMP108A1Paging {

	// no eviction
	// Aim:
	// do not evict any page
	// count number of hit and number of miss, and find the hit-miss pattern; return
	// an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output noEvict(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();
		boolean flag;
		for (int i = 0; i < rSize; i++) {
			flag = false;
			for (int j = 0; j < cSize; j++) {
				if (rArray[i] == cArray[j]) {
					output.hitPattern += "h";
					output.hitCount++;
					flag = true;
					break;
				}
			}
			if (!flag) {
				output.hitPattern += "m";
				output.missCount++;
			}
		}

		output.cache = arrayToString(cArray, cSize);
		return output;
	}

	// evict FIFO
	// Aim:
	// if a request is not in cache, evict the page present in cache for longest
	// time
	// count number of hit and number of miss, and find the hit-miss pattern; return
	// an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictFIFO(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();
		int oldest_index = 0;
		boolean flag = false;
		for (int i = 0; i < rSize; i++) {
			flag = false;
			for (int j = 0; j < cSize; j++) {
				if (rArray[i] == cArray[j]) {
					output.hitPattern += "h";
					output.hitCount++;
					flag = true;
					break;
				}
			}
			if (!flag) {
				output.hitPattern += "m";
				output.missCount++;
				cArray[oldest_index] = rArray[i];
				if (oldest_index == cSize - 1)
					oldest_index = 0;
				else
					oldest_index++;
			}
		}
		output.cache = arrayToString(cArray, cSize);
		return output;
	}

	// evict LFU
	// Aim:
	// if a request is not in cache, evict the page that is least freqently used
	// since in the cache
	// count number of hit and number of miss, and find the hit-miss pattern; return
	// an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictLFU(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();

		output.cache = arrayToString(cArray, cSize);
		return output;
	}

	// evict LRU
	// Aim:
	// if a request is not in cache, evict the page that hasn't been used for the
	// longest amount of time
	// count number of hit and number of miss, and find the hit-miss pattern; return
	// an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictLRU(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();

		output.cache = arrayToString(cArray, cSize);
		return output;
	}

	// DO NOT change this method
	// this will turn the cache into a String
	// Only to be used for output, do not use it to manipulate the cache
	static String arrayToString(int[] array, int size) {
		String outString = "";

		for (int i = 0; i < size; i++) {
			outString += array[i];
			outString += ",";
		}
		return outString;
	}

}
